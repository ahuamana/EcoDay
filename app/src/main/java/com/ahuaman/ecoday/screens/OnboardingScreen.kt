package com.ahuaman.ecoday.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahuaman.ecoday.R
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import org.w3c.dom.Text

@Composable
fun OnboardingScreen(modifier: Modifier = Modifier, clickOnStart: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .scrollable(orientation = Orientation.Vertical,
                state = rememberScrollableState { delta -> delta }),
        verticalArrangement = Arrangement.Center) {
            //Content
            TopHeaderOnboarding()
            ContentOnboarding()
            Footer {
                clickOnStart()
            }
            //End Content
    }
}

@Composable
fun TopHeaderOnboarding(modifier: Modifier = Modifier, showLottie: Boolean = true) {

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.animation_eco_friendly))

    Row {
        if(showLottie){
            LottieAnimation(
                composition = composition,
                iterations = LottieConstants.IterateForever,
                modifier = modifier
                    .height(200.dp)
                    .clip(shape = RoundedCornerShape(16.dp)),

            )
        } else{
            Image(
                modifier = modifier
                    .fillMaxWidth()
                    .height(200.dp),
                painter = painterResource(id = R.drawable.ic_recycle), contentDescription = null)
        }
    }

}

@Composable
fun ContentOnboarding(modifier: Modifier = Modifier) {
    Column {
        Text(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
            fontSize = 42.sp,
            text = stringResource(R.string.welcome_message_onboarding),
            textAlign = TextAlign.Start,
            lineHeight = 48.sp,
            fontFamily = FontFamily(Font(R.font.opensans_bold)))

        Text(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
            fontSize = 13.sp,
            text = stringResource(R.string.onboarding_description),
            textAlign = TextAlign.Start,
            fontFamily = FontFamily(Font(R.font.opensans_regular)))

    }
}

@Composable
fun Footer(modifier: Modifier = Modifier, onClickStart: () -> Unit) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        onClick = {onClickStart() },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF4CAF50), // Use your custom color here
            contentColor = Color.White
        )
        ) {
        Text(text = stringResource(R.string.get_started))
    }
}


@Preview
@Composable
private fun OnboardingScreenPrev() {
    OnboardingScreen() {
        //Do nothing
    }
}