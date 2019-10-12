package de.alpharogroup.spring.batch.mapper

import de.alpharogroup.spring.batch.entity.BundleApplications
import de.alpharogroup.spring.batch.viewmodel.BundleApplication
import de.alpharogroup.mapstruct.mapper.GenericMapper
import org.mapstruct.Mapper

@Mapper
interface BundleApplicationMapper : GenericMapper<BundleApplications, BundleApplication>