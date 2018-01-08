/*
 * copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

package top.pengcheng789.algorithms.dataStruct.bag

/**
 * CreateDate:2017-08-19
 *
 * @author pen
 */
abstract class Bag<T> {

    var size = 0
        protected set

    abstract fun add(value: T)

    abstract fun getByIndex(index: Int): T

    abstract fun clean()

    fun isEmpty(): Boolean { return size == 0 }

    override fun toString(): String {
        var s = "["
        if (size == 0)
            s += ","
        else (0..(size - 1)).map { s += getByIndex(it).toString() + "," }
        return s.substring(0..(s.length-2)) + "]"
    }
}