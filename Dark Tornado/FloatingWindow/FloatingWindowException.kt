//package com.example.permissions; your app's package name

/**
 * --Project FloatingWindow---
 * Created by nenka
 * Date : 2018-02-27 (2월 / 화요일)
 * Time : 오후 2:44
 * ---------------------------
 */
class FloatingWindowException : Exception {

    constructor() : super()

    constructor(message: String) : super(message)

    constructor(message: String, throwable: Throwable) : super(message, throwable)

    constructor(cause: Throwable) : super(cause)

}
