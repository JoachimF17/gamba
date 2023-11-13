package be.pandapp.gamba.repos;

import be.pandapp.gamba.models.entities.Bet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BetRepository extends JpaRepository<Bet, Long> {
}
