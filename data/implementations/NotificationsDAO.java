package org.example.data.implementations;

import org.example.data.DAO;
import org.example.data.entities.Notification;

import java.sql.SQLException;
import java.util.LinkedList;

public class NotificationsDAO extends DAO<Notification> {
    protected NotificationsDAO(Class<Notification> class_) {
        super(class_);
    }
    public LinkedList<Notification> getByUserId(long id) {
        try {
            return super.getByField(Notification.class.getDeclaredField("targetUser"), id);
        } catch (IllegalAccessException | SQLException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Notification entity){
        try {
            super.delete(entity);
        } catch (SQLException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void create(Notification entity){
        try {
            super.create(entity);
        } catch (IllegalAccessException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
