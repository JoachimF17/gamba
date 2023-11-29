package be.pandapp.gamba.services.bet;

import be.pandapp.gamba.exceptions.IdNotFoundException;
import be.pandapp.gamba.models.dto.BetDTO;
import be.pandapp.gamba.models.entities.Bet;
import be.pandapp.gamba.models.forms.BetForm;
import be.pandapp.gamba.repos.BetRepository;
import be.pandapp.gamba.repos.GameRepository;
import be.pandapp.gamba.repos.PlayerRepository;
import be.pandapp.gamba.repos.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BetServiceImpl implements BetService{
    private final BetRepository betRepository;
    private final UsersRepository usersRepository;
    private final PlayerRepository playerRepository;
    private final GameRepository gameRepository;

    public BetServiceImpl(BetRepository betRepository, UsersRepository usersRepository, PlayerRepository playerRepository, GameRepository gameRepository) {
        this.betRepository = betRepository;
        this.usersRepository = usersRepository;
        this.playerRepository = playerRepository;
        this.gameRepository = gameRepository;
    }

    @Override
    public BetDTO insert(BetForm form) {
        if(form.getGameId() == null) return null;
        if(form.getScorerId() == null) return null;
        if(form.getUsersId() == null) return null;

        Bet bet = form.toBet();

        bet.setScorer(playerRepository.findById(form.getScorerId())
                .orElseThrow(() -> new IdNotFoundException(form.getScorerId())));
        bet.setGame(gameRepository.findById(form.getGameId())
                .orElseThrow(() -> new IdNotFoundException(form.getGameId())));
        bet.setUsers(usersRepository.findById(form.getUsersId())
                .orElseThrow(() -> new IdNotFoundException(form.getUsersId())));

        return BetDTO.of(betRepository.save(bet));
    }

    @Override
    public BetDTO getOneById(Long id) {
        return betRepository.findById(id).map(BetDTO::of).orElseThrow(() -> new IdNotFoundException(id));
    }

    @Override
    public BetDTO updateById(Long id, BetForm form) {
        Bet bet = betRepository.findById(id).orElseThrow(() -> new IdNotFoundException(id));

        bet.setScoreHomeTeam(form.getScoreHomeTeam());
        bet.setScoreAwayTeam(form.getScoreAwayTeam());
        bet.setScorer(playerRepository.findById(form.getScorerId())
                .orElseThrow(() -> new IdNotFoundException(form.getScorerId())));

        return BetDTO.of(betRepository.save(bet));
    }

    @Override
    public BetDTO deleteById(Long id) {
        BetDTO betDTO = getOneById(id);
        betRepository.deleteById(id);
        return betDTO;
    }

    @Override
    public List<BetDTO> getAll() {
        return betRepository.findAll().stream().map(BetDTO::of).collect(Collectors.toList());
    }
}
