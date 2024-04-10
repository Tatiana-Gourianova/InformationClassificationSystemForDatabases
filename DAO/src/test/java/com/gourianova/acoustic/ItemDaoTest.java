package com.gourianova.acoustic;

import com.gourianova.acoustic.dao.ItemDao;
import com.gourianova.acoustic.exception.DaoException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class ItemDaoTest {
    private int item_Id;
    private String expectedName;

    public ItemDaoTest(int items_Id, String expectedNames) {
        this.item_Id = items_Id;
        this.expectedName = expectedNames;
    }

    @Parameters
    public static Collection<Object[]> multipleTableVales() {
        return Arrays.asList(new Object[][]{

                {74, "item1"},
                {75, "item2"},
                {76, "item3"}

        });
    }

    @Test
    public void findItemByIdTest001() {
        String actualName = null;
        ItemDao itemDao = new ItemDao();
        try {

            Item item = itemDao.findEntityById(item_Id);
            actualName = item.getName();
            Assert.assertEquals(expectedName, actualName);
        } catch (DaoException e) {
            e.printStackTrace();
        }

    }

}