package de.inefficient.algoradercontest.transport.response;

import de.inefficient.algoradercontest.web.details.ACUserDetails;

/**
 * Created by samuel on 14.02.16.
 */
public class ACGetUserResponse extends ACResponse {
    private ACUserDetails user;

    public ACGetUserResponse(ACUserDetails user) {
        super(true);
        this.user = user;
    }

    public ACUserDetails getUser() {
        return user;
    }
}
