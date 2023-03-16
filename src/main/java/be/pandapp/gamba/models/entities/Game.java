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
@Table(name = "GAME")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GAME_ID", nullable = false)
    private Long id;

    @Column(name = "DATETIME", nullable = false)
    private LocalDateTime datetime;

    @Column(name = "SCORE_HOME_TEAM")
    private Integer scoreHomeTeam;

    @Column(name = "SCORE_AWAY_TEAM")
    private Integer scoreAwayTeam;

}