package be.pandapp.gamba.services.clan;

import be.pandapp.gamba.exceptions.IdNotFoundException;
import be.pandapp.gamba.models.dto.ClanDTO;
import be.pandapp.gamba.models.entities.Clan;
import be.pandapp.gamba.models.forms.ClanForm;
import be.pandapp.gamba.repos.ClanRepository;
import be.pandapp.gamba.repos.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClanServiceImpl implements ClanService{
    private final ClanRepository clanRepository;
    private final UsersRepository usersRepository;

    public ClanServiceImpl(ClanRepository clanRepository, UsersRepository usersRepository) {
        this.clanRepository = clanRepository;
        this.usersRepository = usersRepository;
    }

    @Override
    public ClanDTO insert(ClanForm form) {
        Clan clan = form.toClan();

        clan.setCaptain(usersRepository.findById(form.getCaptainId())
                .orElseThrow(() -> new IdNotFoundException(form.getCaptainId())));

        return ClanDTO.of(clanRepository.save(clan));
    }

    @Override
    public ClanDTO getOneById(Long id) {
        return clanRepository.findById(id).map(ClanDTO::of).orElseThrow(() -> new IdNotFoundException(id));
    }

    @Override
    public ClanDTO updateById(Long id, ClanForm form) {
        Clan clan = clanRepository.findById(id).orElseThrow(() -> new IdNotFoundException(id));

        clan.setLogo(form.getLogo());
        clan.setTeamName(form.getTeamName());
        clan.setCaptain(usersRepository.findById(form.getCaptainId())
                .orElseThrow(() -> new IdNotFoundException(form.getCaptainId())));

        return ClanDTO.of(clanRepository.save(clan));
    }

    @Override
    public ClanDTO deleteById(Long id) {
        ClanDTO clanDTO = getOneById(id);
        clanRepository.deleteById(id);
        return clanDTO;
    }

    @Override
    public List<ClanDTO> getAll() {
        return clanRepository.findAll().stream()
                .map(ClanDTO::of).collect(Collectors.toList());
    }
}
