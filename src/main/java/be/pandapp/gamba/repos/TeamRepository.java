package be.pandapp.gamba.repos;

import be.pandapp.gamba.models.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
