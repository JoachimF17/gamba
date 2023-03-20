package be.pandapp.gamba.models.dto;

import be.pandapp.gamba.models.entities.Users;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsersDTO {
    private Long id;
    private String username;
    private int score;
    private String clan;

    public static UsersDTO of(Users users) {
        if(users == null) return null;

        return new UsersDTO(
                users.getId(),
                users.getUsername(),
                users.getScore(),
                users.getClan() != null ? users.getClan().getTeamName() : null
        );
    }

}
