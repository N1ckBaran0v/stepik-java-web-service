package com.github.N1ckBaran0v;

import java.util.HashMap;
import java.util.Map;

class AccountService {
    private Map<String, String> accounts = new HashMap<>();

    public void signUp(String login, String password) {
        accounts.put(login, password);
    }

    public String signIn(String login, String password) {
        String real = accounts.getOrDefault(login, null);
        if (real != null) {
            return login;
        }
        return null;
    }
}
