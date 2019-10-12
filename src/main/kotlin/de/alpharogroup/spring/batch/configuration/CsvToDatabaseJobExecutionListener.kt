package de.alpharogroup.spring.batch.configuration

import mu.KLogging
import org.springframework.batch.core.JobExecution
import org.springframework.batch.core.JobExecutionListener

class CsvToDatabaseJobExecutionListener : JobExecutionListener {
    val logger = KLogging().logger("beforeJob")
    override fun beforeJob(jobExecution: JobExecution) {
        logger.debug { "beforeJob" }
    }

    override fun afterJob(jobExecution: JobExecution) {
        logger.debug { "afterJob" }

    }

}