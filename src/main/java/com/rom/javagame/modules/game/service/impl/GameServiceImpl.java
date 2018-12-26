package com.rom.javagame.modules.game.service.impl;

import com.rom.javagame.modules.activity.dao.ActivityDao;
import com.rom.javagame.modules.game.dao.GameDao;
import com.rom.javagame.modules.game.entity.PrizeHistoryEntity;
import com.rom.javagame.modules.game.service.GameService;
import com.rom.javagame.modules.prize.entity.PrizeEntity;
import com.rom.javagame.modules.prize.service.PrizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class GameServiceImpl implements GameService {
    @Autowired
    private GameDao gameDao;
    @Autowired
    private ActivityDao activityDao;
    @Autowired
    private PrizeService prizeService;

    //新增获奖信息
    @Override
    public int addPrizeHistory(PrizeHistoryEntity prizeHistoryEntity) {
        int id = -1;
        try {
            //增加活动参与人数
            activityDao.updateActivityPersonNum(prizeHistoryEntity.getActivity_id());
            //根据活动获取奖品列表 随机选则一个prize_id
            List<PrizeEntity> prizeList = prizeService.findPrizesByAct(prizeHistoryEntity.getActivity_id());
            //随机获得一个奖品id
            Random random = new Random();
            int n = random.nextInt(prizeList.size());
            PrizeEntity prizeRandom = prizeList.get(n);
            //奖品数量检测
            //如果小于1 则无获奖 返回-1
            if (prizeRandom.getPrize_num() < 1) {
                return id;
            }
            //奖品数量-1
            prizeService.reducePrize(prizeRandom.getId());
            //增加获奖记录
            prizeHistoryEntity.setPrize_id(prizeRandom.getId());
            gameDao.addPrizeHistory(prizeHistoryEntity);
            //返回获奖记录id
            id = prizeHistoryEntity.getId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
    //根据用户返回获奖记录列表
    @Override
    public List<PrizeHistoryEntity> getPrizeHistoryByAccountId(int account_id) {
        try {
            return gameDao.findPrizeHistoryByAccountId(account_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //根据活动返回获奖记录列表
    @Override
    public List<PrizeHistoryEntity> getPrizeHistoryByActivityId(int activity_id) {
        try{
            return gameDao.findPrizeHistoryByActivityId(activity_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //根据获奖id返回具体信息
    @Override
    public PrizeHistoryEntity getPrizeHistoryById(int id) {
        try {
            return gameDao.findPrizeHistoryById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
