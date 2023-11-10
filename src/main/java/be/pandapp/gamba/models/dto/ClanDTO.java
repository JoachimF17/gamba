package be.pandapp.gamba.models.dto;

import be.pandapp.gamba.models.entities.Clan;
import be.pandapp.gamba.models.entities.Users;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClanDTO {
    private Long id;
    private String teamName;
    private String logo;
    private ClanUsersDTO captain;
    private List<ClanUsersDTO> members;

    public static ClanDTO of(Clan clan) {
        if(clan == null) return null;

        return new ClanDTO(
                clan.getId(),
                clan.getTeamName(),
                clan.getLogo(),
                ClanUsersDTO.of(clan.getCaptain()),
                clan.getMembers() != null
                        ? clan.getMembers().stream().map(ClanUsersDTO::of).collect(Collectors.toList())
                        : null
        );
    }

    @NoArgsConstructor
    @AllArgsConstructor
    private static class ClanUsersDTO {
        private Long id;
        private String username;
        private Integer score;

        public static ClanUsersDTO of(Users users) {
            if (users == null) return null;

            return new ClanUsersDTO(
                    users.getId(),
                    users.getUsername(),
                    users.getScore()
            );
        }
    }
}
