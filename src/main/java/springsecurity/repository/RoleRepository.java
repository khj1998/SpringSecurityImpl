package springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springsecurity.Vo.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
