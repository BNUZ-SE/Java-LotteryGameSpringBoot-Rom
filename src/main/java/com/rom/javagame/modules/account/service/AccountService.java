package com.rom.javagame.modules.account.service;

import com.rom.javagame.modules.account.entity.AccountEntity;

public interface AccountService {

    /**
     * 新增用户
     * @param accountEntity
     * @return
     */
    long addAccount(AccountEntity accountEntity);

    /**
     * 更新用户信息
     * @param accountEntity
     * @return
     */
    boolean updateAccount(AccountEntity accountEntity);

    /**
     * 更新用户密码
     * @param accountEntity
     * @return
     *
     * */
    boolean updateAccountPassword(AccountEntity accountEntity);

    /**
     * 登录
     * 校验密码
     *
     * */
    long doLogin(AccountEntity accountEntity);

    /**
     * 根据用户名字查询用户信息
     * @param account
     */
    AccountEntity findAccountByAccount(String account);

    /**
     * 根据用户ID查询用户信息
     * @param id
     */
    AccountEntity findAccountById(long id);

}
