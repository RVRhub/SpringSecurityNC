package com.rvr.lecture.persistence.service;

import com.rvr.lecture.persistence.dao.IUserJpaDAO;
import com.rvr.lecture.persistence.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserService implements IUserService {

    @Autowired
    private IUserJpaDAO dao;

    public UserService() {
        super();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or principal.username == #username")
    public Users findByName(final String username) {
        return dao.findByName(username);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or principal.id == #id")
    public Users findById(long id) {
        return dao.findOne(id);
    }

    @PostAuthorize("hasRole('ROLE_ADMIN') ")
    public List<Users> findAll() {
        return dao.findAll();
    }

    public Users create(final Users entity) {
        return dao.save(entity);
    }

    public void update(final Users entity) {
        dao.save(entity);
    }

}
