package com.example.edkalchallenge;


import java.util.HashSet;
import java.util.Set;

/**
 * Class that changes the LED light on the device
 */
public class LedManager {
    //testing variables
    private Set<LedColor2> currentLedColors;
    private int currentBrightness;
    //testing variables end

    /**
     * Calls the "3rd party API" and sets the passed in {@link} to the passed in {@link LedColor2}s to the specified brightness.
     *
     * @param ledColors    The colors you want the led light to be (colors are combined to form new colors (All colors together form white for example)). Should be a non-null, and non-empty set. Each entry should be non-null.
     * @param brightness   The brightness level the led light should be. Should be greater than zero.
     */
    protected void setLedColors(final Set<LedColor2> ledColors, final int brightness){
        //Set the current led colors and current brightness to what is passed in.
        //In a real implementation, the method would call the 3rd party API to invoke the change.
    }

    /**
     * Gets the current LED colors that are being displayed. NOTE: This method is visible for testing purposes only.
     * @return The colors that are currently being used. Should be non-null and non-empty. Each entry should be non-null.
     */
    public Set<LedColor2> getCurrentLedColors() {
        return new HashSet<>(currentLedColors);
    }

    /**
     * Gets the current brightness level. NOTE: This method is visible for testing purposes only.
     * @return An integer indicating the brightness of the LED light. This should be greater than zero.
     */
    public int getCurrentBrightness() {
        return currentBrightness;
    }
}
