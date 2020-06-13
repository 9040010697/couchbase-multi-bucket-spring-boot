package com.cb.repository;

import com.cb.model.Customer;
import com.cb.model.Session;
import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface SessionRepository extends ReactiveCouchbaseRepository<Session, String> {

  Mono<Session> findBySession(String session);

}
