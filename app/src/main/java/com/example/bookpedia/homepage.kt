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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class Homepage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation()
        }
    }
}

@Composable
fun AppNavigation (){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "homepage"
    ) {
        composable("homepage") { HomepageScreen(navController) }
        composable("favoritebooks") { FavoriteBooksScreen(navController = navController)}
        composable("profile") { ProfileScreen(navController = navController)}
        composable("list") { DescriptionScreen(navController = navController)}
        composable("list2") { Description2Screen(navController = navController)}
        composable("list3") { Description3Screen(navController = navController)}
//
    }
}
@Composable
fun HomepageScreen(navController: NavController) {
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
                        Modifier.fillMaxWidth()
                            .padding(start = 20.dp, end = 20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.menu),
                            contentDescription = "Menu",
                            modifier = Modifier
                                .size(24.dp)
                        )
                        Text(
                            text = "Books",
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
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(25.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item {
                    Row(
                        Modifier.fillMaxWidth()
                            .height(150.dp)
                            .padding(start = 20.dp, end = 20.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(color = Color(0xF8EDE3))
                            .border(
                                border = BorderStroke(2.dp, Color(0xff18191f)),
                                shape = RoundedCornerShape(16.dp)
                            )
                            .clickable {
                                navController.navigate("list")
                            },
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.hollyjackson),
                            contentDescription = "Book Cover",
                            modifier = Modifier
                                .padding(start = 1.dp)
                                .size(140.dp)
                                .border(border = BorderStroke(-10.dp, Color.White))
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
                                    fontSize = 19.sp,
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
                                Image(
                                    painter = painterResource(id = R.drawable.bookmark),
                                    contentDescription = "bookmark",
                                    modifier = Modifier
                                        .requiredSize(size = 15.dp)
                                )

                                Image(
                                    painter = painterResource(id = R.drawable.heart),
                                    contentDescription = "heart",
                                    modifier = Modifier
                                        .requiredSize(size = 15.dp)

                                )
                            }
                        }
                    }
                }
                item {
                    Row(
                        Modifier.fillMaxWidth()
                            .height(150.dp)
                            .padding(start = 20.dp, end = 20.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(color = Color(0xfffff4cc))
                            .border(
                                border = BorderStroke(2.dp, Color(0xff18191f)),
                                shape = RoundedCornerShape(16.dp)
                            ),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.tereliye),
                            contentDescription = "Book Cover",
                            modifier = Modifier
                                .padding(start = 1.dp)
                                .size(140.dp)
                                .border(border = BorderStroke(-10.dp, Color.White))
                        )
                        Column(
                            Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "Tere Liye",
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
                                text = "Negeri \n" +
                                        "Para \n" +
                                        "Bedebah",
                                color = Color(0xff18191f),
                                style = TextStyle(
                                    fontSize = 19.sp,
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
                                Image(
                                    painter = painterResource(id = R.drawable.bookmark),
                                    contentDescription = "bookmark",
                                    modifier = Modifier
                                        .requiredSize(size = 18.dp)
                                )

                                Image(
                                    painter = painterResource(id = R.drawable.heart),
                                    contentDescription = "heart",
                                    modifier = Modifier
                                        .requiredSize(size = 18.dp)

                                )
                            }
                        }
                    }
                }
                item {
                    Row(
                        Modifier.fillMaxWidth()
                            .height(150.dp)
                            .padding(start = 20.dp, end = 20.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(color = Color(0xffff9692))
                            .border(
                                border = BorderStroke(2.dp, Color(0xff18191f)),
                                shape = RoundedCornerShape(16.dp)
                            ),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.pachinko),
                            contentDescription = "Book Cover",
                            modifier = Modifier
                                .padding(start = 1.dp)
                                .size(140.dp)
                                .border(border = BorderStroke(-10.dp, Color.White))
                        )
                        Column(
                            Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "Min Jin Lee",
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
                                text = "Pachinko",
                                color = Color(0xff18191f),
                                style = TextStyle(
                                    fontSize = 19.sp,
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
                                Image(
                                    painter = painterResource(id = R.drawable.bookmark),
                                    contentDescription = "bookmark",
                                    modifier = Modifier
                                        .requiredSize(size = 15.dp)
                                )

                                Image(
                                    painter = painterResource(id = R.drawable.heart),
                                    contentDescription = "heart",
                                    modifier = Modifier
                                        .requiredSize(size = 15.dp)

                                )
                            }
                        }
                    }
                }
                item {
                    Row(
                        Modifier.fillMaxWidth()
                            .height(150.dp)
                            .padding(start = 20.dp, end = 20.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(color = Color(0xffffe8e8))
                            .border(
                                border = BorderStroke(2.dp, Color(0xff18191f)),
                                shape = RoundedCornerShape(16.dp)
                            ),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.visiblecity),
                            contentDescription = "Book Cover",
                            modifier = Modifier
                                .padding(start = 1.dp)
                                .size(140.dp)
                                .border(border = BorderStroke(-10.dp, Color.White))
                        )
                        Column(
                            Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "Tova Mirvis",
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
                                text = "Visible \n" +
                                        "City",
                                color = Color(0xff18191f),
                                style = TextStyle(
                                    fontSize = 19.sp,
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
                                Image(
                                    painter = painterResource(id = R.drawable.bookmark),
                                    contentDescription = "bookmark",
                                    modifier = Modifier
                                        .requiredSize(size = 15.dp)
                                )

                                Image(
                                    painter = painterResource(id = R.drawable.heart),
                                    contentDescription = "heart",
                                    modifier = Modifier
                                        .requiredSize(size = 15.dp)

                                )
                            }
                        }
                    }
                }
                item {
                    Row(
                        Modifier.fillMaxWidth()
                            .height(150.dp)
                            .padding(start = 20.dp, end = 20.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(color = Color(0xffff9692))
                            .border(
                                border = BorderStroke(2.dp, Color(0xff18191f)),
                                shape = RoundedCornerShape(16.dp)
                            ),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.persuasion),
                            contentDescription = "Book Cover",
                            modifier = Modifier
                                .padding(start = 1.dp)
                                .size(140.dp)
                                .border(border = BorderStroke(-10.dp, Color.White))
                        )
                        Column(
                            Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "Jane Austen",
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
                                text = "Persuasions",
                                color = Color(0xff18191f),
                                style = TextStyle(
                                    fontSize = 19.sp,
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
                                Image(
                                    painter = painterResource(id = R.drawable.bookmark),
                                    contentDescription = "bookmark",
                                    modifier = Modifier
                                        .requiredSize(size = 15.dp)
                                )

                                Image(
                                    painter = painterResource(id = R.drawable.heart),
                                    contentDescription = "heart",
                                    modifier = Modifier
                                        .requiredSize(size = 15.dp)

                                )
                            }
                        }
                    }
                }
                item {
                    Row(
                        Modifier.fillMaxWidth()
                            .height(150.dp)
                            .padding(start = 20.dp, end = 20.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(color = Color(0xffff9692))
                            .border(
                                border = BorderStroke(2.dp, Color(0xff18191f)),
                                shape = RoundedCornerShape(16.dp)
                            ),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.papertowns),
                            contentDescription = "Book Cover",
                            modifier = Modifier
                                .padding(start = 1.dp)
                                .size(140.dp)
                                .border(border = BorderStroke(-10.dp, Color.White))
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
                                text = "Papertowns",
                                color = Color(0xff18191f),
                                style = TextStyle(
                                    fontSize = 19.sp,
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
                                Image(
                                    painter = painterResource(id = R.drawable.bookmark),
                                    contentDescription = "bookmark",
                                    modifier = Modifier
                                        .requiredSize(size = 15.dp)
                                )

                                Image(
                                    painter = painterResource(id = R.drawable.heart),
                                    contentDescription = "heart",
                                    modifier = Modifier
                                        .requiredSize(size = 15.dp)

                                )
                            }
                        }
                    }
                }
                item {
                    Row(
                        Modifier.fillMaxWidth()
                            .height(150.dp)
                            .padding(start = 20.dp, end = 20.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(color = Color(0xffff9692))
                            .border(
                                border = BorderStroke(2.dp, Color(0xff18191f)),
                                shape = RoundedCornerShape(16.dp)
                            ),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.letterstomilena),
                            contentDescription = "Book Cover",
                            modifier = Modifier
                                .padding(start = 1.dp)
                                .size(140.dp)
                                .border(border = BorderStroke(-10.dp, Color.White))
                        )
                        Column(
                            Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "Franz Kafka",
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
                                text = "Letters to \n" +
                                        "Milena",
                                color = Color(0xff18191f),
                                style = TextStyle(
                                    fontSize = 19.sp,
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
                                Image(
                                    painter = painterResource(id = R.drawable.bookmark),
                                    contentDescription = "bookmark",
                                    modifier = Modifier
                                        .requiredSize(size = 15.dp)
                                )

                                Image(
                                    painter = painterResource(id = R.drawable.heart),
                                    contentDescription = "heart",
                                    modifier = Modifier
                                        .requiredSize(size = 15.dp)

                                )
                            }
                        }
                    }
                }
                item {
                    Row(
                        Modifier.fillMaxWidth()
                            .height(150.dp)
                            .padding(start = 20.dp, end = 20.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(color = Color(0xffff9692))
                            .border(
                                border = BorderStroke(2.dp, Color(0xff18191f)),
                                shape = RoundedCornerShape(16.dp)
                            ),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.nightcrawling),
                            contentDescription = "Book Cover",
                            modifier = Modifier
                                .padding(start = 1.dp)
                                .size(140.dp)
                                .border(border = BorderStroke(-10.dp, Color.White))
                        )
                        Column(
                            Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "Leila Mottley",
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
                                text = "Night \n" +
                                        "crawling",
                                color = Color(0xff18191f),
                                style = TextStyle(
                                    fontSize = 19.sp,
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
                                Image(
                                    painter = painterResource(id = R.drawable.bookmark),
                                    contentDescription = "bookmark",
                                    modifier = Modifier
                                        .requiredSize(size = 15.dp)
                                )

                                Image(
                                    painter = painterResource(id = R.drawable.heart),
                                    contentDescription = "heart",
                                    modifier = Modifier
                                        .requiredSize(size = 15.dp)

                                )
                            }
                        }
                    }
                }
                item {
                    Row(
                        Modifier.fillMaxWidth()
                            .height(150.dp)
                            .padding(start = 20.dp, end = 20.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(color = Color(0xffff9692))
                            .border(
                                border = BorderStroke(2.dp, Color(0xff18191f)),
                                shape = RoundedCornerShape(16.dp)
                            ),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.perjamuankhongguan),
                            contentDescription = "Book Cover",
                            modifier = Modifier
                                .padding(start = 1.dp)
                                .size(140.dp)
                                .border(border = BorderStroke(-10.dp, Color.White))
                        )
                        Column(
                            Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "Joko Pinurbo",
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
                                text = "Perjamuan \n" +
                                        "Khong \n" +
                                        "Guan",
                                color = Color(0xff18191f),
                                style = TextStyle(
                                    fontSize = 19.sp,
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
                                Image(
                                    painter = painterResource(id = R.drawable.bookmark),
                                    contentDescription = "bookmark",
                                    modifier = Modifier
                                        .requiredSize(size = 15.dp)
                                )

                                Image(
                                    painter = painterResource(id = R.drawable.heart),
                                    contentDescription = "heart",
                                    modifier = Modifier
                                        .requiredSize(size = 15.dp)

                                )
                            }
                        }
                    }
                }
                item {
                    Row(
                        Modifier.fillMaxWidth()
                            .height(150.dp)
                            .padding(start = 20.dp, end = 20.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(color = Color(0xffff9692))
                            .border(
                                border = BorderStroke(2.dp, Color(0xff18191f)),
                                shape = RoundedCornerShape(16.dp)
                            ),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.mrsdalloway),
                            contentDescription = "Book Cover",
                            modifier = Modifier
                                .padding(start = 1.dp)
                                .size(140.dp)
                                .border(border = BorderStroke(-10.dp, Color.White))
                        )
                        Column(
                            Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "Virginia Woolf",
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
                                text = "Mrs.\n" +
                                        "Dalloway",
                                color = Color(0xff18191f),
                                style = TextStyle(
                                    fontSize = 19.sp,
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
                                Image(
                                    painter = painterResource(id = R.drawable.bookmark),
                                    contentDescription = "bookmark",
                                    modifier = Modifier
                                        .requiredSize(size = 15.dp)
                                )

                                Image(
                                    painter = painterResource(id = R.drawable.heart),
                                    contentDescription = "heart",
                                    modifier = Modifier
                                        .requiredSize(size = 15.dp)

                                )
                            }
                        }
                    }
                }
            }
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                item {
                    Row(
                        Modifier.fillMaxWidth()
                            .height(150.dp)
                            .padding(start = 20.dp, end = 20.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(color = Color(0xffffe8e8))
                            .border(
                                border = BorderStroke(2.dp, Color(0xff18191f)),
                                shape = RoundedCornerShape(16.dp)
                            ),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.chairilanwar),
                            contentDescription = "Book Cover",
                            modifier = Modifier
                                .padding(start = 20.dp)
                                .size(100.dp)
                                .border(border = BorderStroke(2.dp, Color.White))
                        )
                        Column(
                            Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "H. B. Jassin",
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
                                text = "Chairil Anwar Pelopor Angkatan ‘45",
                                color = Color(0xff18191f),
                                style = TextStyle(
                                    fontSize = 21.sp,
                                    fontWeight = FontWeight.Bold
                                ),
                                modifier = Modifier
                                    .padding(bottom = 5.dp)
                            )
                            Row(
                                modifier = Modifier
                                    .padding(bottom = 5.dp),
                                horizontalArrangement = Arrangement.spacedBy(
                                    8.dp,
                                    Alignment.Start
                                ),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.bookmark),
                                    contentDescription = "bookmark",
                                    modifier = Modifier
                                        .requiredSize(size = 18.dp)
                                )
                                Text(
                                    text = "Add to Library",
                                    color = Color(0xff18191f),
                                    lineHeight = 1.38.em,
                                    style = TextStyle(
                                        fontSize = 11.sp
                                    )
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.heart),
                                    contentDescription = "heart",
                                    modifier = Modifier
                                        .requiredSize(size = 18.dp)
                                )
                                Text(
                                    text = "Favorite",
                                    color = Color(0xff18191f),
                                    lineHeight = 1.38.em,
                                    style = TextStyle(
                                        fontSize = 11.sp
                                    )
                                )
                            }
                        }
                    }
                }
                item {
                    Row(
                        Modifier.fillMaxWidth()
                            .height(150.dp)
                            .padding(start = 20.dp, end = 20.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(color = Color(0xffe9e7fc))
                            .border(
                                border = BorderStroke(2.dp, Color(0xff18191f)),
                                shape = RoundedCornerShape(16.dp)
                            ),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.sapardidjoko),
                            contentDescription = "Book Cover",
                            modifier = Modifier
                                .padding(start = 20.dp)
                                .size(100.dp)
                                .border(border = BorderStroke(2.dp, Color.White))
                        )
                        Column(
                            Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "Sapardi Djoko Damono",
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
                                text = "Mantra Orang Jawa",
                                color = Color(0xff18191f),
                                style = TextStyle(
                                    fontSize = 21.sp,
                                    fontWeight = FontWeight.Bold
                                ),
                                modifier = Modifier
                                    .padding(bottom = 5.dp)
                            )
                            Row(
                                modifier = Modifier
                                    .padding(bottom = 5.dp),
                                horizontalArrangement = Arrangement.spacedBy(
                                    8.dp,
                                    Alignment.Start
                                ),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.bookmark),
                                    contentDescription = "bookmark",
                                    modifier = Modifier
                                        .requiredSize(size = 18.dp)
                                )
                                Text(
                                    text = "Add to Library",
                                    color = Color(0xff18191f),
                                    lineHeight = 1.38.em,
                                    style = TextStyle(
                                        fontSize = 11.sp
                                    )
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.heart),
                                    contentDescription = "heart",
                                    modifier = Modifier
                                        .requiredSize(size = 18.dp)
                                )
                                Text(
                                    text = "Favorite",
                                    color = Color(0xff18191f),
                                    lineHeight = 1.38.em,
                                    style = TextStyle(
                                        fontSize = 11.sp
                                    )
                                )
                            }
                        }
                    }
                }
                item {
                    Row(
                        Modifier.fillMaxWidth()
                            .height(150.dp)
                            .padding(start = 20.dp, end = 20.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(color = Color(0xffd6fcf7))
                            .border(
                                border = BorderStroke(2.dp, Color(0xff18191f)),
                                shape = RoundedCornerShape(16.dp)
                            ).clickable {
                                navController.navigate("list2")
                            },
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ratihkumala),
                            contentDescription = "Book Cover",
                            modifier = Modifier
                                .padding(start = 20.dp)
                                .size(100.dp)
                                .border(border = BorderStroke(2.dp, Color.White))
                        )
                        Column(
                            Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "Ratih Kumala",
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
                                text = "Gadis Kretek",
                                color = Color(0xff18191f),
                                style = TextStyle(
                                    fontSize = 21.sp,
                                    fontWeight = FontWeight.Bold
                                ),
                                modifier = Modifier
                                    .padding(bottom = 5.dp)
                            )
                            Row(
                                modifier = Modifier
                                    .padding(bottom = 5.dp),
                                horizontalArrangement = Arrangement.spacedBy(
                                    8.dp,
                                    Alignment.Start
                                ),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.bookmark),
                                    contentDescription = "bookmark",
                                    modifier = Modifier
                                        .requiredSize(size = 18.dp)
                                )
                                Text(
                                    text = "Add to Library",
                                    color = Color(0xff18191f),
                                    lineHeight = 1.38.em,
                                    style = TextStyle(
                                        fontSize = 11.sp
                                    )
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.heart),
                                    contentDescription = "heart",
                                    modifier = Modifier
                                        .requiredSize(size = 18.dp)
                                )
                                Text(
                                    text = "Favorite",
                                    color = Color(0xff18191f),
                                    lineHeight = 1.38.em,
                                    style = TextStyle(
                                        fontSize = 11.sp
                                    )
                                )
                            }
                        }

                    }
                }
                item {
                    Row(
                        Modifier.fillMaxWidth()
                            .height(150.dp)
                            .padding(start = 20.dp, end = 20.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(color = Color(0xfffff4cc))
                            .border(
                                border = BorderStroke(2.dp, Color(0xff18191f)),
                                shape = RoundedCornerShape(16.dp)
                            ),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.fightclub),
                            contentDescription = "Book Cover",
                            modifier = Modifier
                                .padding(start = 20.dp)
                                .size(100.dp)
                                .border(border = BorderStroke(2.dp, Color.White))
                        )
                        Column(
                            Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "Chuck Palahniuk",
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
                                text = "Fight Club",
                                color = Color(0xff18191f),
                                style = TextStyle(
                                    fontSize = 21.sp,
                                    fontWeight = FontWeight.Bold
                                ),
                                modifier = Modifier
                                    .padding(bottom = 5.dp)
                            )
                            Row(
                                modifier = Modifier
                                    .padding(bottom = 5.dp),
                                horizontalArrangement = Arrangement.spacedBy(
                                    8.dp,
                                    Alignment.Start
                                ),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.bookmark),
                                    contentDescription = "bookmark",
                                    modifier = Modifier
                                        .requiredSize(size = 18.dp)
                                )
                                Text(
                                    text = "Add to Library",
                                    color = Color(0xff18191f),
                                    lineHeight = 1.38.em,
                                    style = TextStyle(
                                        fontSize = 11.sp
                                    )
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.heart),
                                    contentDescription = "heart",
                                    modifier = Modifier
                                        .requiredSize(size = 18.dp)
                                )
                                Text(
                                    text = "Favorite",
                                    color = Color(0xff18191f),
                                    lineHeight = 1.38.em,
                                    style = TextStyle(
                                        fontSize = 11.sp
                                    )
                                )
                            }
                        }
                    }

                }
                item {
                    Row(
                        Modifier.fillMaxWidth()
                            .height(150.dp)
                            .padding(start = 20.dp, end = 20.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(color = Color(0xffff9692))
                            .border(
                                border = BorderStroke(2.dp, Color(0xff18191f)),
                                shape = RoundedCornerShape(16.dp)
                            ),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.franzkafka),
                            contentDescription = "Book Cover",
                            modifier = Modifier
                                .padding(start = 20.dp)
                                .size(100.dp)
                                .border(border = BorderStroke(2.dp, Color.White))
                        )
                        Column(
                            Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "Franz Kafka",
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
                                text = "Metamorphosis",
                                color = Color(0xff18191f),
                                style = TextStyle(
                                    fontSize = 21.sp,
                                    fontWeight = FontWeight.Bold
                                ),
                                modifier = Modifier
                                    .padding(bottom = 5.dp)
                            )
                            Row(
                                modifier = Modifier
                                    .padding(bottom = 5.dp),
                                horizontalArrangement = Arrangement.spacedBy(
                                    8.dp,
                                    Alignment.Start
                                ),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.bookmark),
                                    contentDescription = "bookmark",
                                    modifier = Modifier
                                        .requiredSize(size = 18.dp)
                                )
                                Text(
                                    text = "Add to Library",
                                    color = Color(0xff18191f),
                                    lineHeight = 1.38.em,
                                    style = TextStyle(
                                        fontSize = 11.sp
                                    )
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.heart),
                                    contentDescription = "heart",
                                    modifier = Modifier
                                        .requiredSize(size = 18.dp)
                                )
                                Text(
                                    text = "Favorite",
                                    color = Color(0xff18191f),
                                    lineHeight = 1.38.em,
                                    style = TextStyle(
                                        fontSize = 11.sp
                                    )
                                )
                            }

                        }
                    }
                }
                item {
                    Row(
                        Modifier.fillMaxWidth()
                            .height(150.dp)
                            .padding(start = 20.dp, end = 20.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(color = Color(0xffffe8e8))
                            .border(
                                border = BorderStroke(2.dp, Color(0xff18191f)),
                                shape = RoundedCornerShape(16.dp)
                            ),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.twilight),
                            contentDescription = "Book Cover",
                            modifier = Modifier
                                .padding(start = 20.dp)
                                .size(100.dp)
                                .border(border = BorderStroke(2.dp, Color.White))
                        )
                        Column(
                            Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "Stephenie Meyer",
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
                                text = "Twilight",
                                color = Color(0xff18191f),
                                style = TextStyle(
                                    fontSize = 21.sp,
                                    fontWeight = FontWeight.Bold
                                ),
                                modifier = Modifier
                                    .padding(bottom = 5.dp)
                            )
                            Row(
                                modifier = Modifier
                                    .padding(bottom = 5.dp),
                                horizontalArrangement = Arrangement.spacedBy(
                                    8.dp,
                                    Alignment.Start
                                ),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.bookmark),
                                    contentDescription = "bookmark",
                                    modifier = Modifier
                                        .requiredSize(size = 18.dp)
                                )
                                Text(
                                    text = "Add to Library",
                                    color = Color(0xff18191f),
                                    lineHeight = 1.38.em,
                                    style = TextStyle(
                                        fontSize = 11.sp
                                    )
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.heart),
                                    contentDescription = "heart",
                                    modifier = Modifier
                                        .requiredSize(size = 18.dp)
                                )
                                Text(
                                    text = "Favorite",
                                    color = Color(0xff18191f),
                                    lineHeight = 1.38.em,
                                    style = TextStyle(
                                        fontSize = 11.sp
                                    )
                                )
                            }
                        }
                    }
                }
                item {
                    Row(
                        Modifier.fillMaxWidth()
                            .height(150.dp)
                            .padding(start = 20.dp, end = 20.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(color = Color(0xffe9e7fc))
                            .border(
                                border = BorderStroke(2.dp, Color(0xff18191f)),
                                shape = RoundedCornerShape(16.dp)
                            ),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.crimenpunishment),
                            contentDescription = "Book Cover",
                            modifier = Modifier
                                .padding(start = 20.dp)
                                .size(100.dp)
                                .border(border = BorderStroke(2.dp, Color.White))
                        )
                        Column(
                            Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "Fyodor Dostoyevsky",
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
                                text = "Crime and Punishment",
                                color = Color(0xff18191f),
                                style = TextStyle(
                                    fontSize = 21.sp,
                                    fontWeight = FontWeight.Bold
                                ),
                                modifier = Modifier
                                    .padding(bottom = 5.dp)
                            )
                            Row(
                                modifier = Modifier
                                    .padding(bottom = 5.dp),
                                horizontalArrangement = Arrangement.spacedBy(
                                    8.dp,
                                    Alignment.Start
                                ),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.bookmark),
                                    contentDescription = "bookmark",
                                    modifier = Modifier
                                        .requiredSize(size = 18.dp)
                                )
                                Text(
                                    text = "Add to Library",
                                    color = Color(0xff18191f),
                                    lineHeight = 1.38.em,
                                    style = TextStyle(
                                        fontSize = 11.sp
                                    )
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.heart),
                                    contentDescription = "heart",
                                    modifier = Modifier
                                        .requiredSize(size = 18.dp)
                                )
                                Text(
                                    text = "Favorite",
                                    color = Color(0xff18191f),
                                    lineHeight = 1.38.em,
                                    style = TextStyle(
                                        fontSize = 11.sp
                                    )
                                )
                            }
                        }
                    }
                }
                item {
                    Row(
                        Modifier.fillMaxWidth()
                            .height(150.dp)
                            .padding(start = 20.dp, end = 20.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(color = Color(0xffffe8e8))
                            .border(
                                border = BorderStroke(2.dp, Color(0xff18191f)),
                                shape = RoundedCornerShape(16.dp)
                            ),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.americanpsycho),
                            contentDescription = "Book Cover",
                            modifier = Modifier
                                .padding(start = 20.dp)
                                .size(100.dp)
                                .border(border = BorderStroke(2.dp, Color.White))
                        )
                        Column(
                            Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "Bret Easton Ellis",
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
                                text = "American Psycho",
                                color = Color(0xff18191f),
                                style = TextStyle(
                                    fontSize = 21.sp,
                                    fontWeight = FontWeight.Bold
                                ),
                                modifier = Modifier
                                    .padding(bottom = 5.dp)
                            )
                            Row(
                                modifier = Modifier
                                    .padding(bottom = 5.dp),
                                horizontalArrangement = Arrangement.spacedBy(
                                    8.dp,
                                    Alignment.Start
                                ),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.bookmark),
                                    contentDescription = "bookmark",
                                    modifier = Modifier
                                        .requiredSize(size = 18.dp)
                                )
                                Text(
                                    text = "Add to Library",
                                    color = Color(0xff18191f),
                                    lineHeight = 1.38.em,
                                    style = TextStyle(
                                        fontSize = 11.sp
                                    )
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.heart),
                                    contentDescription = "heart",
                                    modifier = Modifier
                                        .requiredSize(size = 18.dp)
                                )
                                Text(
                                    text = "Favorite",
                                    color = Color(0xff18191f),
                                    lineHeight = 1.38.em,
                                    style = TextStyle(
                                        fontSize = 11.sp
                                    )
                                )
                            }
                        }
                    }
                }
                item {
                    Row(
                        Modifier.fillMaxWidth()
                            .height(150.dp)
                            .padding(start = 20.dp, end = 20.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(color = Color(0xffffe8e8))
                            .border(
                                border = BorderStroke(2.dp, Color(0xff18191f)),
                                shape = RoundedCornerShape(16.dp)
                            ),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.agathacristhie),
                            contentDescription = "Book Cover",
                            modifier = Modifier
                                .padding(start = 20.dp)
                                .size(100.dp)
                                .border(border = BorderStroke(2.dp, Color.White))
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
                                text = "Murder on the Orient Express",
                                color = Color(0xff18191f),
                                style = TextStyle(
                                    fontSize = 21.sp,
                                    fontWeight = FontWeight.Bold
                                ),
                                modifier = Modifier
                                    .padding(bottom = 5.dp)
                            )
                            Row(
                                modifier = Modifier
                                    .padding(bottom = 5.dp),
                                horizontalArrangement = Arrangement.spacedBy(
                                    8.dp,
                                    Alignment.Start
                                ),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.bookmark),
                                    contentDescription = "bookmark",
                                    modifier = Modifier
                                        .requiredSize(size = 18.dp)
                                )
                                Text(
                                    text = "Add to Library",
                                    color = Color(0xff18191f),
                                    lineHeight = 1.38.em,
                                    style = TextStyle(
                                        fontSize = 11.sp
                                    )
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.heart),
                                    contentDescription = "heart",
                                    modifier = Modifier
                                        .requiredSize(size = 18.dp)
                                )
                                Text(
                                    text = "Favorite",
                                    color = Color(0xff18191f),
                                    lineHeight = 1.38.em,
                                    style = TextStyle(
                                        fontSize = 11.sp
                                    )
                                )
                            }
                        }
                    }
                }
                item {
                    Row(
                        Modifier.fillMaxWidth()
                            .height(150.dp)
                            .padding(start = 20.dp, end = 20.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(color = Color(0xffffe8e8))
                            .border(
                                border = BorderStroke(2.dp, Color(0xff18191f)),
                                shape = RoundedCornerShape(16.dp)
                            ),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.itendswithus),
                            contentDescription = "Book Cover",
                            modifier = Modifier
                                .padding(start = 20.dp)
                                .size(100.dp)
                                .border(border = BorderStroke(2.dp, Color.White))
                        )
                        Column(
                            Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "Colleen Hoover",
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
                                text = "It Ends With Us",
                                color = Color(0xff18191f),
                                style = TextStyle(
                                    fontSize = 21.sp,
                                    fontWeight = FontWeight.Bold
                                ),
                                modifier = Modifier
                                    .padding(bottom = 5.dp)
                            )
                            Row(
                                modifier = Modifier
                                    .padding(bottom = 5.dp),
                                horizontalArrangement = Arrangement.spacedBy(
                                    8.dp,
                                    Alignment.Start
                                ),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.bookmark),
                                    contentDescription = "bookmark",
                                    modifier = Modifier
                                        .requiredSize(size = 18.dp)
                                )
                                Text(
                                    text = "Add to Library",
                                    color = Color(0xff18191f),
                                    lineHeight = 1.38.em,
                                    style = TextStyle(
                                        fontSize = 11.sp
                                    )
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.heart),
                                    contentDescription = "heart",
                                    modifier = Modifier
                                        .requiredSize(size = 18.dp)
                                )
                                Text(
                                    text = "Favorite",
                                    color = Color(0xff18191f),
                                    lineHeight = 1.38.em,
                                    style = TextStyle(
                                        fontSize = 11.sp
                                    )
                                )
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
fun HomepageScreenPreview() {
    val navController = rememberNavController()
    HomepageScreen(navController)
}


