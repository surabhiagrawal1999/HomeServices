package com.homeserve.homeserve.controller;

import com.homeserve.homeserve.dto.LoginRequest;
import com.homeserve.homeserve.dto.ServiceRequest;
import com.homeserve.homeserve.dto.UserRequest;
import com.homeserve.homeserve.exception.ServiceNotFoundException;
import com.homeserve.homeserve.model.Service;
import com.homeserve.homeserve.model.User;
import com.homeserve.homeserve.service.ServiceCatalog;
import com.homeserve.homeserve.service.UserServiceCatalog;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class HomeController {

    //https://github.com/surabhiagrawal1999/HomeServices

    private final ServiceCatalog serviceCatalog;
    private final UserServiceCatalog userServiceCatalog;

    //Constructor Injection
    public HomeController(ServiceCatalog serviceCatalog, UserServiceCatalog userServiceCatalog){

        this.serviceCatalog=serviceCatalog;
        this.userServiceCatalog=userServiceCatalog;
    }

    @GetMapping("/hello")
    public Map<String, String> hello(){
        return Map.of(
                "message", "Welcome to Home Serve!",
                "status", "Success"
        );
    }

    @GetMapping("/services")
    public List<Service> getServices(){
        return serviceCatalog.getAllServices();
    }

    @PostMapping("/services")
    public Service createService(@RequestBody @Valid ServiceRequest request){
        //ServiceCatalog serviceCatalog = new ServiceCatalog();
        return serviceCatalog.newService(request);
    }

    @PutMapping("/services/{id}")
    public Service updateService(
            @PathVariable int id, @RequestBody @Valid ServiceRequest request){
         return serviceCatalog.updateService(id, request);
    }

    @DeleteMapping("/services/{id}")
    public void deleteEntry(@PathVariable int id){
        serviceCatalog.deleteService(id);
    }

    @PostMapping("/users")
    public User registerUser(@RequestBody @Valid UserRequest request){
        return userServiceCatalog.newUser(request);
    }

    @PostMapping("login")
    public String loginUser(@RequestBody @Valid LoginRequest request){
        return userServiceCatalog.login(request);
    }
}

