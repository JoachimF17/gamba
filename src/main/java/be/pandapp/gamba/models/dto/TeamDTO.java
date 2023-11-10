package be.pandapp.gamba.models.dto;

import be.pandapp.gamba.models.entities.Player;
import be.pandapp.gamba.models.entities.Team;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeamDTO {
    private Long id;
    private String name;
    private String logo;
    private String colors;
    private List<TeamPlayerDTO> players;

    public static TeamDTO of(Team team) {
        if(team == null) return null;

        return new TeamDTO(
                team.getId(),
                team.getName(),
                team.getLogo(),
                team.getColors(),
                team.getPlayers() != null
                        ? team.getPlayers().stream().map(TeamPlayerDTO::of).collect(Collectors.toList())
                        : null
        );
    }

    @NoArgsConstructor
    @AllArgsConstructor
    private static class TeamPlayerDTO {
        private Long id;
        private String name;
        private String role;

        public static TeamPlayerDTO of(Player player) {
            if(player == null) return null;

            return new TeamPlayerDTO(
                    player.getId(),
                    player.getName(),
                    player.getRole()
            );
        }
    }
}
