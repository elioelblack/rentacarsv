package sv.rentacar.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sv.rentacar.api.entity.Modelo;

public interface ModeloRepository extends JpaRepository<Modelo, Integer> {
}
