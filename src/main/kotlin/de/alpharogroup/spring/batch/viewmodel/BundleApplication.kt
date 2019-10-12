/**
 * The MIT License
 *
 * Copyright (C) 2019 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package de.alpharogroup.spring.batch.viewmodel

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import lombok.*
import lombok.experimental.FieldDefaults
import java.util.UUID

/**
 * The class [BundleApplication].
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
class BundleApplication {
    var id: Int? = null
        set(id) {
            field = this.id
        }
    var version: Int? = null
        set(version) {
            field = this.version
        }
    var name: String? = null
        set(name) {
            field = this.name
        }
    var defaultLocale: LanguageLocale? = null
        set(defaultLocale) {
            field = this.defaultLocale
        }
    var supportedLocales: Set<LanguageLocale>? = null
        set(supportedLocales) {
            field = this.supportedLocales
        }

}
