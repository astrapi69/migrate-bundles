package de.alpharogroup.spring.batch.mapper

import de.alpharogroup.spring.batch.entity.BundleNames
import de.alpharogroup.spring.batch.viewmodel.BundleName
import de.alpharogroup.mapstruct.mapper.GenericMapper
import org.mapstruct.Mapper

@Mapper
interface BundleNameMapper : GenericMapper<BundleNames, BundleName>