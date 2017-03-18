package pl.kitek.greencoffeeexample.di

import dagger.Module
import dagger.Provides
import org.mockito.Mockito.mock
import pl.kitek.greencoffeeexample.data.DataSource
import javax.inject.Singleton

@SuppressWarnings("UnusedParameters")
@Module
class AppTestModule {
    @Provides @Singleton fun provideDataRepository(): DataSource = mock(DataSource::class.java)
}
