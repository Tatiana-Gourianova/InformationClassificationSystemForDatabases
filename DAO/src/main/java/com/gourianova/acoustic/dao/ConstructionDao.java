package com.gourianova.acoustic.dao;


import com.gourianova.acoustic.Construction;
import com.gourianova.acoustic.Entity;
import com.gourianova.acoustic.db.ConnectionPool;
import com.gourianova.acoustic.db.ProxyConnection;
import com.gourianova.acoustic.exception.DaoException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ConstructionDao extends AbstractDao<Construction> {
    private final static String SQL_FIND_ALL_CONSTRUCTIONS = "SELECT * FROM constructions;";
    private final static String SQL_CREATE = "INSERT INTO constructions (title) VALUES(?);";
    private final static String SQL_FIND_CONSTRUCT_BY_ID = "SELECT * FROM constructions WHERE id = ?;";
    private final static String SQL_DELETE_CONSTRUCT_BY_ID = "DELETE FROM constructions WHERE id=?;";
    private final static String SQL_EDIT_CONSTRUCT = "INSERT INTO constructions (title) VALUES(?) WHERE id = ?;";
    private final static String SQL_CREATE_CONSTRUCT = "INSERT INTO constructions (title) VALUES (?);";

    @Override
    public ArrayList<Construction> findAll() throws DaoException {
        ArrayList<Construction> constructsList = new ArrayList<>();
        ProxyConnection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SQL_FIND_ALL_CONSTRUCTIONS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Construction construct = new Construction();
                construct.setId(resultSet.getInt(1));
                construct.setTitle(resultSet.getString(2));
                constructsList.add(construct);
            }
        } catch (SQLException e) {
            throw new DaoException("Error in ConstructionDao.findAll method", e);
        } finally {
            close(preparedStatement);
            close(connection);
        }
        System.out.println("Construction.findAllOk");
        return constructsList;
    }

    @Override
    public Construction findEntityById(Integer id) throws DaoException {
        ProxyConnection connection = null;
        PreparedStatement preparedStatement = null;
        Construction construct = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SQL_FIND_CONSTRUCT_BY_ID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                construct = new Construction();
                construct.setId(resultSet.getInt(1));
                construct.setTitle(resultSet.getString(2));

            }
        } catch (SQLException e) {
            throw new DaoException("Error in findEntityById method", e);
        } finally {
            close(preparedStatement);
            close(connection);
        }
        return construct;
    }


    public void create(Construction entity) throws DaoException {
        ProxyConnection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SQL_CREATE);
            preparedStatement.setString(1, entity.getTitle());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Error in ConstructDao.create method", e);
        } finally {
            close(preparedStatement);
            close(connection);
        }
    }

    public Construction updateEntity(Construction entity) throws DaoException {
        ProxyConnection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SQL_EDIT_CONSTRUCT);
            preparedStatement.setString(1, entity.getTitle());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Error in ConstructDao.updateEntity method", e);
        } finally {
            close(preparedStatement);
            close(connection);
        }
        return entity;
    }

    @Override
    public boolean createEntity(Construction entity) throws DaoException {
        ProxyConnection connection = null;
        PreparedStatement preparedStatement = null;
        boolean isCreate;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SQL_CREATE_CONSTRUCT);
            preparedStatement.setString(1, entity.getTitle());
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
            preparedStatement = connection.prepareStatement(SQL_DELETE_CONSTRUCT_BY_ID);
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

    @Override
    public Entity editEntity(Integer entityId) {
        return null;
    }


}