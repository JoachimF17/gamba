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
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "datetime", nullable = false)
    private LocalDateTime datetime;

    @Column(name = "score_home_team")
    private Integer scoreHomeTeam;

    @Column(name = "score_away_team")
    private Integer scoreAwayTeam;

}