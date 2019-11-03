## NePaintColorFilter

### 1. 颜色过滤器
#### 1.1 示意图如下：  
![image](https://github.com/tianyalu/NePaintColorFilter/blob/master/show/color_filters.gif)   
#### 1.2 灰度图： 
将颜色矩阵饱和度调节0即可
```android
    mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.girl);
    ColorMatrix colorMatrix = new ColorMatrix();
    //饱和度调节0-无色彩 1-默认效果 >1-饱和度加强
    colorMatrix.setSaturation(0);
    mColorMatrixColorFilter = new ColorMatrixColorFilter(colorMatrix);
    mPaint.setColorFilter(mColorMatrixColorFilter);
    canvas.drawBitmap(mBitmap, 100, 0, mPaint);
```
示例图下图所示：  
![image](https://github.com/tianyalu/NePaintColorFilter/blob/master/show/gray.png)   


### 2. 颜色矩阵原理
![image](https://github.com/tianyalu/NePaintColorFilter/blob/master/show/color_matrix1.png)  
![image](https://github.com/tianyalu/NePaintColorFilter/blob/master/show/color_matrix2.png)  
![image](https://github.com/tianyalu/NePaintColorFilter/blob/master/show/color_matrix3.png)  
![image](https://github.com/tianyalu/NePaintColorFilter/blob/master/show/color_matrix4.png)  
![image](https://github.com/tianyalu/NePaintColorFilter/blob/master/show/color_matrix5.png)  

