package de.alpharogroup.spring.batch.mapper

import de.alpharogroup.spring.batch.entity.Languages
import de.alpharogroup.spring.batch.viewmodel.Language
import de.alpharogroup.mapstruct.mapper.GenericMapper
import org.mapstruct.Mapper

@Mapper
interface LanguageMapper : GenericMapper<Languages, Language>