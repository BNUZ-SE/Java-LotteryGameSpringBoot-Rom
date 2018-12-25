package com.rom.javagame.modules.prize.service;

import com.rom.javagame.modules.prize.entity.PrizeEntity;

public interface PrizeService {
    /**
     * 新增奖品
     * @param prizeEntity
     * @return
     *
     * */

    boolean addPrize(PrizeEntity prizeEntity);

    /**
     * 更新奖品信息
     * @param prizeEntity
     * @return
     * */
    boolean updatePrize(PrizeEntity prizeEntity);

    /**
     * 删除奖品
     * @param prizeEntity
     * @return
     *
     * */

    /**
     * 根据活动查询奖品
     * @param act_id
     * */

}
