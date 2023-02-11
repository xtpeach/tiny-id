package com.xtpeach.tinyid.server.init.repo;

import com.xtpeach.tinyid.server.dao.entity.TinyIdInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TinyIdInfoRepo<T extends TinyIdInfo>
        extends JpaRepository<TinyIdInfo, String>, JpaSpecificationExecutor<TinyIdInfo> {
}
