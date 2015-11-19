package cse.minorproject.guidepath;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Arihant Jain on 15/10/2015.
 */
public class Zoom extends View {

    private Drawable image;
    ImageButton img, img1;
    private int zoomController=20;

    public Zoom(Context context) {
        super(context);
        image=context.getResources().getDrawable(R.drawable.metro_logo);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        image.setBounds((getWidth() / 2) - zoomController, (getHeight() / 2) - zoomController, (getWidth() / 2) + zoomController, (getHeight() / 2) + zoomController);
        image.draw(canvas);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if(keyCode==KeyEvent.KEYCODE_DPAD_UP){
            zoomController+=10;
        }
        if(keyCode==KeyEvent.KEYCODE_DPAD_DOWN){
            zoomController-=10;
        }
        if(zoomController<10){
            zoomController=10;
        }
        invalidate();
        return true;
    }

}
