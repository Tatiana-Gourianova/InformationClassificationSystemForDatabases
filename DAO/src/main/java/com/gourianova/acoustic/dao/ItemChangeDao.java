package com.gourianova.acoustic.dao;


import com.gourianova.acoustic.Entity;
import com.gourianova.acoustic.Item;
import com.gourianova.acoustic.ItemChange;
import com.gourianova.acoustic.db.ConnectionPool;
import com.gourianova.acoustic.db.ProxyConnection;
import com.gourianova.acoustic.exception.DaoException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ItemChangeDao extends AbstractDao<ItemChange> {

    private final static String SQL_CREATE_ITEM_CHANGE = "INSERT INTO  items_changes (Users_Id,Items_Id) VALUES (?,?);";
    private final static String SQL_FIND_ITEM_CHANGE = "SELECT * FROM items_changes WHERE Users_Id=? ORDER BY id DESC LIMIT 1;";
    private final static String SQL_FIND_ALL_ITEM_CHANGES = "SELECT * FROM items_changes;";
    //TODO: write if necessary
    //private final static String SQL_FIND_UNCLOSED_ITEM_CHANGES = "SELECT * FROM item_changes WHERE End_Date IS NULL;";
    //private final static String SQL_FIND_UNCLOSED_USER_ITEM_CHANGE = "SELECT * FROM item_changes WHERE Users_Id=? AND End_Date IS NULL;";
    //private final static String SQL_FIND_ALL_USER_ITEM_CHANGES = "SELECT * FROM item_changes WHERE Users_Id=?;";
    //private final static String SQL_CLOSE_ITEM_CHANGES = "UPDATE item_changes SET End_Date=now(), Value=? WHERE Users_Id=? AND End_Date IS NULL;";
    private final static String SQL_UPDATE_USER = "UPDATE users  Roles_Id=2 WHERE Id=?;";
    private final static String SQL_UPDATE_ITEM = "UPDATE items SET Is_edited=0 WHERE Id=?;";

    @Override
    public ArrayList<ItemChange> findAll() throws DaoException {
        ArrayList<ItemChange> ordersList = new ArrayList<>();
        ItemChange itemChange;
        ProxyConnection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SQL_FIND_ALL_ITEM_CHANGES);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                itemChange = buildItemChange(resultSet);
                ordersList.add(itemChange);
            }
        } catch (SQLException e) {
            throw new DaoException("Error in findAll method", e);
        } finally {
            close(preparedStatement);
            close(connection);
        }
        return ordersList;
    }

    @Override
    public ItemChange findEntityById(Integer userId) throws DaoException {
        ItemChange itemChange = new ItemChange();
        ProxyConnection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SQL_FIND_ITEM_CHANGE);
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                itemChange = buildItemChange(resultSet);
            }
        } catch (SQLException e) {
            throw new DaoException("Error in findEntityById method", e);
        } finally {
            close(preparedStatement);
            close(connection);
        }
        return itemChange;
    }

    @Override
    public boolean createEntity(ItemChange entity) throws DaoException {
               ProxyConnection connection = null;
            PreparedStatement preparedStatement = null;
            boolean isCreated;
            System.out.println("DAOItemChange");
            try {
                connection = ConnectionPool.getInstance().getConnection();
                preparedStatement = connection.prepareStatement(SQL_CREATE_ITEM_CHANGE);
                preparedStatement.setInt(1, entity.getItemId());
                preparedStatement.setInt(2, entity.getUserId());
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


    @Override
    public boolean deleteEntityById(Integer id) throws DaoException {
        return false;
    }

    @Override
    public Entity editEntity(Integer entityId) {
        return null;
    }

    @Override
    public ItemChange updateEntity(ItemChange entity) throws DaoException {
        return null;
    }

    // @Override
    public Item editItem(Integer itemId, Integer userId) {
        return null;
    }

    public ArrayList<ItemChange> findAllUserItemChanges(Integer userId) throws DaoException {
        ArrayList<ItemChange> ordersList = new ArrayList<>();
        ItemChange itemChange;
        ProxyConnection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SQL_FIND_ALL_ITEM_CHANGES);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                itemChange = buildItemChange(resultSet);
                ordersList.add(itemChange);
            }
        } catch (SQLException e) {
            throw new DaoException("Error in findAllUserItemChanges method", e);
        } finally {
            close(preparedStatement);
            close(connection);
        }
        return ordersList;
    }

    private ItemChange buildItemChange(ResultSet resultSet) throws SQLException {
        ItemChange itemChange = new ItemChange();
        itemChange.setId(resultSet.getInt(1));
        //  if (!(resultSet.getTimestamp(2) == null)) {
        //   itemChange.setEndEdit(true);
        //}
        itemChange.setUserId(resultSet.getInt(3));
        itemChange.setItemId(resultSet.getInt(4));
        return itemChange;
    }
}
