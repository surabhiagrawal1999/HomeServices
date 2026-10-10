package com.homeserve.homeserve.service;

import com.homeserve.homeserve.dto.ServiceRequest;
import com.homeserve.homeserve.exception.ServiceNotFoundException;
import com.homeserve.homeserve.model.Service;
import com.homeserve.homeserve.repository.ServiceRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service

public class ServiceCatalog {

    private final ServiceRepository serviceRepository;

    public ServiceCatalog(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public Service newService(ServiceRequest request){
        Service service = new Service();

        service.setName(request.getName());
        service.setCategory(request.getCategory());
        service.setPrice(request.getPrice());
        serviceRepository.save(service);

        return service;
    }

    public List<Service> getAllServices(){

        return serviceRepository.findAll();
    }

    public Service updateService(int id, ServiceRequest request){
        Service service = serviceRepository.findById(id).orElseThrow();
        service.setName(request.getName());
        service.setCategory(request.getCategory());
        service.setPrice(request.getPrice());
        serviceRepository.save(service);

       return service;
    }

    public void deleteService(int id){
        Optional<Service> service = serviceRepository.findById(id);
        if(service.isPresent()){
            serviceRepository.deleteById(id);
        }
        else throw new ServiceNotFoundException("Data doesn't exist");
    }
}
