package com.example.proj_3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun DetailsScreen() {
    Proj_3Theme {
        Surface(modifier = Modifier.fillMaxSize(), color = Color.Black) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Details Screen",
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    ),
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                Text(
                    text = "This is the details screen.",
                    style = TextStyle(
                        fontSize = 18.sp,
                        color = Color.White
                    )
                )
            }
        }
    }
}


@Composable
fun MainScreen() {
    Proj_3Theme {
        Surface(modifier = Modifier.fillMaxSize(), color = Color.Black) {
            Column(modifier = Modifier.fillMaxSize()) {
                // Display the "northern" image
                Image(
                    painter = painterResource(id = R.drawable.scifi_wallpaper),
                    contentDescription = "The traveller leaving the planet through a portal that formed above the amazon forrest.",
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(16f / 9f)
                )

                // Overlay the pin and its text at the bottom left
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .align(Alignment.Start)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.wolf_render_robot_wallpaper),
                            contentDescription = "Pin",
                            modifier = Modifier.size(24.dp)
                        )

                        Text(
                            text = "Storm breach",
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            ),
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                }

                // Display the display picture and text with buttons
                Row(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 15.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    DisplayPictureWithText(
                        imageResId = R.drawable.mil_scorpion,
                        name = "Image viewport"
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    // Buttons (Download, Like, Bookmark)
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        IconButton(
                            onClick = { /* Handle download button click */ },
                            modifier = Modifier.size(24.dp),
                            content = {
                                Image(
                                    painter = painterResource(id = R.drawable.siege_glitch),
                                    contentDescription = "Download",
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
                                    painter = painterResource(id = R.drawable.satisfactory_wallpaper),
                                    contentDescription = "Like",
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        IconButton(
                            onClick = { /* Handle bookmark button click */ },
                            modifier = Modifier.size(24.dp),
                            content = {
                                Image(
                                    painter = painterResource(id = R.drawable.machinegun_fu),
                                    contentDescription = "Bookmark",
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                        )
                    }
                }
                Spacer(
                    modifier = Modifier
                        .height(1.dp)
                        .fillMaxWidth()
                        .background(Color.DarkGray)
                )
                // View with text in two columns
                Row(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
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
                            modifier = Modifier.padding(bottom = 10.dp)
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
                            modifier = Modifier.padding(bottom = 10.dp)
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
                            modifier = Modifier.padding(bottom = 10.dp)
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
                            text = "130m long",
                            style = TextStyle(
                                fontSize = 14.sp,
                                color = Color.White
                            ),
                            modifier = Modifier.padding(bottom = 10.dp)
                        )
                        Text(
                            text = "Event code name",
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            ),
                            modifier = Modifier.padding(bottom = 4.dp)
                        )
                        Text(
                            text = "The traveller",
                            style = TextStyle(
                                fontSize = 14.sp,
                                color = Color.White
                            ),
                            modifier = Modifier.padding(bottom = 10.dp)
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
                            text = "Keter",
                            style = TextStyle(
                                fontSize = 14.sp,
                                color = Color.White
                            ),
                            modifier = Modifier.padding(bottom = 10.dp)
                        )
                    }
                }

                // Dark gray line
                Spacer(
                    modifier = Modifier
                        .height(1.dp)
                        .fillMaxWidth()
                        .background(Color.DarkGray)
                )

                // Second row with three columns
                Row(
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 4.dp)
                ) {
                    // First Column
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Witnesses",
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            ),
                            modifier = Modifier.padding(bottom = 4.dp)
                        )
                        Text(
                            text = "130",
                            style = TextStyle(
                                fontSize = 14.sp,
                                color = Color.White
                            ),
                            modifier = Modifier.padding(bottom = 10.dp)
                        )
                    }

                    // Second Column
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Downloads",
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            ),
                            modifier = Modifier.padding(bottom = 4.dp)
                        )
                        Text(
                            text = "99.1K",
                            style = TextStyle(
                                fontSize = 14.sp,
                                color = Color.White
                            ),
                            modifier = Modifier.padding(bottom = 10.dp)
                        )
                    }

                    // Third Column
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Response",
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            ),
                            modifier = Modifier.padding(bottom = 4.dp)
                        )
                        Text(
                            text = "Shoot on site.",
                            style = TextStyle(
                                fontSize = 14.sp,
                                color = Color.White
                            ),
                            modifier = Modifier.padding(bottom = 10.dp)
                        )
                    }
                }
                // Dark gray line
                Spacer(
                    modifier = Modifier
                        .height(1.dp)
                        .fillMaxWidth()
                        .background(Color.DarkGray)
                )

                // Dark gray line
                Spacer(
                    modifier = Modifier
                        .height(1.dp)
                        .fillMaxWidth()
                        .background(Color.Red)
                )

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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MainScreen()
}
