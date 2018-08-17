package br.com.ominilabs.agifileprocessor.model;

import org.junit.Assert;
import org.junit.Test;

public class ItemSerializerTest {

    private Sale sale;
    private String validItemList = "[1-10-100,2-30-2.50,3-40-3.10]";

    @Test
    public void validItemList(){

        ItemSerializer.serialize(this.validItemList);

        Assert.assertTrue(Boolean.FALSE);
    }

    @Test
    public void invalidItemList(){
        Assert.assertTrue(Boolean.FALSE);
    }
}
