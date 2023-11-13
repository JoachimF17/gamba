package be.pandapp.gamba.services.team;

import be.pandapp.gamba.models.dto.TeamDTO;
import be.pandapp.gamba.models.forms.TeamForm;

import java.util.List;

public interface TeamService {
    //CRUD
    TeamDTO insert(TeamForm form);
    TeamDTO getOneById(Long id);
    TeamDTO updateById(Long id, TeamForm form);
    TeamDTO deleteById(Long id);
    List<TeamDTO> getAll();
}
