package com.rom.javagame.modules.game.service.impl;

import com.rom.javagame.modules.game.dao.GameDao;
import com.rom.javagame.modules.game.entity.PrizeHistoryEntity;
import com.rom.javagame.modules.game.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {
    @Autowired
    private GameDao gameDao;

    //新增获奖信息
    @Override
    public int addPrizeHistory(PrizeHistoryEntity prizeHistoryEntity){
        int id = -1;
        try {
             gameDao.addPrizeHistory(prizeHistoryEntity);
             id = prizeHistoryEntity.getId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
}
