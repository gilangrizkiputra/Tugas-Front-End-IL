package com.example.gilangtugasfrontend.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gilangtugasfrontend.R
import com.example.gilangtugasfrontend.model.RumahAdat
import com.example.gilangtugasfrontend.ui.theme.GilangTugasFrontEndTheme

@Composable
fun RumahAdatItem(
    rumahAdat: RumahAdat,
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit
) {
    Surface(
        modifier = modifier
            .clickable { onItemClicked(rumahAdat.id) },
        color = MaterialTheme.colorScheme.surface,
        shadowElevation = 4.dp,
        shape = MaterialTheme.shapes.small
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .padding(0.dp)
                .clickable {
                    onItemClicked(rumahAdat.id)
                }
        ) {
            Image(
                painter = painterResource(id = rumahAdat.photo),
                contentDescription = rumahAdat.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(shape = RectangleShape)
                    .size(80.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = rumahAdat.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = 16.sp)
                Row {
                    Text(text = "Daerah : ${rumahAdat.daerah}",
                        color = Color.Black)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RumahAdatItemPreview() {
    GilangTugasFrontEndTheme {
        RumahAdatItem(
            rumahAdat = RumahAdat(1, "Rumah Adat Krong Bade", "Aceh", R.string.desk_krong_bade, R.drawable.krong_bade),
            onItemClicked = { menteeId ->
                println("Makanan Tradisional Id : $menteeId")
            }
        )
    }
}