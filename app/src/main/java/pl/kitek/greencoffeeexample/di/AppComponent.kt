package pl.kitek.greencoffeeexample.di

import dagger.Component
import pl.kitek.greencoffeeexample.MainActivity
import pl.kitek.greencoffeeexample.data.DataSource
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(mainActivity: MainActivity)

    fun dataRepository(): DataSource
}
