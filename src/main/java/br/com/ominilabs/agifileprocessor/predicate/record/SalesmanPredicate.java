package br.com.ominilabs.agifileprocessor.predicate.record;

import br.com.ominilabs.agifileprocessor.properties.AgiFileProcessorProperties;
import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SalesmanPredicate extends AbstractRecordPredicate {

    private AgiFileProcessorProperties properties;

    @Autowired
    public SalesmanPredicate(AgiFileProcessorProperties properties) {
        this.properties = properties;
    }

    @Override
    public boolean matches(Exchange exchange) {
        return this.isValidRecordForTheID(exchange, properties.getRecordSalesmanId());
    }
}
