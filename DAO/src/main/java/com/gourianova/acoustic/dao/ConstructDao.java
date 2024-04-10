package com.gourianova.acoustic.dao;


import com.gourianova.acoustic.Construct;
import com.gourianova.acoustic.Entity;
import com.gourianova.acoustic.db.ConnectionPool;
import com.gourianova.acoustic.db.ProxyConnection;
import com.gourianova.acoustic.exception.DaoException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ConstructDao extends AbstractDao<Construct> {
    private final static String SQL_FIND_ALL_CONSTRUCTS = "SELECT * FROM constructs;";
    private final static String SQL_CREATE = "INSERT INTO constructs (Type) VALUES(?);";
    private final static String SQL_FIND_CONSTRUCT_BY_ID = "SELECT * FROM constructs WHERE id = ?;";
    private final static String SQL_DELETE_CONSTRUCT_BY_ID = "DELETE FROM constructs WHERE id=?;";
    private final static String SQL_EDIT_CONSTRUCT = "INSERT INTO constructs (Type) VALUES(?) WHERE id = ?;";
    private final static String SQL_CREATE_CONSTRUCT = "INSERT INTO constructs (Type) VALUES (?);";

    @Override
    public ArrayList<Construct> findAll() throws DaoException {
        ArrayList<Construct> constructsList = new ArrayList<>();
        ProxyConnection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SQL_FIND_ALL_CONSTRUCTS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Construct construct = new Construct();
                construct.setId(resultSet.getInt(1));
                construct.setType(resultSet.getString(2));

                constructsList.add(construct);
            }
        } catch (SQLException e) {
            throw new DaoException("Error in ConstructDao.findAll method", e);
        } finally {
            close(preparedStatement);
            close(connection);
        }
        System.out.println("Construct.findAllOk");
        return constructsList;
    }

    @Override
    public Construct findEntityById(Integer id) throws DaoException {
        ProxyConnection connection = null;
        PreparedStatement preparedStatement = null;
        Construct construct = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SQL_FIND_CONSTRUCT_BY_ID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                construct = new Construct();
                construct.setId(resultSet.getInt(1));
                construct.setType(resultSet.getString(2));

            }
        } catch (SQLException e) {
            throw new DaoException("Error in findEntityById method", e);
        } finally {
            close(preparedStatement);
            close(connection);
        }
        return construct;
    }

    public void create(Construct entity) throws DaoException {
        ProxyConnection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SQL_CREATE);
            preparedStatement.setString(1, entity.getType());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Error in ConstructDao.create method", e);
        } finally {
            close(preparedStatement);
            close(connection);
        }
    }

    public Construct updateEntity(Construct entity) throws DaoException {
        ProxyConnection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SQL_EDIT_CONSTRUCT);
            preparedStatement.setString(1, entity.getType());

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
    public boolean createEntity(Construct entity) throws DaoException {
        ProxyConnection connection = null;
        PreparedStatement preparedStatement = null;
        boolean isCreate;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SQL_CREATE_CONSTRUCT);
            preparedStatement.setString(1, entity.getType());
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