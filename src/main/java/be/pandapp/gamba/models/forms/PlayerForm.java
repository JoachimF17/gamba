package be.pandapp.gamba.models.forms;

import be.pandapp.gamba.models.entities.Player;
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

    public Player toPlayer() {
        return Player.builder()
                .id(getId())
                .name(getName())
                .role(getRole())
                .build();
    }
}
