package com.example.pregnancyvitalstracker.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.MonitorHeart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pregnancyvitalstracker.model.Vitals
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun VitalsCard(vitals: Vitals) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = 6.dp,
        backgroundColor = Color(0xFFF3E5F5), // Light purple background
        shape = MaterialTheme.shapes.medium
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconText(icon = Icons.Filled.MonitorHeart, text = "${vitals.heartRate} bpm")
                IconText(icon = Icons.Filled.Favorite, text = "${vitals.bpSys}/${vitals.bpDia} mmHg")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconText(icon = Icons.Filled.FitnessCenter, text = "${vitals.weight} kg")
                IconText(icon = Icons.Filled.Favorite, text = "${vitals.kicks} kicks")
            }
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = SimpleDateFormat("EEE, dd MMM yyyy hh:mm a", Locale.getDefault()).format(vitals.timestamp),
                style = MaterialTheme.typography.body2.copy(fontWeight = FontWeight.Bold),
                color = Color(0xFF6A1B9A),
                modifier = Modifier.align(Alignment.End)
            )
        }
    }
}

@Composable
fun IconText(icon: androidx.compose.ui.graphics.vector.ImageVector, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF6A1B9A),
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = text,
            fontSize = 14.sp,
            color = Color.Black
        )
    }
}
