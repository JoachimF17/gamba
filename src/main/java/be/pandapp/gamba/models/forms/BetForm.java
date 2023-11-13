package be.pandapp.gamba.models.forms;

import be.pandapp.gamba.models.entities.Bet;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BetForm {
    private Long id;
    private Integer scoreHomeTeam;
    private Integer scoreAwayTeam;
    private LocalDateTime modifiedLast;
    private Long usersId;
    private Long scorerId;
    private Long gameId;

    public Bet toBet() {
        return Bet.builder()
                .id(getId())
                .scoreHomeTeam(getScoreHomeTeam())
                .scoreAwayTeam(getScoreAwayTeam())
                .modifiedLast(getModifiedLast())
                .build();
    }
}
