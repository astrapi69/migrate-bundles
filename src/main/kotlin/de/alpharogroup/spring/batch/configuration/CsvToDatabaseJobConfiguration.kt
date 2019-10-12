package de.alpharogroup.spring.batch.configuration

import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CsvToDatabaseJobConfiguration {

    @Bean
    fun importCsvFilesJob(jobBuilderFactory: JobBuilderFactory,
                          csvToDatabaseJobExecutionListener: CsvToDatabaseJobExecutionListener, csvFileToBaseNamesStep: Step): Job {
        return jobBuilderFactory.get("importCsvFilesJob").incrementer(RunIdIncrementer())
                .listener(csvToDatabaseJobExecutionListener).start(csvFileToBaseNamesStep)
                .build()
    }
}
