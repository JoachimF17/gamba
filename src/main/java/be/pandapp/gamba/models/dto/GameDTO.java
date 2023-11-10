package be.pandapp.gamba.models.dto;

import be.pandapp.gamba.models.entities.Bet;
import be.pandapp.gamba.models.entities.Game;
import be.pandapp.gamba.models.entities.Team;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GameDTO {
    private Long id;
    private String datetime;
    private Integer scoreHomeTeam;
    private Integer scoreAwayTeam;
    private GameTeamDTO homeTeam;
    private GameTeamDTO awayTeam;
    private List<GameBetDTO> bets;

    public static GameDTO of(Game game) {
        if(game == null) return null;

        return new GameDTO(
                game.getId(),
                game.getDatetime().toString(),
                game.getScoreHomeTeam(),
                game.getScoreAwayTeam(),
                GameTeamDTO.of(game.getHomeTeam()),
                GameTeamDTO.of(game.getAwayTeam()),
                game.getBets() != null
                        ? game.getBets().stream().map(GameBetDTO::of).collect(Collectors.toList())
                        : null
        );
    }

    @NoArgsConstructor
    @AllArgsConstructor
    private static class GameTeamDTO {
        private Long id;
        private String name;
        private String logo;
        private String colors;

        public static GameTeamDTO of(Team team) {
            if(team == null) return null;

            return new GameTeamDTO(
                    team.getId(),
                    team.getName(),
                    team.getLogo(),
                    team.getColors()
            );
        }
    }

    @NoArgsConstructor
    @AllArgsConstructor
    private static class GameBetDTO {
        private Long id;
        private Integer scoreHomeTeam;
        private Integer scoreAwayTeam;

        public static GameBetDTO of(Bet bet) {
            if(bet == null) return null;

            return new GameBetDTO(
                    bet.getId(),
                    bet.getScoreHomeTeam(),
                    bet.getScoreAwayTeam()
            );
        }
    }
}
