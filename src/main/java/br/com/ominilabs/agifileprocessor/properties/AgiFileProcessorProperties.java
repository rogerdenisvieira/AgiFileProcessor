package br.com.ominilabs.agifileprocessor.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AgiFileProcessorProperties {

    @Value("${file.path.input}")
    private String fileInputPath;

    @Value("${file.path.output}")
    private String fileOutputPath;

    @Value("${file.path.input.extension}")
    private String fileInputExtension;

    @Value("${record.id.salesman}")
    private String recordSalesmanId;

    @Value("${record.id.customer}")
    private String recordCustomerId;

    @Value("${record.id.sales}")
    private String recordSalesId;

    @Value("${record.delimiter}")
    private String delimiter;

    public String getFileInputPath() {
        return fileInputPath;
    }

    public String getFileOutputPath() {
        return fileOutputPath;
    }

    public String getFileInputExtension() {
        return fileInputExtension;
    }

    public String getRecordSalesmanId() {
        return recordSalesmanId;
    }

    public String getRecordCustomerId() {
        return recordCustomerId;
    }

    public String getRecordSalesId() {
        return recordSalesId;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public void setFileInputPath(String fileInputPath) {
        this.fileInputPath = fileInputPath;
    }

    public void setFileOutputPath(String fileOutputPath) {
        this.fileOutputPath = fileOutputPath;
    }

    public void setFileInputExtension(String fileInputExtension) {
        this.fileInputExtension = fileInputExtension;
    }

    public void setRecordSalesmanId(String recordSalesmanId) {
        this.recordSalesmanId = recordSalesmanId;
    }

    public void setRecordCustomerId(String recordCustomerId) {
        this.recordCustomerId = recordCustomerId;
    }

    public void setRecordSalesId(String recordSalesId) {
        this.recordSalesId = recordSalesId;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }
}

