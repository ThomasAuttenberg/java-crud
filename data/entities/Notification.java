package org.example.data.entities;

import org.example.data.annotations.DataBaseField;
import org.example.data.annotations.DataBaseTable;
import org.example.data.interfaces.DBSerializable;

@DataBaseTable(name = "notifications")
public class Notification implements DBSerializable {
    @DataBaseField(isPrimaryKey = true,isSequence = true)
    private long id;
    @DataBaseField
    private long targetUser;
    @DataBaseField
    private long updatedTopic;


    public long getId() {
        return id;
    }

    public long getTargetUserId() {
        return targetUser;
    }

    public void setTargetUserId(long targetUser) {
        this.targetUser = targetUser;
    }

    public long getUpdatedTopic() {
        return updatedTopic;
    }

    public void setUpdatedTopic(long updatedTopic) {
        this.updatedTopic = updatedTopic;
    }
}
