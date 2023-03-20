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
    private UsersDTO better;
    private PlayerDTO scorer;
    private GameDTO game;

    public static BetDTO of(Bet bet) {
        if(bet == null) return null;

        return new BetDTO(
                bet.getId(),
                bet.getScoreHomeTeam(),
                bet.getScoreAwayTeam(),
                bet.getModifiedLast().toString(), //TODO: better date
                UsersDTO.of(bet.getUsers()),
                PlayerDTO.of(bet.getScorer()),
                GameDTO.of(bet.getGame())
        );
    }

    @AllArgsConstructor
    @NoArgsConstructor
    private static class UsersDTO {
        private Long id;
        private String username;
        private int score;

        public static UsersDTO of(Users users) {
            if(users == null) return null;

            return new UsersDTO(
                    users.getId(),
                    users.getUsername(),
                    users.getScore()
            );
        }
    }

    @AllArgsConstructor
    @NoArgsConstructor
    private static class PlayerDTO {
        private Long id;
        private String name;
        private String role;

        public static PlayerDTO of(Player player) {
            if(player == null) return null;

            return new PlayerDTO(
                    player.getId(),
                    player.getName(),
                    player.getRole()
            );
        }
    }

    @AllArgsConstructor
    @NoArgsConstructor
    private static class GameDTO {
        private Long id;
        private String dateTime;
        private Integer scoreHomeTeam;
        private Integer scoreAwayTeam;
        private String homeTeam;
        private String awayTeam;

        public static GameDTO of(Game game) {
            if(game == null) return null;

            return new GameDTO(
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
