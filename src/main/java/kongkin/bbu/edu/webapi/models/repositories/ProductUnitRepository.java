package kongkin.bbu.edu.webapi.models.repositories;

import kongkin.bbu.edu.webapi.models.ProductUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductUnitRepository extends JpaRepository<ProductUnit, Integer> {
    List<ProductUnit> findAllByProductId(Integer id);
}
