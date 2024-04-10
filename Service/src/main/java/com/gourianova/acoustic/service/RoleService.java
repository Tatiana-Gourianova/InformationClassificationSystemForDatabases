package com.gourianova.acoustic.service;


import com.gourianova.acoustic.Role;
import com.gourianova.acoustic.dao.RoleDao;
import com.gourianova.acoustic.exception.DaoException;
import com.gourianova.acoustic.exception.ServiceException;

import java.util.ArrayList;


public class RoleService {
    private RoleDao roleDao = new RoleDao();

    public ArrayList<Role> findAll() throws ServiceException {
        try {
            return roleDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException("Transaction failed in findAll method", e);
        }
    }

    public boolean createRole(Role role) throws ServiceException {
        try {
            return roleDao.createEntity(role);
        } catch (DaoException e) {
            throw new ServiceException("Transaction failed in createRole method", e);
        }
    }


    public boolean deleteEntityById(Integer id) throws ServiceException {
        try {
            return roleDao.deleteEntityById(id);
        } catch (DaoException e) {
            throw new ServiceException("Transaction failed in createRole method", e);
        }
    }
}
