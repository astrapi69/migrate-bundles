/**
 * The MIT License
 *
 * Copyright (C) 2007 - 2015 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 * *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package de.alpharogroup.spring.batch.entity

import de.alpharogroup.db.entity.BaseEntity
import de.alpharogroup.db.entity.enums.DatabasePrefix
import de.alpharogroup.db.entity.version.VersionableUUIDEntity
import de.alpharogroup.hibernate.generator.IdentifiableSequenceStyleGenerator
import lombok.*
import lombok.experimental.FieldDefaults
import lombok.experimental.SuperBuilder
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Parameter
import org.hibernate.id.enhanced.SequenceStyleGenerator

import javax.persistence.*

/**
 * The entity class [Resourcebundles] holds the all data of the values of the resource
 * bundles.
 */
@Entity
@Table(name = Resourcebundles.TABLE_NAME, indexes = [Index(name = DatabasePrefix.INDEX_PREFIX
        + Resourcebundles.TABLE_NAME + DatabasePrefix.UNDERSCORE_PREFIX
        + Resourcebundles.COLUMN_NAME_BUNDLE_NAME, columnList = Resourcebundles.COLUMN_NAME_BUNDLE_NAME), Index(name = DatabasePrefix.INDEX_PREFIX + Resourcebundles.TABLE_NAME
        + DatabasePrefix.UNDERSCORE_PREFIX
        + Resourcebundles.COLUMN_NAME_PROPRERTIES_KEY, columnList = Resourcebundles.COLUMN_NAME_PROPRERTIES_KEY), Index(name = DatabasePrefix.INDEX_PREFIX + Resourcebundles.TABLE_NAME
        + DatabasePrefix.UNDERSCORE_PREFIX
        + Resourcebundles.COLUMN_NAME_PROPRERTIES_VALUE, columnList = Resourcebundles.COLUMN_NAME_PROPRERTIES_VALUE)])
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@GenericGenerator(name = BaseEntity.SEQUENCE_GENERIC_GENERATOR_NAME, strategy = IdentifiableSequenceStyleGenerator.STRATEGY_CLASS_NAME, parameters = [Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM, value = DatabasePrefix.SEQUENCE_GENERATOR_PREFIX + Resourcebundles.TABLE_NAME)])
@FieldDefaults(level = AccessLevel.PRIVATE)
@SuperBuilder
class Resourcebundles : VersionableUUIDEntity(), Cloneable {

    /** The bundleName from this [BundleNames] object.  */
    @ManyToOne(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    @JoinColumn(name = "bundlename_id", nullable = true, referencedColumnName = "uuid", foreignKey = ForeignKey(name = "fk_resourcebundles_bundlename_id"))
    var bundleName: BundleNames? = null
        set(bundleName) {
            field = this.bundleName
        }

    /** The properties key from this [BundleNames] object.  */
    @ManyToOne(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    @JoinColumn(name = "properties_key_id", nullable = true, referencedColumnName = "uuid", foreignKey = ForeignKey(name = "fk_resourcebundles_properties_key_id"))
    var key: PropertiesKeys? = null
        set(key) {
            field = this.key
        }

    /** The value for the properties key.  */
    @ManyToOne(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    @JoinColumn(name = "properties_value_id", nullable = true, referencedColumnName = "uuid", foreignKey = ForeignKey(name = "fk_resourcebundles_properties_value_id"))
    var value: PropertiesValues? = null
        set(value) {
            field = this.value
        }

    companion object {

        const val COLUMN_NAME_BUNDLE_NAME = "bundlename_id"
        const val COLUMN_NAME_PROPRERTIES_KEY = "properties_key_id"
        const val COLUMN_NAME_PROPRERTIES_VALUE = "properties_value_id"

        /** Serial Version UID  */
        private val serialVersionUID = 1L
        const val TABLE_NAME = "resourcebundles"
    }

}