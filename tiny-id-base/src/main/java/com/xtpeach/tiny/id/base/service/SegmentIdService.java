package com.xtpeach.tiny.id.base.service;

import com.xtpeach.tiny.id.base.entity.SegmentId;

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
