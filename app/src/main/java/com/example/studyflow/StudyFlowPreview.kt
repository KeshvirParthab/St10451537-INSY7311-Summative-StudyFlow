package com.example.studyflow

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// High-Fidelity UI Color Palette
val PrimaryDark = Color(0xFF1A2332)     // Deep Navy Blue
val SecondaryBlue = Color(0xFF3B5998)   // Accent Blue
val AlertCoral = Color(0xFFE76F51)      // Warning Coral
val BackgroundGray = Color(0xFFF4F6F9)  // Soft Gray canvas base
val SurfaceWhite = Color(0xFFFFFFFF)    // Crisp White containers

@Preview(showBackground = true, widthDp = 360, heightDp = 740)
@Composable
fun StudyFlowDashboardHighFiPreview() {
    Scaffold(
        bottomBar = { HighFiBottomNavigationBar() }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundGray)
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            // Header Section
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "StudyFlow",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = PrimaryDark
                    )
                    Text(
                        text = "Hello, Student",
                        fontSize = 16.sp,
                        color = Color.Gray
                    )
                }
                Surface(
                    modifier = Modifier.size(48.dp),
                    shape = RoundedCornerShape(24.dp),
                    color = PrimaryDark
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text(text = "👤", fontSize = 20.sp)
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Overall Progress Summary Card
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = PrimaryDark)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Your Academic Momentum", color = Color.White.copy(alpha = 0.8f), fontSize = 14.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Overall Completion: 65%", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(12.dp))
                    LinearProgressIndicator(
                        progress = { 0.65f },
                        modifier = Modifier.fillMaxWidth().height(8.dp),
                        color = AlertCoral,
                        trackColor = Color.White.copy(alpha = 0.2f),
                        strokeCap = StrokeCap.Round
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Today's Focus Tasks",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = PrimaryDark
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Task 1 Card
            HighFiTaskCard(
                taskTitle = "HCI Report",
                deadlineText = "Due Friday (2 days left)",
                completionProgress = 0.65f,
                progressPercentage = "65%",
                isUrgent = true
            )

            Spacer(modifier = Modifier.height(14.dp))

            // Task 2 Card
            HighFiTaskCard(
                taskTitle = "Database Exam",
                deadlineText = "Due Dec 10",
                completionProgress = 0.30f,
                progressPercentage = "30%",
                isUrgent = false
            )
        }
    }
}

@Composable
fun HighFiTaskCard(
    taskTitle: String,
    deadlineText: String,
    completionProgress: Float,
    progressPercentage: String,
    isUrgent: Boolean
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = SurfaceWhite),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = taskTitle,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = PrimaryDark
                )
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = if (isUrgent) AlertCoral.copy(alpha = 0.15f) else Color.Gray.copy(alpha = 0.1f)
                ) {
                    Text(
                        text = deadlineText,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = if (isUrgent) AlertCoral else PrimaryDark
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(text = "Progress: $progressPercentage", fontSize = 13.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(6.dp))

            LinearProgressIndicator(
                progress = { completionProgress },
                modifier = Modifier.fillMaxWidth().height(6.dp),
                color = SecondaryBlue,
                trackColor = BackgroundGray,
                strokeCap = StrokeCap.Round
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { },
                modifier = Modifier.align(Alignment.End),
                colors = ButtonDefaults.buttonColors(containerColor = PrimaryDark),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Text(text = "Mark Complete", fontSize = 14.sp, fontWeight = FontWeight.Medium)
            }
        }
    }
}

@Composable
fun HighFiBottomNavigationBar() {
    NavigationBar(
        containerColor = SurfaceWhite,
        tonalElevation = 8.dp
    ) {
        NavigationBarItem(
            icon = { Text("🏠", fontSize = 22.sp) },
            label = { Text("Home") },
            selected = true,
            onClick = {},
            colors = NavigationBarItemDefaults.colors(selectedTextColor = PrimaryDark)
        )
        NavigationBarItem(
            icon = { Text("📅", fontSize = 22.sp) },
            label = { Text("Schedule") },
            selected = false,
            onClick = {}
        )
        NavigationBarItem(
            icon = { Text("✅", fontSize = 22.sp) },
            label = { Text("Tasks") },
            selected = false,
            onClick = {}
        )
        NavigationBarItem(
            icon = { Text("👤", fontSize = 22.sp) },
            label = { Text("Profile") },
            selected = false,
            onClick = {}
        )
    }
}