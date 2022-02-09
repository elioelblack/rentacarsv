package sv.rentacar.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.rentacar.api.entity.AuditRenta;
import sv.rentacar.api.repository.AuditRentaRepository;
import sv.rentacar.api.service.api.AuditRentaServiceAPI;

@Service
public class AuditRentaServiceImpl implements AuditRentaServiceAPI {

    @Autowired
    private AuditRentaRepository auditRentaRepository;

    @Override
    public AuditRenta save(AuditRenta auditRenta) {
        return auditRentaRepository.save(auditRenta);
    }
}
