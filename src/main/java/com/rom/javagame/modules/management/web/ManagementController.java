package com.rom.javagame.modules.management.web;


import com.alibaba.fastjson.JSONObject;
import com.rom.javagame.modules.activity.entity.ActivityEntity;
import com.rom.javagame.modules.game.entity.PrizeHistoryEntity;
import com.rom.javagame.modules.management.service.ManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class ManagementController {

    @Autowired
    private ManagementService managementService;
    /**
     * 获得用户拥有管理权的活动
     * GET
     *
     */
    @RequestMapping(value="/manage/{account_id}", method = RequestMethod.GET)
    public List<ActivityEntity> getActivityManageList(@PathVariable("account_id") int account_id) {
        return managementService.getActivityManageList(account_id);
    }

}
