package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw4.R;

public class Practice09MatrixRotateView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);
    Matrix matrix1 = new Matrix();
    Matrix matrix2 = new Matrix();
    float bitmapWidth, bitmapHeight;

    public Practice09MatrixRotateView(Context context) {
        super(context);
    }

    public Practice09MatrixRotateView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice09MatrixRotateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
        bitmapWidth = bitmap.getWidth();
        bitmapHeight = bitmap.getHeight();
        matrix1.postRotate(180, point1.x + bitmapWidth / 2, point1.y + bitmapHeight / 2);
        matrix2.postRotate(45, point2.x + bitmapWidth / 2, point2.y + bitmapHeight / 2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        canvas.setMatrix(matrix1);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();

        canvas.save();
        canvas.setMatrix(matrix2);
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        canvas.restore();
    }
}
