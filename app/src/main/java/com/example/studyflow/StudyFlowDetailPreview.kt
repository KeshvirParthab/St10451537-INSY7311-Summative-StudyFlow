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
fun StudyFlowDetailView() {
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
            // --- HEADER WITH WORKING NATIVE BACK ARROW ---
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp, bottom = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = android.R.drawable.ic_menu_revert),
                    contentDescription = "Back Navigation Anchor",
                    tint = Color(0xFF1A2332),
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = "Task Overview", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1A2332))
            }

            // --- MASTER DETAILED DEEP DIVE TASK CARD ---
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Text(text = "INSY7311 Module", fontSize = 12.sp, color = Color(0xFF7F8C8D), fontWeight = FontWeight.Bold)
                    Text(text = "HCI Summative Project Report", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1A2332), modifier = Modifier.padding(top = 4.dp, bottom = 12.dp))
                    Text(text = "Submissions checklist requirements require 3 separate PDF uploads including automated references tables.", fontSize = 14.sp, color = Color(0xFF2C3E50), lineHeight = 20.sp)
                }
            }

            Text(text = "Sub-Tasks Progression", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1A2332), modifier = Modifier.padding(bottom = 12.dp))

            // --- PROGRESS CHECKLIST MATRIX SHOWING PROXIMITY ---
            SubTaskRowItem(taskLabel = "Compile reference resources documents", isDone = true)
            SubTaskRowItem(taskLabel = "Incorporate low fidelity wireframe graphics", isDone = true)
            SubTaskRowItem(taskLabel = "Complete high-fidelity declaratives code blocks", isDone = false)
        }

        // --- PERSISTENT BOTTOM NAVIGATION BAR ---
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
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(painter = painterResource(id = android.R.drawable.checkbox_on_background), contentDescription = null, tint = Color(0xFF7F8C8D), modifier = Modifier.size(24.dp))
                Text(text = "Tasks", fontSize = 11.sp, color = Color(0xFF7F8C8D))
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFF1A2332).copy(alpha = 0.1f))
                    .padding(horizontal = 12.dp, vertical = 6.dp)
            ) {
                Icon(painter = painterResource(id = android.R.drawable.ic_menu_agenda), contentDescription = null, tint = Color(0xFF1A2332), modifier = Modifier.size(24.dp))
                Text(text = "Profile", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1A2332))
            }
        }
    }
}

@Composable
fun SubTaskRowItem(taskLabel: String, isDone: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(checked = isDone, onCheckedChange = {})
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = taskLabel,
            fontSize = 14.sp,
            color = if (isDone) Color(0xFF7F8C8D) else Color(0xFF1A2332)
        )
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun StudyFlowDetailPreview() {
    StudyFlowDetailView()
}