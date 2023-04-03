package com.xtpeach.tiny.id.base.factory;

import com.xtpeach.tiny.id.base.generator.IdGenerator;

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
