package com.azvk.nationalhockeyteams;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.azvk.nationalhockeyteams.activities.LoginActivity;

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



@RunWith(AndroidJUnit4.class)
public class LoginActivityEspressoTest {
    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule =
            new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void ensureLoginActivityWorks() {
        // Type text and then press the button.
        onView(withId(R.id.input_name_login))
                .perform(typeText("Cristiano Ronaldo"), closeSoftKeyboard());
        onView(withId(R.id.input_password_login))
                .perform(typeText("1234"), closeSoftKeyboard());
        onView(withId(R.id.signup_button_login)).perform(click());

        onView(withId(R.id.input_name_reg))
                .perform(typeText("Cristiano Ronaldo"), closeSoftKeyboard());
        onView(withId(R.id.input_password_reg))
                .perform(typeText("1234"), closeSoftKeyboard());
        onView(withId(R.id.input_repassword_reg))
                .perform(typeText("1234"), closeSoftKeyboard());
        onView(withId(R.id.input_password_reg))
                .check(matches(withText("1234")));

        onView(withId(R.id.signup_button_reg)).perform(click());

    }


}

