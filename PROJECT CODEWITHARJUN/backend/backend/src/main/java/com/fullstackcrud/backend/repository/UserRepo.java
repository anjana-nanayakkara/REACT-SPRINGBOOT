package com.fullstackcrud.backend.repository;

import com.fullstackcrud.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

}
