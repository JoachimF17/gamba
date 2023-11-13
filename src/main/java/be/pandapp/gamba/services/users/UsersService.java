package be.pandapp.gamba.services.users;

import be.pandapp.gamba.models.dto.UsersDTO;
import be.pandapp.gamba.models.forms.UsersForm;

import java.util.List;

public interface UsersService {
    //CRUD
    UsersDTO insert(UsersForm form);
    UsersDTO getOneById(Long id);
    UsersDTO updateById(Long id, UsersForm form);
    UsersDTO deleteById(Long id);
    List<UsersDTO> getAll();
}
