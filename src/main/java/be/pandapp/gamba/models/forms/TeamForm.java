package be.pandapp.gamba.models.forms;

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
}
