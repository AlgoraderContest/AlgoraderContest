package de.inefficient.algoradercontest.web.details;

/**
 * Created by samuel on 07.02.16.
 * @author samuel
 * @version 0.1
 */
public class ACUserDetails {
    private String id;
    private String username;
    private String displayName;
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
