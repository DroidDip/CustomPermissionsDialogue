package stream.custompermissionsdialogue.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;

import eightbitlab.com.blurview.BlurView;
import eightbitlab.com.blurview.RenderScriptBlur;
import stream.custompermissionsdialogue.PermissionsDialogue;

public class CustomBlurDialogue extends BlurView {

    public CustomBlurDialogue(Context context) {
        super(context);
        init();
    }

    public CustomBlurDialogue(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        initCorners(context);
    }

    public CustomBlurDialogue(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        initCorners(context);
    }

    private void init() {

    }

    private void initCorners(Context context) {
            setRoundedCorners(PermissionsDialogue.Units.dpToPx(context, 15));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void create(View decorView, float radius) {

        ViewGroup rootView = decorView.findViewById(android.R.id.content);
        Drawable windowBackground = decorView.getBackground();

        setupWith(rootView)
                .windowBackground(windowBackground)
                .blurAlgorithm(new RenderScriptBlur(getContext()))
                .blurRadius(radius);
    }

    private void setRoundedCorners(int cornerRadius) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setBackground(new RoundedCornersDrawable(cornerRadius));
            setOutlineProvider(ViewOutlineProvider.BACKGROUND);
            setClipToOutline(true);
        }
    }
}