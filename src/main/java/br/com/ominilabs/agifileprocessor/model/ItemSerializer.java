package br.com.ominilabs.agifileprocessor.model;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ItemSerializer {

    private static final String GROUP_DELIMITER = ",";
    private static final String VALUE_DELIMITER = "-";
    private static final String GROUP_START_DELIMITER = "[";
    private static final String GROUP_END_DELIMITER = "]";


    public static List<Item> serialize(String unformattedList) {

        /**
         *
         * @author Roger D. Vieira
         * @return a list of items
         *
         */

        List<Item> formattedItemList = new ArrayList<Item>();

        //removing brackets from item list
        unformattedList = StringUtils.removeStart(unformattedList, GROUP_START_DELIMITER);
        unformattedList = StringUtils.removeEnd(unformattedList, GROUP_END_DELIMITER);


        //splitting list by its value groups
        String[] splittedByGroup = unformattedList.split(GROUP_DELIMITER);


        String[] ids = splittedByGroup[0].split(VALUE_DELIMITER);
        String[] quantities = splittedByGroup[1].split(VALUE_DELIMITER);
        String[] prices = splittedByGroup[2].split(VALUE_DELIMITER);

        for (int i = 0; i < ids.length; i++) {
            formattedItemList.add(
                    new Item(
                            Integer.parseInt(ids[i]),
                            Float.parseFloat(quantities[i]),
                            Float.parseFloat(prices[i])
                    )
            );
        }

        return formattedItemList;
    }
}

