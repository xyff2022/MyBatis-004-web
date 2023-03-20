package com.powernode.bank.dao;

import com.powernode.bank.pojo.Account;

public interface AccountDao {

    /**
     * 根据账户id插信息（整条）
     * @param actno  账户
     * @return 账户信息
     *
     */
    Account selectByActno(String actno);

    /**
     * @param act 被更新的整个账户
     * @return 1表示成功
     */
    int updataByActno(Account act);
}
