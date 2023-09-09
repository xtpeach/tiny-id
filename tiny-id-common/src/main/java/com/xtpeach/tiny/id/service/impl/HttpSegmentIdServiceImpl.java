package com.xtpeach.tiny.id.service.impl;

import com.xtpeach.tiny.id.config.TinyIdConfig;
import com.xtpeach.tiny.id.base.entity.SegmentId;
import com.xtpeach.tiny.id.base.service.SegmentIdService;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

/**
 * @author xtpeach
 */
public class HttpSegmentIdServiceImpl implements SegmentIdService {

    private static final Logger logger = Logger.getLogger(HttpSegmentIdServiceImpl.class.getName());

    @Override
    public SegmentId getNextSegmentId(String bizType) {
        // 旧的选取 url 方法
//        String url = chooseService(bizType);
//        String response = TinyIdHttpUtils.post(url, TinyIdClientConfig.getInstance().getReadTimeout(),
//                TinyIdClientConfig.getInstance().getConnectTimeout());

        String response = TinyIdConfig.getInstance().getTinyIdFeign().nextSegmentIdSimple(bizType, TinyIdConfig.getInstance().getToken());

        logger.info("tinyId client getNextSegmentId end, response:" + response);
        if (response == null || "".equals(response.trim())) {
            return null;
        }
        SegmentId segmentId = new SegmentId();
        String[] arr = response.split(",");
        segmentId.setCurrentId(new AtomicLong(Long.parseLong(arr[0])));
        segmentId.setLoadingId(Long.parseLong(arr[1]));
        segmentId.setMaxId(Long.parseLong(arr[2]));
        segmentId.setDelta(Integer.parseInt(arr[3]));
        segmentId.setRemainder(Integer.parseInt(arr[4]));
        return segmentId;
    }

    // 旧的选取 url 方法
//    private String chooseService(String bizType) {
//        List<String> serverList = TinyIdClientConfig.getInstance().getServerList();
//        String url = "";
//        if (serverList != null && serverList.size() == 1) {
//            url = serverList.get(0);
//        } else if (serverList != null && serverList.size() > 1) {
//            Random r = new Random();
//            url = serverList.get(r.nextInt(serverList.size()));
//        }
//        url += bizType;
//        return url;
//    }


}
