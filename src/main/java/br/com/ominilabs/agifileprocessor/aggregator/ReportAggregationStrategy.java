package br.com.ominilabs.agifileprocessor.aggregator;

import br.com.ominilabs.agifileprocessor.processor.record.SaleProcessor;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;


public class ReportAggregationStrategy implements AggregationStrategy {

    private static final Logger LOG = LoggerFactory.getLogger(SaleProcessor.class);

    /*
       *
       *  Here I used a copy and paste cuz I knew that I needed to use and aggregator, but I had no
       *  time to search and implement it myself, so I decided to use the following solution:
       *
       *  https://www.sourceallies.com/2014/01/how-to-implement-the-splitter-and-aggregator-patterns-with-apache-camel/
       *
     */

    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
            Message newIn = newExchange.getIn();
            Object newBody = newIn.getBody();

            LOG.info("New exchange: " + newExchange.getIn().getBody());

            ArrayList list = null;
            if (oldExchange == null) {
                list = new ArrayList();
                list.add(newBody);
                newIn.setBody(list);
                return newExchange;
            } else {
                Message in = oldExchange.getIn();
                list = in.getBody(ArrayList.class);
                list.add(newBody);
                return oldExchange;
            }
        }
    }

