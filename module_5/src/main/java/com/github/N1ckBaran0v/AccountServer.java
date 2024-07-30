package com.github.N1ckBaran0v;

import java.util.HashMap;
import java.util.Map;

public class AccountServer implements  AccountServerInterface{
    private int usersLimit = 10;

    @Override
    public int getUsersLimit() {
        return usersLimit;
    }

    @Override
    public void setUsersLimit(int usersLimit) {
        this.usersLimit = usersLimit;
    }
}