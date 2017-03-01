package com.iddamal.min.timetable;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.graphics.Palette;

public class BackgroundGenerator {

    private Context mContext;

    public BackgroundGenerator(Context context) {
        this.mContext = context;
    }

    // Drawables have to be passed in using their integer identifiers
    public void createColours(int drawableRefInt) {
        Bitmap mBitmap = BitmapFactory.decodeResource(mContext.getResources(), drawableRefInt);
        Palette mPalette = Palette.from(mBitmap).generate();
        PaletteStorage.putPaletteHashMap(drawableRefInt, mPalette);
    }
}
