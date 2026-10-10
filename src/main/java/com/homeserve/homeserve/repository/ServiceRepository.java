package com.homeserve.homeserve.repository;

import com.homeserve.homeserve.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

//Service->type of entity managed
//Integer-> type od ID(primary key
public interface ServiceRepository extends JpaRepository<Service, Integer> {

}
