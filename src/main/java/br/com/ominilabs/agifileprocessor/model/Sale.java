package br.com.ominilabs.agifileprocessor.model;

import java.util.List;

public class Sale {

    //003çSale IDç[Item ID-Item Quantity-Item Price]çSalesman name

    private final String GROUP_DELIMITER = ",";
    private final String VALUE_DELIMITER = "-";



    private Integer id;
    private String items;
    private String salesmanName;

    public Sale(Integer id, String items, String salesmanName) {
        this.id = id;
        this.items = items;
        this.salesmanName = salesmanName;
    }

    public Integer getId() {
        return id;
    }

    public List<Item> getItems() {
        return items;
    }

    public String getSalesmanName() {
        return salesmanName;
    }
}
