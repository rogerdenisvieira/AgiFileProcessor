package br.com.ominilabs.agifileprocessor.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.file.GenericFile;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class FileProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        String fileContent = (String) exchange.getIn().getBody();

        String[] splittedContent = fileContent.split("\n");

    }
}
