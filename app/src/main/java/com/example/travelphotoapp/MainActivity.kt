package com.example.travelphotoapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.travelphotoapp.ui.theme.TravelPhotoAppTheme

class MainActivity : ComponentActivity() {
    //currentImage keeps the track of image number we are currently at:
    var currentImage = 0;
    //lateinit is used when you don't want to initialise the value of a variable now:
    lateinit var image : ImageView;
    //Array of name of places to update the textView accordingly:
    var arrayPlacesNames = arrayOf(
        "Dalma Wildlife Sanctuary","Jubilee Park","Modi Park","Russy Modi Center of Excellence",
        "Narva Ghat"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);
        //Target the two buttons and store it in a variable:
        val nextButton = findViewById<ImageButton>(R.id.buttonNext);
        val prevButton = findViewById<ImageButton>(R.id.buttonPrev);
        val placeName = findViewById<TextView>(R.id.tvPlaceName);

        nextButton.setOnClickListener {
            //Change the image and textView values to next corresponding element:
            //Get the current Image Id:
            var currentImageIdString = "pic$currentImage";

            //Get the integer image id associated with the image view:
            var currentImageIdInt = this.resources.getIdentifier(currentImageIdString , "id" , packageName);

            //Using the currentImageId we have to hide the current image(using alpha = 0) and
            //make the next or previous image visible accordingly:

            //Fetching the current image:
            image = findViewById(currentImageIdInt);

            //hide the current image:
            image.alpha = 0f;

            //Making the next image visible:

            //Update the current image value in such a way that if we are at last image and click the
            //next button we get redirected to 0th image:
            currentImage = (5 + currentImage + 1) % 5;

            //Get the next Image Id:
            var nextImageIdString = "pic$currentImage";

            //Get the integer image address associated with the image view:
            var nextImageIdInt = this.resources.getIdentifier(nextImageIdString , "id" , packageName);

            //Fetching the next image:
            image = findViewById(nextImageIdInt);

            //make the next image visible:
            image.alpha = 1f;

            //Update the place name textView:
            placeName.text = arrayPlacesNames[currentImage];
        }

        prevButton.setOnClickListener {
            //Change the image and textView values to next corresponding element:
            //Change the image and textView values to next corresponding element:
            //Get the current Image Id:
            var currentImageIdString = "pic$currentImage";

            //Get the integer image id associated with the image view:
            var currentImageIdInt = this.resources.getIdentifier(currentImageIdString , "id" , packageName);

            //Using the currentImageId we have to hide the current image(using alpha = 0) and
            //make the next or previous image visible accordingly:

            //Fetching the current image:
            image = findViewById(currentImageIdInt);

            //hide the current image:
            image.alpha = 0f;

            //Making the next image visible:

            //Update the current image value in such a way that if we are at 0th image and click the
            //prev button we get redirected to last image:
            currentImage = (5 + currentImage - 1) % 5;

            //Get the next Image Id:
            var prevImageIdString = "pic$currentImage";

            //Get the integer image address associated with the image view:
            var prevImageIdInt = this.resources.getIdentifier(prevImageIdString , "id" , packageName);

            //Fetching the next image:
            image = findViewById(prevImageIdInt);

            //make the next image visible:
            image.alpha = 1f;

            //Update the place name textView:
            placeName.text = arrayPlacesNames[currentImage];
        }
    }
}
