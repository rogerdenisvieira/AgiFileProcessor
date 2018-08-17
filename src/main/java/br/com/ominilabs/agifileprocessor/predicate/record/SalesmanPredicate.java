package br.com.ominilabs.agifileprocessor.predicate.record;

import br.com.ominilabs.agifileprocessor.properties.AgiFileProcessorProperties;
import org.apache.camel.Exchange;
import org.apache.camel.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SalesmanPredicate extends AbstractRecordPredicate implements Predicate {

    private AgiFileProcessorProperties properties;

    @Autowired
    public SalesmanPredicate(AgiFileProcessorProperties properties) {
        this.properties = properties;
    }

    @Override
    public boolean matches(Exchange exchange) {
        return isValidRecordForTheID(exchange, properties.getRecordSalesmanId());
    }
}
