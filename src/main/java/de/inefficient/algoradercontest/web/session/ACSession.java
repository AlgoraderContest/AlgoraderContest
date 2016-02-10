package de.inefficient.algoradercontest.web.session;

import de.inefficient.algoradercontest.web.details.ACUserDetails;

import javax.servlet.http.HttpSession;

/**
 * Created by samuel on 10.02.16.
 * @author samuel
 * @version 0.1
 */
public class ACSession {
    public static final String SESSION = "session";

    public static ACSession from(HttpSession session) {
        if (session == null) {
            return new ACSession(false);
        }
        Object acSessionObject = session.getAttribute(SESSION);
        if (acSessionObject != null && acSessionObject instanceof ACSession) {
            return (ACSession) acSessionObject;
        }
        ACSession acSession = new ACSession(true);
        session.setAttribute(SESSION, acSession);
        return acSession;
    }

    public static ACSession notExisting() {
        return from(null);
    }

    private boolean existing;
    private ACUserDetails userDetails;

    private ACSession(boolean existing) {
        this.existing = existing;
    }

    public ACUserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(ACUserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public boolean isUserLoggedIn() {
        return existing && userDetails != null;
    }

    public boolean isExisting() {
        return existing;
    }
}