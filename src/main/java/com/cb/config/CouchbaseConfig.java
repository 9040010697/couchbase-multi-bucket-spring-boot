package com.cb.config;

import com.cb.model.Session;
import com.cb.model.User;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractReactiveCouchbaseConfiguration;
import org.springframework.data.couchbase.core.RxJavaCouchbaseTemplate;
import org.springframework.data.couchbase.repository.config.ReactiveRepositoryOperationsMapping;

import java.util.Collections;
import java.util.List;

@Configuration
@Slf4j
public class CouchbaseConfig extends AbstractReactiveCouchbaseConfiguration {

  @Value("${app.couchbase.bootstrap-hosts}")
  private String host;

  @Value("${app.couchbase.username}")
  private String userName;

  @Value("${app.couchbase.password}")
  private String password;

  @Value("${app.couchbase.bucket.name-customer}")
  private String customerBucketName;

  @Value("${app.couchbase.bucket.name-user}")
  private String userBucketName;

  @Value("${app.couchbase.bucket.name-session}")
  private String sessionBucketName;


  @Override
  protected List<String> getBootstrapHosts() {
    return Collections.singletonList(host);
  }

  @Override
  protected String getBucketName() {
    return customerBucketName;
  }

  @Override
  protected String getBucketPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return userName;
  }


  @Override
  public void configureReactiveRepositoryOperationsMapping(ReactiveRepositoryOperationsMapping baseMapping) {
    baseMapping.mapEntity(User.class, getCouchbaseTemplate(userBucketName));
    baseMapping.mapEntity(Session.class, getCouchbaseTemplate(sessionBucketName));
  }


  @SneakyThrows
  private RxJavaCouchbaseTemplate getCouchbaseTemplate(String bucketName) {

    RxJavaCouchbaseTemplate template = new RxJavaCouchbaseTemplate(couchbaseClusterInfo(),
            couchbaseCluster().openBucket(bucketName),
            mappingCouchbaseConverter(), translationService());

    template.setDefaultConsistency(getDefaultConsistency());
    return template;
  }
}
