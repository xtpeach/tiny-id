package com.xtpeach.tinyid.server.service;

/**
 * @author xtpeach
 */
public interface TinyIdTokenService {
    /**
     * 是否有权限
     * @param bizType
     * @param token
     * @return
     */
    boolean canVisit(String bizType, String token);
}
