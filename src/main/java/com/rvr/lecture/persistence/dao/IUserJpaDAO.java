package com.rvr.lecture.persistence.dao;


import com.rvr.lecture.persistence.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface IUserJpaDAO extends JpaRepository<Users, Long>, JpaSpecificationExecutor<Users> {

    Users findByName(final String name);

}
