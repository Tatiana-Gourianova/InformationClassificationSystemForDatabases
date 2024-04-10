package com.gourianova.acoustic.service;


import com.gourianova.acoustic.Item;
import com.gourianova.acoustic.ItemChange;
import com.gourianova.acoustic.dao.ItemChangeDao;
import com.gourianova.acoustic.dao.ItemDao;
import com.gourianova.acoustic.exception.DaoException;
import com.gourianova.acoustic.exception.ServiceException;

import java.util.ArrayList;

public class ItemChangeService {
    private static ItemChangeDao itemChangeDao = new ItemChangeDao();
    private ItemDao itemDao = new ItemDao();


    public boolean createItem(ItemChange itemChange) throws ServiceException {
        try {
            return itemChangeDao.createEntity(itemChange);
        } catch (DaoException e) {
            throw new ServiceException("Transaction failed in createApp method", e);
        }
    }
    public static ItemChange findEntityById(Integer id) throws ServiceException {
        try {
            return itemChangeDao.findEntityById(id);
        } catch (DaoException e) {
            throw new ServiceException("Transaction failed in findEntityById method", e);
        }
    }

    public ArrayList<ItemChange> findAllUserOrders(Integer userId) throws ServiceException {
        try {
            return itemChangeDao.findAllUserItemChanges(userId);
        } catch (DaoException e) {
            throw new ServiceException("Transaction failed in findAllUserOrders method", e);
        }
    }

    public ArrayList<ItemChange> findAll() throws ServiceException {
        try {
            return itemChangeDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException("Transaction failed in findAll method", e);
        }
    }

    public ArrayList<ItemChange> findUnclosed() throws ServiceException {
        try {
            return null;
            //itemChangeDao.findUnclosed();
        } catch (Exception e){//(DaoException e) {
            throw new ServiceException("Transaction failed in findUnclosed method", e);
        }
    }
}
