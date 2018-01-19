package com.leon.whichanimalareyou;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AnimalActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);

        Intent intent = getIntent();
        String caption = intent.getStringExtra(MainActivity.EXTRA_CAPTION);
        int[] selection = intent.getIntArrayExtra(MainActivity.EXTRA_SELECTION);

        ImageView imageView = findViewById(R.id.imageView);

        if (caption.isEmpty()) {
            caption = getResources().getString(R.string.short_text);
        }

        Animal animal = new Animal(selection);
        Animal choosenAnimal = null;

        if (Data.getAnimals().contains(animal)) {
            int index = Data.getAnimals().indexOf(animal);
            choosenAnimal = Data.getAnimals().get(index);
        } else {
            int similarity = Integer.MAX_VALUE;
            for(Animal anim: Data.getAnimals()) {
                if (anim.compareTo(animal) < similarity && anim.compareTo(animal) != -1) {
                    similarity = anim.compareTo(animal);
                    choosenAnimal = anim;
                }
            }
        }

        imageView.setImageDrawable(getResources().getDrawable(choosenAnimal.getImageResourceId()));
        TextView captionTextView = findViewById(choosenAnimal.getCaptionResourceId());
        captionTextView.setText(caption);
        captionTextView.setVisibility(View.VISIBLE);

        Toast.makeText(this, String.format("You are %s", choosenAnimal.getName()), Toast.LENGTH_LONG).show();




    }
}
