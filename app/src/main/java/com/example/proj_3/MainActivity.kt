package com.example.proj_3


import MainViewModelFactory
import retrofit2.Response
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.proj_3.ui.theme.Proj_3Theme
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import coil.compose.rememberImagePainter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainActivity : ComponentActivity() {
    private lateinit var viewModel: mainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Create the MainViewModelFactory and pass it to the ViewModelProvider
        val apiService = RetrofitClient.create() // Initialize the apiService using Retrofit

        val viewModelFactory = MainViewModelFactory(apiService, this)
        viewModel = ViewModelProvider(this, viewModelFactory).get(mainViewModel::class.java)

        // 2. Set the content view using Compose
        setContent {
            MainScreen(viewModel)
        }

        // Call the function to fetch the random photo details from the API
        viewModel.getRandomPhoto()
    }
}


@Composable
fun MainScreen(viewModel: mainViewModel) {
    val photoDetails by rememberUpdatedState(viewModel.photoDetails.value)

    Proj_3Theme {
        Surface(modifier = Modifier.fillMaxSize(), color = Color.Black) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                photoDetails?.let { photo ->
                    ImageWithOverlayText(
                        painter = rememberImagePainter(photo.urls.regular),
                        contentDescription = photo.description ?: "The traveller leaving the planet through a portal that formed above the amazon forest",
                        overlayText = photo.description ?: "The travellers ship",
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(16f / 9f)
                    )
                }
            }

            Row(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 15.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                DisplayPictureWithText(
                    imageResId = R.drawable.mil_scorpion,
                    name = "Image viewport"
                )

                Spacer(modifier = Modifier.weight(1f))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(
                        onClick = {},
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

            Row(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Camera",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        ),
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Text(
                        text = "Sony a7 IV",
                        style = TextStyle(
                            fontSize = 12.sp,
                            color = Color.White
                        ),
                        modifier = Modifier.padding(bottom = 10.dp)
                    )
                    Text(
                        text = "Focal Length",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        ),
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Text(
                        text = "18.0mm",
                        style = TextStyle(
                            fontSize = 12.sp,
                            color = Color.White
                        ),
                        modifier = Modifier.padding(bottom = 10.dp)
                    )
                    Text(
                        text = "ISO",
                        style = TextStyle(
                            fontSize = 12.sp,
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
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        ),
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Text(
                        text = "130m long, 45 meters wide",
                        style = TextStyle(
                            fontSize = 12.sp,
                            color = Color.White
                        ),
                        modifier = Modifier.padding(bottom = 10.dp)
                    )
                    Text(
                        text = "Event code name",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        ),
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Text(
                        text = "The traveller",
                        style = TextStyle(
                            fontSize = 12.sp,
                            color = Color.White
                        ),
                        modifier = Modifier.padding(bottom = 10.dp)
                    )
                    Text(
                        text = "Threat level",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        ),
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Text(
                        text = "Keter",
                        style = TextStyle(
                            fontSize = 12.sp,
                            color = Color.White
                        ),
                        modifier = Modifier.padding(bottom = 10.dp)
                    )

                }
            }

            Spacer(
                modifier = Modifier
                    .height(1.dp)
                    .fillMaxWidth()
                    .background(Color.DarkGray)
            )
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 4.dp)
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Witnesses",
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        ),
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Text(
                        text = "163 minimum",
                        style = TextStyle(
                            fontSize = 12.sp,
                            color = Color.White
                        ),
                        modifier = Modifier.padding(bottom = 10.dp)
                    )
                }
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Teams assigned",
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        ),
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Text(
                        text = "6",
                        style = TextStyle(
                            fontSize = 12.sp,
                            color = Color.White
                        ),
                        modifier = Modifier.padding(bottom = 10.dp)
                    )
                }
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Response",
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        ),
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Text(
                        text = "Shoot on site.",
                        style = TextStyle(
                            fontSize = 12.sp,
                            color = Color.White
                        ),
                        modifier = Modifier.padding(bottom = 10.dp)
                    )
                }
            }
            // Bubble Text Component at the bottom
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                BubbleTextComponent(text = "keter")
            }
        }
    }
}


@Composable
fun ImageWithOverlayText(
    painter: Painter,
    contentDescription: String,
    overlayText: String,
    modifier: Modifier = Modifier,
    overlayTextColor: Color = Color.White,
    overlayTextBackground: Color = Color(0xAA000000)
) {
    Surface {
        Image(
            painter = painter,
            contentDescription = contentDescription,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .padding(16.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "image",
                    modifier = Modifier.size(50.dp)
                )

                Text(
                    text = overlayText,
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = overlayTextColor
                    ),
                    modifier = Modifier.padding(8.dp)
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
                .fillMaxSize(),
            contentScale = ContentScale.Crop
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

@Composable
fun BubbleTextComponent(text: String) {

    Column(
        modifier = Modifier.padding(16.dp)

    ) {
        Button(
            onClick = {},
            shape = RoundedCornerShape(20.dp)
        ) {
            Text(text = text)
        }
    }
}

