package com.rom.javagame.modules.game.dao;


import com.rom.javagame.modules.game.entity.PrizeHistoryEntity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GameDao {

    /**
     * 获奖历史新增
     *
     * */
    @Insert("insert into prize_history_tbl(account_id, activity_id, prize_id, create_time) values (#{account_id}, #{activity_id}, #{prize_id}, #{create_time})")
    @SelectKey(before=false, keyProperty = "id", resultType = Integer.class,statementType = StatementType.STATEMENT,statement="SELECT LAST_INSERT_ID() AS id")
    int addPrizeHistory(PrizeHistoryEntity prizeHistoryEntity);


    /**
     * 根据用户id获得获奖记录列表
     *
     * */
    @Select("select account_id,activity_id,prize_id,create_time, id from prize_history_tbl where account_id=#{id}")
    List<PrizeHistoryEntity> findPrizeHistoryByAccountId(@Param("id") int id);

    /**
     * 根据活动id获得获奖记录列表
     *
     * */
    @Select("select account_id,activity_id,prize_id,create_time, id from prize_history_tbl where activity_id=#{id}")
    List<PrizeHistoryEntity> findPrizeHistoryByActivityId(@Param("id") int id);

    /***
     *根据获奖id返回获奖信息
     * */
    @Select("select account_id,activity_id,prize_id,create_time, id from prize_history_tbl where activity_id=#{id}")
    PrizeHistoryEntity findPrizeHistoryById(@Param("id") int id);
}

