package com.xtpeach.tiny.id.server.init.executor;

import com.xtpeach.tiny.id.server.dao.entity.TinyIdInfo;
import com.xtpeach.tiny.id.server.xls.executor.XLSExecutor;
import com.xtpeach.tiny.id.server.init.repo.TinyIdInfoRepo;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

@Component
public class TinyIdInfoExecutor extends XLSExecutor<TinyIdInfo> implements CommandLineRunner {

    @Resource
    private TinyIdInfoRepo<TinyIdInfo> repo;

    @Override
    public void run(String... args) {
        List<TinyIdInfo> tinyIdInfoList = ImportDataFromXLS(TinyIdInfo.class, "tinyid");
        tinyIdInfoList.removeIf(tinyIdInfo -> ObjectUtils.isEmpty(tinyIdInfo.getId()));
        // 获取已有的 tiny_id_info 如果已经有了就不进行初始化
        List<TinyIdInfo> tinyIdInfoListSaved = repo.findAll();
        if (CollectionUtils.isNotEmpty(tinyIdInfoListSaved)) {
            tinyIdInfoList.removeIf(
                    tinyIdInfo ->
                            !ObjectUtils.isEmpty(
                                    tinyIdInfoListSaved.stream().filter(tinyIdInfoSaved
                                            -> tinyIdInfoSaved.getId().longValue() == tinyIdInfo.getId().longValue())
                                            .findFirst().orElse(null)
                            )
            );
        }
        if (CollectionUtils.isNotEmpty(tinyIdInfoList)) {
            repo.saveAll(tinyIdInfoList);
        }
    }

}
