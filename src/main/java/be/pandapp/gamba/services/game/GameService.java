package be.pandapp.gamba.services.game;

import be.pandapp.gamba.models.dto.GameDTO;
import be.pandapp.gamba.models.forms.GameForm;

import java.util.List;

public interface GameService {
    //CRUD
    GameDTO insert(GameForm form);
    GameDTO getOneById(Long id);
    GameDTO updateById(Long id, GameForm form);
    GameDTO deleteById(Long id);
    List<GameDTO> getAll();
}
