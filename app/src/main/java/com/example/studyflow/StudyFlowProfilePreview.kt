package com.example.studyflow

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
fun StudyFlowProfileView() {
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
                text = "Student Profile",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1A2332),
                modifier = Modifier.padding(top = 12.dp, bottom = 24.dp)
            )

            // Profile Info Header Card
            Card(
                modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                    Box(modifier = Modifier.size(54.dp).clip(CircleShape).background(Color(0xFF1A2332)), contentAlignment = Alignment.Center) {
                        Icon(painter = painterResource(id = android.R.drawable.ic_menu_myplaces), contentDescription = null, tint = Color.White, modifier = Modifier.size(28.dp))
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text(text = "Keshvir Parthab", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1A2332))
                        Text(text = "ST10451537", fontSize = 13.sp, color = Color(0xFF7F8C8D))
                    }
                }
            }

            Text(text = "System Preferences", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1A2332), modifier = Modifier.padding(bottom = 12.dp))

            // Settings Rows with fixed weight constraints to stop squashing
            ProfileSettingsItem(label = "Dynamic Accessibility Font Scaling", statusText = "SP Active", iconId = android.R.drawable.ic_menu_search)
            ProfileSettingsItem(label = "High Contrast Mode", statusText = "Enabled", iconId = android.R.drawable.ic_menu_manage)
            ProfileSettingsItem(label = "Colorblind Safe Palette (Coral Accents)", statusText = "Active", iconId = android.R.drawable.ic_menu_compass)
        }

        // Persistent Navigation Menu Bar
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
                modifier = Modifier.clip(RoundedCornerShape(8.dp)).background(Color(0xFF1A2332).copy(alpha = 0.1f)).padding(horizontal = 12.dp, vertical = 6.dp)
            ) {
                Icon(painter = painterResource(id = android.R.drawable.ic_menu_agenda), contentDescription = null, tint = Color(0xFF1A2332), modifier = Modifier.size(24.dp))
                Text(text = "Profile", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1A2332))
            }
        }
    }
}

@Composable
fun ProfileSettingsItem(label: String, statusText: String, iconId: Int) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Added layout weight here to distribute width cleanly and prevent layout squashing
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f).padding(end = 12.dp)
            ) {
                Icon(painter = painterResource(id = iconId), contentDescription = null, tint = Color(0xFF1A2332), modifier = Modifier.size(20.dp))
                Spacer(modifier = Modifier.width(12.dp))
                Text(text = label, fontSize = 14.sp, color = Color(0xFF1A2332), lineHeight = 18.sp)
            }
            Text(text = statusText, fontSize = 12.sp, color = Color(0xFF7F8C8D), fontWeight = FontWeight.Bold)
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun StudyFlowProfilePreview() {
    StudyFlowProfileView()
}