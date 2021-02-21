package com.craterzone.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.craterzone.dao.AddressDao;
import com.craterzone.dao.MobileNumberDao;
import com.craterzone.dao.UserDao;
import com.craterzone.model.Address;
import com.craterzone.model.MobileNumber;
import com.craterzone.model.User;
@Component
public class UserMapper {
	
	private ModelMapper modelMapper=new ModelMapper();
	                                 
	public User DaoToModel(UserDao userDao)
	{
		User user = modelMapper.map(userDao,User.class);  										//(Source ,target)
		return user;
	}

	public List<User> DaoToModel(List<UserDao> list)
	{
		return list.stream().map(x -> DaoToModel(x)).collect(Collectors.toList());
	}
	
	
	public UserDao ModelToDao(User user)
	{
		UserDao userDao = modelMapper.map(user,UserDao.class);
		return userDao;
	}
	
	public List<UserDao> ModelToDao(List<User> list)
	{
		return list.stream().map(x -> ModelToDao(x)).collect(Collectors.toList());
	}
 
}
