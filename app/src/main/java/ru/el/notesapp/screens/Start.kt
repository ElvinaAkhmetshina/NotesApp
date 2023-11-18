package ru.el.notesapp.screens


import android.annotation.SuppressLint
import android.app.Application
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ru.el.notesapp.MainViewModel
import ru.el.notesapp.MainViewModelFactory
import ru.el.notesapp.navigation.NavRoute
import ru.el.notesapp.ui.theme.NotesAppTheme
import ru.el.notesapp.utils.Constants.Keys.START
import ru.el.notesapp.utils.TYPE_FIREBASE
import ru.el.notesapp.utils.TYPE_ROOM
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun StartScreen(navController: NavHostController, viewModel: MainViewModel)
{

    Scaffold(
        modifier = Modifier.fillMaxSize()
    )
    {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                onClick ={
                    viewModel.initDatabase(TYPE_ROOM){
                    navController.navigate(route = NavRoute.Main.route)}
                },
                modifier = Modifier
                    .width(200.dp)
                    .padding(vertical = 8.dp)
            )
            {
                Text (text=START)
            }


        }

    }
}


@Preview(showBackground = true)
@Composable
fun prevStartScreen(){
    NotesAppTheme {
        val context = LocalContext.current
        val mViewModel: MainViewModel = viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
        //val notes = mViewModel.readText().observeAsState(listOf()).value
        StartScreen(navController = rememberNavController(), viewModel = mViewModel)
    }
}


//            Button(
//                onClick ={
//                    mViewModel.initDatabase(TYPE_FIREBASE)
//                    navController.navigate(route = NavRoute.Main.route)
//                },
//                modifier = Modifier
//                    .width(200.dp)
//                    .padding(vertical = 8.dp)
//            )
//            {
//                Text (text = "FireDatabase")
//            }