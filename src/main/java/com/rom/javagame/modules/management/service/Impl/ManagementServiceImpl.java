package com.rom.javagame.modules.management.service.Impl;


import com.rom.javagame.modules.account.dao.AccountDao;
import com.rom.javagame.modules.activity.entity.ActivityEntity;
import com.rom.javagame.modules.activity.service.ActivityService;
import com.rom.javagame.modules.game.entity.PrizeHistoryEntity;
import com.rom.javagame.modules.management.dao.ManagementDao;
import com.rom.javagame.modules.management.entity.AuthorityEntity;
import com.rom.javagame.modules.management.service.ManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManagementServiceImpl implements ManagementService{

    @Autowired
    private ManagementDao managementDao;
    @Autowired
    private ActivityService activityService;

    //新增权限表
    @Override
    public void addAuthority(AuthorityEntity authorityEntity) {
        try{
            managementDao.addAuthority(authorityEntity.getAccount_id(), authorityEntity.getActivity_id());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //根据用户id返回拥有管理权的活动列表
    @Override
    public List<ActivityEntity> getActivityManageList(int account_id) {
        try{
            List<PrizeHistoryEntity> activityManageList = managementDao.findActivityManageList(account_id);
            List<ActivityEntity> activityList = new ArrayList<ActivityEntity>();
            for (PrizeHistoryEntity prizeHistory: activityManageList) {
                activityList.add(activityService.getActivity(prizeHistory.getActivity_id()));
            }
            return activityList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



}
