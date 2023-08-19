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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes2.model.Hero
import com.example.superheroes2.model.heroes
import com.example.superheroes2.ui.theme.Shapes
import com.example.superheroes2.ui.theme.SuperHeroes2Theme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

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
                    heroApp()
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
    modifier: Modifier,

    ) {
    Column(
        horizontalAlignment = Alignment.End
    ) {
        Image(
            painter = painterResource(image), contentDescription = null,
            modifier = modifier
                .size(64.dp)
                .padding(end = 8.dp, top = 8.dp)
                .clip(MaterialTheme.shapes.small),
            //  contentScale = ContentScale.Crop,
        )
    }
}

@Composable
fun heroname(@StringRes name: Int) {
    Text(
        text = stringResource(name),
        style = MaterialTheme.typography.displaySmall


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
            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.Start
            ) {

                heroname(name = HeroesRepository.nameRes)
                heroDescription(HeroesRepository.descriptionRes)
            }
            Column(
                horizontalAlignment = Alignment.End
            ) {

                //heroImage(image = HeroesRepository.imageRes)
                heroImage(
                    image = HeroesRepository.imageRes, modifier = Modifier
                )
            }
        }
    }

}

@Composable
fun heroApp() {

    LazyColumn {
        items(heroes) {
            hero(HeroesRepository = it)
        }
    }

}

@Preview
@Composable
fun heroPreview() {
    heroApp()

}