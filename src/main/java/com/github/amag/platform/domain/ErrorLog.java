package com.github.amag.platform.domain;


import com.arangodb.entity.KeyType;
import com.arangodb.springframework.annotation.Document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Document(value = "error_log", keyType = KeyType.uuid, allowUserKeys = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorLog extends BaseObject {

    private String entityType;

    private UUID entityId;

    private String stackTrace;
}


