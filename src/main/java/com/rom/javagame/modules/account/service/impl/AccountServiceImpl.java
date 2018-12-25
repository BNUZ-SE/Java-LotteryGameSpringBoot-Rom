package com.rom.javagame.modules.account.service.impl;

import com.rom.javagame.modules.account.dao.AccountDao;
import com.rom.javagame.modules.account.entity.AccountEntity;
import com.rom.javagame.modules.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    //注册
    @Override
    public long addAccount(AccountEntity accountEntity) {
        long aid = -1;
        try{
            if(accountDao.findByAccount(accountEntity.getAccount()) == null ) {
                accountDao.addAccount(accountEntity);
                aid = accountDao.findByAccount(accountEntity.getAccount()).getId();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return aid;
    }
    //登录
    @Override
    public long doLogin(AccountEntity accountEntity) {
        long aid = -1;
        try {
            if(accountDao.findByAccount(accountEntity.getAccount()) == null) {
                aid = 0;
            } else {
                if(accountDao.findByAccount(accountEntity.getAccount()).getPassword().equals(accountEntity.getPassword())) {
                    aid = accountDao.findByAccount(accountEntity.getAccount()).getId();
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return aid;
    }
    //修改用户密码

    @Override
    public boolean updateAccountPassword(AccountEntity accountEntity) {
        boolean flag = false;
        try {
            accountDao.updateAccountPassword(accountEntity);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
    //修改用户信息
    @Override
    public boolean updateAccount(AccountEntity accountEntity) {
        boolean flag = false;
        try {
            flag = accountDao.updateAccount(accountEntity);
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public AccountEntity findAccountByAccount(String account) {
        return accountDao.findByAccount(account);
    }

    @Override
    public AccountEntity findAccountById(long id) {
        return accountDao.findById(id);
    }
}
