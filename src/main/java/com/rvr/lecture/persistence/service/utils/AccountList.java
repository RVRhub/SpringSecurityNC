package com.rvr.lecture.persistence.service.utils;

import com.rvr.lecture.persistence.model.Users;

import java.util.ArrayList;
import java.util.List;

public class AccountList {

    private List<Users> accounts = new ArrayList<Users>();

    public AccountList(List<Users> list) {
        this.accounts = list;
    }

    public List<Users> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Users> accounts) {
        this.accounts = accounts;
    }
}
