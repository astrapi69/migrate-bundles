package de.alpharogroup.spring.batch.mapper

import de.alpharogroup.spring.batch.entity.PropertiesValues
import de.alpharogroup.spring.batch.viewmodel.PropertiesValue
import de.alpharogroup.mapstruct.mapper.GenericMapper
import org.mapstruct.Mapper

@Mapper
interface PropertiesValueMapper : GenericMapper<PropertiesValues, PropertiesValue>