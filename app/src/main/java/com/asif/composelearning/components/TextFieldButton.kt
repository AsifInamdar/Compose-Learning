package com.asif.composelearning.components

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asif.composelearning.R
import com.asif.composelearning.ui.theme.ComposeLearningTheme
import com.asif.composelearning.ui.theme.Purple40
import com.asif.composelearning.ui.theme.PurpleGrey80

@Composable
fun TextFieldWithButton(modifier: Modifier) {
    var text by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically)
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = {
                text = it
            },
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "emailIcon",
                    tint = Purple40
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            textStyle = TextStyle(
                fontSize = 14.sp,
                color = Color.Black,
            ),
            label = { Text(text = "Enter your email") },
            placeholder = { Text(text = "Type here...", fontSize = 12.sp) }
        )

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
            },
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "password",
                    tint = Purple40
                )
            },
            trailingIcon = {
                val image =
                    if (!passwordVisible) painterResource(id = R.drawable.password_hidden) else painterResource(
                        id = R.drawable.password_visible
                    )
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(painter = image, contentDescription = null)
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = if (!passwordVisible) PasswordVisualTransformation() else VisualTransformation.None,
            textStyle = TextStyle(
                fontSize = 14.sp,
                color = Color.Black
            ),
            label = { Text(text = "Enter your password") },
            placeholder = { Text(text = "Type here...", fontSize = 12.sp) }
        )

        Button(
            onClick = {
                Toast.makeText(context, "Welcome to the app!", Toast.LENGTH_LONG).show()
            }, shape = RoundedCornerShape(16.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Purple40)
        ) {
            Text(text = "Login", fontSize = 16.sp)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewEditTextButton() {
    ComposeLearningTheme {
        TextFieldWithButton(
            modifier = Modifier
                .fillMaxSize()
                .background(color = PurpleGrey80)
        )
    }
}
