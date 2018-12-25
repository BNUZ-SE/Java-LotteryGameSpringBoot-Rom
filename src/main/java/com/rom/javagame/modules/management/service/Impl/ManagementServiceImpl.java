package com.rom.javagame.modules.management.service.Impl;


import com.rom.javagame.modules.account.dao.AccountDao;
import com.rom.javagame.modules.management.dao.ManagementDao;
import com.rom.javagame.modules.management.entity.AuthorityEntity;
import com.rom.javagame.modules.management.service.ManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagementServiceImpl implements ManagementService{
    @Autowired
    private ManagementDao managementDao;
    //新增权限表
    @Override
    public void addAuthority(AuthorityEntity authorityEntity) {
        try{
            managementDao.addAuthority(authorityEntity.getAccount_id(), authorityEntity.getActivity_id());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
