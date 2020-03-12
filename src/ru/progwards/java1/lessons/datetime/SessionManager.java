package ru.progwards.java1.lessons.datetime;

import java.util.HashSet;
import java.util.List;

public class SessionManager {
    private HashSet<UserSession> sessions;
    private int sessionValid;

    public SessionManager(int sessionValid) {
        this.sessionValid = sessionValid;
    }

    public void add(UserSession userSession) {

    }

    public UserSession find(String userName) {
        return null;
    }

    public UserSession get(int sessionHandle) {
        return null;
    }

    public void delete(int sessionHandle) {

    }

    public void deleteExpired() {

    }
}
