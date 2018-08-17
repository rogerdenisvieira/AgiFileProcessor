package br.com.ominilabs.agifileprocessor.predicate.record;

import br.com.ominilabs.agifileprocessor.properties.AgiFileProcessorProperties;
import org.apache.camel.Exchange;
import org.apache.camel.Predicate;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractRecordPredicate implements Predicate {

    @Autowired
    private AgiFileProcessorProperties properties;

    @Override
    public boolean matches(Exchange exchange) {
        return false;
    }


    public boolean isValidRecordForTheID(Exchange exchange, String id){
        String record = (String) exchange.getIn().getBody();
        String[] recordData = (String[]) record.split(this.properties.getDelimiter());

        return recordData[0].equals(id) ? true : false;

    }
}
