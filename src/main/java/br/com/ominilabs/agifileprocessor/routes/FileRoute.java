package br.com.ominilabs.agifileprocessor.routes;

import br.com.ominilabs.agifileprocessor.aggregator.ReportAggregationStrategy;
import br.com.ominilabs.agifileprocessor.predicate.FileExtensionPredicate;
import br.com.ominilabs.agifileprocessor.predicate.record.CustomerPredicate;
import br.com.ominilabs.agifileprocessor.predicate.record.SalePredicate;
import br.com.ominilabs.agifileprocessor.predicate.record.SalesmanPredicate;
import br.com.ominilabs.agifileprocessor.processor.ReportProcessor;
import br.com.ominilabs.agifileprocessor.processor.record.CustomerProcessor;
import br.com.ominilabs.agifileprocessor.processor.record.InvalidRecordProcessor;
import br.com.ominilabs.agifileprocessor.processor.record.SaleProcessor;
import br.com.ominilabs.agifileprocessor.processor.record.SalesmanProcessor;
import br.com.ominilabs.agifileprocessor.properties.AgiFileProcessorProperties;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileRoute extends RouteBuilder {


    private static final Logger LOG = LoggerFactory.getLogger(FileRoute.class);


    private AgiFileProcessorProperties properties;
    private FileExtensionPredicate fileExtensionPredicate;
    private CustomerPredicate customerPredicate;
    private SalesmanPredicate salesmanPredicate;
    private SalePredicate salePredicate;
    private CustomerProcessor customerProcessor;
    private SalesmanProcessor salesmanProcessor;
    private SaleProcessor saleProcessor;
    private ReportProcessor reportProcessor;
    private InvalidRecordProcessor invalidRecordProcessor;


    @Autowired
    public FileRoute(AgiFileProcessorProperties properties, FileExtensionPredicate fileExtensionPredicate,
                     CustomerPredicate customerPredicate, SalesmanPredicate salesmanPredicate, SalePredicate salePredicate,
                     CustomerProcessor customerProcessor, SalesmanProcessor salesmanProcessor, SaleProcessor saleProcessor,
                     ReportProcessor reportProcessor, InvalidRecordProcessor invalidRecordProcessor) {

        this.properties = properties;
        this.fileExtensionPredicate = fileExtensionPredicate;
        this.customerPredicate = customerPredicate;
        this.salesmanPredicate = salesmanPredicate;
        this.salePredicate = salePredicate;
        this.customerPredicate = customerPredicate;
        this.customerProcessor = customerProcessor;
        this.salesmanProcessor = salesmanProcessor;
        this.saleProcessor = saleProcessor;
        this.reportProcessor = reportProcessor;
        this.invalidRecordProcessor = invalidRecordProcessor;

    }

    @Override
    public void configure() throws Exception {

        LOG.info("Starting FileRoute.");

        from("file://data/in?delay=1000&noop=true")
                .autoStartup(true)
                .log("File ${file:name} has been found.")
                .choice()
                    .when(fileExtensionPredicate)
                        .log("Reading content of ${file:name}")
                        .convertBodyTo(String.class)
                        .split(body().tokenize("\n"))
                        .choice()
                            .when(customerPredicate)
                                .log("Customer record was found.")
                                .process(customerProcessor)
                                .log("Body content after processing: ${body}").endChoice()
                            .when(salesmanPredicate)
                                .log("Salesman record was found.")
                                .process(salesmanProcessor)
                                .log("Body content after processing: ${body}").endChoice()
                            .when(salePredicate)
                                .log("Sale record was found")
                                .process(saleProcessor)
                                .log("Body content after processing: ${body}").endChoice()
                            .end()
                            .to("seda:aggregate");

        from("seda:aggregate")
                .log("Body content before aggregate: ${body}")
                .aggregate(constant(true), new ReportAggregationStrategy()).completionTimeout(1)
                .log("Body content after aggregate: ${body}")
                .process(reportProcessor)
                .to("file://data/out/?fileName=${file:name}.done")
                .end();
    }
}
