package sv.rentacar.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sv.rentacar.api.entity.Automovil;

public interface AutomovilRepository extends JpaRepository<Automovil, Integer> {
}
