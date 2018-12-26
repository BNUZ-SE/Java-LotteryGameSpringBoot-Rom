package com.rom.javagame.modules.activity.dao;


import com.rom.javagame.modules.activity.entity.ActivityEntity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface ActivityDao {
    /**
     * 活动新增
     *
     * */
    @Insert("insert into activity_tbl(act_name, act_desc, act_person_num, start_time, end_time, create_time) values (#{act_name}, #{act_desc}, #{act_person_num}, #{start_time}, #{end_time}, #{create_time})")
    @SelectKey(before=false, keyProperty = "id", resultType = Integer.class,statementType = StatementType.STATEMENT,statement="SELECT LAST_INSERT_ID() AS id")
    int addAct(ActivityEntity activityEntity);

    /**
     * 根据活动id 删除活动（单个）
     * */
    @Delete("delete from activity_tbl where id=#{id}")
    void delAct(@Param("id") int id);

    /**
     * 获取所有活动
     * */
    @Select("select * from activity_tbl")
    List<ActivityEntity> getAllActivity();

    /**
     * 获取单个活动
     *
     * */
    @Select("select * from activity_tbl where id=#{id}")
    ActivityEntity findActivityById(@Param("id") long id);

    /**
     *
     * 根据活动名称和时间返回活动
     * */
    @Select("select * from activity_tbl where act_name=#{act_name} and create_time=#{create_time}")
    ActivityEntity findActivityByNameNTime(@Param("act_name") String act_name, @Param("create_time") Date create_time);

    /**
     * 更新活动信息
     * */
    @Update("update activity_tbl set act_name=#{act_name}, act_desc=#{act_desc}, start_time=#{start_time}, end_time=#{end_time} where id=#{id}")
    boolean updateActivity(ActivityEntity activityEntity);

    /**
     * 参与活动人数增加
     * */
    @Update("update activity_tbl set act_person_num=act_person_num + 1 where id=#{id}")
    boolean updateActivityPersonNum(@Param("id") int id);


    /**
    * 参与活动人数清空
    * */
    @Update("update activity_tbl set act_person_num=0 where id=#{id}")
    boolean clearActivityPersonNum(@Param("id") int id);


}
