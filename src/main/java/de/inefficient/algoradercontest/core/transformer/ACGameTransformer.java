package de.inefficient.algoradercontest.core.transformer;

import de.inefficient.algoradercontest.game.ACGame;
import de.inefficient.algoradercontest.web.details.ACGameDetails;

/**
 * Created by samuel on 14.02.16.
 */
public class ACGameTransformer {
    protected ACGameDetails toGameDetails(ACGame game) {
        if (game == null) {
            return null;
        }
        ACGameDetails gameDetails = new ACGameDetails();
        gameDetails.setId(game.getId());
        gameDetails.setName(game.getName());
        gameDetails.setType(game.getType().getName());
        gameDetails.setDescription(game.getType().getDescription());
        gameDetails.setMaxPlayers(game.getOptions().getMaxPlayers());
        gameDetails.setPlayers(game.getPlayers().size());
        return gameDetails;
    }
}