package com.xtpeach.tiny.id.base.generator;

import java.util.List;

/**
 * @author xtpeach
 */
public interface IdGenerator {
    /**
     * get next id
     * @return
     */
    Long nextId();

    /**
     * get next id batch
     * @param batchSize
     * @return
     */
    List<Long> nextId(Integer batchSize);
}
