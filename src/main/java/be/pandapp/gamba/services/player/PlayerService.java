package be.pandapp.gamba.services.player;

import be.pandapp.gamba.models.dto.PlayerDTO;
import be.pandapp.gamba.models.forms.PlayerForm;

import java.util.List;

public interface PlayerService {
    //CRUD
    PlayerDTO insert(PlayerForm form);
    PlayerDTO getOneById(Long id);
    PlayerDTO updateById(Long id, PlayerForm form);
    PlayerDTO deleteById(Long id);
    List<PlayerDTO> getAll();
}
