package com.example.fakedataapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fakedataapp.data.model.PostFakeDataItem
import com.example.fakedataapp.ui.screens.fakescreen.FakeError
import com.example.fakedataapp.ui.screens.fakescreen.FakeLoading
import com.example.fakedataapp.ui.theme.FakeDataAppTheme

/**
 * The main screen of the app.
 *
 * This is made up of the following:
 *
 * [HomeScreen] composable which will show the appropriate screen,
 * according to the data collection fails or success.
 *
 * [FakePostList] composable which uses a LazyColumn
 * to display a list of data fetched from the internet.
 *
 * [FakePostScreen] composable which will contain the data from the api.
 */
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    fakeState: UiState
) {
    when(fakeState) {
        is UiState.Success -> FakePostList(showFakeData = fakeState.fakeList, modifier = modifier)
        is UiState.Loading -> FakeLoading(modifier = modifier)
        is UiState.Error -> FakeError(modifier = modifier)
    }
}

@Composable
fun FakePostList(
    modifier: Modifier = Modifier,
    showFakeData: List<PostFakeDataItem>
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
    ) {
        items(showFakeData) { fakeApp ->
            FakePostScreen(onFakeData = fakeApp)
        }
    }
}

@Composable
fun FakePostScreen(
    modifier: Modifier = Modifier,
    onFakeData: PostFakeDataItem
) {
    Column(
        modifier = modifier
            .padding(top = 6.dp, start = 10.dp, end = 10.dp, bottom = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "UserId: ${onFakeData.userId}"
        )
        Text(
            text = "Id: ${onFakeData.id}"
        )
        Text(
            text = "Text: ${onFakeData.title}",
            textAlign = TextAlign.Justify
        )
        Text(
            text = "Body: ${onFakeData.body}",
            textAlign = TextAlign.Justify
        )
        Divider(thickness = 3.dp)
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewScreen() {
    FakeDataAppTheme {
        FakePostScreen(
            onFakeData = PostFakeDataItem(
                1,
                2,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
            )
        )
    }
}
