package com.rvr.lecture.web.controller;

import com.rvr.lecture.persistence.model.Users;
import com.rvr.lecture.persistence.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value = "/users")
public class UserController
{
    static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService service;

    public UserController()
    {
        super();
    }

    // API

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Users> findAll(final HttpServletRequest request,
                        final UriComponentsBuilder uriBuilder,
                        final HttpServletResponse response) {
        return service.findAll();


    }


    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    @ResponseBody
    public Users findAll(@PathVariable("name") final String userName ,
                        final HttpServletRequest request,
                        final UriComponentsBuilder uriBuilder,
                        final HttpServletResponse response) {
        return service.findByName(userName);
    }

}
