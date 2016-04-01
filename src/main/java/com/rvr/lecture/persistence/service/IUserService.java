package com.rvr.lecture.persistence.service;

import com.rvr.lecture.persistence.model.Users;

import java.util.List;

public interface IUserService {

    public Users findByName(final String name);

    public Users findById(final long id);

    public List<Users> findAll();

    public Users create(final Users entity);

    public void update(final Users entity);

}
