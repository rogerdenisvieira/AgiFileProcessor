package br.com.ominilabs.agifileprocessor.processor.record;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class InvalidRecordProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {

        String value = exchange.getIn().getBody(String.class);

        exchange.getIn().setBody(null);
    }
}
