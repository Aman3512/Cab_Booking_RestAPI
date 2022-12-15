package com.cab.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cab.model.Drivers;

public interface DriverRepo extends JpaRepository<Drivers, Integer> {

}
