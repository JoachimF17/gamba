package be.pandapp.gamba.services.bet;

import be.pandapp.gamba.models.dto.BetDTO;
import be.pandapp.gamba.models.forms.BetForm;

import java.util.List;

public interface BetService {
    //CRUD
    BetDTO insert(BetForm form);
    BetDTO getOneById(Long id);
    BetDTO updateById(Long id, BetForm form);
    BetDTO deleteById(Long id);
    List<BetDTO> getAll();
}
