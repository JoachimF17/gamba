package be.pandapp.gamba.models.forms;

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
}
