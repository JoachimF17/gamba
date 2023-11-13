package be.pandapp.gamba.models.forms;

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
}
