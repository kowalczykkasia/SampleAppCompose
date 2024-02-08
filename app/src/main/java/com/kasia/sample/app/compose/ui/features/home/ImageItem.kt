package com.kasia.sample.app.compose.ui.features.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.kasia.sample.app.compose.MainActivityViewModel
import com.kasia.sample.app.storage.models.Item

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ImageItem(item: Item, viewModel: MainActivityViewModel, onNavigateToDetails: () -> Unit, modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(4.dp), modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            GlideImage(model = item.url,
                contentDescription = "Image",
                modifier = Modifier
                    .clickable {
                        viewModel.onItemSelected(item)
                        onNavigateToDetails.invoke()
                    }
                    .align(Alignment.CenterHorizontally))

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = item.originalFilename,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 10.dp),
                fontWeight = FontWeight.Bold
            )
        }
    }
}