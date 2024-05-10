package com.example.gilangtugasfrontend.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.gilangtugasfrontend.data.ListData
import com.example.gilangtugasfrontend.model.MakananTradisional
import com.example.gilangtugasfrontend.model.MusikTradisional
import com.example.gilangtugasfrontend.navigation.Screen

@Composable
fun DetailMakananTradisionalScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    makananTradisionalId: Int?
) {
    val newMakananTradisionalList = ListData.makananTradisionalIndonesia.filter { makananTradisional ->
        makananTradisional.id == makananTradisionalId
    }
    Column(
        modifier = modifier
    ) {
        DetailMakananTradisionalContent(newMakananTradisionalList = newMakananTradisionalList)
    }
}

@Composable
private fun DetailMakananTradisionalContent(
    newMakananTradisionalList: List<MakananTradisional>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(16.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(data = newMakananTradisionalList[0].photo)
                .build(),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(height = 200.dp, width = 400.dp)
                .clip(RoundedCornerShape(16.dp)),
            contentDescription = "Poster Movie"
        )
        Text(
            text = newMakananTradisionalList[0].name,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(
            text = "Daerah Asal : ${newMakananTradisionalList[0].daerah}",
            fontSize = 16.sp,
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier.padding(top = 1.dp)
        )
        Text(
            text = "Deskripsi",
            fontSize = 19.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
        )
        Text(
            text = "${stringResource(id = newMakananTradisionalList[0].desk)}",
            style = MaterialTheme.typography.titleSmall,
        )

    }
}

@Preview(showBackground = true)
@Composable
private fun DetailMakananTradisionalContentPreview() {
    DetailMakananTradisionalContent(newMakananTradisionalList = ListData.makananTradisionalIndonesia)
}