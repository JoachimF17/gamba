package be.pandapp.gamba.models.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "BET")
public class Bet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BET_ID", nullable = false)
    private Long id;

    @Column(name = "SCORE_HOME_TEAM", nullable = false)
    private Integer scoreHomeTeam;

    @Column(name = "SCORE_AWAY_TEAM", nullable = false)
    private Integer scoreAwayTeam;

    @Column(name = "MODIFIED_LAST", nullable = false)
    private LocalDateTime modifiedLast;

    @ManyToOne(optional = false)
    @JoinColumn(name = "USERS_ID", nullable = false)
    private Users users;

    @ManyToOne(optional = false)
    @JoinColumn(name = "SCORER_ID", nullable = false)
    private Player scorer;

    @ManyToOne(optional = false)
    @JoinColumn(name = "GAME_ID", nullable = false)
    private Game game;

}