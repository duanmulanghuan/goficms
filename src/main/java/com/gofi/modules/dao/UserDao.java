package com.gofi.modules.dao;

import java.util.List;

import com.gofi.modules.entity.UserEntity;

public interface UserDao {
	
	List<UserEntity> getAll();
	
	UserEntity getOne(Long id);

	void insert(UserEntity user);

	void update(UserEntity user);

	void delete(Long id);

}