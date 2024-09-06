package com.scm.scm.repositories;

import com.scm.scm.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,String> {
//    extra methods db related operations
//    custom query methods
//    custom finder methods

    Optional<User> findByEmail(String email);

}
