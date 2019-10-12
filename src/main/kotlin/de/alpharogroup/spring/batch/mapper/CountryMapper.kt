package de.alpharogroup.spring.batch.mapper

import de.alpharogroup.spring.batch.entity.Countries
import de.alpharogroup.spring.batch.viewmodel.Country
import de.alpharogroup.mapstruct.mapper.GenericMapper
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface CountryMapper : GenericMapper<Countries, Country>