package com.example.vdsapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.vdsapp.R

@Composable
fun CenteredNavigationBar() {
    NavigationBar(
        modifier = Modifier
            .padding(10.dp)
            .clip(CircleShape)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.Default.Home,
                contentDescription = stringResource(id = R.string.home_button),
                modifier = Modifier
                    .padding(10.dp)
                    .clip(CircleShape)
                    .clickable { }
                    .padding(20.dp)
            )
            Icon(
                Icons.Default.AccountCircle,
                contentDescription = stringResource(id = R.string.account_button),
                modifier = Modifier
                    .padding(10.dp)
                    .clip(CircleShape)
                    .clickable { }
                    .padding(20.dp)
            )
        }
    }
}
