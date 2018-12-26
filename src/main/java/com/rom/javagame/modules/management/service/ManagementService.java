package com.rom.javagame.modules.management.service;


import com.rom.javagame.modules.activity.entity.ActivityEntity;
import com.rom.javagame.modules.management.entity.AuthorityEntity;

import java.util.List;

public interface ManagementService {
    /**
     * 新增权限
     * @param authorityEntity
     * @return
     */
    void addAuthority(AuthorityEntity authorityEntity);

    /**
     * 返回拥有控制权限的活动的列表
     * @param account_id
     * @return
     * */
    List<ActivityEntity> getActivityManageList(int account_id);
}
