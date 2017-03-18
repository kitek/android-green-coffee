package pl.kitek.greencoffeeexample.di

import dagger.Module
import dagger.Provides
import pl.kitek.greencoffeeexample.data.DataRepository
import pl.kitek.greencoffeeexample.data.DataSource
import javax.inject.Singleton

@Module
class AppModule {
    @Provides @Singleton fun provideDataRepository(): DataSource = DataRepository()
}
