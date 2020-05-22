package uk.nhs.nhsx.sonar.android.app.status

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import uk.nhs.nhsx.sonar.android.app.R

class IsolateRobot {

    fun checkActivityIsDisplayed() {
        onView(withId(R.id.status_red_title)).check(matches(isDisplayed()))
    }

    fun checkPopUpIsDisplayed() {
        onView(withId(R.id.bottom_sheet_isolate)).check(matches(isDisplayed()))
    }

    fun clickBookTestCard() {
        onView(withId(R.id.book_test_card)).perform(click())
    }

    fun clickHaveSymptoms() {
        onView(withId(R.id.have_symptoms)).perform(click())
    }
}
