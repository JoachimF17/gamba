package be.pandapp.gamba.models.forms;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PlayerForm {
    private Long id;
    private String name;
    private String role;
    private Long teamId;
}
