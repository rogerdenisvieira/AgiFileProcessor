package br.com.ominilabs.agifileprocessor.processor;

import br.com.ominilabs.agifileprocessor.model.Customer;
import br.com.ominilabs.agifileprocessor.model.Report;
import br.com.ominilabs.agifileprocessor.model.Sale;
import br.com.ominilabs.agifileprocessor.model.Salesman;
import br.com.ominilabs.agifileprocessor.processor.record.SaleProcessor;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component
public class ReportProcessor implements Processor {

    private static final Logger LOG = LoggerFactory.getLogger(ReportProcessor.class);
    /*
    *
    * Quantidade de clientes no arquivo de entrada
    * Quantidade de vendedor no arquivo de entrada
    * ID da venda mais cara
    * O pior vendedor
    *
    */



    @Override
    public void process(Exchange exchange) throws Exception {

        ArrayList list = (ArrayList) exchange.getIn().getBody();

        List<Sale> sales = new ArrayList<>();
        List<Customer> customers = new ArrayList<>();
        List<Salesman> salesmen = new ArrayList<>();

        Report report;

        LOG.info("Preparing data for generate report.");

        for (Object item : list) {
            if (item instanceof Sale) {
                sales.add((Sale) item);
            } else if (item instanceof Salesman) {
                salesmen.add((Salesman) item);
            } else if (item instanceof Customer) {
                customers.add((Customer) item);
            } else {
                LOG.info("Invalid object found in report exchange:" + item);
            }
        }

        LOG.info("Generating report.");

        report = new Report(
                customers.size(),
                salesmen.size(),
                sales.stream().max(Comparator.comparing(Sale::calculateTotalSaleValue)).get().getId(),
                sales.stream().min(Comparator.comparing(Sale::calculateTotalSaleValue)).get().getSalesmanName()
        );

        LOG.info(report.toString());

        exchange.getIn().setBody(report.toString());

    }
}
