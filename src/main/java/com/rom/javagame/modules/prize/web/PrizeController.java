package com.rom.javagame.modules.prize.web;

import com.alibaba.fastjson.JSONObject;
import com.rom.javagame.modules.prize.entity.PrizeEntity;
import com.rom.javagame.modules.prize.service.PrizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class PrizeController {
    @Autowired
    private PrizeService prizeService;

    /***
     * 新增奖品
     * POST
     * */
    @RequestMapping(value="/act/{actid}/prize", method = RequestMethod.POST)
    public boolean addPrize(@PathVariable long actid, @RequestBody JSONObject jsonObject) {
        PrizeEntity prizeEntity = new PrizeEntity();
        prizeEntity.setAct_id(actid);
        prizeEntity.setPrize_name(jsonObject.get("prize_name").toString());
        prizeEntity.setPrize_desc(jsonObject.get("prize_desc").toString());
        prizeEntity.setPrize_level(Integer.parseInt(jsonObject.get("prize_level").toString()));
        prizeEntity.setPrize_num(Long.parseLong(jsonObject.get("prize_num").toString()));
        return prizeService.addPrize(prizeEntity);
    }



}
