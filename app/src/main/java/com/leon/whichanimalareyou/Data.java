package com.leon.whichanimalareyou;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Leon on 9.1.2018..
 */

public class Data {

    public static List<String> getQuestions() {
        List<String> questions = new ArrayList<>();
        questions.add("I would kill for some food right now");
        questions.add("I need a LOT of sleep or I feel cranky");
        questions.add("I can't live without water");
        questions.add("You won't like me when I'm angry");
        questions.add("Eating is my life");
        questions.add("I love cuddling");
        questions.add("Stay away from my nuts!");
        questions.add("I need my beauty sleep");


        return questions;
    }

    public static List<Animal> getAnimals() {
        ArrayList<Animal> animalList = new ArrayList<>();
        animalList.add(new Animal("butterfly",new int[]{0,4,0,0,0,0,0,4},R.drawable.butterfly,R.id.butterfly_caption));
        animalList.add(new Animal("dolphin",new int[]{3,0,4,2,2,2,0,0},R.drawable.dolphin,R.id.dolphin_caption));
        animalList.add(new Animal("elephant",new int[]{0,2,2,2,3,0,0,1},R.drawable.elephant,R.id.elephant_caption));
        animalList.add(new Animal("flamingo",new int[]{2,2,1,1,1,0,0,2},R.drawable.flamingo,R.id.flamingo_caption));
        animalList.add(new Animal("jellyfish",new int[]{0,0,4,3,0,0,0,0},R.drawable.jellyfish,R.id.jellyfish_caption));
        animalList.add(new Animal("lion",new int[]{4,2,2,4,2,2,0,2},R.drawable.lion,R.id.lion_caption));
        animalList.add(new Animal("monkey",new int[]{0,2,1,1,2,1,0,2},R.drawable.monkey,R.id.monkey_caption));
        animalList.add(new Animal("red panda",new int[]{0,3,1,1,4,0,0,3},R.drawable.redpanda,R.id.redpanda_caption));
        animalList.add(new Animal("squirrel",new int[]{0,1,1,0,3,0,4,1},R.drawable.squirrel,R.id.butterfly_caption));
        animalList.add(new Animal("teddy bear",new int[]{0,4,0,0,0,4,0,4},R.drawable.teddybear,R.id.teddybear_caption));
        animalList.add(new Animal("tiger",new int[]{4,2,2,4,2,1,0,1},R.drawable.tiger,R.id.tiger_caption));

        return animalList;
    }



}
