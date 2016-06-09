package de.inefficient.algoradercontest.server.transport.response;

import de.inefficient.algoradercontest.server.web.details.ACUserDetails;

/**
 * Created by samuel on 10.02.16.
 * @author samuel
 * @version 0.1
 */
public class ACUserRegisteredResponse extends ACResponse {
    private ACUserDetails userDetails;

    public ACUserRegisteredResponse(ACUserDetails userDetails) {
        super(true);
        this.userDetails = userDetails;
    }

    public ACUserDetails getUserDetails() {
        return userDetails;
    }
}