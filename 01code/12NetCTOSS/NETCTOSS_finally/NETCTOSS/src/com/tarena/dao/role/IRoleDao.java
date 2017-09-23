package com.tarena.dao.role;

import java.util.List;

import com.tarena.dao.DAOException;
import com.tarena.entity.Role;

public interface IRoleDao {

	void insertRole(Role role) throws DAOException;

	Role findById(int id) throws DAOException;

	void updateRole(Role role) throws DAOException;

	List<Role> findAll() throws DAOException;

}
