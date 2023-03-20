package com.powernode.bank.web;


import com.powernode.bank.exceptions.MoneyNotEnough;
import com.powernode.bank.service.AccountService;
import com.powernode.bank.service.impl.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/transfer")
public class AccountServlet extends HttpServlet {

    private AccountService accountService =new AccountServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fromActno = request.getParameter("fromActno");
        String toActno = request.getParameter("toActno");
        double money = Double.parseDouble(request.getParameter("money"));
        try {
            accountService.transfer(fromActno,toActno,money);
            response.sendRedirect(request.getContextPath() + "/success.html");
        } catch (MoneyNotEnough e) {
            response.sendRedirect(request.getContextPath() + "/default.html");
        }
    }
}
