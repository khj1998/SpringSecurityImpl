package springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springsecurity.Vo.User;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
