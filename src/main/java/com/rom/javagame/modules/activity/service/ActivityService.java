package com.rom.javagame.modules.activity.service;

import com.rom.javagame.modules.activity.entity.ActivityEntity;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ActivityService {
    /**
     * 新增活动
     * @param activityEntity
     * @return id
     *
     * */
    long addActivity(ActivityEntity activityEntity, long account_id);

    /**
     *
     * 删除活动
     * @param id
     * @return
     */
    boolean delActivity(int id);

    /**
     * 修改活动信息
     * @param activityEntity
     * @return
     * */
    //TODO boolean updateActivity (ActivityEntity activityEntity);

    /**
     * 根据活动id查询信息
     * @param id
     * @return
     *
     * */
    ActivityEntity getActivity(long id);

    /**
     * 返回所有活动信息
     * @return
     * */

    List<ActivityEntity> getAllActivity();
}
