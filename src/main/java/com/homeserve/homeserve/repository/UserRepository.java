package com.homeserve.homeserve.repository;

import com.homeserve.homeserve.model.User;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//User->type of entity managed
//Integer-> type od ID(primary key
public interface UserRepository extends JpaRepository<User, Integer> {

    //findByEmail->look at User.email->generate appropriate SQL->SELECT ... FROM user WHERE email = ?
    Optional<User> findByEmail(String email);
}

