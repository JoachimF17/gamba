package be.pandapp.gamba.repos;

import be.pandapp.gamba.models.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
