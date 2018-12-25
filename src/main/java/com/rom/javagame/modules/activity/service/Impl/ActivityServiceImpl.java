package com.rom.javagame.modules.activity.service.Impl;

import com.rom.javagame.modules.activity.dao.ActivityDao;
import com.rom.javagame.modules.activity.entity.ActivityEntity;
import com.rom.javagame.modules.activity.service.ActivityService;
import com.rom.javagame.modules.management.dao.ManagementDao;
import com.rom.javagame.modules.management.entity.AuthorityEntity;
import com.rom.javagame.modules.management.service.ManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityDao activityDao;
    @Autowired
    private ManagementService managementService;
    //新增活动
    @Override
    public long addActivity(ActivityEntity activityEntity, long account_id) {
        long re = -1;
        try {
            if(activityDao.findActivityByNameNTime(activityEntity.getAct_name(), activityEntity.getCreate_time()) == null) {
                activityDao.addAct(activityEntity);
                //id为活动表中的自增id
                long id = activityEntity.getId();
                //关联权限表
                AuthorityEntity authorityEntity = new AuthorityEntity();
                authorityEntity.setAccount_id(account_id);
                authorityEntity.setActivity_id(id);
                managementService.addAuthority(authorityEntity);
                System.out.println(id);
                re = id;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return re;
    }
    //获取单个活动信息
    @Override
    public ActivityEntity getActivity(long id){
        return activityDao.findActivityById(id);
    }
    //获取所有活动列表
    @Override
    public List<ActivityEntity> getAllActivity(){
        return activityDao.getAllActivity();
    }


}
