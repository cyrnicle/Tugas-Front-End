package com.example.bookpedia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


@Composable
fun Description3Screen(navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(105.dp)
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
//                                .align(Alignment.TopStart) //TopStart Aligning the button to the top-left corner
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Back",
                                modifier = Modifier.size(30.dp)
                            )
                        }
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
                        text = "Nemesis",
                        color = Color(0xff18191f),
                        textAlign = TextAlign.Center,
                        lineHeight = 1.11.em,
                        style = MaterialTheme.typography.displaySmall,
                        modifier = Modifier
                            .requiredWidth(width = 327.dp)
                    )
                    Text(
                        text = "In utter disbelief Miss Marple read the letter addressed to her from the recently deceased Mr Rafiel – an acquaintance she had met briefly on her travels. Recognising in Miss Marple a natural flair...",
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
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .clip(shape = RoundedCornerShape(16.dp))
                .background(color = Color(0xfff95a2c))
                .padding(all = 16.dp)


        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(6.dp, Alignment.Start),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Continue Reading",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    lineHeight = 1.33.em,
                    style = TextStyle(
                        fontSize = 21.sp,
                        fontWeight = FontWeight.Bold
                    )
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
//                                            .clickable {
//                                                navController.navigate("homepage")
//                                            }

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
//                                            .clickable {
//                                                navController.navigate("favoritebooks")
//                                            }

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
//                                            .clickable {
//                                                navController.navigate("profile")
//                                            }

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
//                                            .clickable {
//                                                navController.navigate("library")
//                                            }

                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Description3ScreenPreview() {
    val navController = rememberNavController()
    Description3Screen(navController)
}


