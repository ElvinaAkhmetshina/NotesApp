package ru.el.notesapp

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface


import androidx.compose.material.Text
import androidx.compose.material.TopAppBar


import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.el.notesapp.navigation.NotesNavHost
import ru.el.notesapp.ui.theme.NotesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesAppTheme {
                val context = LocalContext.current
                val mViewModel: MainViewModel = viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
                //val notes = mViewModel.readText.observeAsState(listOf()).value
                // A surface container using the 'background' color from the theme
               Scaffold(
                   topBar = {
                       TopAppBar(
                           title = {
                               Text(text = "ELVINA_AKHMETSHINA", fontFamily = FontFamily.Cursive, fontStyle = FontStyle.Italic)
                           },
                           backgroundColor = Color.Cyan,
                           contentColor = Color.White,
                           elevation = 12.dp
                       )

                   },
                   content = {padding->
                       Surface(
                        modifier = Modifier.fillMaxSize().padding(padding),
                        color = MaterialTheme.colors.background
                   ) {
                       NotesNavHost(mViewModel)
                   }
                   }
               )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NotesAppTheme {

    }
}