package com.rvr.lecture.persistence.service;

import com.rvr.lecture.persistence.model.Authority;

public interface IAuthorityService {

    public Authority findByName(final String name);

    public Authority findById(final long id);

    public Authority create(final Authority entity);

    public void update(final Authority entity);

}