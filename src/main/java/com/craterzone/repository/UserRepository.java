package com.craterzone.repository;


import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.craterzone.dao.AddressDao;
import com.craterzone.dao.UserDao;


public interface UserRepository extends JpaRepository<UserDao, Integer> 
{
	UserDao findByEmail(String email); 
	UserDao findByName(String name); 
}


