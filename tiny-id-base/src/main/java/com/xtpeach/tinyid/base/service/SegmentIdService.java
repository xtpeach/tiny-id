package com.xtpeach.tinyid.base.service;

import com.xtpeach.tinyid.base.entity.SegmentId;

/**
 * @author xtpeach
 */
public interface SegmentIdService {

    /**
     * 根据bizType获取下一个SegmentId对象
     * @param bizType
     * @return
     */
    SegmentId getNextSegmentId(String bizType);

}
