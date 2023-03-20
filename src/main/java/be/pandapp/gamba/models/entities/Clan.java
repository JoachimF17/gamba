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
@Table(name = "team")
public class Clan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "team_name", nullable = false, unique = true, length = 50)
    private String teamName;

    @Column(name = "logo")
    private String logo;

    @OneToOne(optional = false, orphanRemoval = true)
    @JoinColumn(name = "CAPTAIN_ID", nullable = false)
    private Users captain;

    @OneToMany(mappedBy = "clan", orphanRemoval = true)
    private List<Users> members = new ArrayList<>();

}