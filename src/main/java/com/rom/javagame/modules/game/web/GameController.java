package com.rom.javagame.modules.game.web;


import com.alibaba.fastjson.JSONObject;
import com.rom.javagame.modules.game.entity.PrizeHistoryEntity;
import com.rom.javagame.modules.game.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class GameController {

    @Autowired
    private GameService gameService;
    /**
     * 抽奖
     * POST
     * */
    @RequestMapping(value="/game", method = RequestMethod.POST)
    public int addPrizeHistory(@RequestBody JSONObject jsonObject) {
        PrizeHistoryEntity prizeHistoryEntity = new PrizeHistoryEntity();
        prizeHistoryEntity.setAccount_id(Integer.parseInt(jsonObject.get("account_id").toString()));
        prizeHistoryEntity.setActivity_id(Integer.parseInt(jsonObject.get("activity_id").toString()));
        //TODO 根据活动获取奖品列表 随机选则一个prize_id
        prizeHistoryEntity.setCreate_time(new Date());
        return gameService.addPrizeHistory(prizeHistoryEntity);
    }
}
