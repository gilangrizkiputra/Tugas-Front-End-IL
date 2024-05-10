package com.example.gilangtugasfrontend.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gilangtugasfrontend.R
import com.example.gilangtugasfrontend.model.MakananTradisional
import com.example.gilangtugasfrontend.ui.theme.GilangTugasFrontEndTheme

@Composable
fun MakananTradisionalItem(
    makananTradisional: MakananTradisional,
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit
) {
    Surface(
        modifier = modifier
            .clickable { onItemClicked(makananTradisional.id) },
        color = MaterialTheme.colorScheme.surface,
        shadowElevation = 4.dp,
        shape = MaterialTheme.shapes.small
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clickable {
                    onItemClicked(makananTradisional.id)
                }
        ) {
            Image(
                painter = painterResource(id = makananTradisional.photo),
                contentDescription = makananTradisional.name,
                modifier = Modifier
                    .clip(shape = RectangleShape)
            )
            Text(
                text = makananTradisional.name,
                fontSize = 18.sp,
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Start,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            )
            Text(
                text = makananTradisional.daerah,
                fontSize = 14.sp,
                color = Color.Black,
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
    }

@Preview
@Composable
private fun MakananTradisionalItemPreview() {
    GilangTugasFrontEndTheme {
        MakananTradisionalItem(
            makananTradisional = MakananTradisional(
                1,
                "Mi Aceh",
                "Aceh",
                R.string.desk_mi_aceh,
                R.drawable.mi_aceh
            ),
            onItemClicked = { makananTradisionalId ->
                println("Makanan Tradisional Id : $makananTradisionalId")
            }
        )
    }
}
