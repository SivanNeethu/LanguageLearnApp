package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.data.CurriculumData
import com.example.data.StoriesData
import com.example.data.WorksheetsData
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class ExampleRobolectricTest {

  @Test
  fun `read string from context`() {
    val context = ApplicationProvider.getApplicationContext<Context>()
    val appName = context.getString(R.string.app_name)
    assertEquals("LinguaKids", appName)
  }

  @Test
  fun `verify three hundred stories available offline`() {
    val stories = StoriesData.allStories
    assertEquals(300, stories.size)
    stories.forEach { story ->
      assertTrue(story.titleEnglish.isNotBlank())
      assertTrue(story.titleHindi.isNotBlank())
      assertTrue(story.titleKannada.isNotBlank())
      assertTrue(story.titleMalayalam.isNotBlank())
      assertTrue(story.paragraphs.isNotEmpty())
    }
  }

  @Test
  fun `verify curriculum vocabulary and worksheets`() {
    assertTrue(CurriculumData.vocabularyList.isNotEmpty())
    assertTrue(CurriculumData.hindiLetters.isNotEmpty())
    assertTrue(CurriculumData.kannadaLetters.isNotEmpty())
    assertTrue(WorksheetsData.worksheets.isNotEmpty())
  }
}
