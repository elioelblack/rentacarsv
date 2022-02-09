package sv.rentacar.api.service.api;

import sv.rentacar.api.entity.Modelo;

import java.util.List;

public interface ModeloServiceAPI {
    List<Modelo> findAll();
}
