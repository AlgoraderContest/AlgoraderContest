package de.inefficient.algoradercontest.server.transport.response;

import de.inefficient.algoradercontest.server.web.details.ACGameDetails;

import java.util.List;

/**
 * Created by samuel on 14.02.16.
 */
public class ACGetGameListResponse extends ACResponse {
    private List<ACGameDetails> games;

    public ACGetGameListResponse(List<ACGameDetails> games) {
        super(true);
        this.games = games;
    }

    public List<ACGameDetails> getGames() {
        return games;
    }
}