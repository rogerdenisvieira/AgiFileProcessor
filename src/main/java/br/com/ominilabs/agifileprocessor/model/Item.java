package br.com.ominilabs.agifileprocessor.model;

public class Item {

    //[Item ID-Item Quantity-Item Price]

    private Integer id;
    private Integer quantity;
    private Float price;

    public Item(Integer id, Integer quantity, Float price) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Float getPrice() {
        return price;
    }
}
