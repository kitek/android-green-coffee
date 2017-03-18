package pl.kitek.greencoffeeexample.features

import android.support.test.InstrumentationRegistry
import android.support.test.rule.ActivityTestRule
import com.mauriciotogneri.greencoffee.GreenCoffeeConfig
import com.mauriciotogneri.greencoffee.GreenCoffeeTest
import com.mauriciotogneri.greencoffee.ScenarioConfig
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import pl.kitek.greencoffeeexample.MainActivity
import pl.kitek.greencoffeeexample.di.TestComponentRule
import pl.kitek.greencoffeeexample.steps.MainSteps
import java.io.IOException
import java.util.*


@RunWith(Parameterized::class)
class MainFeatureTest(scenarioConfig: ScenarioConfig) : GreenCoffeeTest(scenarioConfig) {

    private val component = TestComponentRule(InstrumentationRegistry.getTargetContext())
    private val main = ActivityTestRule<MainActivity>(MainActivity::class.java, true, false)
    @get:Rule val chain: TestRule = RuleChain.outerRule(component).around(main)

    @Test
    fun test() {
        start(MainSteps(component, main))
    }

    companion object {
        @Parameterized.Parameters
        @Throws(IOException::class)
        @JvmStatic fun scenarios(): Iterable<ScenarioConfig> {
            return GreenCoffeeConfig("testapp") // folder to place the screenshot if a test fails
                    .withFeatureFromAssets("assets/main.feature")
                    .scenarios(Locale("en", "GB"))
        }
    }
}
