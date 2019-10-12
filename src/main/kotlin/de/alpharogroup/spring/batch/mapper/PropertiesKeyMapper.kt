package de.alpharogroup.spring.batch.mapper

import de.alpharogroup.spring.batch.entity.PropertiesKeys
import de.alpharogroup.spring.batch.viewmodel.PropertiesKey
import de.alpharogroup.mapstruct.mapper.GenericMapper
import org.mapstruct.Mapper

@Mapper
interface PropertiesKeyMapper : GenericMapper<PropertiesKeys, PropertiesKey>