package br.com.ominilabs.agifileprocessor.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ItemSerializerTest {

    private Sale sale;
    private String validItemList = "[1-10-100,2-30-2.50,3-40-3.10]";
    private String invalidItemList = "[1-10-@,2-30-2&50,3-40-3,10]";
    private List<Item> itemList;

    @Before
    public void setup() {
        this.itemList = ItemSerializer.serialize(this.validItemList);
    }

    @Test
    public void checkIdIntoValidItemList() {

        Integer expectedId = 1;
        Assert.assertEquals(expectedId, itemList.get(0).getId());
    }

    @Test
    public void checkQuantityIntoValidItemList() {

        Float expectedQuantity = 30f;
        Assert.assertEquals(expectedQuantity, itemList.get(1).getQuantity());
    }

    @Test
    public void checkQPriceIntoValidItemList() {

        Float expectedPrice = 3.10f;
        Assert.assertEquals(expectedPrice, itemList.get(2).getPrice());
    }

    @Test(expected = Exception.class)
    public void invalidItemListParser() {

        this.itemList = ItemSerializer.serialize(this.invalidItemList);

    }
}
