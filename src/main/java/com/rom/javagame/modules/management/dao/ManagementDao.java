package com.rom.javagame.modules.management.dao;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ManagementDao {
    /**
     * 添加权限信息
     * **/
    @Insert("insert into authority_tbl(account_id, activity_id) values (#{account_id}, #{activity_id})")
    void addAuthority(@Param("account_id") long account_id, @Param("activity_id") long activity_id);
}
