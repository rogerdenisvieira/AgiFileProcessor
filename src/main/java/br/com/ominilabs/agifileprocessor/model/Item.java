package br.com.ominilabs.agifileprocessor.model;

public class Item {

    //[Item ID-Item Quantity-Item Price]

    private Integer id;
    private Float quantity;
    private Float price;

    public Item(Integer id, Float quantity, Float price) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public Float getQuantity() {
        return quantity;
    }

    public Float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
