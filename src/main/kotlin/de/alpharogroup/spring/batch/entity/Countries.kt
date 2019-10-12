/**
 * The MIT License
 *
 *
 * Copyright (C) 2007 - 2015 Asterios Raptis
 *
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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import de.alpharogroup.db.entity.BaseEntity
import de.alpharogroup.db.entity.enums.DatabasePrefix
import de.alpharogroup.db.entity.name.NameEntity
import de.alpharogroup.db.entity.name.NameUUIDEntity
import de.alpharogroup.hibernate.generator.IdentifiableSequenceStyleGenerator
import lombok.AccessLevel
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import lombok.experimental.FieldDefaults
import lombok.experimental.SuperBuilder
import org.hibernate.annotations.Cache
import org.hibernate.annotations.CacheConcurrencyStrategy
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Parameter
import org.hibernate.id.enhanced.SequenceStyleGenerator

import javax.persistence.*

/**
 * The entity class [Countries] is keeping the information for all countries in the world
 */
@Entity
@Table(name = Countries.TABLE_NAME, uniqueConstraints = [UniqueConstraint(name = DatabasePrefix.UNIQUE_CONSTRAINT_PREFIX + Countries.TABLE_NAME
        + DatabasePrefix.UNDERSCORE_PREFIX
        + NameEntity.COLUMN_NAME_NAME, columnNames = [NameEntity.COLUMN_NAME_NAME]), UniqueConstraint(name = DatabasePrefix.UNIQUE_CONSTRAINT_PREFIX + Countries.TABLE_NAME
        + DatabasePrefix.UNDERSCORE_PREFIX
        + Countries.COLUMN_NAME_ISO_3166_A2_NAME, columnNames = [Countries.COLUMN_NAME_ISO_3166_A2_NAME])], indexes = [Index(name = DatabasePrefix.INDEX_PREFIX + Countries.TABLE_NAME
        + DatabasePrefix.UNDERSCORE_PREFIX
        + NameEntity.COLUMN_NAME_NAME, columnList = NameEntity.COLUMN_NAME_NAME), Index(name = DatabasePrefix.INDEX_PREFIX + Countries.TABLE_NAME
        + DatabasePrefix.UNDERSCORE_PREFIX
        + Countries.COLUMN_NAME_ISO_3166_A2_NAME, columnList = Countries.COLUMN_NAME_ISO_3166_A2_NAME)])
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Getter
@Setter
@NoArgsConstructor
@GenericGenerator(name = BaseEntity.SEQUENCE_GENERIC_GENERATOR_NAME, strategy = IdentifiableSequenceStyleGenerator.STRATEGY_CLASS_NAME, parameters = [Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM, value = DatabasePrefix.SEQUENCE_GENERATOR_PREFIX + Countries.TABLE_NAME)])
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
@SuperBuilder
class Countries : NameUUIDEntity(), Cloneable {
    /** The iso3166 name with two characters.  */
    @Column(name = "iso3166_a2name", length = 2)
    var iso3166a2name: String? = null
        set(iso3166a2name) {
            field = this.iso3166a2name
        }

    companion object {

        const val COLUMN_NAME_ISO_3166_A2_NAME = "iso3166_a2name"
        /** The serial Version UID.  */
        private val serialVersionUID = 1L
        const val TABLE_NAME = "countries"
    }

}