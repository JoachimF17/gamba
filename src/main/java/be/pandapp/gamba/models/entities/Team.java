package be.pandapp.gamba.models.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
@Entity
@Table(name = "TEAM")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TEAM_ID", nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false, unique = true, length = 50)
    private String name;

    @Column(name = "LOGO", nullable = false, unique = true)
    private String logo;

    @Column(name = "COLORS", nullable = false, length = 50)
    private String colors;

    @OneToMany(mappedBy = "team", orphanRemoval = true)
    private List<Player> players = new ArrayList<>();

}