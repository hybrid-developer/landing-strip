package com.novoda.landingstrip;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.util.AttributeSet;

class Attributes {

    @ColorRes
    private static final int DEFAULT_INDICATOR_COLOUR = R.color.ls__white;

    @DimenRes
    private static final int DEFAULT_INDICATOR_HEIGHT = R.dimen.ls__default_indicator_height;

    @DimenRes
    private static final int DEFAULT_TABS_PADDING = R.dimen.ls__default_tabs_container_padding;

    @ColorRes
    private final int indicatorColor;

    private final int indicatorHeight;
    private final int tabsPaddingLeft;
    private final int tabsPaddingRight;

    static Attributes readAttributes(Context context, AttributeSet attrs) {
        TypedArray xml = context.obtainStyledAttributes(attrs, R.styleable.LandingStrip);

        try {
            int indicatorColour = xml.getResourceId(R.styleable.LandingStrip_indicatorColor, DEFAULT_INDICATOR_COLOUR);
            int indicatorHeight = getDimensPixelSize(R.styleable.LandingStrip_indicatorHeight, DEFAULT_INDICATOR_HEIGHT, xml);
            int tabsPaddingLeft = getDimensPixelSize(R.styleable.LandingStrip_tabsLeftPadding, DEFAULT_TABS_PADDING, xml);
            int tabsPaddingRight = getDimensPixelSize(R.styleable.LandingStrip_tabsRightPadding, DEFAULT_TABS_PADDING, xml);

            return new Attributes(indicatorColour, indicatorHeight, tabsPaddingLeft, tabsPaddingRight);
        } finally {
            xml.recycle();
        }
    }

    private static int getDimensPixelSize(int styleIndex, @DimenRes int defaultSize, TypedArray attributes) {
        return attributes.getDimensionPixelSize(styleIndex, toPixelDimens(defaultSize, attributes.getResources()));

    }

    private static int toPixelDimens(@DimenRes int dimens, Resources resources) {
        return resources.getDimensionPixelSize(dimens);
    }

    Attributes(@ColorRes int indicatorColor, int indicatorHeight, int tabsPaddingLeft, int tabsPaddingRight) {
        this.indicatorColor = indicatorColor;
        this.indicatorHeight = indicatorHeight;
        this.tabsPaddingLeft = tabsPaddingLeft;
        this.tabsPaddingRight = tabsPaddingRight;
    }

    int getIndicatorColor() {
        return indicatorColor;
    }

    int getIndicatorHeight() {
        return indicatorHeight;
    }

    int getTabsPaddingLeft() {
        return tabsPaddingLeft;
    }

    int getTabsPaddingRight() {
        return tabsPaddingRight;
    }

}
