package com.cb.model;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.couchbase.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    @Id
    private String uId;

    @Field
    private String uName;

    @Field
    private String mobile;
}
