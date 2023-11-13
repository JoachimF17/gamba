package be.pandapp.gamba.models.forms;

import be.pandapp.gamba.models.entities.Team;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TeamForm {
    private Long id;
    private String name;
    private String logo;
    private String colors;

    public Team toTeam() {
        return Team.builder()
                .id(getId())
                .name(getName())
                .logo(getLogo())
                .colors(getColors())
                .build();
    }
}
