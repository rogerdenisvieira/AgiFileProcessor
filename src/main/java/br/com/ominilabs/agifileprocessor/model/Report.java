package br.com.ominilabs.agifileprocessor.model;

import javax.jnlp.IntegrationService;

public class Report {



    private final String TEXT_RECORDS_QUANTITY_SOURCE_FILE = "Quantidade de clientes no arquivo de entrada";
    private final String TEXT_SALESMEN_QUANTITY_SOURCE_FILE = "Quantidade de vendedor no arquivo de entrada";
    private final String TEXT_ID_EXPENSIVEST_SALE = "ID da venda mais cara";
    private final String TEXT_WORST_SALESMAN = "O pior vendedor";


    private Integer sourceFileRecordsQuantity;
    private Integer sourceFileSalesmenQuantity;
    private Integer expensivestSaleId;
    private String worstSalesman;

    public Report(Integer sourceFileRecordsQuantity, Integer sourceFileSalesmenQuantity, Integer expensivestSaleId, String worstSalesman) {
        this.sourceFileRecordsQuantity = sourceFileRecordsQuantity;
        this.sourceFileSalesmenQuantity = sourceFileSalesmenQuantity;
        this.expensivestSaleId = expensivestSaleId;
        this.worstSalesman = worstSalesman;
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();

        builder.append(TEXT_RECORDS_QUANTITY_SOURCE_FILE + ": "+ this.sourceFileRecordsQuantity);
        builder.append("\n");
        builder.append(TEXT_SALESMEN_QUANTITY_SOURCE_FILE + ": " + this.sourceFileSalesmenQuantity);
        builder.append("\n");
        builder.append(TEXT_ID_EXPENSIVEST_SALE + ": " + this.expensivestSaleId);
        builder.append("\n");
        builder.append(TEXT_WORST_SALESMAN + ": " + this.worstSalesman);

        return builder.toString();

    }
}
