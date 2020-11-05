package com.github.amag.processorchestrator.domain;


import com.arangodb.entity.KeyType;
import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.HashIndex;
import com.arangodb.springframework.annotation.Ref;
import com.github.amag.processorchestrator.context.ProcessContext;
import com.github.amag.processorchestrator.criteria.Criteria;
import com.github.amag.processorchestrator.domain.enums.ProcessInstanceStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Document(value = "process_instances", keyType = KeyType.uuid, allowUserKeys = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@HashIndex(fields = {"processDate","processTemplate"}, unique = true)
public class ProcessInstance extends BaseObject {

    private String name;

    private ProcessInstanceStatus status;

    @CreatedDate
    private Date createdWhen;

    @LastModifiedDate
    private Date modifiedWhen;

    private Date processDate;

    @Ref(lazy = true)
    private ProcessInstance processTemplate;

    private ProcessContext processContext;

    private boolean isTemplate;

    private Criteria<ProcessInstance> executionCriteria;

}

