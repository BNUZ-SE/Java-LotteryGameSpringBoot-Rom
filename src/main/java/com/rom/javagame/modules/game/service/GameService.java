package com.rom.javagame.modules.game.service;

import com.rom.javagame.modules.game.entity.PrizeHistoryEntity;

import java.util.List;

public interface GameService {
    /**
     * 新增抽奖记录
     * @param prizeHistoryEntity
     * @return
     * */
    int addPrizeHistory(PrizeHistoryEntity prizeHistoryEntity);

    /**
     * 删除抽奖记录
     * */
    //TODO Delete history

    /**
     * 根据用户返回获奖记录列表
     * @param account_id
     * @return
     * */
    List<PrizeHistoryEntity> getPrizeHistoryByAccountId(int account_id);

    /**
     * 根据活动返回获奖记录列表
     * @param activity_id
     * @return
     * */
    List<PrizeHistoryEntity> getPrizeHistoryByActivityId(int activity_id);

    /**
     * 根据获奖id返回具体信息
     * @param
     * @return
     *
     */
    PrizeHistoryEntity getPrizeHistoryById(int id);


}
