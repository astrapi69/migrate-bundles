package de.alpharogroup.spring.batch.configuration

import javax.persistence.EntityManagerFactory

import de.alpharogroup.spring.batch.entity.BaseNames
import de.alpharogroup.spring.batch.factory.SpringBatchObjectFactory
import de.alpharogroup.spring.batch.mapper.BaseNameMapper
import de.alpharogroup.spring.batch.viewmodel.BaseName
import org.mapstruct.factory.Mappers
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.item.ItemProcessor
import org.springframework.batch.item.database.JpaItemWriter
import org.springframework.batch.item.file.FlatFileItemReader
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.FileSystemResource
import org.springframework.transaction.PlatformTransactionManager

import lombok.AccessLevel
import lombok.AllArgsConstructor
import lombok.experimental.FieldDefaults
import org.springframework.beans.factory.annotation.Autowired

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
            val entity = Mappers.getMapper(BaseNameMapper::class.java).toEntity(item)
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