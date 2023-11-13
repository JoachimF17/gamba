package be.pandapp.gamba.repos;

import be.pandapp.gamba.models.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
