package com.example.studyflow

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
fun StudyFlowCreateTaskView() {
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
                text = "Create New Task",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1A2332),
                modifier = Modifier.padding(top = 12.dp, bottom = 24.dp)
            )

            // Input Form Fields
            Text(text = "Task Title", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1A2332), modifier = Modifier.padding(bottom = 8.dp))
            OutlinedTextField(
                value = "HCI Summative Report",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp),
                shape = RoundedCornerShape(8.dp),
                colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = Color(0xFF1A2332))
            )

            Text(text = "Due Date", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1A2332), modifier = Modifier.padding(bottom = 8.dp))
            OutlinedTextField(
                value = "27 May 2026",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp),
                shape = RoundedCornerShape(8.dp),
                leadingIcon = { Icon(painter = painterResource(id = android.R.drawable.ic_menu_my_calendar), contentDescription = null) },
                colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = Color(0xFF1A2332))
            )

            Text(text = "Module Code", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1A2332), modifier = Modifier.padding(bottom = 8.dp))
            OutlinedTextField(
                value = "INSY7311",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth().padding(bottom = 28.dp),
                shape = RoundedCornerShape(8.dp),
                colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = Color(0xFF1A2332))
            )

            // Form Action Buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                OutlinedButton(
                    onClick = { },
                    modifier = Modifier.weight(1f).height(48.dp),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = "Cancel", color = Color(0xFF7F8C8D))
                }
                Button(
                    onClick = { },
                    modifier = Modifier.weight(1f).height(48.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1A2332)),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = "Save Task", color = Color.White, fontWeight = FontWeight.Bold)
                }
            }
        }

        // Bottom Navigation Bar
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
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(painter = painterResource(id = android.R.drawable.ic_menu_my_calendar), contentDescription = null, tint = Color(0xFF7F8C8D), modifier = Modifier.size(24.dp))
                Text(text = "Schedule", fontSize = 11.sp, color = Color(0xFF7F8C8D))
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.clip(RoundedCornerShape(8.dp)).background(Color(0xFF1A2332).copy(alpha = 0.1f)).padding(horizontal = 12.dp, vertical = 6.dp)
            ) {
                Icon(painter = painterResource(id = android.R.drawable.checkbox_on_background), contentDescription = null, tint = Color(0xFF1A2332), modifier = Modifier.size(24.dp))
                Text(text = "Tasks", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1A2332))
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(painter = painterResource(id = android.R.drawable.ic_menu_agenda), contentDescription = null, tint = Color(0xFF7F8C8D), modifier = Modifier.size(24.dp))
                Text(text = "Profile", fontSize = 11.sp, color = Color(0xFF7F8C8D))
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun StudyFlowCreateTaskPreview() {
    StudyFlowCreateTaskView()
}