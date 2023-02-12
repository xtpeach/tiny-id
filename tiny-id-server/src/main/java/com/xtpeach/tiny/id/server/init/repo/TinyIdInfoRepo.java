package com.xtpeach.tiny.id.server.init.repo;

import com.xtpeach.tiny.id.server.dao.entity.TinyIdInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TinyIdInfoRepo<T extends TinyIdInfo>
        extends JpaRepository<TinyIdInfo, String>, JpaSpecificationExecutor<TinyIdInfo> {
}
