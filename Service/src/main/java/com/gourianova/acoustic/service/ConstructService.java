package com.gourianova.acoustic.service;


import com.gourianova.acoustic.Construct;
import com.gourianova.acoustic.dao.ConstructDao;
import com.gourianova.acoustic.exception.DaoException;
import com.gourianova.acoustic.exception.ServiceException;

import java.util.ArrayList;


public class ConstructService {
    private ConstructDao constructDao = new ConstructDao();

    public ArrayList<Construct> findAll() throws ServiceException {
        ArrayList<Construct> typesList;
        try {
            typesList = constructDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException("Transaction failed in findAll method", e);
        }
        return typesList;
    }

    public boolean createItemType(Construct construct) throws ServiceException {
        try {
            return constructDao.createEntity(construct);
        } catch (DaoException e) {
            throw new ServiceException("Transaction failed in createStation method", e);
        }
    }

    public void create(Construct construct) throws ServiceException {
        try {
            constructDao.create(construct);
        } catch (DaoException e) {
            throw new ServiceException("Transaction failed in create method", e);
        }
    }

    public boolean deleteEntityById(int id) throws ServiceException {

        try {
            return constructDao.deleteEntityById(id);
        } catch (DaoException e) {
            throw new ServiceException("Transaction failed in delete method", e);
        }


    }
}
