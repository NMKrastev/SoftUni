package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Mechanic;

import java.util.Optional;

@Repository
public interface MechanicsRepository extends JpaRepository<Mechanic, Long> {

    Optional<Mechanic> findFirstByEmail(String email);

    Optional<Mechanic> findFirstByPhone(String phone);

    Optional<Mechanic> findMechanicByFirstName(String firstName);

}
