package be.pandapp.gamba.models.dto;

import be.pandapp.gamba.models.entities.Bet;
import be.pandapp.gamba.models.entities.Game;
import be.pandapp.gamba.models.entities.Player;
import be.pandapp.gamba.models.entities.Users;
import lombok.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class BetDTO {
    private Long id;
    private int scoreHomeTeam;
    private int scoreAwayTeam;
    private String modifiedLast;
    private BetUsersDTO better;
    private BetScorerDTO scorer;
    private BetGameDTO game;

    public static BetDTO of(Bet bet) {
        if(bet == null) return null;

        return new BetDTO(
                bet.getId(),
                bet.getScoreHomeTeam(),
                bet.getScoreAwayTeam(),
                bet.getModifiedLast().toString(), //TODO: better date
                BetUsersDTO.of(bet.getUsers()),
                BetScorerDTO.of(bet.getScorer()),
                BetGameDTO.of(bet.getGame())
        );
    }

    @AllArgsConstructor
    @NoArgsConstructor
    private static class BetUsersDTO {
        private Long id;
        private String username;
        private int score;

        public static BetUsersDTO of(Users users) {
            if(users == null) return null;

            return new BetUsersDTO(
                    users.getId(),
                    users.getUsername(),
                    users.getScore()
            );
        }
    }

    @AllArgsConstructor
    @NoArgsConstructor
    private static class BetScorerDTO {
        private Long id;
        private String name;
        private String role;

        public static BetScorerDTO of(Player player) {
            if(player == null) return null;

            return new BetScorerDTO(
                    player.getId(),
                    player.getName(),
                    player.getRole()
            );
        }
    }

    @AllArgsConstructor
    @NoArgsConstructor
    private static class BetGameDTO {
        private Long id;
        private String dateTime;
        private Integer scoreHomeTeam;
        private Integer scoreAwayTeam;
        private String homeTeam;
        private String awayTeam;

        public static BetGameDTO of(Game game) {
            if(game == null) return null;

            return new BetGameDTO(
                    game.getId(),
                    game.getDatetime().toString(), //TODO: format date
                    game.getScoreHomeTeam(),
                    game.getScoreAwayTeam(),
                    game.getHomeTeam().getName(),
                    game.getAwayTeam().getName()
            );
        }
    }
}
