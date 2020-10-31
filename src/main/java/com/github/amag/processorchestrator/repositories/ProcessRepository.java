package com.github.amag.processorchestrator.repositories;

import com.arangodb.springframework.repository.ArangoRepository;
import com.github.amag.processorchestrator.domain.Process;
import com.github.amag.processorchestrator.domain.enums.ProcessInstanceStatus;
import com.github.amag.processorchestrator.domain.enums.ProcessStatus;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

public interface ProcessRepository extends ArangoRepository<Process, UUID> {
    Optional<Process> findByExecutedUptoBeforeAndProcessStatus(Date date, ProcessStatus processStatus);
}
