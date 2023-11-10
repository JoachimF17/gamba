package be.pandapp.gamba.models.dto;

import be.pandapp.gamba.models.entities.Player;
import be.pandapp.gamba.models.entities.Team;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlayerDTO {
    private Long id;
    private String name;
    private String role;
    private TeamDTO team;

    public PlayerDTO of(Player player) {
        if(player == null) return null;

        return new PlayerDTO(
                player.getId(),
                player.getName(),
                player.getRole(),
                TeamDTO.of(player.getTeam())
        );
    }

    @AllArgsConstructor
    @NoArgsConstructor
    private static class TeamDTO {
        private Long id;
        private String name;

        public static TeamDTO of(Team team) {
            if(team == null) return null;

            return new TeamDTO(
                    team.getId(),
                    team.getName()
            );
        }
    }
}
