package be.pandapp.gamba.services.player;

import be.pandapp.gamba.exceptions.IdNotFoundException;
import be.pandapp.gamba.models.dto.PlayerDTO;
import be.pandapp.gamba.models.entities.Player;
import be.pandapp.gamba.models.forms.PlayerForm;
import be.pandapp.gamba.repos.PlayerRepository;
import be.pandapp.gamba.repos.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService{
    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository, TeamRepository teamRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }

    @Override
    public PlayerDTO insert(PlayerForm form) {
        Player player = form.toPlayer();

        player.setTeam(teamRepository.findById(form.getTeamId())
                .orElseThrow(() -> new IdNotFoundException(form.getTeamId())));

        return PlayerDTO.of(playerRepository.save(player));
    }

    @Override
    public PlayerDTO getOneById(Long id) {
        return playerRepository.findById(id).map(PlayerDTO::of).orElseThrow(() -> new IdNotFoundException(id));
    }

    @Override
    public PlayerDTO updateById(Long id, PlayerForm form) {
        Player player = playerRepository.findById(id).orElseThrow(() -> new IdNotFoundException(id));

        player.setName(form.getName());
        player.setRole(form.getRole());
        player.setTeam(teamRepository.findById(form.getTeamId())
                .orElseThrow(() -> new IdNotFoundException(form.getTeamId())));

        return PlayerDTO.of(playerRepository.save(player));
    }

    @Override
    public PlayerDTO deleteById(Long id) {
        PlayerDTO playerDTO = getOneById(id);
        playerRepository.deleteById(id);
        return playerDTO;
    }

    @Override
    public List<PlayerDTO> getAll() {
        return playerRepository.findAll().stream().map(PlayerDTO::of).collect(Collectors.toList());
    }
}
