/*
 *  This file is part of AndroidIDE.
 *
 *  AndroidIDE is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  AndroidIDE is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *   along with AndroidIDE.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.itsaky.androidide.inflater.internal.adapters

import android.view.View
import com.itsaky.androidide.annotations.inflater.AttributeAdapter
import com.itsaky.androidide.inflater.IAttribute
import com.itsaky.androidide.inflater.IAttributeAdapter
import com.itsaky.androidide.inflater.IView

/**
 * Attribute adapter for [View].
 *
 * @author Akash Yadav
 */
@AttributeAdapter(forClass = View::class)
open class ViewAttrAdapter : IAttributeAdapter() {

  override fun apply(view: IView, attribute: IAttribute) {
    TODO("Not yet implemented")
  }
  
  override fun applyBasic(view: IView) {
    TODO("Not yet implemented")
  }
}
