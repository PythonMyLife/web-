package backend.Repository;

import backend.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.google.common.base.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    boolean deleteByUsername(String username);
}
