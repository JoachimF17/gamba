package be.pandapp.gamba.repos;

import be.pandapp.gamba.models.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
