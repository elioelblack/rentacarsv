package sv.rentacar.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import sv.rentacar.api.entity.Automovil;

public interface AutomovilRepository extends JpaRepository<Automovil, Integer> {

    Page<Automovil> findAllByActivoAndDisponible(Pageable pageable, boolean activo, boolean disponible);

}
