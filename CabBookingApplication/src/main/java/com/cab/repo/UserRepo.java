package com.cab.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cab.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	Optional<User> findByMobileNo(String mobileNo);
}
