package com.xtpeach.tiny.id.server.factory.impl;

import com.xtpeach.tiny.id.base.factory.AbstractIdGeneratorFactory;
import com.xtpeach.tiny.id.base.generator.IdGenerator;
import com.xtpeach.tiny.id.base.generator.impl.CachedIdGenerator;
import com.xtpeach.tiny.id.base.service.SegmentIdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xtpeach
 */
@Component
public class IdGeneratorFactoryServer extends AbstractIdGeneratorFactory {

    private static final Logger logger = LoggerFactory.getLogger(CachedIdGenerator.class);
    @Autowired
    private SegmentIdService tinyIdService;

    @Override
    public IdGenerator createIdGenerator(String bizType) {
        logger.info("createIdGenerator :{}", bizType);
        return new CachedIdGenerator(bizType, tinyIdService);
    }
}
