package com.example.studyflow

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
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

val DarkNavyColor = Color(0xFF1A2332)
val BackgroundCanvasColor = Color(0xFFF4F6F9)
val ComponentWhiteColor = Color(0xFFFFFFFF)
val SecondaryMutedText = Color(0xFF7F8C8D)
val PrimaryProgressBlue = Color(0xFF2C3E50)
val UrgentCoralColor = Color(0xFFE76F51)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StudyFlowDashboardView() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundCanvasColor)
            .padding(16.dp)
    ) {
        // --- SCROLLABLE CONTENT REGION ---
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            // --- HEADER COMPONENT ---
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp, bottom = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "StudyFlow",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = DarkNavyColor,
                        letterSpacing = (-0.5).sp
                    )
                    Text(
                        text = "Hello, Student",
                        fontSize = 14.sp,
                        color = SecondaryMutedText,
                        modifier = Modifier.padding(top = 2.dp)
                    )
                }
                Box(
                    modifier = Modifier
                        .size(44.dp)
                        .clip(CircleShape)
                        .background(DarkNavyColor),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = android.R.drawable.ic_menu_myplaces),
                        contentDescription = "Profile View Anchor",
                        tint = ComponentWhiteColor,
                        modifier = Modifier.size(22.dp)
                    )
                }
            }

            // --- PROGRESS CARD ---
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 28.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = DarkNavyColor),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp)
                ) {
                    Text(
                        text = "YOUR ACADEMIC MOMENTUM",
                        fontSize = 12.sp,
                        color = SecondaryMutedText,
                        fontWeight = FontWeight.SemiBold,
                        letterSpacing = 1.sp
                    )
                    Text(
                        text = "Overall Completion: 65%",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = ComponentWhiteColor,
                        modifier = Modifier.padding(top = 6.dp, bottom = 14.dp)
                    )
                    LinearProgressIndicator(
                        progress = { 0.65f },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(8.dp)
                            .clip(RoundedCornerShape(4.dp)),
                        color = UrgentCoralColor,
                        trackColor = SecondaryMutedText.copy(alpha = 0.3f)
                    )
                }
            }

            Text(
                text = "Today's Focus Tasks",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = DarkNavyColor,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // --- TASK CARDS ---
            // Task 1: HCI Report
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
                    .combinedClickable(
                        onClick = { },
                        onLongClick = { }
                    ),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = ComponentWhiteColor),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Top
                    ) {
                        Text(
                            text = "HCI Report",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = DarkNavyColor
                        )
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(6.dp))
                                .background(UrgentCoralColor.copy(alpha = 0.15f))
                                .padding(horizontal = 8.dp, vertical = 4.dp)
                        ) {
                            Text(
                                text = "Due Friday (2 days left)",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = UrgentCoralColor
                            )
                        }
                    }
                    Text(
                        text = "Progress: 65%",
                        fontSize = 12.sp,
                        color = SecondaryMutedText,
                        modifier = Modifier.padding(top = 6.dp, bottom = 8.dp)
                    )
                    LinearProgressIndicator(
                        progress = { 0.65f },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(4.dp)
                            .clip(RoundedCornerShape(2.dp)),
                        color = PrimaryProgressBlue,
                        trackColor = BackgroundCanvasColor
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Visible UI Shortcut Signifier
                        Text(
                            text = "Hold for details",
                            fontSize = 11.sp,
                            color = SecondaryMutedText,
                            fontWeight = FontWeight.Medium
                        )
                        Button(
                            onClick = { },
                            colors = ButtonDefaults.buttonColors(containerColor = DarkNavyColor),
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Text(text = "Mark Complete", fontSize = 12.sp, color = ComponentWhiteColor, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }

            // Task 2: Database Exam
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
                    .combinedClickable(
                        onClick = { },
                        onLongClick = { }
                    ),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = ComponentWhiteColor),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Top
                    ) {
                        Text(
                            text = "Database Exam",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = DarkNavyColor
                        )
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(6.dp))
                                .background(BackgroundCanvasColor)
                                .padding(horizontal = 8.dp, vertical = 4.dp)
                        ) {
                            Text(
                                text = "Due Dec 10",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = SecondaryMutedText
                            )
                        }
                    }
                    Text(
                        text = "Progress: 30%",
                        fontSize = 12.sp,
                        color = SecondaryMutedText,
                        modifier = Modifier.padding(top = 6.dp, bottom = 8.dp)
                    )
                    LinearProgressIndicator(
                        progress = { 0.30f },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(4.dp)
                            .clip(RoundedCornerShape(2.dp)),
                        color = PrimaryProgressBlue,
                        trackColor = BackgroundCanvasColor
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Visible UI Shortcut Signifier
                        Text(
                            text = "Hold for details",
                            fontSize = 11.sp,
                            color = SecondaryMutedText,
                            fontWeight = FontWeight.Medium
                        )
                        Button(
                            onClick = { },
                            colors = ButtonDefaults.buttonColors(containerColor = DarkNavyColor),
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Text(text = "Mark Complete", fontSize = 12.sp, color = ComponentWhiteColor, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        }

        // --- PERSISTENT BOTTOM NAVIGATION BAR ---
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .background(ComponentWhiteColor)
                .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(DarkNavyColor.copy(alpha = 0.1f))
                    .padding(horizontal = 12.dp, vertical = 6.dp)
            ) {
                Icon(
                    painter = painterResource(id = android.R.drawable.ic_menu_manage),
                    contentDescription = "Home Anchor",
                    tint = DarkNavyColor,
                    modifier = Modifier.size(24.dp)
                )
                Text(text = "Home", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = DarkNavyColor)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    painter = painterResource(id = android.R.drawable.ic_menu_my_calendar),
                    contentDescription = "Schedule View",
                    tint = SecondaryMutedText,
                    modifier = Modifier.size(24.dp)
                )
                Text(text = "Schedule", fontSize = 11.sp, color = SecondaryMutedText)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    painter = painterResource(id = android.R.drawable.checkbox_on_background),
                    contentDescription = "Task Hub",
                    tint = SecondaryMutedText,
                    modifier = Modifier.size(24.dp)
                )
                Text(text = "Tasks", fontSize = 11.sp, color = SecondaryMutedText)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    painter = painterResource(id = android.R.drawable.ic_menu_agenda),
                    contentDescription = "User Settings",
                    tint = SecondaryMutedText,
                    modifier = Modifier.size(24.dp)
                )
                Text(text = "Profile", fontSize = 11.sp, color = SecondaryMutedText)
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun StudyFlowDashboardPreview() {
    StudyFlowDashboardView()
}
