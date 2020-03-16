package ru.progwards.java1.lessons.datetime;

import java.time.Instant;
import java.util.Random;

public class UserSession {
    private int sessionHandle;
    private String userName;
    private long lastAccess;

    public int getSessionHandle() {
        return sessionHandle;
    }

    public String getUserName() {
        return userName;
    }

    public long getLastAccess() {
        return lastAccess;
    }

    public void updateLastAccess() {
        lastAccess = Instant.now().toEpochMilli();
    }

    public UserSession(String userName) {
        this.userName = userName;
        updateLastAccess();
        Random random = new Random();
        this.sessionHandle = random.nextInt();
    }
}
