package com.craterzone.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.craterzone.dao.UserDao;
import com.craterzone.mapper.UserMapper;
import com.craterzone.model.User;
import com.craterzone.repository.UserRepository;
@CacheConfig
@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserMapper userMapper;

	@Cacheable(value = "Users",  unless="#result == null" )
	@CachePut(value = "Users",  unless="#result == null")
	public List<User> getUser() {
		List<UserDao> listDao = userRepository.findAll();
		return userMapper.DaoToModel(listDao);
	}

	public Optional<User> login(User user) {
		UserDao username = userRepository.findByName(user.getName());
		if (Objects.nonNull(username))
			return Optional.ofNullable(userMapper.DaoToModel(username));
		else
			return null;
	}

	public Optional<User> saveUser(User user) {
		UserDao userExists = userRepository.findByEmail(user.getEmail());
		if (userExists != null)
			return Optional.ofNullable(userMapper.DaoToModel(userExists));
		else {
			UserDao userDao = userMapper.ModelToDao(user);
			userDao = userRepository.save(userDao);
			return Optional.ofNullable(userMapper.DaoToModel(userDao));
		}
	}

	@Cacheable(value = "Users", key = "#id",  unless="#result == null")       //This Method will never get executed if the key is already in the cache.
	public Optional<User> getById(int id) {
		UserDao userId = userRepository.findById(id).orElse(null);
		return Optional.ofNullable(userMapper.DaoToModel(userId));
	}

	@CacheEvict(value = "Users", key = "#id") // Delete from Cache. Use it with DeleteMapping
	public boolean deleteId(int id) {
		Optional<UserDao> userDao = userRepository.findById(id);

		if (userDao.isPresent()) {
			userRepository.deleteById(id);
			return true;
		}
		return false;
	}
}

/*
 * @Cacheable : Triggers cache population @GetMapping ,@PostMapping
 
 * @CachePut : Updates the cache, without interfering with the method execution
             : Update a Cache. Use it with PutMapping
             
 * @CacheEvict : Triggers cache eviction[removing items from cache]
               : Delete from Cache. Use it with DeleteMapping
               
 * @Caching : Regroups multiple cache operations to be applied on a method
  
 * @CacheConfig : Shares some common cache-related settings at class-level
 
 * @EnableCaching : Configuration level annotation, enables Caching
  
 */