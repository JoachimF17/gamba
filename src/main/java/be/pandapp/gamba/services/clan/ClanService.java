package be.pandapp.gamba.services.clan;

import be.pandapp.gamba.models.dto.ClanDTO;
import be.pandapp.gamba.models.forms.ClanForm;

import java.util.List;

public interface ClanService {
    //CRUD
    ClanDTO insert(ClanForm form);
    ClanDTO getOneById(Long id);
    ClanDTO updateById(Long id, ClanForm form);
    ClanDTO deleteById(Long id);
    List<ClanDTO> getAll();
}
