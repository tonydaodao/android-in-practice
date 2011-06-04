/**
 * 
 */
package com.manning.aip.canvasdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.view.View;

/**
 * View to display a LHX type intro
 * 
 * @author tamas
 * 
 */
public class ShapesAndTextView extends View {

   public ShapesAndTextView(Context context) {
      super(context);
      // Loading up the font
      font = Typeface.createFromAsset(context.getAssets(), "256bytes.ttf");
      // loading the bitmap
      bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.copter);
   }

   private Paint paint;
   private Typeface font;
   private Bitmap bitmap;

   @Override
   protected void onDraw(Canvas canvas) {
      canvas.drawRGB(0, 0, 0); // #1
      drawShapes(canvas); // #2
      drawText(canvas); // #3
      drawBitmap(canvas); // #4
      invalidate(); // #5
   }

   private void drawShapes(Canvas canvas) {
      // draw a red square, a green circle and blue triangle in the
      // bottom part of the screen
      int side = canvas.getWidth() / 5;
      paint = new Paint();
      paint.setARGB(255, 255, 0, 0);
      canvas.drawRect(side, canvas.getHeight() - 60 - side, side + side, getHeight() - 60, paint);
      paint.setARGB(255, 0, 255, 0);
      canvas.drawCircle(side * 2 + side / 2, canvas.getHeight() - 60 - side / 2, side / 2, paint);
      paint.setARGB(255, 0, 0, 255);
      paint.setStyle(Paint.Style.FILL);
      Path triangle = new Path();
      triangle.moveTo(side * 3 + 30, canvas.getHeight() - 60 - side);
      triangle.lineTo(side * 3 + 60, canvas.getHeight() - 60);
      triangle.lineTo(side * 3, canvas.getHeight() - 60);
      triangle.lineTo(side * 3 + 30, canvas.getHeight() - 60 - side);
      canvas.drawPath(triangle, paint);
   }

   private void drawText(Canvas canvas) {
      String text = "256 byte Style";
      paint.setColor(Color.WHITE);
      paint.setTextSize(40);
      paint.setTypeface(font);
      canvas.drawText(text, 50, canvas.getHeight() - 20, paint);
   }

   private void drawBitmap(Canvas canvas) {
      paint = new Paint();
      canvas.drawBitmap(bitmap, 0, 0, paint);
   }
}
