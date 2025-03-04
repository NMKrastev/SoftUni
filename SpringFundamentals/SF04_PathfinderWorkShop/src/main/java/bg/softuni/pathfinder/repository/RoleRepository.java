package bg.softuni.pathfinder.repository;

import bg.softuni.pathfinder.model.entity.Role;
import bg.softuni.pathfinder.model.enums.RoleEnumType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(RoleEnumType roleEnumType);
}
