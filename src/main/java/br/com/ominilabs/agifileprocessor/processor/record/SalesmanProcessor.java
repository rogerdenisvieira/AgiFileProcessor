package br.com.ominilabs.agifileprocessor.processor.record;

import br.com.ominilabs.agifileprocessor.model.Salesman;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
public class SalesmanProcessor extends AbstractRecordProcessor {


    private static final Logger LOG = LoggerFactory.getLogger(SalesmanProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {

        String[] recordValues = this.extractExchangeRecordValues(exchange);


        Salesman salesman = new Salesman(
                recordValues[1],
                recordValues[2],
                Float.parseFloat(recordValues[3])
        );

        exchange.getIn().setHeader("record","salesman");
        exchange.getIn().setBody(salesman);

        LOG.info(salesman.toString());
    }
}
