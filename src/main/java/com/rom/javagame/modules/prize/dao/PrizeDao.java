package com.rom.javagame.modules.prize.dao;

import com.rom.javagame.modules.prize.entity.PrizeEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PrizeDao {

    /**
     * 创建新的奖品信息
     *
     */
    @Insert("insert into prize_tbl (act_id, prize_name, prize_level, prize_desc, prize_num) values (#{act_id}, #{prize_name}, #{prize_level}, #{prize_desc}, #{prize_num})")
    void addPrize(PrizeEntity prizeEntity);

    /**
     * 更新奖品信息
     *
     * */
    @Update("update prize_tbl set prize_name=#{prize_name},prize_desc=#{prize_desc}, prize_level=#{prize_level}, prize_num=#{prize_num}where id =#{id}")
    boolean updatePrize(PrizeEntity prizeEntity);

    /**
     * 删除奖品
     *
     * */
    //TODO @Delete("")

    /**
     * 根据活动id查找奖品
     * */

    //TODO @Select



}
