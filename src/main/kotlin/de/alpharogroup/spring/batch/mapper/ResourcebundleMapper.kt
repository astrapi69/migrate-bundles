package de.alpharogroup.spring.batch.mapper

import de.alpharogroup.spring.batch.entity.Resourcebundles
import de.alpharogroup.spring.batch.viewmodel.Resourcebundle
import de.alpharogroup.mapstruct.mapper.GenericMapper
import org.mapstruct.Mapper

@Mapper
interface ResourcebundleMapper : GenericMapper<Resourcebundles, Resourcebundle>