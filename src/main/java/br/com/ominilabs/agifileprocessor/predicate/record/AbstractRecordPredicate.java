package br.com.ominilabs.agifileprocessor.predicate.record;

import br.com.ominilabs.agifileprocessor.processor.ReportProcessor;
import br.com.ominilabs.agifileprocessor.properties.AgiFileProcessorProperties;
import org.apache.camel.Exchange;
import org.apache.camel.Predicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractRecordPredicate implements Predicate {

    @Autowired
    private AgiFileProcessorProperties properties;

    @Override
    public boolean matches(Exchange exchange) {
        return false;
    }

    private static final Logger LOG = LoggerFactory.getLogger(AbstractRecordPredicate.class);

    /**
     *
     * @author Roger D. Vieira
     * @return a boolean checking whether record is of a provided type or not
     *
     */
    public boolean isValidRecordForTheID(Exchange exchange, String id) {
        String record = (String) exchange.getIn().getBody();
        String[] recordData = (String[]) record.split(this.properties.getDelimiter());
        Boolean isValid = recordData[0].equals(id) ? true : false;

        LOG.info("Record ID:" + recordData[0] + " Config ID: " + id + " Content:" + record + " isValid: " + isValid);

        return isValid;

    }
}
