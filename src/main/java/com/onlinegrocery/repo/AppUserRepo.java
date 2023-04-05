package com.onlinegrocery.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinegrocery.entity.AppUser;


@Repository
public interface AppUserRepo extends JpaRepository<AppUser,String>{

	Optional<AppUser> findByUserName(String userName);

	
	

}