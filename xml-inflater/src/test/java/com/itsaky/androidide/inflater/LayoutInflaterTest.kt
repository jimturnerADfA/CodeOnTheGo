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

package com.itsaky.androidide.inflater

import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.common.truth.Truth.assertThat
import com.itsaky.androidide.lookup.Lookup
import com.itsaky.androidide.projects.ProjectManager
import com.itsaky.androidide.projects.builder.BuildService
import com.itsaky.androidide.tooling.api.messages.InitializeProjectMessage
import com.itsaky.androidide.tooling.testing.ToolingApiTestLauncher
import java.io.File
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.android.controller.ActivityController

/** @author Akash Yadav */
@RunWith(RobolectricTestRunner::class)
class LayoutInflaterTest {

  private lateinit var activityController: ActivityController<AppCompatActivity>
  private lateinit var activity: AppCompatActivity

  @Before
  fun setup() {

    val (server, project) = ToolingApiTestLauncher().launchServer(implDir = "../build-tools/tooling-api-impl")
    server.initialize(InitializeProjectMessage(File("../tests/test-project").absolutePath)).get()

    Lookup.DEFAULT.register(BuildService.KEY_PROJECT_PROXY, project)
    ProjectManager.setupProject()

    this.activityController = Robolectric.buildActivity(AppCompatActivity::class.java)
    this.activity = this.activityController.get()
  }

  @Test
  fun `test functionality`() {
    val file = layoutFile("singleView")
    val parent = LinearLayout(activity)
    val inflater = ILayoutInflater.newInflater()
    val inflated = inflater.inflate(file, parent)
    assertThat(inflated).isNotNull()
  }

  private fun layoutFile(name: String): File {
    val app = ProjectManager.app ?: throw IllegalStateException("Project is not initialized")
    return File(app.projectDir, "src/main/res/layout/$name.xml")
  }
}
