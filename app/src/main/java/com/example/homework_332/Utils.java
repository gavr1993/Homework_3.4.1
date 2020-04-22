package com.example.homework_332;

import android.app.Activity;

public class Utils {
    private static int Theme;

    public final static int THEME_GREEN = 0;
    public final static int THEME_BLUE = 1;
    public final static int THEME_BLACK = 2;
    public final static int SMALL = 3;
    public final static int MIDDLE = 4;
    public final static int LARGE = 5;

    public static void changeToTheme(Activity activity, int theme) {
        Theme = theme;
        activity.recreate();
    }

    public static void onActivityCreateSetTheme(Activity activity) {
        switch (Theme) {
            default:
            case SMALL:
                activity.setTheme(R.style.MarginS);
                break;
            case MIDDLE:
                activity.setTheme(R.style.MarginM);
                break;
            case LARGE:
                activity.setTheme(R.style.MarginL);
                break;
            case THEME_GREEN:
                activity.setTheme(R.style.ThemeGreen);
            case THEME_BLUE:
                activity.setTheme(R.style.ThemeBlue);
            case THEME_BLACK:
                activity.setTheme(R.style.ThemeBlack);
        }
    }
}