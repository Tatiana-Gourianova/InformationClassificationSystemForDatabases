package com.gourianova.acoustic.dao;


import com.gourianova.acoustic.Item;
import com.gourianova.acoustic.db.ConnectionPool;
import com.gourianova.acoustic.db.ProxyConnection;
import com.gourianova.acoustic.exception.DaoException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ItemDao extends AbstractDao<Item> {
    private final static String SQL_CREATE_ITEM = "INSERT INTO  items (Name,  Thickness, Density, Si63, Si125, Si250, Si500, Si1000, Si2000, Si4000, Si8000) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private final static String SQL_FIND_ALL_ITEMS = "SELECT*  FROM items;";

    private final static String SQL_FIND_BY_PAGE = "SELECT * FROM items ORDER BY items.Id LIMIT ? OFFSET ?;";

    private final static String SQL_FIND_BY_ID = "SELECT * FROM items WHERE id = ?;";
    private final static String SQL_FIND_ITEM = "SELECT items.Id ,   items.Name, items.Thickness, items.Density  FROM items WHERE  items.Name=? ;";
    private final static String SQL_DELETE_ITEM_BY_ID = "DELETE FROM  items  WHERE items.Id = ?;";
    private final static String SQL_UPDATE_ITEM = "UPDATE items SET Name=?, Thickness=?, Density=? Si63=?, Si125=?, Si250=?, Si500=?, Si1000=?, Si2000=?, Si4000=?, Si8000=? WHERE Id=?;";

    @Override
    public boolean createEntity(Item entity) throws DaoException {
        ProxyConnection connection = null;
        PreparedStatement preparedStatement = null;
        boolean isCreated;
        System.out.println("DAOItem");
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SQL_CREATE_ITEM);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setBigDecimal(2, entity.getThickness());
            preparedStatement.setBigDecimal(3, entity.getDensity());
            preparedStatement.setInt(4, entity.getSi63());
            preparedStatement.setInt(5, entity.getSi125());
            preparedStatement.setInt(6, entity.getSi250());
            preparedStatement.setInt(7, entity.getSi500());
            preparedStatement.setInt(8, entity.getSi1000());
            preparedStatement.setInt(9, entity.getSi2000());
            preparedStatement.setInt(10, entity.getSi4000());
            preparedStatement.setInt(11, entity.getSi8000());
            preparedStatement.executeUpdate();
            System.out.println("DAOItem.createEntity OK ");
            isCreated = true;
        } catch (SQLException e) {
            throw new DaoException("Error in createEntity", e);
        } finally {
            close(preparedStatement);
            close(connection);
        }
        return isCreated;
    }

    //TODO write+
    @Override
    public Item updateEntity(Item item) throws DaoException {
        ProxyConnection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SQL_UPDATE_ITEM);
            preparedStatement.setString(1, item.getName());
            preparedStatement.setBigDecimal(2, item.getThickness());
            preparedStatement.setBigDecimal(3, item.getDensity());
            preparedStatement.setInt(4, item.getSi63());
            preparedStatement.setInt(5, item.getSi125());
            preparedStatement.setInt(6, item.getSi500());
            preparedStatement.setInt(7, item.getSi1000());
            preparedStatement.setInt(8, item.getSi2000());
            preparedStatement.setInt(9, item.getSi4000());
            preparedStatement.setInt(10, item.getSi8000());
            preparedStatement.setLong(11, item.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Error in updateEntity method", e);
        } finally {
            close(preparedStatement);
            close(connection);
        }
        return item;
    }

    @Override
    public ArrayList<Item> findAll() throws DaoException {
        ArrayList<Item> itemsList = new ArrayList<>();
        ProxyConnection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SQL_FIND_ALL_ITEMS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Item item = buildItem(resultSet);
                itemsList.add(item);
            }
        } catch (SQLException e) {
            throw new DaoException("Error in findAll method", e);
        } finally {
            close(preparedStatement);
            close(connection);
        }
        System.out.println("ItemDao.findAllOk");
        return itemsList;
    }

    @Override
    public Item findEntityById(Integer id) throws DaoException {
        Item item = null;
        ProxyConnection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SQL_FIND_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                item = buildItem(resultSet);
            }

        } catch (SQLException e) {
            throw new DaoException("Error in findEntityByID method", e);
        } finally {
            close(preparedStatement);
            close(connection);
        }
        return item;
    }

    @Override
    public boolean deleteEntityById(Integer id) throws DaoException {
        ProxyConnection connection = null;
        boolean isDeleted = false;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SQL_DELETE_ITEM_BY_ID);
            preparedStatement.setLong(1, id);
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

    //TODO write
    @Override
    public Item editEntity(Integer entityId) {

        return null;
    }


    public ArrayList<Item> findAllByPage(int pageCapacity, int pageNumber) throws DaoException {
        ArrayList<Item> itemsList = new ArrayList<>();
        ProxyConnection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SQL_FIND_BY_PAGE);
            preparedStatement.setInt(1, pageCapacity);
            preparedStatement.setInt(2, (pageNumber * pageCapacity - pageCapacity));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Item item = buildItem(resultSet);
                itemsList.add(item);
            }
        } catch (SQLException e) {
            throw new DaoException("Error in findAllByPage method", e);
        } finally {
            close(preparedStatement);
            close(connection);
        }
        return itemsList;
    }

    public ArrayList<Item> findEntityByTitleAndModel(String name, String model) throws DaoException {
        ArrayList<Item> itemsList = new ArrayList<>();
        Item item = null;
        ProxyConnection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SQL_FIND_ITEM);
            // preparedStatement = connection.prepareStatement(SQL_FIND_BY_ID);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                item = buildItem(resultSet);
                itemsList.add(item);
            }


        } catch (SQLException e) {
            throw new DaoException("Error in findEntityByID method", e);
        } finally {
            close(preparedStatement);
            close(connection);
        }
        return itemsList;
    }

    private Item buildItem(ResultSet resultSet) throws SQLException {
        Item item = new Item();
        item.setId(Math.toIntExact(resultSet.getLong(1)));
        item.setName(resultSet.getString(2));
        item.setThickness(resultSet.getBigDecimal(3));
        item.setDensity(resultSet.getBigDecimal(4));
        item.setSi63(resultSet.getInt(5));
        item.setSi125(resultSet.getInt(6));
        item.setSi250(resultSet.getInt(7));
        item.setSi500(resultSet.getInt(8));
        item.setSi1000(resultSet.getInt(9));
        item.setSi2000(resultSet.getInt(10));
        item.setSi4000(resultSet.getInt(11));
        //TODO сделать обработку если null
        //  if (resultSet.getString(12).isEmpty()) {
        item.setSi8000(resultSet.getInt(12));
        return item;
    }


}
