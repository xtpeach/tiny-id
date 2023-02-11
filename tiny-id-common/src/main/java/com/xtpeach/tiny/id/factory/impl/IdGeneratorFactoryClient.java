package com.xtpeach.tiny.id.factory.impl;

import com.xtpeach.tiny.id.config.TinyIdClientConfig;
import com.xtpeach.tinyid.base.factory.AbstractIdGeneratorFactory;
import com.xtpeach.tinyid.base.generator.IdGenerator;
import com.xtpeach.tinyid.base.generator.impl.CachedIdGenerator;
import com.xtpeach.tiny.id.service.impl.HttpSegmentIdServiceImpl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author xtpeach
 */
public class IdGeneratorFactoryClient extends AbstractIdGeneratorFactory {

    private static final Logger logger = Logger.getLogger(IdGeneratorFactoryClient.class.getName());

    private static IdGeneratorFactoryClient idGeneratorFactoryClient;

    private static final int DEFAULT_TIME_OUT = 5000;

    private static String serverUrl = "http://{0}/tiny-id/id/nextSegmentIdSimple?token={1}&bizType=";

    private IdGeneratorFactoryClient() {

    }

    public static IdGeneratorFactoryClient getInstance() {
        if (idGeneratorFactoryClient == null) {
            synchronized (IdGeneratorFactoryClient.class) {
                if (idGeneratorFactoryClient == null) {
                    init();
                }
            }
        }
        return idGeneratorFactoryClient;
    }

    private static void init() {
        idGeneratorFactoryClient = new IdGeneratorFactoryClient();
        String tinyIdToken = "tiny-id-token";
        String tinyIdServer = "127.0.0.1";

        TinyIdClientConfig tinyIdClientConfig = TinyIdClientConfig.getInstance();
        tinyIdClientConfig.setTinyIdServer(tinyIdServer);
        tinyIdClientConfig.setTinyIdToken(tinyIdToken);
        tinyIdClientConfig.setReadTimeout(DEFAULT_TIME_OUT);
        tinyIdClientConfig.setConnectTimeout(DEFAULT_TIME_OUT);

        String[] tinyIdServers = tinyIdServer.split(",");
        List<String> serverList = new ArrayList<>(tinyIdServers.length);
        for (String server : tinyIdServers) {
            String url = MessageFormat.format(serverUrl, server, tinyIdToken);
            serverList.add(url);
        }
        logger.info("init tinyId client success url info:" + serverList);
        tinyIdClientConfig.setServerList(serverList);
    }

    @Override
    protected IdGenerator createIdGenerator(String bizType) {
        return new CachedIdGenerator(bizType, new HttpSegmentIdServiceImpl());
    }

}
