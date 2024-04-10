package com.gourianova.acoustic.util;

import com.gourianova.acoustic.Item;

import java.util.regex.Pattern;

public class ValidateItem {


    /**
     * Only digits,- up to 100 characters
     */
    private final static Pattern THICKNESS_PATTERN =
            Pattern.compile("([0-9-]{0,100})");

    private final static Pattern DENSITY_PATTERN =
            Pattern.compile("([0-9]*\\.?[0-9]{0,100000})");
    //private final static Pattern RANGE_PATTERN =
      //      Pattern.compile("([0-9]*\\.?[0-9]{1,100})");

    //TODO: validate another properties of the item

    private final static String WRONG_THICKNESS = "thickness";
    private final static String WRONG_DENSITY = "density";
    //private final static String WRONG_RANGE_DATA = "wrongRangeData";



    public static String validate(Item item) {
        if (!THICKNESS_PATTERN.matcher(String.valueOf(item.getThickness())).matches()) {
            return WRONG_THICKNESS;
        }

        if (!DENSITY_PATTERN.matcher(String.valueOf(item.getThickness())).matches()) {
            return WRONG_DENSITY;
        }
      /*  if (!RANGE_PATTERN.matcher(String.valueOf(item.getDensity() - item.getThickness())).matches()) {
            return WRONG_RANGE_DATA;
        }
*/
        return null;
    }

}