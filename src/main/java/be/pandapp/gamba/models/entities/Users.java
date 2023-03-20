package be.pandapp.gamba.models.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "USERS")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USERS_ID", nullable = false)
    private Long id;

    @Column(name = "USERNAME", nullable = false, unique = true, length = 50)
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "SCORE", nullable = false)
    private Integer score;

    @OneToMany(mappedBy = "users", orphanRemoval = true)
    private List<Bet> bets = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "CLAN_ID")
    private Clan clan;

}