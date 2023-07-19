package com.example.proj_3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.proj_3.ui.theme.Proj_3Theme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material3.IconButton
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Proj_3Theme {
                Surface(modifier = Modifier.fillMaxSize(), color = Color.Black) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        Image(
                            painter = painterResource(id = R.drawable.outpost),
                            contentDescription = "Your Image",
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(16f / 9f)
                        )

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(0.dp)
                                .align(Alignment.Start)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.mil_scorpion),
                                    contentDescription = "Pin",
                                    modifier = Modifier.size(24.dp)
                                )

                                Text(
                                    text = "Northern expansion efforts.",
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White
                                    ),
                                    modifier = Modifier.padding(start = 0.dp)
                                )
                            }
                        }

                        Row(
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 15.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            DisplayPictureWithText(
                                imageResId = R.drawable.machinegun_fu,
                                name = "Tommaso"
                            )

                            Spacer(modifier = Modifier.weight(1f))

                            Row(verticalAlignment = Alignment.CenterVertically) {
                                IconButton(
                                    onClick = {},
                                    modifier = Modifier.size(24.dp),
                                    content = {
                                        Image(
                                            painter = painterResource(id = R.drawable.scifi_wallpaper),
                                            contentDescription = "Future world",
                                            modifier = Modifier.size(24.dp)
                                        )
                                    }
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                IconButton(
                                    onClick = {},
                                    modifier = Modifier.size(24.dp),
                                    content = {
                                        Image(
                                            painter = painterResource(id = R.drawable.siege_glitch),
                                            contentDescription = "Like",
                                            modifier = Modifier.size(24.dp)
                                        )
                                    }
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                IconButton(
                                    onClick = {},
                                    modifier = Modifier.size(24.dp),
                                    content = {
                                        Image(
                                            painter = painterResource(id = R.drawable.wolf_render_robot_wallpaper),
                                            contentDescription = "Bookmark",
                                            modifier = Modifier.size(24.dp)
                                        )
                                    }
                                )
                            }
                        }

                        Row(
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = "Camera",
                                    style = TextStyle(
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White
                                    ),
                                    modifier = Modifier.padding(bottom = 4.dp)
                                )
                                Text(
                                    text = "GoPro",
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        color = Color.White
                                    ),
                                    modifier = Modifier.padding(bottom = 20.dp)
                                )
                                Text(
                                    text = "Focal Length",
                                    style = TextStyle(
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White
                                    ),
                                    modifier = Modifier.padding(bottom = 4.dp)
                                )
                                Text(
                                    text = "18.0mm",
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        color = Color.White
                                    ),
                                    modifier = Modifier.padding(bottom = 20.dp)
                                )
                                Text(
                                    text = "ISO",
                                    style = TextStyle(
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White
                                    ),
                                    modifier = Modifier.padding(bottom = 4.dp)
                                )
                                Text(
                                    text = "100",
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        color = Color.White
                                    ),
                                    modifier = Modifier.padding(bottom = 20.dp)
                                )
                            }
                            Spacer(modifier = Modifier.width(16.dp))
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = "Size",
                                    style = TextStyle(
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White
                                    ),
                                    modifier = Modifier.padding(bottom = 4.dp)
                                )
                                Text(
                                    text = "1.7 GB",
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        color = Color.White
                                    ),
                                    modifier = Modifier.padding(bottom = 20.dp)
                                )
                                Text(
                                    text = "Distance from main facility",
                                    style = TextStyle(
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White
                                    ),
                                    modifier = Modifier.padding(bottom = 4.dp)
                                )
                                Text(
                                    text = "18.7 Km",
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        color = Color.White
                                    ),
                                    modifier = Modifier.padding(bottom = 20.dp)
                                )
                                Text(
                                    text = "Threat level",
                                    style = TextStyle(
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White
                                    ),
                                    modifier = Modifier.padding(bottom = 4.dp)
                                )
                                Text(
                                    text = "Low",
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        color = Color.White
                                    ),
                                    modifier = Modifier.padding(bottom = 20.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}




@Composable
fun DisplayPictureWithText(imageResId: Int, name: String) {
    Row(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = "Display Picture",
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = name,
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        )
    }
}
