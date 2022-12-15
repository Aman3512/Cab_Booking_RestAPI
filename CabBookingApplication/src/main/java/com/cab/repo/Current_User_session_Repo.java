package com.cab.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cab.model.Current_User_session;

public interface Current_User_session_Repo extends JpaRepository<Current_User_session, Integer>{

	Optional<Current_User_session> findByUuid(String uuid);
}
