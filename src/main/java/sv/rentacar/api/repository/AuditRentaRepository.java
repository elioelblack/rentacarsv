package sv.rentacar.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sv.rentacar.api.entity.AuditRenta;

public interface AuditRentaRepository extends JpaRepository<AuditRenta, Integer> {

}
