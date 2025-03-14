package me.ash.reader

import android.content.Context
import android.widget.Toast
import java.lang.Thread.UncaughtExceptionHandler
import kotlin.system.exitProcess

class CrashHandler(private val context: Context) : UncaughtExceptionHandler {
    init {
        Thread.setDefaultUncaughtExceptionHandler(this)
    }

    override fun uncaughtException(p0: Thread, p1: Throwable) {
        Toast.makeText(context, p1.message, Toast.LENGTH_LONG).show()
        p1.printStackTrace()
        android.os.Process.killProcess(android.os.Process.myPid());
        exitProcess(1)
    }
}
