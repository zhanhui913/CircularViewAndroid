package com.zhan.library;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Zhan on 16-01-07.
 */
public class CircularView extends View {

    //Default values
    private final static int DEFAULT_BG_RADIUS = 50; //DP
    private final static int DEFAULT_BG_COLOR = R.color.black;
    private final static int DEFAULT_STROKE_WIDTH = 0; //DP
    private final static int DEFAULT_STROKE_COLOR = R.color.black;
    private final static int DEFAULT_STROKE_PADDING = 0; //DP
    private final static int DEFAULT_ICON_COLOR = R.color.white;
    private final static int DEFAULT_ICON_TOP_PADDING = 10; //DP
    private final static int DEFAULT_ICON_BOTTOM_PADDING = 10; //DP
    private final static int DEFAULT_ICON_LEFT_PADDING = 10; //DP
    private final static int DEFAULT_ICON_RIGHT_PADDING = 10; //DP
    private final static int DEFAULT_ICON = R.drawable.ic_smile;
    private final static int DEFAULT_TEXT_COLOR = R.color.white;
    private final static int DEFAULT_TEXT_SIZE = 20; // DP

    private Context context;
    private int circleRadius; //pixels
    private int circleColor;
    private int strokeWidth;  //pixels
    private int strokeColor;
    private int strokePadding; //pixels
    private int iconColor;
    private Drawable iconDrawable;
    private int icon;


    private int iconTopPadding; //pixels
    private int iconBottomPadding; //pixels
    private int iconLeftPadding; //pixels
    private int iconRightPadding; //pixels

    private String text;
    private int textColor;
    private int textSize; //pixels


    private Paint paint;

    public CircularView(Context context) {
        super(context);
        init(context, null, 0, 0);
    }

    public CircularView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0, 0);
    }

    public CircularView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr, 0);
    }

    public CircularView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes){
        this.context = context;

        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.CircularView, 0, 0);
        try{
            circleRadius = a.getDimensionPixelSize(R.styleable.CircularView_cv_bgRadius, dpToPx(DEFAULT_BG_RADIUS));
            circleColor = a.getColor(R.styleable.CircularView_cv_bgColor, ContextCompat.getColor(this.context, DEFAULT_BG_COLOR));
            strokeWidth = a.getDimensionPixelSize(R.styleable.CircularView_cv_strokeWidth, dpToPx(DEFAULT_STROKE_WIDTH));
            strokeColor = a.getColor(R.styleable.CircularView_cv_strokeColor, ContextCompat.getColor(this.context, DEFAULT_STROKE_COLOR));
            strokePadding = a.getDimensionPixelSize(R.styleable.CircularView_cv_strokePadding, dpToPx(DEFAULT_STROKE_PADDING));
            //icon = a.getResourceId(R.styleable.CircularView_cv_iconDrawable, DEFAULT_ICON);
            iconDrawable = a.getDrawable(R.styleable.CircularView_cv_iconDrawable);
            iconColor = a.getColor(R.styleable.CircularView_cv_iconColor, ContextCompat.getColor(this.context, DEFAULT_ICON_COLOR));
            iconTopPadding = a.getDimensionPixelSize(R.styleable.CircularView_cv_iconTopPadding, dpToPx(DEFAULT_ICON_TOP_PADDING));
            iconBottomPadding = a.getDimensionPixelSize(R.styleable.CircularView_cv_iconBottomPadding, dpToPx(DEFAULT_ICON_BOTTOM_PADDING));
            iconLeftPadding = a.getDimensionPixelSize(R.styleable.CircularView_cv_iconLeftPadding, dpToPx(DEFAULT_ICON_LEFT_PADDING));
            iconRightPadding = a.getDimensionPixelSize(R.styleable.CircularView_cv_iconRightPadding, dpToPx(DEFAULT_ICON_RIGHT_PADDING));

            text = a.getString(R.styleable.CircularView_cv_text);
            textColor = a.getColor(R.styleable.CircularView_cv_textColor, ContextCompat.getColor(this.context, DEFAULT_TEXT_COLOR));
            textSize = a.getDimensionPixelSize(R.styleable.CircularView_cv_textSize, dpToPx(DEFAULT_TEXT_SIZE));
        }finally {
            a.recycle();
        }

        paint = new Paint();
        paint.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int ss = ((strokeWidth + strokePadding) * 2);

        int desiredWidth = (circleRadius * 2) + ss;
        int desiredHeight = (circleRadius * 2) + ss;

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width;
        int height;

        //Measure Width
        if (widthMode == MeasureSpec.EXACTLY) { //specific value
            //Must be this size
            width = widthSize;
        } else if (widthMode == MeasureSpec.AT_MOST) { //match parent
            //Can't be bigger than...
            width = Math.min(desiredWidth, widthSize);
        } else { //wrap content
            //Be whatever you want
            width = desiredWidth;
        }

        //Measure Height
        if (heightMode == MeasureSpec.EXACTLY) {
            //Must be this size
            height = heightSize;
        } else if (heightMode == MeasureSpec.AT_MOST) {
            //Can't be bigger than...
            height = Math.min(desiredHeight, heightSize);
        } else {
            //Be whatever you want
            height = desiredHeight;
        }

        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int viewWidthHalf = this.getWidth() / 2;
        int viewHeightHalf = this.getHeight() / 2;

        drawCircle(canvas, circleRadius, viewWidthHalf, viewHeightHalf);

        if(icon != 0){
            drawIcon(canvas);
        }else if(text != null && !text.isEmpty()){
            drawText(canvas);
        }
    }

    private void drawCircle(Canvas canvas, int radius, int width, int height){
        if(Math.round(strokeWidth) > 0) { //If there's stroke defined
            //Paint the stroke
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(strokeColor);
            paint.setStrokeWidth(strokeWidth);
            canvas.drawCircle(width, height, radius + strokePadding + (strokeWidth / 2), paint);
        }

        //Paint the inner circle
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(circleColor);
        canvas.drawCircle(width, height, radius, paint);
    }

    private void drawIcon(Canvas canvas){
        //iconDrawable = ResourcesCompat.getDrawable(context.getResources(), icon, context.getTheme());

        if(icon != 0){
            iconDrawable = ResourcesCompat.getDrawable(context.getResources(), icon, context.getTheme());
        }

        if(iconDrawable != null){
            Rect bounds = canvas.getClipBounds();

            bounds.left += (iconLeftPadding + strokeWidth + strokePadding);
            bounds.right -= (iconRightPadding + strokeWidth + strokePadding);
            bounds.top += (iconTopPadding + strokeWidth + strokePadding);
            bounds.bottom -= (iconBottomPadding + strokeWidth + strokePadding);

            iconDrawable.setBounds(bounds);
            iconDrawable.mutate().setColorFilter(iconColor, PorterDuff.Mode.SRC_IN);
            iconDrawable.draw(canvas);
        }
    }

    private void drawText(Canvas canvas){
        if(!text.isEmpty()){
            paint.setTextSize(textSize);
            paint.setColor(textColor);
            paint.setTextAlign(Paint.Align.CENTER);


            Paint.FontMetrics metrics = paint.getFontMetrics();
            float height = Math.abs(metrics.top - metrics.bottom);
            float x = getWidth() / 2;
            float y = (getHeight() / 2) + (height / 4);

            canvas.drawText(text, x, y, paint);
            canvas.restore();
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // Getters & Setters
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////
    // Circle
    //////////////////////////////////////////////////////

    /**
     * Retrieve the circle's radius in dp
     * @return the circle's radius in dp
     */
    public int getCircleRadiusInDP() {
        return pxToDp(circleRadius);
    }

    /**
     * Retrieve the circle's radius in px
     * @return the circle's radius in px
     */
    public int getCircleRadiusInPX(){
        return this.circleRadius;
    }

    /**
     * Set the circle's radius using dp format
     * @param dp the intended new circle radius in dp format
     */
    public void setCircleRadiusInDP(int dp) {
        this.circleRadius = dpToPx(dp);
        requestLayout();
        invalidate();
    }

    /**
     * Set the circle's radius using px format
     * @param px the intended new circle radius in dp format
     */
    public void setCircleRadiusInPX(int px){
        this.circleRadius = px;
        requestLayout();
        invalidate();
    }

    /**
     * Retrieve the circle's background color in R.color format
     * @return R.color format in int
     */
    public int getCircleColor() {
        return circleColor;
    }

    /**
     * Set the circle's background color using R.color format
     * @param circleColor the intended new circle background color
     */
    public void setCircleColor( int circleColor) {
        this.circleColor = ContextCompat.getColor(getContext(), circleColor);
        invalidate();
    }

    //////////////////////////////////////////////////////
    // Stroke
    //////////////////////////////////////////////////////

    /**
     * Retrieve the circle's stroke width in dp
     * @return the circle's stroke width in dp
     */
    public int getStrokeWidthInDP() {
        return pxToDp(strokeWidth);
    }

    /**
     * Retrieve the circle's stroke width in px
     * @return the circle's stroke width in px
     */
    public int getStrokeWidthInPX() {
        return this.strokeWidth;
    }

    /**
     * Set the circle's stroke width using dp format
     * @param dp the intended new circle stroke in dp format
     */
    public void setStrokeWidthInDP(int dp) {
        this.strokeWidth = dpToPx(dp);
        requestLayout();
        invalidate();
    }

    /**
     * Set the circle's stroke width using px format
     * @param px the intended new circle stroke in px format
     */
    public void setStrokeWidthInPX(int px) {
        this.strokeWidth = px;
        requestLayout();
        invalidate();
    }

    /**
     * Retrieve the circle's stroke color in R.color format
     * @return R.color format in int
     */
    public int getStrokeColor() {
        return strokeColor;
    }

    /**
     * Set the circle's stroke color using R.color format
     * @param strokeColor the intended new circle stroke color
     */
    public void setStrokeColor(int strokeColor) {
        this.strokeColor = ContextCompat.getColor(getContext(), strokeColor);
        invalidate();
    }

    /**
     * Retrieve the circle's stroke padding width in dp
     * @return the circle's stroke padding width in dp
     */
    public int getStrokePaddingInDP() {
        return pxToDp(strokePadding);
    }

    /**
     * Retrieve the circle's stroke padding width in px
     * @return the circle's stroke padding width in px
     */
    public int getStrokePaddingInPX() {
        return this.strokePadding;
    }

    /**
     * Set the circle's stroke padding width using dp format
     * @param dp the intended new circle stroke padding in dp format
     */
    public void setStrokePaddingInDP(int dp) {
        this.strokePadding = dpToPx(dp);
        requestLayout();
        invalidate();
    }

    /**
     * Set the circle's stroke padding width using px format
     * @param px the intended new circle stroke padding in px format
     */
    public void setStrokePaddingInPX(int px) {
        this.strokePadding = px;
        requestLayout();
        invalidate();
    }

    //////////////////////////////////////////////////////
    // Icon
    //////////////////////////////////////////////////////

    /**
     * Retrieve the icon's color in R.color format
     * @return R.color format in int
     */
    public int getIconColor() {
        return iconColor;
    }

    /**
     * Set the icon color using R.color format
     * @param iconColor the intended new icon color
     */
    public void setIconColor(int iconColor) {
        this.iconColor = ContextCompat.getColor(getContext(), iconColor);
        invalidate();
    }

    /**
     * Retrieve the icon's resource in R.drawable format
     * @return R.drawable format in int
     */
    public int getIconResource(){
        return this.icon;
    }

    /**
     * Set the icon resource using R.drawable format
     * @param icon the intended new icon resource
     */
    public void setIconResource(int icon){
        this.icon = icon;
        invalidate();
    }

    //////////////////////////////////////////////////////
    // Icon Padding
    //////////////////////////////////////////////////////

    /**
     * Retrieve the icon's top padding in dp
     * @return the icon's top padding in dp
     */
    public int getIconTopPaddingInDP() {
        return pxToDp(iconTopPadding);
    }

    /**
     * Set the icon's top padding using dp format
     * @param dp the intended new icon's top padding in dp format
     */
    public void setIconTopPaddingInDP(int dp) {
        this.iconTopPadding = dpToPx(dp);
        invalidate();
    }

    /**
     * Retrieve the icon's top padding in px
     * @return the icon's top padding in px
     */
    public int getIconTopPaddingInPX() {
        return this.iconTopPadding;
    }

    /**
     * Set the icon's top padding using px format
     * @param px the intended new icon's top padding in px format
     */
    public void setIconTopPaddingInPX(int px) {
        this.iconTopPadding = px;
        invalidate();
    }

    /**
     * Retrieve the icon's bottom padding in dp
     * @return the icon's bottom padding in dp
     */
    public int getIconBottomPaddingInDP() {
        return pxToDp(iconBottomPadding);
    }

    /**
     * Set the icon's bottom padding using dp format
     * @param dp the intended new icon's bottom padding in dp format
     */
    public void setIconBottomPaddingInDP(int dp) {
        this.iconBottomPadding = dpToPx(dp);
        invalidate();
    }

    /**
     * Retrieve the icon's bottom padding in px
     * @return the icon's bottom padding in px
     */
    public int getIconBottomPaddingInPX() {
        return this.iconBottomPadding;
    }

    /**
     * Set the icon's bottom padding using px format
     * @param px the intended new icon's bottom padding in px format
     */
    public void setIconBottomPaddingInPX(int px) {
        this.iconBottomPadding = px;
        invalidate();
    }

    /**
     * Retrieve the icon's left padding in dp
     * @return the icon's left padding in dp
     */
    public int getIconLeftPaddingInDP() {
        return pxToDp(iconLeftPadding);
    }

    /**
     * Set the icon's left padding using dp format
     * @param dp the intended new icon's left padding in dp format
     */
    public void setIconLeftPaddingInDP(int dp) {
        this.iconLeftPadding = dpToPx(dp);
        invalidate();
    }

    /**
     * Retrieve the icon's left padding in px
     * @return the icon's left padding in px
     */
    public int getIconLeftPaddingInPX() {
        return this.iconLeftPadding;
    }

    /**
     * Set the icon's left padding using px format
     * @param px the intended new icon's left padding in px format
     */
    public void setIconLeftPaddingInPX(int px) {
        this.iconLeftPadding = px;
        invalidate();
    }

    /**
     * Retrieve the icon's right padding in dp
     * @return the icon's right padding in dp
     */
    public int getIconRightPaddingInDP() {
        return pxToDp(iconRightPadding);
    }

    /**
     * Set the icon's right padding using dp format
     * @param dp the intended new icon's right padding in dp format
     */
    public void setIconRightPaddingInDP(int dp) {
        this.iconRightPadding = dpToPx(dp);
        invalidate();
    }

    /**
     * Retrieve the icon's right padding in px
     * @return the icon's right padding in px
     */
    public int getIconRightPaddingInPX() {
        return this.iconRightPadding;
    }

    /**
     * Set the icon's right padding using px format
     * @param px the intended new icon's right padding in px format
     */
    public void setIconRightPaddingInPX(int px) {
        this.iconRightPadding = px;
        invalidate();
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = ContextCompat.getColor(getContext(), textColor);
        invalidate();
    }

    public int getTextSize() {
        return pxToDp(textSize);
    }

    public void setTextSize(int dp) {
        this.textSize = dpToPx(dp);
        invalidate();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // Etc
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////

    private int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    private int pxToDp(int px) {
        return (int) (px / Resources.getSystem().getDisplayMetrics().density);
    }
}
