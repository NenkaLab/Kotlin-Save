
//package com.example.permissions; your app's package name

import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.support.annotation.ColorInt
import android.support.annotation.ColorRes
import android.view.View

/**
 * --------NenkaChat--------
 * Created by nenka
 * Date : 2018-02-27 (2월 / 화요일)
 * Time : 오후 2:40
 * ---------------------------
 */
interface FloatingWindowInterface {

    fun setContentView(view: View): FloatingWindow

    fun setGravity(gravity: Int): FloatingWindow

    fun setWidth(size: Int): FloatingWindow

    fun setHeight(size: Int): FloatingWindow

    fun getContentView(): View

    fun getGravity(): Int

    fun getWidth(): Int

    fun getHeight(): Int

    fun setSize(width: Int, height: Int): FloatingWindow

    fun setPosition(x: Int, y: Int): FloatingWindow

    fun setPosition(gravity: Int, x: Int, y: Int): FloatingWindow

    fun setBackground(drawable: Drawable): FloatingWindow

    fun setBackgroundColor(@ColorInt color: Int): FloatingWindow

    fun setBackgroundResource(@ColorRes resid: Int): FloatingWindow

    fun setBackgroundDrawable(drawable: Drawable)

    fun setBackgroundTintList(colorStateList: ColorStateList): FloatingWindow

    fun setBackgroundTintMode(tintMode: PorterDuff.Mode): FloatingWindow

    fun getSize(): Array<out Int>

    fun getPosition(): Array<out Int>

    fun getBackground(): Drawable

    fun getBackgroundTintList(): ColorStateList

    fun getBackgroundTintMode(): PorterDuff.Mode

    fun show(): FloatingWindow

    fun dismiss(): FloatingWindow

    fun update(gravity: Int): FloatingWindow

    fun update(x: Int, y: Int): FloatingWindow

    fun update(gravity: Int, x: Int, y: Int): FloatingWindow

    fun update(x: Int, y: Int, width: Int, height: Int): FloatingWindow
}
