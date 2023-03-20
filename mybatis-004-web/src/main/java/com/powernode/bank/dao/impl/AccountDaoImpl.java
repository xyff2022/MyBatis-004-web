package com.powernode.bank.dao.impl;

import com.powernode.bank.dao.AccountDao;
import com.powernode.bank.pojo.Account;
import com.powernode.bank.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

public class AccountDaoImpl implements AccountDao {


    @Override
    public Account selectByActno(String actno) {
        SqlSession sqlSession = SqlSessionUtils.openSqlSession();
        Account account = (Account) sqlSession.selectOne("account.selectByActno", actno);
        return account;
    }

    @Override
    public int updataByActno(Account act) {
        SqlSession sqlSession = SqlSessionUtils.openSqlSession();
        int update = sqlSession.update("account.update", act);
        sqlSession.commit();
        sqlSession.close();
        return update;
    }
}
