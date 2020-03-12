package ru.progwards.java1.lessons.datetime;

import java.util.Date;

public class UserSession {
    private int sessionHandle;
    private String userName;
    private Date lastAccess;

    public UserSession(String userName) {
        this.userName = userName;
    }

    public void updateLastAccess() {

    }

    public int getSessionHandle() {
        return sessionHandle;
    }

    public String getUserName() {
        return userName;
    }

    public Date getLastAccess() {
        return lastAccess;
    }
}
