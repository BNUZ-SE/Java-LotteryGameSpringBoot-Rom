package com.rom.javagame.modules.activity.web;


import com.alibaba.fastjson.JSONObject;
import com.rom.javagame.modules.account.service.AccountService;
import com.rom.javagame.modules.activity.entity.ActivityEntity;
import com.rom.javagame.modules.activity.service.ActivityService;
import com.rom.javagame.utils.String2Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @Autowired
    private AccountService accountService;
    /**
     * 新增活动
     * POST
     *
     * */
    @RequestMapping(value = "/act", method = RequestMethod.POST)
    public long addActivity(@RequestBody JSONObject jsonObject){
        ActivityEntity activityEntity = new ActivityEntity();
        activityEntity.setAct_name(jsonObject.get("act_name").toString());
        activityEntity.setAct_desc(jsonObject.get("act_desc").toString());
        activityEntity.setAct_person_num(0);
        //TODO 设置开始时间 结束时间
        //        activityEntity.setStart_time(String2Date.stringToDate(jsonObject.get("start_time").toString(),"yyyy-MM-dd HH:mm:ss"));
        //        activityEntity.setEnd_time(String2Date.stringToDate(jsonObject.get("end_time").toString(), "yyyy-MM-dd HH:mm:ss"));
        activityEntity.setStart_time(new Date());
        activityEntity.setEnd_time(new Date());
        activityEntity.setCreate_time(new Date());
        return activityService.addActivity(activityEntity, Long.parseLong(jsonObject.get("account_id").toString()));
    }
    /**
     *
     * 删除单个活动
     * DELETE
     *
     * */
    @RequestMapping(value="act/{activity_id}", method = RequestMethod.DELETE)
    public boolean delActivity(@PathVariable int activity_id) {
        return activityService.delActivity(activity_id);
    }
    /**
     * 获取全部活动
     * GET
     *
     * */
    @RequestMapping(value="/act", method = RequestMethod.GET)
    public List<ActivityEntity> getAllActivity() {
        return activityService.getAllActivity();
    }
    /**
     * 获取单个活动信息
     * GET
     * */
    @RequestMapping(value="act/{actid}", method = RequestMethod.GET)
    public ActivityEntity getActivity(@PathVariable long actid) {
        return activityService.getActivity(actid);
    }
    /**
     * 更新单个活动信息
     * PUT
     * **/
    @RequestMapping(value="act/{activity_id}", method = RequestMethod.PUT)
    public int updateActivity(@PathVariable int activity_id, @RequestBody JSONObject jsonObject) {
        ActivityEntity activityEntity = new ActivityEntity();
        activityEntity.setId(activity_id);
        activityEntity.setAct_name(jsonObject.get("activity_name").toString());
        activityEntity.setAct_desc(jsonObject.get("activity_desc").toString());
        //TODO 设置开始时间 结束时间
        return activityService.updateActivity(activityEntity);
    }
    /**
     * 清空活动参与人数
     * */
    @RequestMapping(value="act/{activity_id}/clear", method = RequestMethod.GET)
    public boolean clearActivityPersonNum(@PathVariable int activity_id) {
        return activityService.clearActivityPersonNum(activity_id);
    }
}
