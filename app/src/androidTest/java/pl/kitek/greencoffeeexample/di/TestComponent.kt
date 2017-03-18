package pl.kitek.greencoffeeexample.di


import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppTestModule::class))
interface TestComponent : AppComponent
