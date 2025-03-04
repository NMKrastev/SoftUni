package bg.softuni.sa02_springsecurity.repository;

import bg.softuni.sa02_springsecurity.model.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {


}
