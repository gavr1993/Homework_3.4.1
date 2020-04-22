package com.example.homework_332;

import android.app.Activity;

public class Utils {
    private static int Theme;

    public final static int THEME_GREEN = 0;
    public final static int THEME_BLUE = 1;
    public final static int THEME_BLACK = 2;
    public static void changeToTheme(Activity activity, int theme) {
        Theme = theme;
        activity.recreate();
    }

    public static void onActivityCreateSetTheme(Activity activity) {
        switch (Theme) {
            default:
            case THEME_GREEN:
                activity.setTheme(R.style.ThemeGreen);
                break;
            case THEME_BLUE:
                activity.setTheme(R.style.ThemeBlue);
                break;
            case THEME_BLACK:
                activity.setTheme(R.style.ThemeBlack);
                break;
        }
    }
}