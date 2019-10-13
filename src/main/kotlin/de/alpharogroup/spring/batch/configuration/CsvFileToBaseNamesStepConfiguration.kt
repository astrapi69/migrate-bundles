package de.alpharogroup.spring.batch.configuration

import javax.persistence.EntityManagerFactory

import de.alpharogroup.spring.batch.entity.BaseNames
import de.alpharogroup.spring.batch.factory.SpringBatchObjectFactory
import de.alpharogroup.spring.batch.mapper.BaseNamesMapper
import de.alpharogroup.spring.batch.viewmodel.BaseName
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.item.ItemProcessor
import org.springframework.batch.item.database.JpaItemWriter
import org.springframework.batch.item.file.FlatFileItemReader
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.FileSystemResource
import org.springframework.transaction.PlatformTransactionManager

@Configuration
class CsvFileToBaseNamesStepConfiguration {

    lateinit var entityManagerFactory: EntityManagerFactory

    lateinit var applicationProperties: ApplicationProperties

    lateinit var stepBuilderFactory: StepBuilderFactory

    lateinit var transactionManager: PlatformTransactionManager


    @Bean
    fun baseNamesResource(): FileSystemResource {
        val filePath = applicationProperties.csvDir + "/" + applicationProperties.basenamesFileName
        return FileSystemResource(filePath)
    }

    @Bean
    fun baseNamesReader(): FlatFileItemReader<BaseName> {
        return SpringBatchObjectFactory.newCsvFileItemReader(baseNamesResource(), BaseName::class.java, ";", 1)
    }

    @Bean
    fun baseNamesWriter(): JpaItemWriter<BaseNames> {
        return SpringBatchObjectFactory.newJpaItemWriter(entityManagerFactory)
    }

    @Bean
    fun baseNamesProcessor(): ItemProcessor<BaseName, BaseNames> {
        return ItemProcessor { item ->
            val entity = BaseNamesMapper().toEntity(item)
            item
            entity
        }
    }

    @Bean
    fun csvFileToBaseNamesStep(): Step {
        return stepBuilderFactory.get("csvFileToBrosStep").chunk<BaseName, BaseNames>(10).reader(baseNamesReader())
                .processor(baseNamesProcessor()).writer(baseNamesWriter()).transactionManager(transactionManager).build()
    }

}