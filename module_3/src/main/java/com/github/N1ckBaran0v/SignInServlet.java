package com.github.N1ckBaran0v;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

class SignInServlet extends HttpServlet {
    private final AccountService accountService;

    public SignInServlet(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = accountService.signIn(req.getParameter("login"), req.getParameter("password"));
        resp.setContentType("text/html;charset=utf-8");
        if (account == null) {
            resp.getWriter().println("Unauthorized");
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        } else {
            resp.getWriter().println("Authorized: " + account);
            resp.setStatus(HttpServletResponse.SC_OK);
        }
    }
}
