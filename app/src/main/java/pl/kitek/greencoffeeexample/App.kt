package pl.kitek.greencoffeeexample

import android.app.Application
import android.content.Context
import pl.kitek.greencoffeeexample.di.AppComponent
import pl.kitek.greencoffeeexample.di.AppModule
import pl.kitek.greencoffeeexample.di.DaggerAppComponent

class App : Application() {

    private var appComponent: AppComponent? = null

    fun getComponent(): AppComponent {
        if (null == appComponent) {
            appComponent = DaggerAppComponent.builder()
                    .appModule(AppModule())
                    .build()
        }
        return appComponent!!
    }

    fun setComponent(graph: AppComponent?) {
        this.appComponent = graph
    }

    companion object {
        fun get(context: Context): App {
            return context.applicationContext as App
        }
    }
}
