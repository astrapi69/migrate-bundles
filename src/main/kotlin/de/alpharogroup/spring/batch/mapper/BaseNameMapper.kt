package de.alpharogroup.spring.batch.mapper

import de.alpharogroup.spring.batch.entity.BaseNames
import de.alpharogroup.spring.batch.viewmodel.BaseName
import de.alpharogroup.mapstruct.mapper.GenericMapper
import org.mapstruct.Mapper

@Mapper
interface BaseNameMapper : GenericMapper<BaseNames, BaseName>