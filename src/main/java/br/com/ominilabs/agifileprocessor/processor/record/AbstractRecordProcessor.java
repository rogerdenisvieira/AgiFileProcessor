package br.com.ominilabs.agifileprocessor.processor.record;


import br.com.ominilabs.agifileprocessor.properties.AgiFileProcessorProperties;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractRecordProcessor implements Processor {

    @Autowired
    private AgiFileProcessorProperties properties;


    @Override
    public void process(Exchange exchange) throws Exception {

    }


    /**
     *
     * @author Roger D. Vieira
     * @return a string array containing values from exchange
     *
     */

    public String[] extractExchangeRecordValues(Exchange exchange) {
        String record = (String) exchange.getIn().getBody();
        String[] recordValues = record.split(this.properties.getDelimiter());

        return recordValues;

    }

}
