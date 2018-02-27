# FloatingWindow

© 2017 Dark Tornado, All rights reserved.

FloatingWindow is as similar as PopupWinow, but it can be used in serverce because it is made with WindowManager.<br>
It needs android.permission.SYSTEM_ALERT_WINDOW.<br>

FloatingWindow는 WindowManager를 이용해서 만든 PopupWindow와 유사한 것입니다. 따라서, 서비스에서도 사용이 가능합니다.<br>
android.permission.SYSTEM_ALERT_WINDOW 권한이 필요합니다.<br><br>


If you want to use as Dialog, please reference <a href="https://github.com/DarkTornado/AlertWindow">AlertWindow</a>.<br>
만약, 다이얼로그처럼 사용하는 것을 원한다면, <a href="https://github.com/DarkTornado/AlertWindow">AlertWindow</a>을 참고해주세요.


### How to Use(?) 사용법(?)
Make a class named FloatingWindow and Copt+Paste.<br>
FloatingWindow라는 클래스 하나 만들고 소스 복사+붙여넣기 하시고 사용하시면 됩니다.<br>


### API

- <b>new FloatingWindow(Context ctx);</b><br>
ctx is context of app. You can use this or getApplicationContext().<br>
ctx는 앱의 context값. this나 getApplicationContext()라고 적으면 됨.

- <b>new FloatingWindow(Context ctx, boolean isIncludeEditText);</b><br>
ctx is context of app. You can use this or getApplicationContext(). If isIncludeEditText is true, you can input text to EditText but you cannot touch outside of window's outside.<br>
ctx는 앱의 context값. this나 getApplicationContext()라고 적으면 됨. isIncludeEditText가 true라면 윈도우 밖 터치는 불가능하나, EditText에 텍스트 입력 가능.

- <b>.dismiss();</b><br>
Dismiss the FloatingWindow.<br>
FloatingWindow 삭제.

- <b>.getHeight();</b><br>
Get FloatingWindow's height.<br>
FloatingWindow의 세로 크기를 가져옴.

- <b>.getWidth();</b><br>
Get FloatingWindow's width.<br>
FloatingWindow의 가로 크기를 가져옴.

- <b>.setBackground(Drawable drawable);</b><br>
Set FloatingWindow's background with drawable.<br>
FloatingWindow의 배경 설정.

- <b>.setBackgroundColor(int color);</b><br>
Set FloatingWindow's background color.<br>
FloatingWindow의 배경 색상 설정.

- <b>.setBackgroundDrawable(Drawable drawable);</b><br>
Set FloatingWindow's background with drawable.<br>
FloatingWindow의 배경 설정.

- <b>.setContentView(View view);</b><br>
Set FloatingWindow's view.<br>
FloatingWindow의 뷰 설정.

- <b>.setGravity(int gravity);</b><br>
Set FloatingWindow's gravity.<br>
FloatingWindow의 gravity(정렬 비스무리한 개념) 설정.

- <b>.setHeight(int height);</b><br>
Set FloatingWindow's height.<br>
FloatingWindow의 세로 크기 설정.

- <b>.setPosition(int x, int y);</b><br>
Set FloatingWindow's position.<br>
FloatingWindow의 위치 설정.

- <b>.setPosition(int gravity, int x, int y);</b><br>
Set FloatingWindow's position.<br>
FloatingWindow의 위치 설정.

- <b>.setSize(int width, int height);</b><br>
Set FloatingWindow's size.<br>
FloatingWindow의 크기 설정.

- <b>.setHeight(int width);</b><br>
Set FloatingWindow's width.<br>
FloatingWindow의 가로 크기 설정.

- <b>.show();</b><br>
Show the FloatingWindow<br>
FloatingWindow를 화면에 출력.

