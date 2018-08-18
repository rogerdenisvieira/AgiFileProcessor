package br.com.ominilabs.agifileprocessor.processor.record;

import br.com.ominilabs.agifileprocessor.model.Customer;
import br.com.ominilabs.agifileprocessor.model.Report;
import br.com.ominilabs.agifileprocessor.properties.AgiFileProcessorProperties;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerProcessor extends AbstractRecordProcessor {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerProcessor.class);


    @Autowired
    private AgiFileProcessorProperties properties;

    @Override
    public void process(Exchange exchange) throws Exception {

        String[] recordValues = this.extractExchangeRecordValues(exchange);

        Customer customer = new Customer(
                recordValues[1],
                recordValues[2],
                recordValues[3]
        );


        exchange.getIn().setHeader("record","customer");
        exchange.getIn().setBody(customer);

        LOG.info(customer.toString());
    }
}
