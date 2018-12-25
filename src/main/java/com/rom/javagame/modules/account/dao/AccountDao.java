package com.rom.javagame.modules.account.dao;


import com.rom.javagame.modules.account.entity.AccountEntity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface AccountDao{
    /**
     * * 用户数据新增
     */
    @Insert("insert into account_tbl(account,password,nick_name,update_time,create_time) values (#{account},#{password},#{nick_name},#{update_time},#{create_time})")
    int addAccount(AccountEntity accountEntity);

    /**
     * 修改用户密码
     * @param accountEntity
     * @return
     */
    @Update("update account_tbl set password=#{password} where id=#{id}")
    boolean updateAccountPassword(AccountEntity accountEntity);

    /**
     * 修改用户信息
     * @param accountEntity
     * @return
     * */
    @Update("update account_tbl set nick_name=#{nick_name} where id=#{id}")
    boolean updateAccount(AccountEntity accountEntity);

    /**
     * 根据用户名称查询用户信息
     *
     */
    @Select("SELECT id,account,password,nick_name,update_time,create_time FROM account_tbl where account=#{account}")
    AccountEntity findByAccount(@Param("account") String account);

    /**
     * 根据用户ID查询用户信息
     *
     */
    @Select("SELECT id,account,password,nick_name,update_time,create_time FROM account_tbl where id=#{id}")
    AccountEntity findById(@Param("id") long id);

}