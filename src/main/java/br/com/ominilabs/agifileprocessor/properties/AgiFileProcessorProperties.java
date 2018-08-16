package br.com.ominilabs.agifileprocessor.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AgiFileProcessorProperties {

    @Value("${file.path.input}")
    private String fileInputPath;

    @Value("${file.path.output}")
    private String fileOutputPath;

    @Value("${file.path.output.extension}")
    private String fileOutputExtension;

    @Value("${register.id.vendor}")
    private String dataVendorID;

    @Value("${register.id.customer}")
    private String dataCustomerID;

    @Value("${register.id.sales}")
    private String dataSalesID;

    @Value("${register.delimiter}")
    private String dataDelimiter;

}

