package com.example.gilangtugasfrontend.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gilangtugasfrontend.R
import com.example.gilangtugasfrontend.model.MusikTradisional
import com.example.gilangtugasfrontend.ui.theme.GilangTugasFrontEndTheme

@Composable
fun MusikTradisionalItem(
    musikTradisional: MusikTradisional,
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit
) {
    Surface(
        modifier = modifier
            .clickable { onItemClicked(musikTradisional.id) }
            .size(width = 160.dp, height = 180.dp),
        color = MaterialTheme.colorScheme.surface,
        shadowElevation = 4.dp,
        shape = MaterialTheme.shapes.small
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = musikTradisional.photo),
                contentDescription = musikTradisional.name,
                modifier = Modifier
                    .clip(shape = RectangleShape)
            )
            Text(
                text = musikTradisional.name,
                fontSize = 16.sp,
                style = MaterialTheme.typography.titleMedium,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Start,
                modifier = Modifier.width(140.dp).padding(top = 16.dp),
                maxLines = 1
            )
            Text(
                text = "Daerah : ${musikTradisional.daerah}",
                fontSize = 14.sp,
                color = Color.Black,
                overflow = TextOverflow.Visible,
                modifier = Modifier.width(140.dp),
                maxLines = 1
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MusikTradisionalItemHorizontalPreview() {
    GilangTugasFrontEndTheme {
        MusikTradisionalItem(
            musikTradisional = MusikTradisional(
                1,
                "Angklung",
                "Jawa Barat",
                R.string.desk_angklung,
                R.drawable.angklung),
            onItemClicked = { musikTradisionalId ->
                println("Makanan Tradisional Id : $musikTradisionalId")
            }
        )
    }
}