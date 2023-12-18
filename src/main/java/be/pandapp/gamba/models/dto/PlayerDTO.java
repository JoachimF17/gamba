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
    private PlayerTeamDTO team;

    public static PlayerDTO of(Player player) {
        if(player == null) return null;

        return new PlayerDTO(
                player.getId(),
                player.getName(),
                player.getRole(),
                PlayerTeamDTO.of(player.getTeam())
        );
    }

    @AllArgsConstructor
    @NoArgsConstructor
    private static class PlayerTeamDTO {
        private Long id;
        private String name;

        public static PlayerTeamDTO of(Team team) {
            if(team == null) return null;

            return new PlayerTeamDTO(
                    team.getId(),
                    team.getName()
            );
        }
    }
}
