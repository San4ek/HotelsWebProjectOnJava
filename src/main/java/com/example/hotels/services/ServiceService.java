package com.example.hotels.services;

import com.example.hotels.models.Service;
import com.example.hotels.repositories.ServiceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@org.springframework.stereotype.Service
@Slf4j
@RequiredArgsConstructor
public class ServiceService {

    private final ServiceRepository serviceRepository;

    public List<Service> getServices() {
        return serviceRepository.findAll();
    }

    public void saveService(Service service) {
        serviceRepository.save(service);
    }

    public Service getService(Long id) {
        return serviceRepository.findById(id).orElseThrow();
    }

    public void editService(Long id, Service service) {
        service.setId(id);
        serviceRepository.save(service);
    }

    public void deleteService(Long id) {
        serviceRepository.deleteById(id);
    }
}
