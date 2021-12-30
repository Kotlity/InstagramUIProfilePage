package com.instagramprofileui.jetpackcompose

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen() {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    Column(modifier = Modifier.fillMaxSize()) {
//        TopBar(name = "__.nothing_special.__", modifier = Modifier.padding(10.dp))
        Spacer(modifier = Modifier.height(30.dp))
        TopBar(accountName = "__.nothing_special.__", modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(15.dp))
        Divider(color = Color.LightGray, thickness = 0.5.dp)
        Spacer(modifier = Modifier.height(8.dp))
        Dashboard(modifier = Modifier.height(34.dp), "Professional Dashboard", "Tools and resources just for businesses.")
        Spacer(modifier = Modifier.height(8.dp))
        Divider(color = Color.LightGray, thickness = 0.5.dp)
        Spacer(modifier = Modifier.height(10.dp))
        ProfileStatsAndMainInformation()
        Spacer(modifier = Modifier.height(10.dp))
        ButtonsSection(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(20.dp))
        StoryHighlightRow(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(10.dp))
        PostTabView(content = listOf(
            ContentForRowOfTabs(
                tabImage = painterResource(id = R.drawable.grid),
                tabTitle = "Posts"
            ),
            ContentForRowOfTabs(
                tabImage = painterResource(id = R.drawable.mention),
                tabTitle = "Mentions"
            )
        )) {
            selectedTabIndex = it
        }
        when (selectedTabIndex) {
            0 -> PostSection(
                posts = listOf(
                    painterResource(id = R.drawable.post_1),
                    painterResource(id = R.drawable.post_2),
                    painterResource(id = R.drawable.post_3),
                    painterResource(id = R.drawable.post_4),
                    painterResource(id = R.drawable.post_5),
                    painterResource(id = R.drawable.post_6),
                    painterResource(id = R.drawable.post_7),
                    painterResource(id = R.drawable.post_8),
                    painterResource(id = R.drawable.post_9),
                    painterResource(id = R.drawable.post_10)
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

//@Composable
//fun TopBar(
//    name: String,
//    modifier: Modifier = Modifier
//) {
//    Row(
//        verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.SpaceAround,                            // одинаковые отступы между каждым элементом
//        modifier = modifier.fillMaxWidth()
//    ) {
//        Icon(imageVector = Icons.Default.ArrowBack,
//            contentDescription = "back",
//            tint = Color.Black,
//            modifier = Modifier.size(24.dp)
//        )
//        Text(
//            text = name,
//            overflow = TextOverflow.Ellipsis,                                       // если имя аккаунта будет налаживаться на другие элементы, то под концом имени будут 3 точки
//            fontWeight = FontWeight.Bold,
//            fontSize = 20.sp
//        )
//        Icon(imageVector = Icons.Default.Notifications,
//            contentDescription = "notifications",
//            tint = Color.Black,
//            modifier = Modifier.size(24.dp)
//        )
//        Icon(imageVector = Icons.Default.Menu,
//            contentDescription = "menu",
//            tint = Color.Black,
//            modifier = Modifier.size(24.dp)
//        )
//    }
//}

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    accountName: String
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Text(
            text = accountName,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 10.dp)
        )
        Icon(
            imageVector = Icons.Default.KeyboardArrowDown,
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier.size(21.dp)
        )
        Spacer(modifier = Modifier.width(110.dp))
        topBarIcons(modifier = Modifier.weight(1f))
    }
}

@Composable
fun topBarIcons(
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.create),
            contentDescription = null,
            modifier = Modifier.size(22.dp)
        )
        Icon(
            imageVector = Icons.Default.Menu,
            contentDescription = null,
            modifier = Modifier.size(25.dp)
        )
    }
}

@Composable
fun Dashboard(
    modifier: Modifier = Modifier,
    mainText: String,
    additionalText: String
) {
    Column(modifier = modifier.padding(start = 10.dp)) {
        Row {
            Text(
                text = mainText,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.width(245.dp))
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = null,
                modifier = Modifier
                    .size(21.dp)
                    .padding(top = 10.dp)
            )
        }
        Text(
            text = additionalText,
            fontSize = 12.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun ProfileStatsAndMainInformation(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            MainAccountImage(
                image = painterResource(id = R.drawable.main_profile_image),
                modifier = Modifier
                    .size(90.dp)
                    .weight(2.4f)             // изображение занимает 24% от всей ширины Row
            )
            Spacer(modifier = Modifier.width(35.dp))
            StatsInformation(modifier = Modifier.weight(7.6f))                                 // заполняем оставшиюся ширину (76%)
        }
        Spacer(modifier = Modifier.height(7.dp))
        ProfileInfo("there's nothing here", "Personal blog", "Ukraine, Boyarka", "19 y.o.", "скоро приеду проведать тебя", "t.me/There_is_nothing_special_for_you")
    }
}

@Composable
fun MainAccountImage(
    image: Painter,
    modifier: Modifier = Modifier
) {
    Image(
        painter = image,
        contentDescription = null,
        modifier
            .aspectRatio(
                1f,
                matchHeightConstraintsFirst = true
            )
            .clip(CircleShape)
    )
}

@Composable
fun StatsInformation(
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {
        ProfileStat(categoriesStatsAmount = "10", categories = "Posts")
        ProfileStat(categoriesStatsAmount = "261", categories = "Followers")
        ProfileStat(categoriesStatsAmount = "27", categories = "Following")
    }
}

@Composable
fun ProfileStat(
    categoriesStatsAmount: String,
    categories: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = categoriesStatsAmount,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = categories,
            fontWeight = FontWeight.W500
        )
    }
}

@Composable
fun ProfileInfo(
    profileName: String,
    business: String,
    placeOfLiving: String,
    age: String,
    description: String,
    url: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp)
    ) {
        Text(
            text = profileName,
            fontWeight = FontWeight.ExtraBold
        )
        Text(
            text = business,
            color = Color.Gray
        )
        Text(
            text = placeOfLiving
        )
        Text(
            text = age
        )
        Row {
            Text(
                text = description
            )
            Column(
                modifier = Modifier.padding(vertical = 1.dp)
            ) {
                Emoji(
                    image = painterResource(id = R.drawable.emoji_heart),
                    modifier = Modifier.size(16.dp)
                )
            }
        }
        Text(
            text = url,
            color = Color(0xFF3D3D91)
        )
    }
}

@Composable
fun Emoji(
    image: Painter,
    modifier: Modifier = Modifier
) {
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
    )
}

@Composable
fun ButtonsSection(
    modifier: Modifier = Modifier
) {
    val minWidth = 128.dp
    val height = 30.dp

    MainButton(
        mainButtonText = "Edit profile",
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 6.dp)
    )
    Spacer(modifier = Modifier.height(10.dp))
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
    ) {
        Button(
            buttonText = "Ad tools",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        Button(
            buttonText = "Insights",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        Button(
            buttonText = "Contact",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
    }
}

@Composable
fun MainButton(
    modifier: Modifier = Modifier,
    mainButtonText: String
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(6.dp)
    ) {
        Text(
            text = mainButtonText,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        )
    }
}

@Composable
fun Button(
    modifier: Modifier = Modifier,
    buttonText: String
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(6.dp)
    ) {
        Text(
            text = buttonText,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        )
    }
}

@Composable
fun StoryHighlightRow(
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(start = 10.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            StoryHighlightImage(
                image = painterResource(id = R.drawable.story_image_1),
                modifier = Modifier.size(55.dp)
            )
            Spacer(modifier = Modifier.height(2.dp))
            Emoji(
                image = painterResource(id = R.drawable.emoji_sad),
                modifier = Modifier.size(16.dp)
            )
        }
        Spacer(modifier = Modifier.width(18.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            StoryHighlightImage(
                image = painterResource(id = R.drawable.story_image_2),
                modifier = Modifier.size(55.dp)
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Spring 2021",
                fontSize = 12.sp
            )
        }
        Spacer(modifier = Modifier.width(18.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            StoryHighlightImage(
                image = painterResource(id = R.drawable.story_image_3),
                modifier = Modifier.size(55.dp)
            )
            Spacer(modifier = Modifier.height(2.dp))
            Row {
                Text(
                    text = "Лучшие",
                    fontSize = 12.sp
                )
                Emoji(
                    image = painterResource(id = R.drawable.emoji_2hearts),
                    modifier = Modifier.size(16.dp)
                )
            }
        }
        Spacer(modifier = Modifier.width(18.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            StoryHighlightImage(
                image = painterResource(id = R.drawable.story_image_4),
                modifier = Modifier.size(55.dp)
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Лучшее утро...",
                fontSize = 12.sp
            )
        }
        Spacer(modifier = Modifier.width(18.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null,
                modifier = Modifier
                    .size(49.dp)
                    .aspectRatio(
                        1f,
                        matchHeightConstraintsFirst = true
                    )
                    .border(
                        width = 1.dp,
                        color = Color.Black,
                        shape = CircleShape
                    )
                    .padding(10.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "New",
                fontSize = 12.sp
            )
        }
    }
}

@Composable
fun StoryHighlightImage(
    image: Painter,
    modifier: Modifier = Modifier
) {
    Image(
        painter = image,
        contentDescription = null,
        modifier
            .aspectRatio(
                1f,
                matchHeightConstraintsFirst = true               // 1 параметр подгоняет высоту и ширину изображения до одинакового размера, 2 - если true, смотрит сначало на высоту, и делает ширину такой же, как и высота, с false наоборот
            )
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = CircleShape
            )
            .padding(3.dp)                                                 // делает расстояние между border и картинкой
            .clip(CircleShape)
    )
}



//@Composable
//fun HighlightSection(
//    modifier: Modifier = Modifier,
//    highlights: List<StoryHighlight>
//) {
//    LazyRow(
//        modifier = modifier
//    ) {
//        items(highlights.size) { index ->
//            Column(
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.Center,
//                modifier = Modifier.padding(end = 15.dp)
//            ) {
//                StoryHighlightImage(
//                    image = highlights[index].storyImage,
//                    modifier = Modifier.size(70.dp)
//                )
//                Text(
//                    text = highlights[index].storyTitle,
//                    overflow = TextOverflow.Ellipsis,
//                    textAlign = TextAlign.Center
//                )
//            }
//        }
//    }
//}

@Composable
fun PostTabView(
    modifier: Modifier = Modifier,
    content: List<ContentForRowOfTabs>,
    onTabSelected: (selectedIndex: Int) -> Unit
) {
    var selectedTabIndex by remember {                   // вначале будет выдавать ошибку. Чтобы исправить её нужно: скопировать зависимость от remember 2 раза и затем эти зависимости поменять на setValue и getValue
        mutableStateOf(0)
    }
    val inactiveColor = Color(0xFF777777)
    TabRow(
        selectedTabIndex = selectedTabIndex,
        backgroundColor = Color.Transparent,             // изменяет бэкграунд полоски выбора категории
        contentColor = Color.Black,                      // изменяет цвет нижней полоски
        modifier = modifier
    ) {
        content.forEachIndexed { index, item ->
            Tab(
                selected = selectedTabIndex == index,
                selectedContentColor = Color.Black,
                unselectedContentColor = inactiveColor,
                onClick = {
                    selectedTabIndex = index
                    onTabSelected(index)
                }
            ) {
                Icon(painter = item.tabImage,
                    contentDescription = item.tabTitle,
                    tint = if (selectedTabIndex == index) Color.Black else inactiveColor,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp)
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PostSection(
    posts: List<Painter>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        modifier = modifier.scale(1.01f)                     // увеличили масштаб картинок чтобы border был виден только между другими картинками, но не по бокам(border просто сдвигается за экран и его не видно)
    ) {
        items(posts.size) { index ->
            Image(
                painter = posts[index],
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(
                        width = 1.dp,
                        color = Color.White
                    )
            )
        }
    }
}