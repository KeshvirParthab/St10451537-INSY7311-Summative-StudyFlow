package com.example.studyflow

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Reusing your established premium high-fidelity colors
val PrimaryDarkColor = Color(0xFF1A2332)
val BackgroundCanvasGray = Color(0xFFF4F6F9)
val CardSurfaceWhite = Color(0xFFFFFFFF)
val AccentBlueColor = Color(0xFF3B5998)

@Preview(showBackground = true, widthDp = 360, heightDp = 740)
@Composable
fun StudyFlowScheduleHighFiPreview() {
    Scaffold(
        bottomBar = { HighFiBottomNavigationBar() }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundCanvasGray)
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            // Screen Header
            Text(
                text = "Schedule / Calendar",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = PrimaryDarkColor
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Monday Entry Card
            HighFiScheduleItem(
                dayLabel = "MON",
                eventTitle = "HCI Lecture",
                timeWindow = "09:00 - 11:00",
                iconGlyph = "📖"
            )

            Spacer(modifier = Modifier.height(14.dp)) // Strictly managed layout spacing

            // Tuesday Entry Card
            HighFiScheduleItem(
                dayLabel = "TUE",
                eventTitle = "Essay Draft",
                timeWindow = "Anytime",
                iconGlyph = "📝"
            )

            Spacer(modifier = Modifier.height(14.dp))

            // Wednesday Entry Card
            HighFiScheduleItem(
                dayLabel = "WED",
                eventTitle = "Group Meeting",
                timeWindow = "14:00 - 15:30",
                iconGlyph = "👥"
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Primary Navigation Add Event Button
            Button(
                onClick = { },
                modifier = Modifier.fillMaxWidth().height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = PrimaryDarkColor),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(text = "+ Add Event", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun HighFiScheduleItem(
    dayLabel: String,
    eventTitle: String,
    timeWindow: String,
    iconGlyph: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Timeline Day Marker column
        Text(
            text = dayLabel,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray,
            modifier = Modifier.width(45.dp)
        )

        // Event Detail Container Block
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = CardSurfaceWhite),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // High-fidelity asset background placeholder row
                Surface(
                    modifier = Modifier.size(40.dp),
                    shape = RoundedCornerShape(8.dp),
                    color = BackgroundCanvasGray
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text(text = iconGlyph, fontSize = 18.sp)
                    }
                }

                Spacer(modifier = Modifier.width(16.dp))

                Column {
                    Text(
                        text = eventTitle,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = PrimaryDarkColor
                    )
                    Text(
                        text = timeWindow,
                        fontSize = 13.sp,
                        color = Color.Gray
                    )
                }
            }
        }
    }
}