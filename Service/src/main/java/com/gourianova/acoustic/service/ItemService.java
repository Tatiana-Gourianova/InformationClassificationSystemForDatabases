package com.gourianova.acoustic.service;


import com.gourianova.acoustic.exception.ServiceException;
import com.gourianova.acoustic.Item;
import com.gourianova.acoustic.dao.ItemDao;
import com.gourianova.acoustic.exception.DaoException;
import com.gourianova.acoustic.util.ValidateItem;

import java.util.ArrayList;


public class ItemService {

    private ItemDao itemDao = new ItemDao();

    public ArrayList<Item> findAll() throws ServiceException {
        ArrayList<Item> itemsList;
        try {
            itemsList = itemDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException("Transaction failed in findAll method", e);
        }
        return itemsList;
    }

    public ArrayList<Item> findAllByPage(int pageCapacity, int pageNumber) throws ServiceException {
        ArrayList<Item> itemsList;
        try {
            itemsList = itemDao.findAllByPage(pageCapacity, pageNumber);
        } catch (DaoException e) {
            throw new ServiceException("Transaction failed in findAllByPage method", e);
        }
        return itemsList;
    }

    public ArrayList<Item>  findEntityByTitleAndModel(String name, String model) throws ServiceException {
        ArrayList<Item> itemsList;
        try {
            itemsList = itemDao. findEntityByTitleAndModel(name, model);
        } catch (DaoException e) {
            throw new ServiceException("Transaction failed in findEntityByTitleAndModel method", e);
        }
        return itemsList;

    }

    public Item editEntity(Integer entityId) throws ServiceException {
        Item item;
        item = itemDao.editEntity(entityId);

        return item;
    }

    public Item findItemById(Integer id) throws ServiceException {
        try {
            return itemDao.findEntityById(id);
        } catch (DaoException e) {
            throw new ServiceException("Transaction failed in findUserById method", e);
        }
    }

    public boolean createItem(Item item) throws ServiceException {
        try {
            return itemDao.createEntity(item);
        } catch (DaoException e) {
            throw new ServiceException("Transaction failed in createApp method", e);
        }
    }

    public boolean deleteEntityById(Integer id) throws ServiceException {
        try {
            return itemDao.deleteEntityById(id);
        } catch (DaoException e) {
            throw new ServiceException("Transaction failed in delete method", e);
        }

    }
    public String validateItem(Item Item) throws ServiceException {

        return ValidateItem.validate(Item);
    }

    public Item updateItem(Item item) throws ServiceException {
        Item newItem = new Item();
        try {
            newItem = itemDao.updateEntity(item);
        } catch (DaoException e) {
            throw new ServiceException("Transaction failed in updateUser method", e);
        }
        return newItem;
    }
}
