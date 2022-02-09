package sv.rentacar.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sv.rentacar.api.entity.Automovil;
import sv.rentacar.api.repository.AutomovilRepository;
import sv.rentacar.api.service.api.AutomovilServiceAPI;

@Service
public class AutomovilServiceImpl implements AutomovilServiceAPI {

    @Autowired
    private AutomovilRepository automovilRepository;

    @Override
    public Page<Automovil> getAll(Pageable pageable) {
        return automovilRepository.findAll(pageable);
    }
}
