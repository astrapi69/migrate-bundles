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
 * The entity class [BundleNames] holds the data from the [BaseNames] and the
 * [LanguageLocales]. If you see it from the properties file view this represents an
 * properties file. So you can have the default properties file that is the properties file without
 * the locale suffix and you have for instance a French properties file with the locale suffix _fr.
 * This would be two entries from this entity class one for the default and one for the French
 * locale.
 */
@Entity
@Table(name = BundleNames.TABLE_NAME, indexes = [Index(name = DatabasePrefix.INDEX_PREFIX + BundleNames.TABLE_NAME
        + DatabasePrefix.UNDERSCORE_PREFIX
        + BundleNames.COLUMN_NAME_BASE_NAME, columnList = BundleNames.COLUMN_NAME_BASE_NAME), Index(name = DatabasePrefix.INDEX_PREFIX + BundleNames.TABLE_NAME
        + DatabasePrefix.UNDERSCORE_PREFIX
        + BundleNames.COLUMN_NAME_FILEPATH, columnList = BundleNames.COLUMN_NAME_FILEPATH), Index(name = DatabasePrefix.INDEX_PREFIX + BundleNames.TABLE_NAME
        + DatabasePrefix.UNDERSCORE_PREFIX
        + BundleNames.COLUMN_NAME_LOCALE, columnList = BundleNames.COLUMN_NAME_LOCALE), Index(name = DatabasePrefix.INDEX_PREFIX + BundleNames.TABLE_NAME
        + DatabasePrefix.UNDERSCORE_PREFIX
        + BundleNames.COLUMN_NAME_OWNER, columnList = BundleNames.COLUMN_NAME_OWNER)])
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@GenericGenerator(name = BaseEntity.SEQUENCE_GENERIC_GENERATOR_NAME, strategy = IdentifiableSequenceStyleGenerator.STRATEGY_CLASS_NAME, parameters = [Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM, value = DatabasePrefix.SEQUENCE_GENERATOR_PREFIX + BundleNames.TABLE_NAME)])
@FieldDefaults(level = AccessLevel.PRIVATE)
@SuperBuilder
class BundleNames : VersionableUUIDEntity(), Cloneable {

    /** The base name of this bundle.  */
    @ManyToOne(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    @JoinColumn(name = "base_name_id", nullable = true, referencedColumnName = "uuid", foreignKey = ForeignKey(name = "fk_bundlenames_base_name_id"))
    var baseName: BaseNames? = null
        set(baseName) {
            field = this.baseName
        }

    /** The optional filepath from this resource bunlde.  */
    @Column(name = "filepath", length = 4096)
    var filepath: String? = null
        set(filepath) {
            field = this.filepath
        }

    /** The locale of this bundle.  */
    @ManyToOne(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    @JoinColumn(name = "locale_id", nullable = true, referencedColumnName = "uuid", foreignKey = ForeignKey(name = "fk_bundlenames_locale_id"))
    var locale: LanguageLocales? = null
        set(locale) {
            field = this.locale
        }

    /** The [BundleApplications] that owns this [BundleNames] object.  */
    @ManyToOne(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    @JoinColumn(name = "owner_id", nullable = true, referencedColumnName = "uuid", foreignKey = ForeignKey(name = "fk_bundlenames_owner_id"))
    var owner: BundleApplications? = null
        set(owner) {
            field = this.owner
        }

    companion object {

        const val COLUMN_NAME_BASE_NAME = "base_name_id"
        const val COLUMN_NAME_FILEPATH = "filepath"
        const val COLUMN_NAME_LOCALE = "locale_id"
        const val COLUMN_NAME_OWNER = "owner_id"
        /** The Constant for the named query for find BundleNames by the owner.  */
        const val NQ_FIND_BY_OWNER = "BundleNames." + "findByOwner"
        /** Serial Version UID  */
        private val serialVersionUID = 1L

        const val TABLE_NAME = "bundlenames"
    }

}
