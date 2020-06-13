package com.cb.repository;

import com.cb.model.User;
import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveCouchbaseRepository<User, String> {
    Mono<User> findByMobile(String mobile);
}
