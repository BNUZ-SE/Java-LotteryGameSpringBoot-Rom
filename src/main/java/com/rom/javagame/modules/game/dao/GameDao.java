package com.rom.javagame.modules.game.dao;


import com.rom.javagame.modules.game.entity.PrizeHistoryEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.mapping.StatementType;
import org.springframework.stereotype.Repository;

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

}

