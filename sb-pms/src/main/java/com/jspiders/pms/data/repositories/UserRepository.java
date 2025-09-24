package com.jspiders.pms.data.repositories;

import com.jspiders.pms.data.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,Integer> {

    //SELECT * FROM USERS where role = role
    List<UserEntity> findAllByRole(String role);
    Optional<UserEntity> findByEmail(String email);

    //Optional is used to avoid NPE
}
