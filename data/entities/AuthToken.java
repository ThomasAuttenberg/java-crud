package org.example.data.entities;

import org.example.data.annotations.DataBaseField;
import org.example.data.annotations.DataBaseTable;
import org.example.data.interfaces.DBSerializable;

import java.sql.Timestamp;

@DataBaseTable(name = "authTokens")
public class AuthToken implements DBSerializable {
    @DataBaseField
    private long user_id;
    @DataBaseField(isPrimaryKey = true)
    private String token;
    @DataBaseField
    private String ip;
    @DataBaseField
    private Timestamp expireTime;

    /*
     сеттеры, геттеры
    */


    public AuthToken(){}

    public void setUserid(long user_id) {
        this.user_id = user_id;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setExpireTime(Timestamp expireTime) {
        this.expireTime = expireTime;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public long getUserid() {
        return user_id;
    }

    public Timestamp getExpireTime() {
        return expireTime;
    }

    public String getToken() {
        return token;
    }

    public String getIp() {
        return ip;
    }
}
