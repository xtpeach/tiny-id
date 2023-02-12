package com.xtpeach.tiny.id.server.init.executor;

import com.xtpeach.tiny.id.server.dao.entity.TinyIdToken;
import com.xtpeach.tiny.id.server.xls.executor.XLSExecutor;
import com.xtpeach.tiny.id.server.init.repo.TinyIdTokenRepo;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

@Component
public class TinyIdTokenExecutor extends XLSExecutor<TinyIdToken> implements CommandLineRunner {

    @Resource
    private TinyIdTokenRepo<TinyIdToken> repo;

    @Override
    public void run(String... args) {
        List<TinyIdToken> tinyIdTokenList = ImportDataFromXLS(TinyIdToken.class, "tinyid");
        tinyIdTokenList.removeIf(tinyIdToken -> ObjectUtils.isEmpty(tinyIdToken.getId()));
        if (CollectionUtils.isNotEmpty(tinyIdTokenList)) {
            repo.saveAll(tinyIdTokenList);
        }
    }

}
