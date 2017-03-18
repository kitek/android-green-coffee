package pl.kitek.greencoffeeexample.steps

import android.content.Intent
import android.support.test.rule.ActivityTestRule
import com.mauriciotogneri.greencoffee.GreenCoffeeSteps
import com.mauriciotogneri.greencoffee.annotations.Given
import com.mauriciotogneri.greencoffee.annotations.Then
import com.mauriciotogneri.greencoffee.annotations.When
import org.mockito.Mockito
import pl.kitek.greencoffeeexample.MainActivity
import pl.kitek.greencoffeeexample.R
import pl.kitek.greencoffeeexample.di.TestComponentRule

class MainSteps(val component: TestComponentRule,
                val main: ActivityTestRule<MainActivity>) : GreenCoffeeSteps() {

    @Given("^there is a message: \"([^\"]*)\"$")
    fun thereIsMessage(message: String) {
        Mockito.`when`(component.getDataRepository().getMessage()).thenReturn(message)
    }

    @When("^the app has launched$")
    fun whenTheAppHasLaunched() {
        main.launchActivity(Intent())
    }

    @Then("^I should see message: \"([^\"]*)\"$")
    fun iShouldSeeMessage(message: String) {
        onViewWithId(R.id.messageText).contains(message)
    }
}
