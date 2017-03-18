package pl.kitek.greencoffeeexample.di

import android.content.Context
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement
import pl.kitek.greencoffeeexample.App
import pl.kitek.greencoffeeexample.data.DataSource

class TestComponentRule(val context: Context) : TestRule {

    private var testComponent: TestComponent = DaggerTestComponent.builder()
            .appTestModule(AppTestModule())
            .build()

    fun getDataRepository(): DataSource {
        return testComponent.dataRepository()
    }

    override fun apply(base: Statement?, description: Description?): Statement {
        return object : Statement() {
            override fun evaluate() {
                val app = App.get(context)
                app.setComponent(testComponent)
                base?.evaluate()
                app.setComponent(null)
            }
        }
    }
}