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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StudyFlowScheduleView() {
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
                text = "Schedule / Calendar",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1A2332),
                modifier = Modifier.padding(top = 12.dp, bottom = 24.dp)
            )

            // Timeline Matrix Rows
            ScheduleRowItem(day = "MON", title = "HCI Lecture", time = "09:00 - 11:00", iconId = android.R.drawable.ic_menu_agenda)
            ScheduleRowItem(day = "TUE", title = "Essay Draft", time = "Anytime", iconId = android.R.drawable.ic_menu_edit)
            ScheduleRowItem(day = "WED", title = "Group Meeting", time = "14:00 - 15:30", iconId = android.R.drawable.ic_menu_share)

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1A2332)),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(text = "+ Add Event", fontSize = 14.sp, color = Color.White, fontWeight = FontWeight.Bold)
            }
        }

        // Navigation Menu
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
                Icon(painter = painterResource(id = android.R.drawable.ic_menu_manage), contentDescription = "Home", tint = Color(0xFF7F8C8D), modifier = Modifier.size(24.dp))
                Text(text = "Home", fontSize = 11.sp, color = Color(0xFF7F8C8D))
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFF1A2332).copy(alpha = 0.1f))
                    .padding(horizontal = 12.dp, vertical = 6.dp)
            ) {
                Icon(painter = painterResource(id = android.R.drawable.ic_menu_my_calendar), contentDescription = "Schedule", tint = Color(0xFF1A2332), modifier = Modifier.size(24.dp))
                Text(text = "Schedule", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1A2332))
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(painter = painterResource(id = android.R.drawable.checkbox_on_background), contentDescription = "Tasks", tint = Color(0xFF7F8C8D), modifier = Modifier.size(24.dp))
                Text(text = "Tasks", fontSize = 11.sp, color = Color(0xFF7F8C8D))
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(painter = painterResource(id = android.R.drawable.ic_menu_agenda), contentDescription = "Profile", tint = Color(0xFF7F8C8D), modifier = Modifier.size(24.dp))
                Text(text = "Profile", fontSize = 11.sp, color = Color(0xFF7F8C8D))
            }
        }
    }
}

@Composable
fun ScheduleRowItem(day: String, title: String, time: String, iconId: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = day,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF7F8C8D),
            modifier = Modifier.width(48.dp)
        )
        Card(
            modifier = Modifier.weight(1f),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = iconId),
                    contentDescription = null,
                    tint = Color(0xFF1A2332),
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(text = title, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1A2332))
                    Text(text = time, fontSize = 12.sp, color = Color(0xFF7F8C8D))
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun StudyFlowSchedulePreview() {
    StudyFlowScheduleView()
}