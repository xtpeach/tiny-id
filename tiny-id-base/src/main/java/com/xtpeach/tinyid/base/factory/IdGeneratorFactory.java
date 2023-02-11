package com.xtpeach.tinyid.base.factory;

import com.xtpeach.tinyid.base.generator.IdGenerator;

/**
 * @author xtpeach
 */
public interface IdGeneratorFactory {
    /**
     * 根据bizType创建id生成器
     * @param bizType
     * @return
     */
    IdGenerator getIdGenerator(String bizType);
}
