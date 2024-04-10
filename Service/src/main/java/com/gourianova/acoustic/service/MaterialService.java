package com.gourianova.acoustic.service;


import com.gourianova.acoustic.Material;
import com.gourianova.acoustic.dao.ConstructDao;
import com.gourianova.acoustic.dao.MaterialDao;
import com.gourianova.acoustic.exception.DaoException;
import com.gourianova.acoustic.exception.ServiceException;

import java.util.ArrayList;

public class MaterialService {

    private MaterialDao materialDao = new MaterialDao();

    public  ArrayList<Material> findAll() throws ServiceException {
        try {
            return materialDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException("Transaction failed in findAll method", e);
        }
    }

    public boolean createSensorUnit(Material material) throws ServiceException {
        try {
            return materialDao.createEntity(material);
        } catch (DaoException e) {
            throw new ServiceException("Transaction failed in createStation method", e);
        }
    }

    public boolean deleteEntityById(int id) throws ServiceException {

        try {
            return materialDao.deleteEntityById(id);
        } catch (DaoException e) {
            throw new ServiceException("Transaction failed in delete method", e);
        }


    }
}
