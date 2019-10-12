package de.alpharogroup.spring.batch.configuration

import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CsvToDatabaseJobConfiguration {


    @Bean
    fun importCsvFilesJob(@Autowired jobBuilderFactory: JobBuilderFactory, @Autowired  csvFileToBaseNamesStep: Step): Job {
        return jobBuilderFactory.get("importCsvFilesJob").incrementer(RunIdIncrementer())
                .start(csvFileToBaseNamesStep)
                .build()
    }
}
