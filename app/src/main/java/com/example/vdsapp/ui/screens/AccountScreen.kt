package com.example.vdsapp.ui.screens

import android.icu.text.IDNA.Info
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.vdsapp.network.models.responses.Account
import com.example.vdsapp.network.models.responses.UserInfo

@Composable
fun AccountScreen(
    account: Account,
    navController: NavHostController,
    exitAction: () -> Unit
) {
    account.info?.let { info ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(10.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 250.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Аккаунт",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.onTertiaryContainer
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    InfoRow(label = "Дата активации:", value = info.actdate)
                    InfoRow(label = "Страна:", value = info.country)
                    InfoRow(label = "Тип клиента (face_id):", value = info.faceId.toString())
                    InfoRow(
                        label = "Статус:",
                        value = if (info.state == "1") "Активен" else "Неактивен"
                    )
                    InfoRow(label = "Электронная почта:", value = info.email)
                    InfoRow(label = "Имя:", value = info.name)
                    InfoRow(label = "Отчество:", value = info.middlename)
                    InfoRow(label = "Фамилия:", value = info.surname)
                }
            }
            Button(
                onClick = {
                    exitAction()
                    navController.navigate("token_input")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(212, 0, 0, 255),
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 7.dp)
            ) {
                Text(text = "Выйти")
            }
        }
    }
}

@Composable
fun InfoRow(label: String, value: String?) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Text(
            text = label,
            modifier = Modifier.weight(1f),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = value ?: "Не указано",
            modifier = Modifier.weight(1f)
        )
    }
}