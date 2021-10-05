package com.example.myjetpackapp2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myjetpackapp2.ui.theme.MyJetpackApp2Theme
import com.example.myjetpackapp2.ui.theme.Shapes

@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DefaultPreview()
        }
    }
}

@ExperimentalMaterialApi
@Preview(showBackground = true, device = Devices.DEFAULT, name = "MainActivity")
@Composable
fun DefaultPreview() {
    MyJetpackApp2Theme {
        Column(modifier = Modifier.fillMaxSize()) {
            Toolbar()
            HorizontalView()
            MyDivider()
            Box(contentAlignment = Alignment.BottomCenter) {
                VerticalView()
                BottomMenu()
            }
        }
    }
}

@Composable
fun BottomMenu() {
    BottomNavigation(backgroundColor = Color.White) {
        BottomNavigationItem(icon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_home_24),
                contentDescription = "home"
            )
        }, selected = true,
            alwaysShowLabel = true,
            onClick = {})
        BottomNavigationItem(icon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_search_24),
                contentDescription = "search"
            )
        }, selected = false,
            alwaysShowLabel = false,
            onClick = {})
        BottomNavigationItem(icon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_outline_add_box_24),
                contentDescription = "add",
            )
        }, selected = false,
            alwaysShowLabel = false,
            onClick = {})
        BottomNavigationItem(icon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_favorite_border_24),
                contentDescription = "like"
            )
        }, selected = false,
            alwaysShowLabel = false,
            onClick = {})
        BottomNavigationItem(icon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_person_outline_24),
                contentDescription = "profile"
            )
        }, selected = false,
            alwaysShowLabel = false,
            onClick = {})
    }
}


@Composable
fun MyDivider() {
    Divider(
        Modifier
            .padding(top = 10.dp)
            .height(0.6.dp), color = Color(0xFFECECEC)
    )
}

@Composable
fun MyDivider2() {
    Divider(
        Modifier
            .padding()
            .height(0.6.dp), color = Color(0xFFECECEC)
    )
}

@Composable
fun Toolbar() {
    Row(
        modifier = Modifier
            .height(56.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_instagram_logo),
            contentDescription = "logo",
            modifier = Modifier
                .padding(start = 14.dp, top = 2.dp)
                .height(42.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.ic_messenger),
            contentDescription = "direct",
            Modifier
                .padding(end = 14.dp)
                .fillMaxWidth()
                .height(24.dp),
            alignment = Alignment.CenterEnd
        )
    }
}

@ExperimentalMaterialApi
@Composable
fun HorizontalView() {
    LazyRow {
        items(getRoundList()) { item ->
            GetHorizontalItemView(item.img ?: 0, item.name!!)
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun GetHorizontalItemView(img: Int, profileName: String) {
    val colorList = ArrayList<Color>()
    colorList.add(Color.Red)
    colorList.add(Color.Red)
    colorList.add(Color.Yellow)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            elevation = 4.dp,
            shape = Shapes.large,
            modifier = Modifier.padding(start = 5.dp, end = 5.dp),
            border = BorderStroke(2.dp,
                brush = Brush.linearGradient(colors = colorList)),
            onClick = {}
        ) {
            Image(
                painter = painterResource(id = img),
                contentDescription = profileName,
                modifier = Modifier
                    .height(74.dp)
                    .width(74.dp)
                    .padding(5.dp)
                    .clip(RoundedCornerShape(60.dp)),
                contentScale = ContentScale.Crop
            )
        }
        Text(
            text = profileName,
            color = Color.Black,
            fontFamily = FontFamily.SansSerif,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

fun getRoundList(): List<Round> {
    val list = ArrayList<Round>()
    list.add(Round("Mozak", R.drawable.img5))
    list.add(Round("ONVETI", R.drawable.img2))
    list.add(Round("DevHead", R.drawable.img6))
    list.add(Round("Brain", R.drawable.img4))
    list.add(Round("Kotlin", R.drawable.kotlin_img))
    list.add(Round("Web Progs", R.drawable.img3))
    list.add(Round("ShazzleChat", R.drawable.shazzle))
    list.add(Round("Flowers", R.drawable.img7))
    return list
}

@Composable
fun VerticalView() {
    LazyColumn {
        items(getVerticalPosts()) { item ->
            GetVerticalItemView(name = item.name!!,
                img = item.img!!,
                post = item.post!!,
                likeCount = item.likeCount!!,
                commentCount = item.commentCount!!,
                putTime = item.putTime!!)
        }
    }
}

@Composable
fun GetVerticalItemView(
    name: String,
    img: Int,
    post: Int,
    likeCount: Int,
    commentCount: Int,
    putTime: Int,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 14.dp)
                .height(56.dp), verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                shape = Shapes.large, modifier = Modifier
                    .height(36.dp)
                    .width(36.dp)
            ) {
                Image(
                    painter = painterResource(id = img),
                    contentDescription = name,
                    contentScale = ContentScale.Crop
                )
            }

            Text(
                text = name,
                modifier = Modifier.padding(start = 10.dp),
                fontSize = 14.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold
            )

            Image(
                painter = painterResource(id = R.drawable.ic_more),
                contentDescription = "more",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(16.dp)
                    .padding(end = 13.dp),
                alignment = Alignment.CenterEnd
            )
        }

        Image(
            painter = painterResource(id = post),
            contentDescription = name,
            modifier = Modifier
                .height(400.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )

        Row(
            modifier = Modifier
                .height(46.dp)
                .fillMaxWidth()
                .padding(start = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_favorite_border_24),
                contentDescription = "favouriteIcon",
                modifier = Modifier
                    .height(36.dp)
                    .width(36.dp)
                    .padding(4.dp)
                    .clip(RoundedCornerShape(40))
                    .clickable {

                    }
                    .layoutId("likeButton")
            )
            Image(
                painter = painterResource(id = R.drawable.comment_icon),
                contentDescription = "message",
                modifier = Modifier
                    .height(33.dp)
                    .width(33.dp)
                    .padding(4.dp)
                    .rotate(280f)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_message),
                contentDescription = "message",
                modifier = Modifier
                    .height(34.dp)
                    .width(34.dp)
                    .padding(4.dp)
                    .rotate(17.6f)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_bookmark_border_24),
                contentDescription = "bookmark",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 8.dp)
                    .height(28.dp),
                alignment = Alignment.CenterEnd
            )
        }

        Text(text = "$likeCount likes",
            modifier = Modifier.padding(start = 16.dp),
            color = Color.Black,
            fontWeight = FontWeight.Bold)

        Text(text = "View all $commentCount comment",
            modifier = Modifier.padding(start = 16.dp),
            color = Color.Gray,
            fontSize = 13.sp)

        Text(text = "$putTime minutes ago",
            modifier = Modifier.padding(start = 16.dp, bottom = 16.dp),
            color = Color.Gray,
            fontSize = 11.sp)

        MyDivider2()
    }
}

fun getVerticalPosts(): List<Round> {
    val posts = ArrayList<Round>()
    posts.add(Round("ONVETI", R.drawable.img2, R.drawable.img2, 14, 21, 5))
    posts.add(Round("Mozak", R.drawable.img5, R.drawable.img5, 7, 16, 8))
    posts.add(Round("DevHead", R.drawable.img6, R.drawable.img6, 27, 18, 28))
    posts.add(Round("Web Progs", R.drawable.img3, R.drawable.img3, 4, 1, 33))
    posts.add(Round("Brain", R.drawable.img4, R.drawable.img4, 34, 4, 12))
    posts.add(Round("Kotlin", R.drawable.kotlin_img, R.drawable.kotlin_img, 341, 113, 16))
    posts.add(Round("ShazzleChat", R.drawable.shazzle, R.drawable.shazzle, 263, 198, 45))
    posts.add(Round("Flowers", R.drawable.img7, R.drawable.img7, 9, 27, 59))
    return posts
}
