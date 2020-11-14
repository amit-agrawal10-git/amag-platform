package com.github.amag.processorchestrator.domain;

import com.arangodb.springframework.annotation.ArangoId;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Data
public abstract class BaseObject {

    @Id
    protected String arangoKey;

    @ArangoId
    protected String arangoId;

    @CreatedDate
    private Date createdWhen;

    @LastModifiedDate
    private Date modifiedWhen;


    protected transient boolean criteriaResult;

}
