
package com.openclassrooms.entrevoisins.neighbour_list;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;
import com.openclassrooms.entrevoisins.utils.DeleteViewAction;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.openclassrooms.entrevoisins.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.core.IsNull.notNullValue;



/**
 * Test class for list of neighbours
 */
@RunWith(AndroidJUnit4.class)
public class NeighboursListTest {

    // This is fixed
    private static int ITEMS_COUNT = 12;
    private static int FAVORITE_COUNT = 0;

    private ListNeighbourActivity mActivity;

    @Rule
    public ActivityTestRule<ListNeighbourActivity> mActivityRule =
            new ActivityTestRule(ListNeighbourActivity.class);

    @Before
    public void setUp() {
        mActivity = mActivityRule.getActivity();
        assertThat(mActivity, notNullValue());
    }

    /**
     * When we click on a neighbour (from the list), this neighbour's profile layout is launched and displayed
     */
    @Test
    public void myNeighbourList_onClicItem_ShouldLaunchProfileNeighbour() {
        //Given : When perform a click on an item from the neighbour's list
        onView((ViewMatchers.withId(R.id.list_neighbours)))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));
        //Expected : The view matches the profile layout view
        onView(ViewMatchers.withId(R.id.profile_header_name)).check(matches(withId(R.id.profile_header_name)));

    }

    /**
     * When the neighbour's profile layout is launched, the neighbour's name TexView is not empty
     */
    @Test
    public void myNeighbourProfile_onDisplay_neighbourNameIsNotEmpty() {
        onView(ViewMatchers.withId(R.id.list_neighbours))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.profile_header_name)).check(matches(withText("Caroline")));
        onView(withId(R.id.profile_body_name)).check(matches(withText("Caroline")));

    }

    /**
     * When we delete a neighbour, he is not shown anymore
     */
    @Test
    public void myNeighboursList_deleteAction_shouldRemoveItem() {
        onView(ViewMatchers.withId(R.id.list_neighbours))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, new DeleteViewAction()));
        onView(ViewMatchers.withId(R.id.list_neighbours)).check(withItemCount(ITEMS_COUNT-1));
    }

    /**
     * When a neighbour is checked as favorite, we check that the favorite list only contains neighbour's
     * marked as favorite
     */
    @Test
    public void myNeighboursFavoriteList_shouldOnlyHaveFavoriteNeighbours() throws InterruptedException {
        onView(ViewMatchers.withId(R.id.list_neighbours))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.profile_favorite_button));
        // Thread.sleep sert à bypass une erreur d'espresso qui souhaite charger simulatanément une view et appuyer
        // sur un bouton de cette view en même temps.
        {Thread.sleep(1000);}
        onView(withId(R.id.profile_favorite_button)).perform(click());
        onView(withId(R.id.profile_header_return)).perform(click());
        onView(ViewMatchers.withId(R.id.favorite_list_neighbours)).check(withItemCount(FAVORITE_COUNT+1));
    }
}














