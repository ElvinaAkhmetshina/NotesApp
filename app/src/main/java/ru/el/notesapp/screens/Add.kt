package ru.el.notesapp.screens

import android.annotation.SuppressLint
import android.app.Application
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.RadioButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import ru.el.notesapp.model.Note
import ru.el.notesapp.navigation.NavRoute
import ru.el.notesapp.ui.theme.NotesAppTheme
import ru.el.notesapp.utils.Constants.Keys.ADD_NOTE


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AddScreen(navController: NavHostController, viewModel: MainViewModel){
    var title by remember{mutableStateOf("")}
    var subtitle by remember{mutableStateOf("")}
    //var date by remember{mutableStateOf("")}
    var priority by remember{mutableStateOf("")}
    var isButtonEnabled by remember{ mutableStateOf(false) }
    ///val priority2 = remember { mutableStateOf("") }
    Scaffold{
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
            Text(
                text = ADD_NOTE,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            OutlinedTextField(value = title, onValueChange = {
                title = it
                isButtonEnabled = title.isNotEmpty() && subtitle.isNotEmpty()
            }, label = { Text(text = "Note title") }, isError = title.isEmpty())
            OutlinedTextField(value = subtitle, onValueChange = {
                subtitle = it
                isButtonEnabled = title.isNotEmpty() && subtitle.isNotEmpty()
            }, label = { Text(text = "Note subtitle") }, isError = subtitle.isEmpty())
            /*OutlinedTextField(value = date, onValueChange = {
                date = it
                isButtonEnabled = date.isNotEmpty() && title.isNotEmpty() && subtitle.isNotEmpty()
            }, label = { Text(text = "Note date") }, isError = date.isEmpty())*/
            /*OutlinedTextField(value = priority, onValueChange = {
                priority = it
                isButtonEnabled = title.isNotEmpty() && subtitle.isNotEmpty()
            }, label = { Text(text = "Note date") }, isError = priority.isEmpty())*/


            //val change= { priority2.value = !priority2.value }
            Column(Modifier.selectableGroup())
            {
                Row{
                    RadioButton(
                        selected = priority == "1",
                        onClick = { priority = "1" },
                        modifier = Modifier.padding(8.dp)
                    )
                    Text("Normal", fontSize = 22.sp)
                }
                Row{
                    RadioButton(
                        selected = priority == "2",
                        onClick = { priority = "2" },
                        modifier = Modifier.padding(8.dp)
                    )
                    Text("High", fontSize = 22.sp)
                }
            }
            Button(
                modifier = Modifier.padding(top = 16.dp),
                enabled = isButtonEnabled,
                onClick = {
                    viewModel.addNote(
                        note = Note(
                            title = title,
                            subtitle = subtitle,
                            date = System.currentTimeMillis()/1000,
                            priority = priority.toInt()
                        )
                    ) {
                        navController.navigate(NavRoute.Main.route)
                    }
                }
            )
            {
                Text(text = ADD_NOTE)
            }
        }
}
}

@Preview(showBackground = true)
@Composable
fun prevAddScreen(){
    NotesAppTheme {
        val context = LocalContext.current
        val mViewModel: MainViewModel = viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
        //val notes = mViewModel.readTest.observeAsState(listOf()).value
        AddScreen(navController = rememberNavController(), viewModel = mViewModel)
    }
}