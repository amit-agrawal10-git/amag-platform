package com.github.amag.platform.repositories;

import com.arangodb.springframework.repository.ArangoRepository;
import com.github.amag.platform.domain.Constant;

import java.util.Optional;
import java.util.UUID;

public interface ConstantRepository extends ArangoRepository<Constant, UUID> {
    Optional<Constant> findByKey(String key);
}
