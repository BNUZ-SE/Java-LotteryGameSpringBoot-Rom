package com.rom.javagame.modules.management.service;


import com.rom.javagame.modules.management.entity.AuthorityEntity;

public interface ManagementService {
    /**
     * 新增权限
     * @param authorityEntity
     * @return
     */
    void addAuthority(AuthorityEntity authorityEntity);
}
