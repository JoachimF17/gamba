package be.pandapp.gamba.models.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "HOME_TEAM_ID")
    private Team homeTeam;

    @ManyToOne
    @JoinColumn(name = "AWAY_TEAM_ID")
    private Team awayTeam;

    @OneToMany(mappedBy = "game", orphanRemoval = true)
    private List<Bet> bets = new ArrayList<>();

}