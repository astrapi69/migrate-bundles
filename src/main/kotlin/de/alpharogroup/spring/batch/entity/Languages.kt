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
import de.alpharogroup.db.entity.name.NameEntity
import de.alpharogroup.db.entity.name.versionable.VersionableNameUUIDEntity
import de.alpharogroup.hibernate.generator.IdentifiableSequenceStyleGenerator
import lombok.*
import lombok.experimental.FieldDefaults
import lombok.experimental.SuperBuilder
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Parameter
import org.hibernate.id.enhanced.SequenceStyleGenerator

import javax.persistence.*

/**
 * The entity class [LanguageLocales] holds the data for the languages.
 */
@Entity
@Table(name = Languages.TABLE_NAME, uniqueConstraints = [UniqueConstraint(name = DatabasePrefix.UNIQUE_CONSTRAINT_PREFIX + Languages.TABLE_NAME
        + DatabasePrefix.UNDERSCORE_PREFIX
        + NameEntity.COLUMN_NAME_NAME, columnNames = [NameEntity.COLUMN_NAME_NAME]), UniqueConstraint(name = DatabasePrefix.UNIQUE_CONSTRAINT_PREFIX + Languages.TABLE_NAME
        + DatabasePrefix.UNDERSCORE_PREFIX
        + Languages.COLUMN_NAME_ISO_639_DASH1, columnNames = [Languages.COLUMN_NAME_ISO_639_DASH1])], indexes = [Index(name = DatabasePrefix.INDEX_PREFIX + Languages.TABLE_NAME
        + DatabasePrefix.UNDERSCORE_PREFIX
        + NameEntity.COLUMN_NAME_NAME, columnList = NameEntity.COLUMN_NAME_NAME), Index(name = DatabasePrefix.INDEX_PREFIX + Languages.TABLE_NAME
        + DatabasePrefix.UNDERSCORE_PREFIX
        + Languages.COLUMN_NAME_ISO_639_DASH1, columnList = Languages.COLUMN_NAME_ISO_639_DASH1)])
@Getter
@Setter
@ToString
@NoArgsConstructor
@GenericGenerator(name = BaseEntity.SEQUENCE_GENERIC_GENERATOR_NAME, strategy = IdentifiableSequenceStyleGenerator.STRATEGY_CLASS_NAME, parameters = [Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM, value = DatabasePrefix.SEQUENCE_GENERATOR_PREFIX + Languages.TABLE_NAME)])
@FieldDefaults(level = AccessLevel.PRIVATE)
@SuperBuilder
class Languages : VersionableNameUUIDEntity(), Cloneable {

    /** The iso639_1 code with two characters.  */
    @Column(name = "iso639_1", length = 2)
    var iso639Dash1: String? = null
        set(iso639Dash1) {
            field = this.iso639Dash1
        }

    companion object {

        const val COLUMN_NAME_ISO_639_DASH1 = "iso639_1"

        /** Serial Version UID  */
        private val serialVersionUID = 1L
        const val TABLE_NAME = "languages"
    }

}
