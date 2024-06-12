package org.example.data.implementations;

import org.example.data.DAO;
import org.example.data.DataBaseConnection;
import org.example.data.entities.Message;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedList;

public class MessageDAO extends DAO<Message> {
    public MessageDAO(){
        super(Message.class);
    }
    public Message getByMessageId(long messageId){
        LinkedList<Message> messages = null;
        try {
            messages = super.getByField(Message.class.getDeclaredField("message_id"),messageId);
            return messages.isEmpty() ? null : messages.getFirst();
        } catch (IllegalAccessException | SQLException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }
    public LinkedList<Message> getByParentMessageId(long messageId){
        try {
            return super.getByField(Message.class.getDeclaredField("parentmessage_id"),messageId);
        } catch (IllegalAccessException | SQLException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }
    public enum PagingMode{
        prevMessages,
        nextMessages
    }

    public LinkedList<Message> getByParentMessageIdPaginate(long parentMessageId, long dateTimeFrom, PagingMode pagingMode, int pageLimit){
        if(pageLimit > 250) pageLimit = 250;
        try(DataBaseConnection connection = new DataBaseConnection()){
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("SELECT * FROM (SELECT * FROM messages WHERE parentmessage_id = '").append(parentMessageId).append("' AND dateTime ");
            if(pagingMode == PagingMode.nextMessages){
                queryBuilder.append(" > '").append(new Timestamp(dateTimeFrom+1)).append("' ORDER BY dateTime ASC LIMIT ").append(pageLimit);
            }else{
                queryBuilder.append(" < '").append(new Timestamp(dateTimeFrom+1)).append("' ORDER BY dateTime DESC LIMIT ").append(pageLimit);
            }
            queryBuilder.append(") ORDER BY dateTime ASC");
            String query = queryBuilder.toString();
            ResultSet set = connection.executeQuery(query);
            return resultSetToObjects(set);
        } catch (SQLException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }
    public void createWithSpecificId(Message entity){
        try(DataBaseConnection connection = new DataBaseConnection()){
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("INSERT INTO messages (message_id, content, author_id) VALUES (")
                    .append(entity.getMessageId())
                    .append(",'")
                    .append(entity.getContent())
                    .append("',")
                    .append(entity.getAuthorId())
                    .append(");");
            String query = queryBuilder.toString();
            connection.execute(query);
            System.out.println("executed");
        }catch (SQLException e){
            System.out.println("some exception "+e.getMessage());
            throw new RuntimeException(e);
        }
    }
    @Override
    public void create(Message entity){
        try {
            super.create(entity);
        } catch (IllegalAccessException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Message entity){
        try {
            super.delete(entity);
        } catch (SQLException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Message entity){
        try {
            super.update(entity);
        } catch (IllegalAccessException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
