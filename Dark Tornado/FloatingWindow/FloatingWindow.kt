//package com.example.permissions; your app's package name

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.PixelFormat
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.os.Build
import android.support.annotation.RequiresApi
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.widget.RelativeLayout


/**
 * --------NenkaChat--------
 * Created by nenka
 * Date : 2018-02-27 (2월 / 화요일)
 * Time : 오후 2:39
 * ---------------------------
 */
class FloatingWindow(val context: Context, val isIncludeEditText: Boolean? = null): FloatingWindowInterface{

    private var mManager: WindowManager? = null
    private var mParams: WindowManager.LayoutParams? = null
    private var view: View? = null
    private var layout: RelativeLayout? = null

    init {
        @Throws(FloatingWindowException::class)
        if (isIncludeEditText == null){
            @Suppress("DEPRECATION")
            mParams = WindowManager.LayoutParams(
                    -2, -2,
                    WindowManager.LayoutParams.TYPE_PHONE,
                    WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                    PixelFormat.TRANSLUCENT)
            mParams!!.x = 0
            mParams!!.y = 0
            mParams!!.gravity = Gravity.CENTER
            layout = RelativeLayout(context)
        } else {
            @Suppress("DEPRECATION")
            mParams = if (isIncludeEditText)
                WindowManager.LayoutParams(
                        -2, -2,
                        WindowManager.LayoutParams.TYPE_PHONE,
                        WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH,
                        PixelFormat.TRANSLUCENT)
            else
                WindowManager.LayoutParams(
                        -2, -2,
                        WindowManager.LayoutParams.TYPE_PHONE,
                        WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                        PixelFormat.TRANSLUCENT)
            mParams!!.x = 0
            mParams!!.y = 0
            mParams!!.gravity = Gravity.CENTER
            layout = RelativeLayout(context)
        }
    }

    @Throws(FloatingWindowException::class)
    override fun setContentView(view: View): FloatingWindow {
        this.view = view
        return this
    }

    @Throws(FloatingWindowException::class)
    override fun setGravity(gravity: Int): FloatingWindow {
        mParams!!.gravity = gravity
        return this
    }

    @Throws(FloatingWindowException::class)
    override fun setWidth(size: Int): FloatingWindow {
        mParams!!.width = size
        return this
    }

    @Throws(FloatingWindowException::class)
    override fun setHeight(size: Int): FloatingWindow {
        mParams!!.height = size
        return this
    }

    @Throws(FloatingWindowException::class)
    override fun getContentView(): View {
        return view!!
    }

    @Throws(FloatingWindowException::class)
    override fun getGravity(): Int {
        return mParams!!.gravity
    }

    @Throws(FloatingWindowException::class)
    override fun getWidth(): Int {
        return mParams!!.width
    }

    @Throws(FloatingWindowException::class)
    override fun getHeight(): Int {
        return mParams!!.height
    }

    @Throws(FloatingWindowException::class)
    override fun setSize(width: Int, height: Int): FloatingWindow {
        mParams!!.width = width
        mParams!!.height = height
        return this
    }

    @Throws(FloatingWindowException::class)
    override fun setPosition(x: Int, y: Int): FloatingWindow {
        mParams!!.x = x
        mParams!!.y = y
        return this
    }

    @Throws(FloatingWindowException::class)
    override fun setPosition(gravity: Int, x: Int, y: Int): FloatingWindow {
        mParams!!.gravity = gravity
        mParams!!.x = x
        mParams!!.y = y
        return this
    }

    @Throws(FloatingWindowException::class)
    override fun setBackground(drawable: Drawable): FloatingWindow {
        layout!!.background = drawable
        return this
    }

    @Throws(FloatingWindowException::class)
    override fun setBackgroundColor(color: Int): FloatingWindow {
        layout!!.setBackgroundColor(color)
        return this
    }

    @Throws(FloatingWindowException::class)
    override fun setBackgroundResource(resid: Int): FloatingWindow {
        layout!!.setBackgroundResource(resid)
        return this
    }

    @Deprecated("DEPRECATION", level = DeprecationLevel.WARNING)
    @Throws(FloatingWindowException::class)
    override fun setBackgroundDrawable(drawable: Drawable) {
        @Suppress("DEPRECATION")
        layout!!.setBackgroundDrawable(drawable)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    @Throws(FloatingWindowException::class)
    override fun setBackgroundTintList(colorStateList: ColorStateList): FloatingWindow {
        layout!!.backgroundTintList = colorStateList
        return this
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    @Throws(FloatingWindowException::class)
    override fun setBackgroundTintMode(tintMode: PorterDuff.Mode): FloatingWindow {
        layout!!.backgroundTintMode = tintMode
        return this
    }

    @Throws(FloatingWindowException::class)
    override fun getSize(): Array<out Int> {
        return arrayOf(mParams!!.width, mParams!!.height)
    }

    @Throws(FloatingWindowException::class)
    override fun getPosition(): Array<out Int> {
        return arrayOf(mParams!!.x, mParams!!.y)
    }

    @Throws(FloatingWindowException::class)
    override fun getBackground(): Drawable {
        return layout!!.background
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    @Throws(FloatingWindowException::class)
    override fun getBackgroundTintList(): ColorStateList {
        return layout!!.backgroundTintList
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    @Throws(FloatingWindowException::class)
    override fun getBackgroundTintMode(): PorterDuff.Mode {
        return layout!!.backgroundTintMode
    }

    @Throws(FloatingWindowException::class)
    override fun show(): FloatingWindow {
        layout!!.addView(view)
        mManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        mManager!!.addView(layout, mParams)
        return this
    }

    @Throws(FloatingWindowException::class)
    override fun dismiss(): FloatingWindow {
        mManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        mManager!!.removeView(layout)
        return this
    }

    @Throws(FloatingWindowException::class)
    override fun update(gravity: Int): FloatingWindow {
        mParams!!.gravity = gravity
        mManager!!.updateViewLayout(view, mParams)
        return this
    }

    @Throws(FloatingWindowException::class)
    override fun update(x: Int, y: Int): FloatingWindow {
        mParams!!.x = x
        mParams!!.y = y
        mManager!!.updateViewLayout(view, mParams)
        return this
    }

    @Throws(FloatingWindowException::class)
    override fun update(gravity: Int, x: Int, y: Int): FloatingWindow {
        mParams!!.x = x
        mParams!!.y = y
        mParams!!.gravity = gravity
        mManager!!.updateViewLayout(view, mParams)
        return this
    }

    @Throws(FloatingWindowException::class)
    override fun update(x: Int, y: Int, width: Int, height: Int): FloatingWindow {
        mParams!!.x = x
        mParams!!.y = y
        mParams!!.width = width
        mParams!!.height = height
        mManager!!.updateViewLayout(view, mParams)
        return this
    }
}
