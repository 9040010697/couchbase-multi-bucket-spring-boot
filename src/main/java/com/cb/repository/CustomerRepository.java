package com.cb.repository;

import com.cb.model.Customer;
import com.cb.utils.RepoConstants;
import org.springframework.data.couchbase.core.query.Query;
import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface CustomerRepository extends ReactiveCouchbaseRepository<Customer, String> {

    @Query(RepoConstants.PHONE_NUMBER_SEARCH_QUERY)
    Mono<Customer> findByPhoneNumber(String phoneNumber);

    @Query(RepoConstants.MLC_CARD_SEARCH_QUERY)
    Mono<Customer> findByMlcCardNo(String mlcCardNo);

    @Query(RepoConstants.MLC_CARD_PHONE_NUMBER_SEARCH_QUERY)
    Mono<Customer> findByMlcCardNoAndPhoneNumber(String mlcCardNo, String phoneNumber);
    

}
