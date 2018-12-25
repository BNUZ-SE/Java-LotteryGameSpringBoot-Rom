package com.rom.javagame.modules.account.entity;


import com.rom.javagame.utils.base64Utils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

public class AccountEntity implements java.io.Serializable {
    private Long id;
    private String account;
    private String password;
    private String nick_name;
    private Date update_time;
    private Date create_time;

    public AccountEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return base64Utils.decodeBase64(this.password);
    }

    public void setPassword(String password) {
        this.password = base64Utils.encodeBase64(password);
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
