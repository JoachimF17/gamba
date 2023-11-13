package be.pandapp.gamba.models.forms;

import be.pandapp.gamba.models.entities.Users;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UsersForm {
    private Long id;
    private String username;
    private String password;
    private Integer score;
    private Long clanId;

    public Users toUsers() {
        return Users.builder()
                .id(getId())
                .username(getUsername())
                .password(getPassword())
                .score(getScore())
                .build();
    }
}
