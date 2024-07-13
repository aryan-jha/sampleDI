package com.example.sampledi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.sampledi.Dummy.Car
import com.example.sampledi.ui.theme.SampleDiTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var car: Car
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SampleDiTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier.padding(innerPadding),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(text = car.showCar())
                    }
                }
            }
        }
    }
}

/*
* step 1 - make a baseClass so that it can be accesible throughout the application.
* step 2 - register in manifest file (android:name=".BaseClass")
* step 3 - make a directory named as DI
* step 4 - now make module as HiltModule as in object type in DI.
* step 5 - now annotate the object with @Module and @InstallIn(SingletonComponent::class) to instantiate it as dagger object.
*           singletonComponent means that it will be created only once in the application and will get destroyed when the application is destroyed.
*step 6 - now make functions which will be providing the object. and annotate them with @Provides
* step 7 - now in mainActivity start with @AndroidEntryPoint and inject the object (lateinit var car: Car)
* step 8 - now use car normally in mainActivity
*
*
* in order to use it we have to downgrade versions i.e
* kotlin to 1.8.10
* agp to 8.1.4
* and java verision to 17
* and kotlincompilerExtension version to 1.4.3
*
*
*
*
*
* */