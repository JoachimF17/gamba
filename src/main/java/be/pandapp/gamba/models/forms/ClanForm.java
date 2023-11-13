package be.pandapp.gamba.models.forms;

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
}
