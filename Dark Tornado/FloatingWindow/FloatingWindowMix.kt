package com.nenkalab.nenkachat.fuck_hacker

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
 * --Project FloatingWindow---
 * Created by nenka
 * Date : 2018-02-27 (2월 / 화요일)
 * Time : 오후 4:31
 * ---------------------------
 */
class FloatingWindowMix(private val context: Context, isIncludeEditText: Boolean? = null) {


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

    @Throws(FloatingWindowMix.FloatingWindowException::class)
    fun setContentView(view: View): FloatingWindowMix {
        this.view = view
        return this
    }

    @Throws(FloatingWindowMix.FloatingWindowException::class)
    fun setGravity(gravity: Int): FloatingWindowMix {
        mParams!!.gravity = gravity
        return this
    }

    @Throws(FloatingWindowMix.FloatingWindowException::class)
    fun setWidth(size: Int): FloatingWindowMix {
        mParams!!.width = size
        return this
    }

    @Throws(FloatingWindowMix.FloatingWindowException::class)
    fun setHeight(size: Int): FloatingWindowMix {
        mParams!!.height = size
        return this
    }

    @Throws(FloatingWindowMix.FloatingWindowException::class)
    fun getContentView(): View {
        return view!!
    }

    @Throws(FloatingWindowMix.FloatingWindowException::class)
    fun getGravity(): Int {
        return mParams!!.gravity
    }

    @Throws(FloatingWindowMix.FloatingWindowException::class)
    fun getWidth(): Int {
        return mParams!!.width
    }

    @Throws(FloatingWindowMix.FloatingWindowException::class)
    fun getHeight(): Int {
        return mParams!!.height
    }

    @Throws(FloatingWindowMix.FloatingWindowException::class)
    fun setSize(width: Int, height: Int): FloatingWindowMix {
        mParams!!.width = width
        mParams!!.height = height
        return this
    }

    @Throws(FloatingWindowMix.FloatingWindowException::class)
    fun setPosition(x: Int, y: Int): FloatingWindowMix {
        mParams!!.x = x
        mParams!!.y = y
        return this
    }

    @Throws(FloatingWindowMix.FloatingWindowException::class)
    fun setPosition(gravity: Int, x: Int, y: Int): FloatingWindowMix {
        mParams!!.gravity = gravity
        mParams!!.x = x
        mParams!!.y = y
        return this
    }

    @Throws(FloatingWindowMix.FloatingWindowException::class)
    fun setBackground(drawable: Drawable): FloatingWindowMix {
        layout!!.background = drawable
        return this
    }

    @Throws(FloatingWindowMix.FloatingWindowException::class)
    fun setBackgroundColor(color: Int): FloatingWindowMix {
        layout!!.setBackgroundColor(color)
        return this
    }

    @Throws(FloatingWindowMix.FloatingWindowException::class)
    fun setBackgroundResource(resid: Int): FloatingWindowMix {
        layout!!.setBackgroundResource(resid)
        return this
    }

    @Deprecated("DEPRECATION", level = DeprecationLevel.WARNING)
    @Throws(FloatingWindowMix.FloatingWindowException::class)
    fun setBackgroundDrawable(drawable: Drawable): FloatingWindowMix {
        @Suppress("DEPRECATION")
        layout!!.setBackgroundDrawable(drawable)
        return this
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    @Throws(FloatingWindowMix.FloatingWindowException::class)
    fun setBackgroundTintList(colorStateList: ColorStateList): FloatingWindowMix {
        layout!!.backgroundTintList = colorStateList
        return this
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    @Throws(FloatingWindowMix.FloatingWindowException::class)
    fun setBackgroundTintMode(tintMode: PorterDuff.Mode): FloatingWindowMix {
        layout!!.backgroundTintMode = tintMode
        return this
    }

    @Throws(FloatingWindowMix.FloatingWindowException::class)
    fun getSize(): Array<out Int> {
        return arrayOf(mParams!!.width, mParams!!.height)
    }

    @Throws(FloatingWindowMix.FloatingWindowException::class)
    fun getPosition(): Array<out Int> {
        return arrayOf(mParams!!.x, mParams!!.y)
    }

    @Throws(FloatingWindowMix.FloatingWindowException::class)
    fun getBackground(): Drawable {
        return layout!!.background
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    @Throws(FloatingWindowMix.FloatingWindowException::class)
    fun getBackgroundTintList(): ColorStateList {
        return layout!!.backgroundTintList
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    @Throws(FloatingWindowMix.FloatingWindowException::class)
    fun getBackgroundTintMode(): PorterDuff.Mode {
        return layout!!.backgroundTintMode
    }

    @Throws(FloatingWindowMix.FloatingWindowException::class)
    fun show(): FloatingWindowMix {
        layout!!.addView(view)
        mManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        mManager!!.addView(layout, mParams)
        return this
    }

    @Throws(FloatingWindowMix.FloatingWindowException::class)
    fun dismiss(): FloatingWindowMix {
        mManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        mManager!!.removeView(layout)
        return this
    }

    @Throws(FloatingWindowMix.FloatingWindowException::class)
    fun update(gravity: Int): FloatingWindowMix {
        mParams!!.gravity = gravity
        mManager!!.updateViewLayout(view, mParams)
        return this
    }

    @Throws(FloatingWindowMix.FloatingWindowException::class)
    fun update(x: Int, y: Int): FloatingWindowMix {
        mParams!!.x = x
        mParams!!.y = y
        mManager!!.updateViewLayout(view, mParams)
        return this
    }

    @Throws(FloatingWindowMix.FloatingWindowException::class)
    fun update(gravity: Int, x: Int, y: Int): FloatingWindowMix {
        mParams!!.x = x
        mParams!!.y = y
        mParams!!.gravity = gravity
        mManager!!.updateViewLayout(view, mParams)
        return this
    }

    @Throws(FloatingWindowMix.FloatingWindowException::class)
    fun update(x: Int, y: Int, width: Int, height: Int): FloatingWindowMix {
        mParams!!.x = x
        mParams!!.y = y
        mParams!!.width = width
        mParams!!.height = height
        mManager!!.updateViewLayout(view, mParams)
        return this
    }

    inner class FloatingWindowException : Exception {

        constructor() : super()

        constructor(message: String) : super(message)

        constructor(message: String, throwable: Throwable) : super(message, throwable)

        constructor(cause: Throwable) : super(cause)

    }
}
