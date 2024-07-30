package com.github.N1ckBaran0v;

public class AccountServerController implements AccountServerControllerMBean{
    private final AccountServerInterface accountServer;

    public AccountServerController(AccountServerInterface accountServer) {
        this.accountServer = accountServer;
    }

    @Override
    public int getUsersLimit() {
        return 0;
    }

    @Override
    public void setUsersLimit(int usersLimit) {

    }
}
