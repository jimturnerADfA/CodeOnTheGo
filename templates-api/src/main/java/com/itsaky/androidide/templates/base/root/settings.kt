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

package com.itsaky.androidide.templates.base.root

import com.itsaky.androidide.templates.GRADLE_FOLDER_NAME
import com.itsaky.androidide.templates.GRADLE_VERSION
import com.itsaky.androidide.templates.LOCAL_ANDROID_GRADLE_PLUGIN_VERSION
import com.itsaky.androidide.templates.base.ProjectTemplateBuilder

internal fun ProjectTemplateBuilder.settingsGradleSrcStr(): String {
  return """
pluginManagement {
  repositories {
    gradlePluginPortal()
    google()
    mavenCentral()
    flatDir {
        dirs '../$GRADLE_FOLDER_NAME' // Directory containing your local JAR
    }
  }
  plugins {
     id 'com.android.application' version '$LOCAL_ANDROID_GRADLE_PLUGIN_VERSION' // Adjust this to match your local plugin version
  }
}

dependencyResolutionManagement {
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {
    google()
    mavenCentral()
  }
}

rootProject.name = "${data.name}"

${modules.joinToString(separator = ", ") { "include(\"${it.name}\")" }}    
  """.trim()
}
