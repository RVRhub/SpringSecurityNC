package com.rvr.lecture.persistence.service;

import com.rvr.lecture.persistence.dao.IAuthorityJpaDAO;
import com.rvr.lecture.persistence.model.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class AuthorityService implements IAuthorityService {

    @Autowired
    private IAuthorityJpaDAO dao;

    public AuthorityService() {
        super();
    }

    public Authority findByName(final String name) {
        return dao.findByName(name);
    }

    public Authority findById(long id) {
        return dao.findOne(id);
    }

    public Authority create(final Authority entity) {
        return dao.save(entity);
    }

    public void update(final Authority entity) {
        dao.save(entity);
    }

}
