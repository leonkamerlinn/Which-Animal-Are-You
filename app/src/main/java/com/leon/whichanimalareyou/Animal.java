package com.leon.whichanimalareyou;

import android.support.annotation.NonNull;

import java.util.Arrays;

/**
 * Created by Leon on 9.1.2018..
 */

public class Animal implements Comparable<Animal> {
    private static final String NO_NAME = "";
    private static final int NO_RESOURCE_ID = Integer.MIN_VALUE;
    private final int[] mStats;
    private final String mName;
    private final int mResourceId;
    private final int mCaptionResourceId;

    public Animal(String name, int[] stats, int resourceId, int captionResourceId) {
        mStats = stats;
        mName = name;
        mResourceId = resourceId;
        mCaptionResourceId = captionResourceId;
    }

    public Animal(int[] stats) {
        mStats = stats;
        mName = NO_NAME;
        mResourceId = NO_RESOURCE_ID;
        mCaptionResourceId = NO_RESOURCE_ID;
    }

    public boolean hasName() {
        return (!getName().equals(NO_NAME));
    }

    public boolean hasResourceId() {
        return (getImageResourceId() != NO_RESOURCE_ID);
    }

    public int[] getStats() {
        return mStats;
    }

    public String getName() {
        return mName;
    }

    public int getImageResourceId() {
        return mResourceId;
    }
    public int getCaptionResourceId() {
        return mCaptionResourceId;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Animal) {
            Animal other = (Animal)obj;
            if (hasName() && hasResourceId()) {
                if (getName().equals(other.getName()) && Arrays.equals(getStats(), other.getStats()) && getImageResourceId() == other.getImageResourceId()) {
                    return true;
                }
            } else {
                return (compareTo(other) == 0);
            }

        }

        return false;
    }




    @Override
    public int compareTo(@NonNull Animal animal) {
        if (getStats().length != Data.getQuestions().size() || animal.getStats().length != Data.getQuestions().size()) {
            return -1;
        }

        int count = getStats().length;
        for(int i = 0; i < getStats().length; i++) {
            int thisState = getStats()[i];
            int otherState = animal.getStats()[i];
            if (thisState == otherState) {
                count--;
            }
        }

        return count;
    }
}
