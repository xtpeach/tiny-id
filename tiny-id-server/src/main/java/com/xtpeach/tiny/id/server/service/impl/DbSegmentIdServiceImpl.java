package com.xtpeach.tiny.id.server.service.impl;

import com.xtpeach.tiny.id.base.entity.SegmentId;
import com.xtpeach.tiny.id.base.exception.TinyIdSysException;
import com.xtpeach.tiny.id.base.service.SegmentIdService;
import com.xtpeach.tiny.id.server.common.Constants;
import com.xtpeach.tiny.id.server.dao.TinyIdInfoDAO;
import com.xtpeach.tiny.id.server.dao.entity.TinyIdInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;


/**
 * @author xtpeach
 */
@Component
public class DbSegmentIdServiceImpl implements SegmentIdService {

    private static final Logger logger = LoggerFactory.getLogger(DbSegmentIdServiceImpl.class);

    @Autowired
    private TinyIdInfoDAO tinyIdInfoDAO;

    /**
     * Transactional标记保证query和update使用的是同一连接
     * 事务隔离级别应该为READ_COMMITTED,Spring默认是DEFAULT(取决于底层使用的数据库，mysql的默认隔离级别为REPEATABLE_READ)
     * <p>
     * 如果是REPEATABLE_READ，那么在本次事务中循环调用tinyIdInfoDAO.queryByBizType(bizType)获取的结果是没有变化的，也就是查询不到别的事务提交的内容
     * 所以多次调用tinyIdInfoDAO.updateMaxId也就不会成功
     *
     * @param bizType
     * @return
     */
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public SegmentId getNextSegmentId(String bizType) {
        // 获取nextTinyId的时候，有可能存在version冲突，需要重试
        for (int i = 0; i < Constants.RETRY; i++) {
            TinyIdInfo tinyIdInfo = tinyIdInfoDAO.queryByBizType(bizType);
            if (tinyIdInfo == null) {
                tinyIdInfo = new TinyIdInfo();
                tinyIdInfo.setId(System.currentTimeMillis());
                tinyIdInfo.setBizType(bizType);
                tinyIdInfo.setBeginId(0L);
                tinyIdInfo.setMaxId(0L);
                tinyIdInfo.setStep(10);
                tinyIdInfo.setDelta(1);
                tinyIdInfo.setRemainder(0);
                tinyIdInfo.setCreateTime(new Date());
                tinyIdInfo.setUpdateTime(new Date());
                tinyIdInfo.setVersion(0L);
                tinyIdInfoDAO.createByBizType(tinyIdInfo);
            }
            Long newMaxId = tinyIdInfo.getMaxId() + tinyIdInfo.getStep();
            Long oldMaxId = tinyIdInfo.getMaxId();
            int row = tinyIdInfoDAO.updateMaxId(tinyIdInfo.getId(), newMaxId, oldMaxId, tinyIdInfo.getVersion(),
                    tinyIdInfo.getBizType());
            if (row == 1) {
                tinyIdInfo.setMaxId(newMaxId);
                SegmentId segmentId = convert(tinyIdInfo);
                logger.info("getNextSegmentId success tinyIdInfo:{} current:{}", tinyIdInfo, segmentId);
                return segmentId;
            } else {
                logger.info("getNextSegmentId conflict tinyIdInfo:{}", tinyIdInfo);
            }
        }
        throw new TinyIdSysException("get next segmentId conflict");
    }

    public SegmentId convert(TinyIdInfo idInfo) {
        SegmentId segmentId = new SegmentId();
        segmentId.setCurrentId(new AtomicLong(idInfo.getMaxId() - idInfo.getStep()));
        segmentId.setMaxId(idInfo.getMaxId());
        segmentId.setRemainder(idInfo.getRemainder() == null ? 0 : idInfo.getRemainder());
        segmentId.setDelta(idInfo.getDelta() == null ? 1 : idInfo.getDelta());
        // 默认20%加载
        segmentId.setLoadingId(segmentId.getCurrentId().get() + idInfo.getStep() * Constants.LOADING_PERCENT / 100);
        return segmentId;
    }
}
