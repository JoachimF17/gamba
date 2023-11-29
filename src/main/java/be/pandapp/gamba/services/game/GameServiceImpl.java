package be.pandapp.gamba.services.game;

import be.pandapp.gamba.exceptions.IdNotFoundException;
import be.pandapp.gamba.models.dto.GameDTO;
import be.pandapp.gamba.models.entities.Game;
import be.pandapp.gamba.models.forms.GameForm;
import be.pandapp.gamba.repos.GameRepository;
import be.pandapp.gamba.repos.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService{
    private final GameRepository gameRepository;
    private final TeamRepository teamRepository;

    public GameServiceImpl(GameRepository gameRepository, TeamRepository teamRepository) {
        this.gameRepository = gameRepository;
        this.teamRepository = teamRepository;
    }

    @Override
    public GameDTO insert(GameForm form) {
        Game game = form.toGame();

        game.setHomeTeam(teamRepository.findById(form.getHomeTeamId())
                .orElseThrow(() -> new IdNotFoundException(form.getHomeTeamId())));
        game.setAwayTeam(teamRepository.findById(form.getAwayTeamId())
                .orElseThrow(() -> new IdNotFoundException(form.getAwayTeamId())));

        return GameDTO.of(gameRepository.save(game));
    }

    @Override
    public GameDTO getOneById(Long id) {
        return gameRepository.findById(id).map(GameDTO::of).orElseThrow(() -> new IdNotFoundException(id));
    }

    @Override
    public GameDTO updateById(Long id, GameForm form) {
        Game game = gameRepository.findById(id).orElseThrow(() -> new IdNotFoundException(id));

        game.setDatetime(form.getDatetime());
        game.setScoreHomeTeam(form.getScoreHomeTeam());
        game.setScoreAwayTeam(form.getScoreAwayTeam());
        game.setHomeTeam(teamRepository.findById(form.getHomeTeamId())
                .orElseThrow(() -> new IdNotFoundException(form.getHomeTeamId())));
        game.setAwayTeam(teamRepository.findById(form.getAwayTeamId())
                .orElseThrow(() -> new IdNotFoundException(form.getAwayTeamId())));

        return GameDTO.of(gameRepository.save(game));
    }

    @Override
    public GameDTO deleteById(Long id) {
        GameDTO gameDTO = getOneById(id);
        gameRepository.deleteById(id);
        return gameDTO;
    }

    @Override
    public List<GameDTO> getAll() {
        return gameRepository.findAll().stream().map(GameDTO::of).collect(Collectors.toList());
    }
}
