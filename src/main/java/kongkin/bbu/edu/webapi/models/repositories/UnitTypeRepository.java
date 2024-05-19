package kongkin.bbu.edu.webapi.models.repositories;

import kongkin.bbu.edu.webapi.models.UnitType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitTypeRepository extends JpaRepository<UnitType, Integer> {
    UnitType findByName(String name);

}
