package org.example.data.entities;

import org.example.data.annotations.DataBaseField;
import org.example.data.annotations.DataBaseTable;
import org.example.data.interfaces.DBSerializable;

import java.sql.Timestamp;

@DataBaseTable(name = "messages")
public class Message implements DBSerializable {
    @DataBaseField(isPrimaryKey = true, isSequence = true)
    private Long message_id = null;
    @DataBaseField
    private Long parentmessage_id;
    @DataBaseField
    private String content;
    @DataBaseField
    private Timestamp datetime;
    @DataBaseField
    private long author_id;
    @DataBaseField
    private int quotes;
    @DataBaseField
    private String extendedPath;
    public void setMessage_id(Long messageId){this.message_id = messageId;}
    public Long getMessageId() {
        return message_id;
    }

    public Long getParentMessageId() {
        return parentmessage_id;
    }

    public long getAuthorId() {
        return author_id;
    }

    public String getContent() {
        return content;
    }

    public int getQuotes() {
        return quotes;
    }

    public Timestamp getDatetime() {
        return datetime;
    }
    public Long getDateTimeLong(){
        return datetime.getTime();
    }
    public void setAuthorId(long author_id) {
        this.author_id = author_id;
    }

    public void setParentMessageId(long parentmessage_id) {
        this.parentmessage_id = parentmessage_id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }
    public void addQuote(){
        this.quotes +=1;
    }
    public String getExtendedPath(){return extendedPath;}
}
