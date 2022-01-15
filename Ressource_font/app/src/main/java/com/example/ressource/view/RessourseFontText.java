package com.example.ressource.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;



public class RessourseFontText extends AppCompatTextView {
    public RessourseFontText(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.addStyleOnTextView(context, attrs );
    }

    public RessourseFontText(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.addStyleOnTextView( context, attrs );
    }



    public void addStyleOnTextView ( Context context, AttributeSet attributeSet ) {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/chickenslovers.ttf");
        setTypeface( typeface );
    }


}
