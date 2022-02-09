package sv.rentacar.api.service.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sv.rentacar.api.entity.Automovil;

public interface AutomovilServiceAPI {

    Page<Automovil> getAll(Pageable pageable);

}
