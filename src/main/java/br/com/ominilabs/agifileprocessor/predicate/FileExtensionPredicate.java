package br.com.ominilabs.agifileprocessor.predicate;

import br.com.ominilabs.agifileprocessor.properties.AgiFileProcessorProperties;
import org.apache.camel.Exchange;
import org.apache.camel.Predicate;
import org.apache.camel.component.file.GenericFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class FileExtensionPredicate implements Predicate {

    private AgiFileProcessorProperties properties ;

    @Autowired
    public FileExtensionPredicate(AgiFileProcessorProperties properties){
        this.properties = properties;
    }

    @Override
    public boolean matches(Exchange exchange) {

        GenericFile file = (GenericFile) exchange.getIn().getBody();
        return file.getFileName().endsWith(properties.getFileInputExtension());

    }
}
