package com.github.N1ckBaran0v;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

class AdminServlet extends HttpServlet {
    private final AccountServerInterface accountService;

    public AdminServlet(AccountServerInterface accountService) {
        this.accountService = accountService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println(accountService.getUsersLimit());
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
