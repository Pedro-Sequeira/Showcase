package com.pedrosequeira.showcase.dashboard

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.pedrosequeira.showcase.commons.ui.theme.ShowcaseTheme

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ShowcaseTheme {
        Greeting("Android")
    }
}
