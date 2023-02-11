package com.xtpeach.tinyid.server.init.repo;

import com.xtpeach.tinyid.server.dao.entity.TinyIdToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TinyIdTokenRepo<T extends TinyIdToken>
        extends JpaRepository<TinyIdToken, String>, JpaSpecificationExecutor<TinyIdToken> {
}
