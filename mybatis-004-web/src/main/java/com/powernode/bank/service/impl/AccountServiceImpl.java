package com.powernode.bank.service.impl;

import com.powernode.bank.dao.AccountDao;
import com.powernode.bank.dao.impl.AccountDaoImpl;
import com.powernode.bank.exceptions.MoneyNotEnough;
import com.powernode.bank.pojo.Account;
import com.powernode.bank.service.AccountService;
import org.apache.ibatis.transaction.TransactionException;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao=new AccountDaoImpl();

    @Override
    public void transfer(String fromActno, String toActno, double money) throws MoneyNotEnough,TransactionException {
        Account fromAct =accountDao.selectByActno(fromActno);
        if(fromAct.getBalance()<money){
            throw new MoneyNotEnough("余额不足");
        }
        Account toAct =accountDao.selectByActno(toActno);
        fromAct.setBalance(fromAct.getBalance()-money);
        toAct.setBalance(toAct.getBalance()+money);
        int count = accountDao.updataByActno(fromAct);
        count+=accountDao.updataByActno(toAct);
        if (count!=2) {
            throw new TransactionException("失败");
        }

    }
}
