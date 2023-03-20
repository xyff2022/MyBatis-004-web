package com.powernode.bank.service;

import com.powernode.bank.exceptions.MoneyNotEnough;

/**
 * 账户业务类
 */
public interface AccountService {

    void transfer(String formActno, String toActno, double money) throws MoneyNotEnough;
}
