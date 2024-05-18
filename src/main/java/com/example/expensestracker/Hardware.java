package com.example.expensestracker;

import javafx.scene.media.AudioClip;

import java.util.Objects;

public class Hardware {
    public static void playButtonSoundEffect() {
        try {
            // Loading the sound file
            AudioClip sound = new AudioClip(Objects.requireNonNull(Hardware.class.getResource("clicksoundeffect.mp3")).toString());

            // Playing the sound
            sound.play();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions (e.g., file not found)
        }
    }
}
