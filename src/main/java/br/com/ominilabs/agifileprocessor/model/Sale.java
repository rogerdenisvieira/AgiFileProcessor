package br.com.ominilabs.agifileprocessor.model;

import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;
import java.util.List;

public class Sale {

    //003çSale IDç[Item ID-Item Quantity-Item Price]çSalesman name

    private Integer id;
    private String salesmanName;
    private List<Item> items;

    public Sale(Integer id, List<Item> items, String salesmanName) {
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

    public Float calculateTotalSaleValue() {
        Float total = 0.0f;

        for(Item i : items){
            total += i.getPrice();
        }

        return total;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", salesmanName='" + salesmanName + '\'' +
                ", items=" + items +
                '}';
    }
}
