package ru.progwards.java1.lessons.datetime;

import java.time.Instant;
import java.util.*;

public class SessionManager {
    private Map<Integer, UserSession> sessions;
    private int sessionValid;

    public SessionManager(int sessionValid) {
        this.sessionValid = sessionValid;
        this.sessions = new HashMap<>();
    }

    public void add(UserSession userSession) {
        sessions.putIfAbsent(userSession.getSessionHandle(), userSession);
    }

    public UserSession find(String userName) {
        Collection<UserSession> userSessionsCollection = sessions.values();
        for (UserSession userSession : userSessionsCollection) {
            if (userName.equals(userSession.getUserName())) {
                if ((userSession.getLastAccess() + sessionValid*1000) <= Instant.now().toEpochMilli()) {
                    return null;
                } else {
                    userSession.updateLastAccess();
                    return userSession;
                }
            }
        }
        return null;
    }

    public UserSession get(int sessionHandle) {
        if (!sessions.containsKey(sessionHandle))
            return null;
        UserSession userSession = sessions.get(sessionHandle);
        if ((userSession.getLastAccess() + sessionValid*1000) <= Instant.now().toEpochMilli())
            return null;
        userSession.updateLastAccess();
        return userSession;
    }

    public void delete(int sessionHandle) {
        sessions.remove(sessionHandle);
    }

    public void deleteExpired() {
        Collection<UserSession> sessionsCollection = sessions.values();
        UserSession[] userSessionsArr = new UserSession[sessionsCollection.size()];
        userSessionsArr = sessionsCollection.toArray(userSessionsArr);
        for(int i = 0; i < userSessionsArr.length; i++) {
            if ((userSessionsArr[i].getLastAccess() + sessionValid*1000) <= Instant.now().toEpochMilli()) {
                delete(userSessionsArr[i].getSessionHandle());
            }
        }
    }}
