package com.gourianova.acoustic.service;


import com.gourianova.acoustic.Construction;
import com.gourianova.acoustic.exception.DaoException;
import com.gourianova.acoustic.exception.ServiceException;
import com.gourianova.acoustic.dao.ConstructionDao;
import java.util.ArrayList;


public class ConstructionService {
    private ConstructionDao constructionDao = new ConstructionDao();

    public ArrayList<Construction> findAll() throws ServiceException {
        ArrayList<Construction> constructionsList;
        try {
            constructionsList = constructionDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException("Transaction failed in findAll method", e);
        }
        return constructionsList;
    }

    public boolean createItemType(Construction construct) throws ServiceException {
        try {
            return constructionDao.createEntity(construct);
        } catch (DaoException e) {
            throw new ServiceException("Transaction failed in createStation method", e);
        }
    }

    public void create(Construction construct) throws ServiceException {
        try {
            constructionDao.create(construct);
        } catch (DaoException e) {
            throw new ServiceException("Transaction failed in create method", e);
        }
    }

    public boolean deleteEntityById(int id) throws ServiceException {
        try {
            return constructionDao.deleteEntityById(id);
        } catch (DaoException e) {
            throw new ServiceException("Transaction failed in delete method", e);
        }
    }
}
