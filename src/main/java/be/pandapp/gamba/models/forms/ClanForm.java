package be.pandapp.gamba.models.forms;

import be.pandapp.gamba.models.entities.Clan;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ClanForm {
    private Long id;
    private String teamName;
    private String logo;
    private Long captainId;

    public Clan toClan() {
        return Clan.builder()
                .id(getId())
                .teamName(getTeamName())
                .logo(getLogo())
                .build();
    }
}
