package br.com.ominilabs.agifileprocessor.processor.record;

import br.com.ominilabs.agifileprocessor.model.ItemSerializer;
import br.com.ominilabs.agifileprocessor.model.Sale;
import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SaleProcessor extends AbstractRecordProcessor {

    private static final Logger LOG = LoggerFactory.getLogger(SaleProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {

        String[] recordValues = this.extractExchangeRecordValues(exchange);

        Sale sale = new Sale(
                Integer.parseInt(recordValues[1]),
                ItemSerializer.serialize(recordValues[2]),
                recordValues[3]
        );

        exchange.getIn().setHeader("record","sale");
        exchange.getIn().setBody(sale);

        LOG.info(sale.toString());

    }
}
