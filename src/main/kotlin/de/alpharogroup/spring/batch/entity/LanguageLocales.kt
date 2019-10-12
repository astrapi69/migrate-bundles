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
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Parameter
import org.hibernate.id.enhanced.SequenceStyleGenerator

import javax.persistence.*

/**
 * The entity class [LanguageLocales] holds the data for the locale as [String] object.
 */
@Entity
@Table(name = LanguageLocales.TABLE_NAME, uniqueConstraints = [UniqueConstraint(name = DatabasePrefix.UNIQUE_CONSTRAINT_PREFIX
        + LanguageLocales.TABLE_NAME + DatabasePrefix.UNDERSCORE_PREFIX
        + LanguageLocales.COLUMN_NAME_LOCALE, columnNames = [LanguageLocales.COLUMN_NAME_LOCALE])], indexes = [Index(name = DatabasePrefix.INDEX_PREFIX + LanguageLocales.TABLE_NAME
        + DatabasePrefix.UNDERSCORE_PREFIX
        + LanguageLocales.COLUMN_NAME_LOCALE, columnList = LanguageLocales.COLUMN_NAME_LOCALE)])
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@GenericGenerator(name = BaseEntity.SEQUENCE_GENERIC_GENERATOR_NAME, strategy = IdentifiableSequenceStyleGenerator.STRATEGY_CLASS_NAME, parameters = [Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM, value = DatabasePrefix.SEQUENCE_GENERATOR_PREFIX + LanguageLocales.TABLE_NAME)])
@FieldDefaults(level = AccessLevel.PRIVATE)
class LanguageLocales : VersionableUUIDEntity(), Cloneable {

    /** The locale of this entry.  */
    @Column(length = 64)
    var locale: String? = null
        set(locale) {
            field = this.locale
        }

    companion object {

        const val COLUMN_NAME_LOCALE = "locale"

        /** Serial Version UID  */
        private val serialVersionUID = 1L
        const val TABLE_NAME = "language_locales"
    }

}