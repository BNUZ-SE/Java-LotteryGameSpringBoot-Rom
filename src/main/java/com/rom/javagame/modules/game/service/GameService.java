package com.rom.javagame.modules.game.service;

import com.rom.javagame.modules.game.entity.PrizeHistoryEntity;

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


}
