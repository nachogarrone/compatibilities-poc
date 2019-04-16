package com.mercadolibre.compatibilitiespoc.repository;

import com.mercadolibre.compatibilitiespoc.model.Network;
import com.microsoft.spring.data.gremlin.repository.GremlinRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GraphRepository extends GremlinRepository<Network, String> {}
