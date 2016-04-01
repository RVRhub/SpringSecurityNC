package com.rvr.lecture.persistence.dao;

import com.rvr.lecture.persistence.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface IAuthorityJpaDAO extends JpaRepository<Authority, Long>, JpaSpecificationExecutor<Authority> {

    Authority findByName(final String name);

}