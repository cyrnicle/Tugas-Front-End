package com.example.bookpedia

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
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
import androidx.navigation.compose.rememberNavController

@Composable
fun FavoriteBooksScreen(navController: NavController) {
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
//                                .align(Alignment.TopStart) //TopStart Aligning the button to the top-left corner
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Back",
                                modifier = Modifier.size(30.dp)
                            )
                        }

                        Text(
                            text = "Favorite",
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
                    Box(
                        modifier = Modifier
                            .requiredWidth(347.dp)
                            .requiredHeight(56.dp)
                            .padding(top = 16.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(Color.White)
                            .border(
                                BorderStroke(2.dp, Color(0xff18191f)),
                                shape = RoundedCornerShape(16.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(
                            Modifier.fillMaxWidth()
                                .padding(start = 15.dp, end = 20.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Search title here ...",
                                color = Color(0xff18191f),
                                lineHeight = 1.33.em,
                                style = TextStyle(
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Light
                                )
                            )
                            Icon(
                                painter = painterResource(id = R.drawable.search),
                                contentDescription = "Search",
                                modifier = Modifier
                                    .size(24.dp)
                            )
                        }
                    }
                }
            }
            LazyVerticalGrid(
                contentPadding = PaddingValues(0.dp),
                verticalArrangement = Arrangement.spacedBy(40.dp),
                horizontalArrangement = Arrangement.spacedBy(50.dp),
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxSize()
            ) {
                item {
                    Row(
                        Modifier.fillMaxWidth()
                            .height(170.dp)
                            .padding(start = 30.dp, end = 10.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(color = Color(0xff9ab89a))
                            .border(
                                border = BorderStroke(2.dp, Color(0xff18191f)),
                                shape = RoundedCornerShape(16.dp)
                            )
                            .clickable {
                                navController.navigate("list3")
                            },
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.nemesis),
                            contentDescription = "Book Cover",
                            modifier = Modifier
                                .padding(start = 1.dp)
                                .size(140.dp)
                                .border(border = BorderStroke(10.dp, Color.White))
                        )
                        Column(
                            Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "Agatha Christie",
                                color = Color(0xff474a57),
                                lineHeight = 1.45.em,
                                style = TextStyle(
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                ),
                                modifier = Modifier
                                    .padding(bottom = 5.dp)
                            )
                            Text(
                                text = "Nemesis",
                                color = Color(0xff18191f),
                                style = TextStyle(
                                    fontSize = 60.sp,
                                    fontWeight = FontWeight.Bold
                                ),
                                modifier = Modifier.size(90.dp)
                                    .padding(bottom = 1.dp)
                            )
                            Row(
                                modifier = Modifier
                                    .padding(bottom = 2.dp),
                                horizontalArrangement = Arrangement.spacedBy(9.dp, Alignment.Start),
                                verticalAlignment = Alignment.CenterVertically
                            ) {


                            }
                        }
                    }
                }
                item {
                    Row(
                        Modifier.fillMaxWidth()
                            .height(170.dp)
                            .padding(start = 30.dp, end = 10.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(color = Color(0xffe7c3a8))
                            .border(
                                border = BorderStroke(2.dp, Color(0xff18191f)),
                                shape = RoundedCornerShape(16.dp)
                            ),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.thesun),
                            contentDescription = "Book Cover",
                            modifier = Modifier
                                .padding(start = 1.dp)
                                .size(140.dp)
                                .border(border = BorderStroke(10.dp, Color.White))
                        )
                        Column(
                            Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "Rupi Kaur",
                                color = Color(0xff474a57),
                                lineHeight = 1.45.em,
                                style = TextStyle(
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                ),
                                modifier = Modifier
                                    .padding(bottom = 5.dp)
                            )
                            Text(
                                text = "The Sun  \n" +
                                        "and Her  \n" +
                                        "Flowers",
                                color = Color(0xff18191f),
                                style = TextStyle(
                                    fontSize = 60.sp,
                                    fontWeight = FontWeight.Bold
                                ),
                                modifier = Modifier.size(90.dp)
                                    .padding(bottom = 1.dp)
                            )
                            Row(
                                modifier = Modifier
                                    .padding(bottom = 2.dp),
                                horizontalArrangement = Arrangement.spacedBy(9.dp, Alignment.Start),
                                verticalAlignment = Alignment.CenterVertically
                            ) {


                            }
                        }
                    }
                }
                item {
                    Row(
                        Modifier.fillMaxWidth()
                            .height(170.dp)
                            .padding(start = 30.dp, end = 10.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(color = Color(0xffe984a2))
                            .border(
                                border = BorderStroke(2.dp, Color(0xff18191f)),
                                shape = RoundedCornerShape(16.dp)
                            ),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.hollyjackson),
                            contentDescription = "Book Cover",
                            modifier = Modifier
                                .padding(start = 1.dp)
                                .size(140.dp)
                                .border(border = BorderStroke(10.dp, Color.White))
                        )
                        Column(
                            Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "Holly Jackson",
                                color = Color(0xff474a57),
                                lineHeight = 1.45.em,
                                style = TextStyle(
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                ),
                                modifier = Modifier
                                    .padding(bottom = 5.dp)
                            )
                            Text(
                                text = "A Good \n" +
                                        "Girl's Guide \n" +
                                        "to Murder",
                                color = Color(0xff18191f),
                                style = TextStyle(
                                    fontSize = 60.sp,
                                    fontWeight = FontWeight.Bold
                                ),
                                modifier = Modifier.size(90.dp)
                                    .padding(bottom = 1.dp)
                            )
                            Row(
                                modifier = Modifier
                                    .padding(bottom = 2.dp),
                                horizontalArrangement = Arrangement.spacedBy(9.dp, Alignment.Start),
                                verticalAlignment = Alignment.CenterVertically
                            ) {


                            }
                        }
                    }
                }
                item {
                    Row(
                        Modifier.fillMaxWidth()
                            .height(170.dp)
                            .padding(start = 30.dp, end = 10.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(color = Color(0xff7bc5c1))
                            .border(
                                border = BorderStroke(2.dp, Color(0xff18191f)),
                                shape = RoundedCornerShape(16.dp)
                            ),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ariel),
                            contentDescription = "Book Cover",
                            modifier = Modifier
                                .padding(start = 1.dp)
                                .size(140.dp)
                                .border(border = BorderStroke(10.dp, Color.White))
                        )
                        Column(
                            Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "Sylvia Plath",
                                color = Color(0xff474a57),
                                lineHeight = 1.45.em,
                                style = TextStyle(
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                ),
                                modifier = Modifier
                                    .padding(bottom = 5.dp)
                            )
                            Text(
                                text = "Ariel",
                                color = Color(0xff18191f),
                                style = TextStyle(
                                    fontSize = 60.sp,
                                    fontWeight = FontWeight.Bold
                                ),
                                modifier = Modifier.size(90.dp)
                                    .padding(bottom = 1.dp)
                            )
                            Row(
                                modifier = Modifier
                                    .padding(bottom = 2.dp),
                                horizontalArrangement = Arrangement.spacedBy(9.dp, Alignment.Start),
                                verticalAlignment = Alignment.CenterVertically
                            ) {


                            }
                        }
                    }
                }
                item {
                    Row(
                        Modifier.fillMaxWidth()
                            .height(170.dp)
                            .padding(start = 30.dp, end = 10.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(color = Color(0xfffcaa82))
                            .border(
                                border = BorderStroke(2.dp, Color(0xff18191f)),
                                shape = RoundedCornerShape(16.dp)
                            ),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.alinetokill),
                            contentDescription = "Book Cover",
                            modifier = Modifier
                                .padding(start = 1.dp)
                                .size(140.dp)
                                .border(border = BorderStroke(10.dp, Color.White))
                        )
                        Column(
                            Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "Anthony Horowitz",
                                color = Color(0xff474a57),
                                lineHeight = 1.45.em,
                                style = TextStyle(
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                ),
                                modifier = Modifier
                                    .padding(bottom = 5.dp)
                            )
                            Text(
                                text = "A Line \n" +
                                        "to Kill",
                                color = Color(0xff18191f),
                                style = TextStyle(
                                    fontSize = 60.sp,
                                    fontWeight = FontWeight.Bold
                                ),
                                modifier = Modifier.size(90.dp)
                                    .padding(bottom = 1.dp)
                            )
                            Row(
                                modifier = Modifier
                                    .padding(bottom = 2.dp),
                                horizontalArrangement = Arrangement.spacedBy(9.dp, Alignment.Start),
                                verticalAlignment = Alignment.CenterVertically
                            ) {


                            }
                        }
                    }
                }
                item {
                    Row(
                        Modifier.fillMaxWidth()
                            .height(170.dp)
                            .padding(start = 30.dp, end = 10.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(color = Color(0xffc3c3d5))
                            .border(
                                border = BorderStroke(2.dp, Color(0xff18191f)),
                                shape = RoundedCornerShape(16.dp)
                            ),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.thebelljar),
                            contentDescription = "Book Cover",
                            modifier = Modifier
                                .padding(start = 1.dp)
                                .size(140.dp)
                                .border(border = BorderStroke(10.dp, Color.White))
                        )
                        Column(
                            Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "Sylvia Plath",
                                color = Color(0xff474a57),
                                lineHeight = 1.45.em,
                                style = TextStyle(
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                ),
                                modifier = Modifier
                                    .padding(bottom = 5.dp)
                            )
                            Text(
                                text = "The \n" +
                                        "Bell Jar",
                                color = Color(0xff18191f),
                                style = TextStyle(
                                    fontSize = 60.sp,
                                    fontWeight = FontWeight.Bold
                                ),
                                modifier = Modifier.size(90.dp)
                                    .padding(bottom = 1.dp)
                            )
                            Row(
                                modifier = Modifier
                                    .padding(bottom = 2.dp),
                                horizontalArrangement = Arrangement.spacedBy(9.dp, Alignment.Start),
                                verticalAlignment = Alignment.CenterVertically
                            ) {


                            }
                        }
                    }
                }
                item {
                    Row(
                        Modifier.fillMaxWidth()
                            .height(170.dp)
                            .padding(start = 30.dp, end = 10.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(color = Color(0xffffcdd2))
                            .border(
                                border = BorderStroke(2.dp, Color(0xff18191f)),
                                shape = RoundedCornerShape(16.dp)
                            ),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.milknhoney),
                            contentDescription = "Book Cover",
                            modifier = Modifier
                                .padding(start = 1.dp)
                                .size(140.dp)
                                .border(border = BorderStroke(10.dp, Color.White))
                        )
                        Column(
                            Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "Rupi Kaur",
                                color = Color(0xff474a57),
                                lineHeight = 1.45.em,
                                style = TextStyle(
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                ),
                                modifier = Modifier
                                    .padding(bottom = 5.dp)
                            )
                            Text(
                                text = "Milk and \n" +
                                        "Honey",
                                color = Color(0xff18191f),
                                style = TextStyle(
                                    fontSize = 60.sp,
                                    fontWeight = FontWeight.Bold
                                ),
                                modifier = Modifier.size(90.dp)
                                    .padding(bottom = 1.dp)
                            )
                            Row(
                                modifier = Modifier
                                    .padding(bottom = 2.dp),
                                horizontalArrangement = Arrangement.spacedBy(9.dp, Alignment.Start),
                                verticalAlignment = Alignment.CenterVertically
                            ) {


                            }
                        }
                    }
                }
                item {
                    Row(
                        Modifier.fillMaxWidth()
                            .height(170.dp)
                            .padding(start = 30.dp, end = 10.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(color = Color(0xff9cd3d8))
                            .border(
                                border = BorderStroke(2.dp, Color(0xff18191f)),
                                shape = RoundedCornerShape(16.dp)
                            ),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.poirot),
                            contentDescription = "Book Cover",
                            modifier = Modifier
                                .padding(start = 1.dp)
                                .size(140.dp)
                                .border(border = BorderStroke(10.dp, Color.White))
                        )
                        Column(
                            Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "Agatha Christie",
                                color = Color(0xff474a57),
                                lineHeight = 1.45.em,
                                style = TextStyle(
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                ),
                                modifier = Modifier
                                    .padding(bottom = 5.dp)
                            )
                            Text(
                                text = "Poirot",
                                color = Color(0xff18191f),
                                style = TextStyle(
                                    fontSize = 60.sp,
                                    fontWeight = FontWeight.Bold
                                ),
                                modifier = Modifier.size(90.dp)
                                    .padding(bottom = 1.dp)
                            )
                            Row(
                                modifier = Modifier
                                    .padding(bottom = 2.dp),
                                horizontalArrangement = Arrangement.spacedBy(9.dp, Alignment.Start),
                                verticalAlignment = Alignment.CenterVertically
                            ) {


                            }
                        }
                    }
                }
                item {
                    Row(
                        Modifier.fillMaxWidth()
                            .height(170.dp)
                            .padding(start = 30.dp, end = 10.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(color = Color(0xffc9b6d7))
                            .border(
                                border = BorderStroke(2.dp, Color(0xff18191f)),
                                shape = RoundedCornerShape(16.dp)
                            ),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.amodern),
                            contentDescription = "Book Cover",
                            modifier = Modifier
                                .padding(start = 1.dp)
                                .size(140.dp)
                                .border(border = BorderStroke(10.dp, Color.White))
                        )
                        Column(
                            Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "Edgar Allan Poe",
                                color = Color(0xff474a57),
                                lineHeight = 1.45.em,
                                style = TextStyle(
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                ),
                                modifier = Modifier
                                    .padding(bottom = 5.dp)
                            )
                            Text(
                                text = "A Modern \n" +
                                        "Detective",
                                color = Color(0xff18191f),
                                style = TextStyle(
                                    fontSize = 60.sp,
                                    fontWeight = FontWeight.Bold
                                ),
                                modifier = Modifier.size(90.dp)
                                    .padding(bottom = 1.dp)
                            )
                            Row(
                                modifier = Modifier
                                    .padding(bottom = 2.dp),
                                horizontalArrangement = Arrangement.spacedBy(9.dp, Alignment.Start),
                                verticalAlignment = Alignment.CenterVertically
                            ) {


                            }
                        }
                    }
                }
                item {
                    Row(
                        Modifier.fillMaxWidth()
                            .height(170.dp)
                            .padding(start = 30.dp, end = 10.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(color = Color(0xff8fa5b2))
                            .border(
                                border = BorderStroke(2.dp, Color(0xff18191f)),
                                shape = RoundedCornerShape(16.dp)
                            ),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.abundance),
                            contentDescription = "Book Cover",
                            modifier = Modifier
                                .padding(start = 1.dp)
                                .size(140.dp)
                                .border(border = BorderStroke(10.dp, Color.White))
                        )
                        Column(
                            Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "John Green",
                                color = Color(0xff474a57),
                                lineHeight = 1.45.em,
                                style = TextStyle(
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                ),
                                modifier = Modifier
                                    .padding(bottom = 5.dp)
                            )
                            Text(
                                text = "A Abundance \n" +
                                        "of Katherines",
                                color = Color(0xff18191f),
                                style = TextStyle(
                                    fontSize = 60.sp,
                                    fontWeight = FontWeight.Bold
                                ),
                                modifier = Modifier.size(90.dp)
                                    .padding(bottom = 1.dp)
                            )
                            Row(
                                modifier = Modifier
                                    .padding(bottom = 2.dp),
                                horizontalArrangement = Arrangement.spacedBy(9.dp, Alignment.Start),
                                verticalAlignment = Alignment.CenterVertically
                            ) {


                            }
                        }
                    }
                }
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

@Preview(showBackground = true)
@Composable
fun FavoriteBooksScreenPreview() {
    val navController = rememberNavController()
    FavoriteBooksScreen(navController)
}





