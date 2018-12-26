package com.rom.javagame.modules.prize.service;

import com.rom.javagame.modules.prize.entity.PrizeEntity;

import java.util.List;

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
     * @param id
     * @return
     *
     * */
    boolean delPrize(int id);

    /**
     * 根据活动查询奖品
     * @param act_id
     * */
    List<PrizeEntity> findPrizesByAct(int act_id);

    /**
     * 奖品数量 -1
     * */
    boolean reducePrize(int id);
}
