package com.gourianova.acoustic.dao;


import com.gourianova.acoustic.Entity;
import com.gourianova.acoustic.Material;
import com.gourianova.acoustic.db.ConnectionPool;
import com.gourianova.acoustic.db.ProxyConnection;
import com.gourianova.acoustic.exception.DaoException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class MaterialDao extends AbstractDao<Material> {

    private final static String SQL_FIND_ALL_MATERIALS = "SELECT * FROM materials;";
    private final static String SQL_CREATE_MATERIAL = "INSERT INTO materials (Unit, Source, Url) VALUES (?, ?, ?);";
    private final static String SQL_FIND_MATERIAL_BY_ID = "SELECT * FROM materials WHERE id = ?;";
    private final static String SQL_DELETE_MATERIAL_BY_ID = "DELETE FROM materials WHERE id=?;";

    @Override
    public ArrayList<Material> findAll() throws DaoException {
        ArrayList<Material> materialsList = new ArrayList<>();
        ProxyConnection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SQL_FIND_ALL_MATERIALS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Material material = new Material();
                material.setId(resultSet.getInt(1));
                material.setUnit(resultSet.getString(2));
                material.setSource(resultSet.getString(3));
                material.setUrl(resultSet.getString(4));
                materialsList.add(material);
            }
        } catch (SQLException e) {
            throw new DaoException("Error in  MaterialDao.findAll method", e);
        } finally {
            close(preparedStatement);
            close(connection);
        }
        System.out.println("Material.findAllOk");
        return materialsList;
    }

    @Override
    public Material findEntityById(Integer id) throws DaoException {
        ProxyConnection connection = null;
        PreparedStatement preparedStatement = null;
        Material material = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SQL_FIND_MATERIAL_BY_ID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                material = new Material();
                material.setId(resultSet.getInt(1));
                material.setUnit(resultSet.getString(2));
                material.setSource(resultSet.getString(3));
                material.setUrl(resultSet.getString(4));
            }
        } catch (SQLException e) {
            throw new DaoException("Error in findEntityById method", e);
        } finally {
            close(preparedStatement);
            close(connection);
        }
        return material;
    }

    @Override
    public boolean createEntity(Material entity) throws DaoException {
        ProxyConnection connection = null;
        PreparedStatement preparedStatement = null;
        boolean isCreate;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SQL_CREATE_MATERIAL);
            preparedStatement.setString(1, entity.getUnit());
            preparedStatement.setString(2, entity.getSource());
            preparedStatement.setString(3, entity.getUrl());
            preparedStatement.executeUpdate();
            isCreate = true;
        } catch (SQLException e) {
            throw new DaoException("Error in createEntity", e);
        } finally {
            close(preparedStatement);
            close(connection);
        }
        return isCreate;
    }

    @Override
    public boolean deleteEntityById(Integer id) throws DaoException {
        ProxyConnection connection = null;
        boolean isDeleted = false;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SQL_DELETE_MATERIAL_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            isDeleted = true;
        } catch (SQLException e) {
            throw new DaoException("Error in deleteEntity method", e);
        } finally {
            close(preparedStatement);
            close(connection);
        }
        return isDeleted;
    }

    //TODO: ?
    @Override
    public Entity editEntity(Integer entityId) {
        return null;
    }

    @Override
    public Material updateEntity(Material entity) throws DaoException {
        return null;
    }

}
