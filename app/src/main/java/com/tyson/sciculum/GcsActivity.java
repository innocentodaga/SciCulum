package com.tyson.sciculum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class GcsActivity extends AppCompatActivity {
    private ImageSlider imageSlider;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gcs);

        imageView = findViewById(R.id.back_icon);
        imageSlider = findViewById(R.id.image_slider);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(GcsActivity.this, HomeActivity.class);
                startActivity(back);
            }
        });


        //creating a list of the images
        ArrayList<SlideModel> sliderModels = new ArrayList<>();

        //the different sources of the images
        sliderModels.add(new SlideModel("https://i.pinimg.com/236x/cc/c9/c6/ccc9c695b9ecfad38fbc83294466753e.jpg", ScaleTypes.FIT));
        sliderModels.add(new SlideModel("https://i.pinimg.com/236x/93/62/bb/9362bbb0260d95c975262ff220057b52.jpg", ScaleTypes.FIT));
        sliderModels.add(new SlideModel("https://i.pinimg.com/236x/b0/f5/8e/b0f58e19949af2c0c23604dc0b58c22a.jpg", ScaleTypes.FIT));
        sliderModels.add(new SlideModel("https://i.pinimg.com/236x/82/53/f4/8253f46af6e9eaa5699b8bf1387653e9.jpg", ScaleTypes.FIT));
        sliderModels.add(new SlideModel("https://i.pinimg.com/236x/d4/c9/b7/d4c9b7b4e4828e0227eb82f45332e7d7.jpg", ScaleTypes.FIT));

        imageSlider.setImageList(sliderModels, ScaleTypes.FIT);
    }
}