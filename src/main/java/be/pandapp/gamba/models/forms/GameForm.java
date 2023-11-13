package be.pandapp.gamba.models.forms;

import be.pandapp.gamba.models.entities.Game;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class GameForm {
    private Long id;
    private LocalDateTime datetime;
    private Integer scoreHomeTeam;
    private Integer scoreAwayTeam;
    private Long homeTeamId;
    private Long awayTeamId;

    public Game toGame() {
        return Game.builder()
                .id(getId())
                .datetime(getDatetime())
                .scoreHomeTeam(getScoreHomeTeam())
                .scoreAwayTeam(getScoreAwayTeam())
                .build();
    }
}
