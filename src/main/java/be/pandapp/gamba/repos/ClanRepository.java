package be.pandapp.gamba.repos;

import be.pandapp.gamba.models.entities.Clan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClanRepository extends JpaRepository<Clan, Long> {
}
