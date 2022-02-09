package sv.rentacar.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.rentacar.api.entity.Modelo;
import sv.rentacar.api.repository.ModeloRepository;
import sv.rentacar.api.service.api.ModeloServiceAPI;

import java.util.List;

@Service
public class ModeloServiceImpl implements ModeloServiceAPI {

    @Autowired
    private ModeloRepository modeloRepository;

    @Override
    public List<Modelo> findAll() {
        return modeloRepository.findAll();
    }
}
