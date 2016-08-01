package com.azvk.nationalhockeyteams;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.azvk.nationalhockeyteams.activities.RegistrationActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class RegistrationActivityEspressoTest {
    @Rule
    public ActivityTestRule<RegistrationActivity> mActivityRule =
            new ActivityTestRule<>(RegistrationActivity.class);

    @Test
    public void ensureActivityWorks() {
        // Type text and then press the button.
        onView(withId(R.id.input_name_reg))
                .perform(typeText("Cristiano Ronaldo"), closeSoftKeyboard());
        onView(withId(R.id.input_password_reg))
                .perform(typeText("1234"), closeSoftKeyboard());
        onView(withId(R.id.input_repassword_reg))
                .perform(typeText("1234"), closeSoftKeyboard());

        onView(withId(R.id.signup_button_reg)).perform(click());

        onView(withText("userExists")).inRoot(new ToastMatcher())
                .check(matches(isDisplayed()));
    }


}
