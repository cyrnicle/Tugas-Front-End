package com.example.bookpedia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


@Composable
fun ProfileScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(156.dp)
                    .background(
                        Color.White,
                        RoundedCornerShape(bottomEnd = 8.dp, bottomStart = 8.dp)
                    ),
                contentAlignment = Alignment.CenterStart
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(end = 20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(
                            onClick = {
                                navController.popBackStack()
                            },
                            modifier = Modifier
                                .padding(16.dp)
//                                .align(Alignment.TopStart) // Aligning the button to the top-left corner
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Back",
                                modifier = Modifier.size(30.dp)
                            )
                        }

                        Text(
                            text = "Profile",
                            color = Color.Black,
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 30.sp,
                            style = MaterialTheme.typography.headlineLarge,
                            textAlign = TextAlign.Center,
                        )
                        Row {
                            Icon(
                                painter = painterResource(id = R.drawable.bell),
                                contentDescription = "Notification",
                                modifier = Modifier
                                    .size(24.dp)
                                    .offset(x = 15.dp)
                            )
                            Box(
                                modifier = Modifier
                                    .size(24.dp)
                                    .requiredSize(14.dp)
                                    .clip(CircleShape)
                                    .background(Color(0xfff95a2c))
                                    .border(
                                        BorderStroke(2.dp, Color.White),
                                        shape = CircleShape
                                    )
                            )
                        }
                    }
                }
            }
            Box(
                modifier = Modifier
                    .requiredWidth(width = 400.dp)
                    .requiredHeight(height = 150.dp)
                    .clip(shape = RoundedCornerShape(bottomStart = 50.dp, bottomEnd = 80.dp))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.cacacac),
                    contentDescription = "openpeeps / avatar-4",
                    modifier = Modifier
                        .requiredSize(size = 150.dp)
                        .align(Alignment.Center)
                        .clip(shape = RoundedCornerShape(170.dp))
                        .border(
                            border = BorderStroke(3.dp, Color.Black),
                            shape = RoundedCornerShape(166.dp)

                        )
                )
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Top),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .background(color = Color.White)
                    .padding(
                        horizontal = 50.dp,
                        vertical = 32.dp
                    )
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(19.dp, Alignment.Top),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Istiarsa Pawestri",
                        color = Color(0xff18191f),
                        textAlign = TextAlign.Center,
                        lineHeight = 1.11.em,
                        style = MaterialTheme.typography.displaySmall,
                        modifier = Modifier
                            .requiredWidth(width = 327.dp)
                    )
                    Text(
                        text = "@istiarsapaw@gmail.com",
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        lineHeight = 1.12.em,
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Medium
                        ),
                        modifier = Modifier
                            .requiredWidth(width = 300.dp)
                    )
                    Text(
                        text = "A bibliophile and undergraduate English Literature student at Indonesia Open University. I developed a love for literature at a young age and have since loved reading books. \n" +
                                "\"To learn a new language is to have one more window from which to look at the world\"",
                        color = Color(0xff474a57),
                        textAlign = TextAlign.Justify,
                        lineHeight = 1.33.em,
                        style = TextStyle(
                            fontSize = 21.sp,
                            fontWeight = FontWeight.Medium
                        ),
                        modifier = Modifier
                            .requiredWidth(width = 327.dp)
                    )
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(85.dp)
                    .shadow(
                        elevation = 4.dp,
                        shape = RoundedCornerShape(8.dp),
                        clip = false
                    )
                    .background(
                        color = Color(0xFFFFFFFF),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .align(Alignment.CenterHorizontally),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 35.dp, end = 35.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.home),
                            contentDescription = "Homepage",
                            modifier = Modifier
                                .size(70.dp)
                                .clickable {
                                    navController.navigate("homepage")
                                }
                        )
                    }

                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.bookmark),
                            contentDescription = "Library",
                            modifier = Modifier
                                .size(30.dp)
//                            .clickable {
//                                navController.navigate("favoritebooks")
//                            }
                        )
                    }
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.heartfill),
                            contentDescription = "Favorite",
                            modifier = Modifier
                                .size(30.dp)
                                .clickable {
                                    navController.navigate("favoritebooks")
                                }
                        )
                    }
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.user),
                            contentDescription = "Profile",
                            modifier = Modifier
                                .size(30.dp)
                                .clickable {
                                    navController.navigate("profile")
                                }
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileBooksScreenPreview() {
    val navController = rememberNavController()
    ProfileScreen(navController)
}



