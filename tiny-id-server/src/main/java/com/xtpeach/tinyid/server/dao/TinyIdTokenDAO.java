package com.xtpeach.tinyid.server.dao;

import com.xtpeach.tinyid.server.dao.entity.TinyIdToken;

import java.util.List;

/**
 * @author xtpeach
 */
public interface TinyIdTokenDAO {
    /**
     * 查询db中所有的token信息
     * @return
     */
    List<TinyIdToken> selectAll();
}
