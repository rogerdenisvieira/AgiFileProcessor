package br.com.ominilabs.agifileprocessor.routes;

import br.com.ominilabs.agifileprocessor.predicate.FileExtensionPredicate;
import br.com.ominilabs.agifileprocessor.predicate.record.CustomerPredicate;
import br.com.ominilabs.agifileprocessor.predicate.record.SalePredicate;
import br.com.ominilabs.agifileprocessor.predicate.record.SalesmanPredicate;
import br.com.ominilabs.agifileprocessor.processor.FileProcessor;
import br.com.ominilabs.agifileprocessor.processor.record.CustomerProcessor;
import br.com.ominilabs.agifileprocessor.processor.record.SaleProcessor;
import br.com.ominilabs.agifileprocessor.processor.record.SalesmanProcessor;
import br.com.ominilabs.agifileprocessor.properties.AgiFileProcessorProperties;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileRoute extends RouteBuilder {



    private AgiFileProcessorProperties properties;
    private FileExtensionPredicate fileExtensionPredicate;
    private FileProcessor fileProcessor;
    private CustomerPredicate customerPredicate;
    private SalesmanPredicate salesmanPredicate;
    private SalePredicate salePredicate;
    private CustomerProcessor customerProcessor;
    private SalesmanProcessor salesmanProcessor;
    private SaleProcessor saleProcessor;


    @Autowired
    public FileRoute(AgiFileProcessorProperties properties, FileExtensionPredicate fileExtensionPredicate,
                     FileProcessor fileProcessor, CustomerPredicate customerPredicate, SalesmanPredicate salesmanPredicate,
                     SalePredicate salePredicate, CustomerProcessor customerProcessor, SalesmanProcessor salesmanProcessor,
                     SaleProcessor saleProcessor) {

        this.properties = properties;
        this.fileExtensionPredicate = fileExtensionPredicate;
        this.fileProcessor = fileProcessor;
        this.customerPredicate = customerPredicate;
        this.salesmanPredicate = salesmanPredicate;
        this.salePredicate = salePredicate;
        this.customerPredicate = customerPredicate;
        this.customerProcessor = customerProcessor;
        this.salesmanProcessor = salesmanProcessor;
        this.saleProcessor = saleProcessor;

    }

    @Override
    public void configure() throws Exception {

        System.out.println("teste");

        from("file://data/in?delay=1000&noop=true")
                .autoStartup(true)
                .log("File ${file:name} has been found.")
                .choice()
                    .when(fileExtensionPredicate)
                        .log("Reading content of ${file:name}")
                        .convertBodyTo(String.class)
                        .split(body().tokenize("\n"))
                        .choice()
                            .when(customerPredicate).log("Customer record was found.")
                                .process(customerProcessor)
                            .when(salesmanPredicate)
                                .log("Salesman record was found.")
                                .process(customerProcessor)
                            .when(salePredicate)
                                .log("Sale record was found")
                                .process(saleProcessor).end().endChoice()
                    .otherwise()
                        .log("${file:name} is not a valid file type.")
                .end();
    }
}
