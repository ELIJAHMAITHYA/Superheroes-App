package com.example.superheroes2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes2.model.Hero
import com.example.superheroes2.model.heroes
import com.example.superheroes2.ui.theme.Shapes
import com.example.superheroes2.ui.theme.SuperHeroes2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperHeroes2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}


@Composable
fun heroDescription(@StringRes description: Int) {
    Text(
        text = stringResource(description),
        style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier
            .padding(start = 8.dp)

    )
}

@Composable
fun heroImage(
    @DrawableRes image: Int,
    modifier: Modifier = Modifier
        .size(64.dp)
        .padding(start = 8.dp, top = 8.dp, end = 8.dp, bottom = 8.dp)
        .clip(shape = Shapes.medium),

    ) {
    Image(
        painter = painterResource(image), contentDescription = null
    )
}

@Composable
fun heroname(@StringRes name: Int) {
    Text(
        text = stringResource(name),
        style = MaterialTheme.typography.displayMedium


    )
}

@Composable
fun hero(
    HeroesRepository: Hero,
    modifier: Modifier = Modifier
) {
    Card(modifier = Modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Column() {
                heroname(name = HeroesRepository.nameRes)
                heroDescription(HeroesRepository.descriptionRes)
            }
            heroImage(HeroesRepository.imageRes)

        }

    }

}

@Composable
fun heroApp() {
//    LazyColumn(contentPadding = it) {
//        items(dogs) {
//            DogItem(
//                dog = it,
//                modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
//            )
//        }
//    }
    LazyColumn {
        items(heroes){
            hero(HeroesRepository = it)
        }
    }

}

@Preview
@Composable
fun heroPreview() {

}