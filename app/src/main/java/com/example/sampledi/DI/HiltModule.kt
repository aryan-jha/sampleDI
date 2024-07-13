package com.example.sampledi.DI

import androidx.core.location.LocationRequestCompat.Quality
import com.example.sampledi.Dummy.Car
import com.example.sampledi.Dummy.Engine
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier


@Module
@InstallIn(SingletonComponent::class)
object HiltModule {

//    @Provides
//    fun provideCar():Car{
//        return Car() // for normally making an object
//    }

    @Provides
    fun provideCar(@EngineTest engine: Engine):Car{//if there are two of same return types then use annotation which we made
        return Car(engine) // so now this will take the provideEngine 1 vala  and if we have used there @EngineTest2 then it will take provideEngine2

        //if it was dependent on engine then we would have written
    }

    @Provides
    fun provideEngine():Engine{
        return Engine()
    }

    @Provides
    fun provideEngine2():Engine{
        return Engine()
    }
    //now suppose we have other fun too which returns engine only then line 24 will get confused ki konsa uthaae so.
    //we will use our own annotations to make to classify.

}

// annotations created
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class EngineTest

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class EngineTest2