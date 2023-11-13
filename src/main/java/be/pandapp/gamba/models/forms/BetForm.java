package be.pandapp.gamba.models.forms;

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
}
