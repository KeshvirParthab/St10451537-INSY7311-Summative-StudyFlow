package com.example.studyflow

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StudyFlowCalendarMonthView() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF4F6F9))
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            Text(
                text = "May 2026",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1A2332),
                modifier = Modifier.padding(top = 12.dp, bottom = 20.dp)
            )

            // Calendar Month Grid Headers
            Row(modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                val days = listOf("S", "M", "T", "W", "T", "F", "S")
                days.forEach { day ->
                    Text(text = day, modifier = Modifier.weight(1f), textAlign = TextAlign.Center, fontWeight = FontWeight.Bold, color = Color(0xFF7F8C8D), fontSize = 12.sp)
                }
            }

            // Simple Calendar Grid Week Rows
            CalendarWeekRow(days = listOf("", "", "", "", "", "1", "2"))
            CalendarWeekRow(days = listOf("3", "4", "5", "6", "7", "8", "9"))
            CalendarWeekRow(days = listOf("10", "11", "12", "13", "14", "15", "16"))
            CalendarWeekRow(days = listOf("17", "18", "19", "20", "21", "22", "23"))
            CalendarWeekRow(days = listOf("24", "25", "26", "27", "28", "29", "30"))

            Spacer(modifier = Modifier.height(20.dp))

            // Deadline Indicator Card beneath the grid
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFE76F51).copy(alpha = 0.15f))
            ) {
                Row(modifier = Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
                    Icon(painter = painterResource(id = android.R.drawable.ic_dialog_alert), contentDescription = null, tint = Color(0xFFE76F51))
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(text = "May 27: INSY7311 Summative Due", color = Color(0xFF1A2332), fontWeight = FontWeight.Bold, fontSize = 13.sp)
                }
            }
        }

        // Standard Persistent Navigation Menu Bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .background(Color.White)
                .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(painter = painterResource(id = android.R.drawable.ic_menu_manage), contentDescription = null, tint = Color(0xFF7F8C8D), modifier = Modifier.size(24.dp))
                Text(text = "Home", fontSize = 11.sp, color = Color(0xFF7F8C8D))
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.clip(RoundedCornerShape(8.dp)).background(Color(0xFF1A2332).copy(alpha = 0.1f)).padding(horizontal = 12.dp, vertical = 6.dp)
            ) {
                Icon(painter = painterResource(id = android.R.drawable.ic_menu_my_calendar), contentDescription = null, tint = Color(0xFF1A2332), modifier = Modifier.size(24.dp))
                Text(text = "Schedule", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1A2332))
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(painter = painterResource(id = android.R.drawable.checkbox_on_background), contentDescription = null, tint = Color(0xFF7F8C8D), modifier = Modifier.size(24.dp))
                Text(text = "Tasks", fontSize = 11.sp, color = Color(0xFF7F8C8D))
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(painter = painterResource(id = android.R.drawable.ic_menu_agenda), contentDescription = null, tint = Color(0xFF7F8C8D), modifier = Modifier.size(24.dp))
                Text(text = "Profile", fontSize = 11.sp, color = Color(0xFF7F8C8D))
            }
        }
    }
}

@Composable
fun CalendarWeekRow(days: List<String>) {
    Row(modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp)) {
        days.forEach { day ->
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(36.dp)
                    .background(if (day == "27") Color(0xFFE76F51) else Color.Transparent, shape = RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = day,
                    fontSize = 14.sp,
                    fontWeight = if (day == "27") FontWeight.Bold else FontWeight.Normal,
                    color = if (day == "27") Color.White else Color(0xFF1A2332)
                )
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun StudyFlowCalendarMonthPreview() {
    StudyFlowCalendarMonthView()
}