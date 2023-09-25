package com.gkcoding.composebuttoncomponents

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.gkcoding.composebuttoncomponents.component.DCButton
import com.gkcoding.composebuttoncomponents.component.DCElevatedButton
import com.gkcoding.composebuttoncomponents.component.DCFilledTonalButton
import com.gkcoding.composebuttoncomponents.component.DCOutlinedButton
import com.gkcoding.composebuttoncomponents.component.DCTextButton
import com.gkcoding.composebuttoncomponents.ui.theme.ComposeButtonComponentsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeButtonComponentsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        DCButton(
                            onClick = { Log.d(TAG, "DCButton: onClick() called") },
                            onLongClick = { Log.d(TAG, "DCButton: onLongClick() called") }) {
                            Text(text = "DCButton")
                        }
                        DCElevatedButton(
                            onClick = { Log.d(TAG, "DCElevatedButton: onClick() called") },
                            onLongClick = {
                                Log.d(
                                    TAG,
                                    "DCElevatedButton: onLongClick() called"
                                )
                            }) {
                            Text(text = "DCElevatedButton")
                        }
                        DCFilledTonalButton(
                            onClick = { Log.d(TAG, "DCFilledTonalButton: onClick() called") },
                            onLongClick = {
                                Log.d(
                                    TAG,
                                    "DCFilledTonalButton: onLongClick() called"
                                )
                            }) {
                            Text(text = "DCFilledTonalButton")
                        }
                        DCOutlinedButton(
                            onClick = { Log.d(TAG, "DCOutlinedButton: onClick() called") },
                            onLongClick = {
                                Log.d(
                                    TAG,
                                    "DCOutlinedButton: onLongClick() called"
                                )
                            }) {
                            Text(text = "DCOutlinedButton")
                        }
                        DCTextButton(
                            onClick = { Log.d(TAG, "DCTextButton: onClick() called") },
                            onLongClick = { Log.d(TAG, "DCTextButton: onLongClick() called") }) {
                            Text(text = "DCTextButton")
                        }

                    }
                }
            }
        }
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}
