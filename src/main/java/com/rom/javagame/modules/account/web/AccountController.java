package com.rom.javagame.modules.account.web;


import com.alibaba.fastjson.JSONObject;
import com.rom.javagame.modules.account.entity.AccountEntity;
import com.rom.javagame.modules.account.service.AccountService;
import com.rom.javagame.utils.base64Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    /**
     * 注册账户
     * POST
     *
     * */
    @RequestMapping(value = "/account/register", method = RequestMethod.POST)
    public long addAccount(@RequestBody JSONObject jsonObject) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setAccount(jsonObject.get("account").toString());
        accountEntity.setPassword(jsonObject.get("password").toString());
        System.out.println(base64Utils.encodeBase64(base64Utils.decodeBase64(jsonObject.get("password").toString())));
        accountEntity.setNick_name(jsonObject.get("nick_name").toString());
        accountEntity.setCreate_time(new Date());
        accountEntity.setUpdate_time(new Date());
        return accountService.addAccount(accountEntity);
    }

    /**
     * 获取账户信息
     * GET
     * */
    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public AccountEntity findByAccountId(@RequestParam(value="aid", required = true) long id) {
        return accountService.findAccountById(id);
    }

    /**
     *  更新账户
     *  PUT
     *  (url 参数为aid即用户id 其余参数为body参数 account)
     */
    @RequestMapping(value = "/account", method = RequestMethod.PUT)
    public boolean updateAccount(@RequestParam(value="aid" ,required = true ) long id, @RequestBody JSONObject jsonObject) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setId(id);
        accountEntity.setAccount(jsonObject.get("account").toString());
        accountEntity.setPassword(jsonObject.get("password").toString());
        accountEntity.setNick_name(jsonObject.get("nick_name").toString());
        return accountService.updateAccount(accountEntity);
    }

    /**
     *  登录
     *  POST
     *
     *
     */
    @RequestMapping(value = "/account/login", method = RequestMethod.POST)
    public long checkLogin(@RequestBody JSONObject jsonObject) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setAccount(jsonObject.get("account").toString());
        accountEntity.setPassword(jsonObject.get("password").toString());
        return accountService.doLogin(accountEntity);
    }

}
