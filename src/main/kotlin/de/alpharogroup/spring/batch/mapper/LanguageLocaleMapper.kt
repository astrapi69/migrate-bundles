package de.alpharogroup.spring.batch.mapper

import de.alpharogroup.spring.batch.entity.LanguageLocales
import de.alpharogroup.spring.batch.viewmodel.LanguageLocale
import de.alpharogroup.mapstruct.mapper.GenericMapper
import org.mapstruct.Mapper

@Mapper
interface LanguageLocaleMapper : GenericMapper<LanguageLocales, LanguageLocale>