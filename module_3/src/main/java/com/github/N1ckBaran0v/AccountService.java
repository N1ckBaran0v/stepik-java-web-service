package com.github.N1ckBaran0v;

import com.github.N1ckBaran0v.database.DatabaseService;
import com.github.N1ckBaran0v.database.UsersDataSet;

class AccountService {
    private final DatabaseService databaseService = new DatabaseService();

    public void signUp(String login, String password) {
        databaseService.addUser(login, password);
    }

    public String signIn(String login, String password) {
        UsersDataSet dataSet = databaseService.getUser(login);
        if (dataSet != null && password.equals(dataSet.getPassword())) {
            return login;
        }
        return null;
    }
}
