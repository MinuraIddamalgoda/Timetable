package com.iddamal.min.timetable;

import android.support.v7.graphics.Palette;

import java.util.HashMap;

public class PaletteStorage {

    private static HashMap<Integer, Palette> sPaletteHashMap = new HashMap<>();

    public static Palette getPaletteHashMapInt(int key) {
        return sPaletteHashMap.get(key);
    }

    public static void putPaletteHashMap(Integer key, Palette value) {
        sPaletteHashMap.put(key, value);
    }
}
