package de.alpharogroup.spring.batch.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "app")
class ApplicationProperties
{
    lateinit var name: String
    lateinit var dbHost: String
    lateinit var dbName: String
    lateinit var dbPort: Integer
    lateinit var dbUrlPrefix: String
    lateinit var dbUsername: String
    lateinit var dbPassword: String
    lateinit var dir: String
    lateinit var csvDir: String
    lateinit var basenamesFileName: String
}