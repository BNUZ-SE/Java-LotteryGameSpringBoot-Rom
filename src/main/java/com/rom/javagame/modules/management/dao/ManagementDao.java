package com.rom.javagame.modules.management.dao;


import com.rom.javagame.modules.game.entity.PrizeHistoryEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ManagementDao {
    /**
     * 添加权限信息
     * **/
    @Insert("insert into authority_tbl(account_id, activity_id) values (#{account_id}, #{activity_id})")
    void addAuthority(@Param("account_id") long account_id, @Param("activity_id") long activity_id);

    /**
     * 根据id返回权限列表
     *
     * */
    @Select("select account_id, activity_id from authority_tbl where account_id=#{id}")
    List<PrizeHistoryEntity> findActivityManageList(@Param("id") int id);
}
