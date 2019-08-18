package com.example.demo.frontend.main

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.await
import kotlinx.coroutines.launch
import org.w3c.dom.HTMLScriptElement
import kotlin.browser.document
import kotlin.browser.window

fun windowMain() {
    val currentScript = document.currentScript
    if (currentScript is HTMLScriptElement) {
        val currentScriptPath = currentScript.src
        GlobalScope.launch {
            println("Registering service worker")
            window.navigator.serviceWorker.register(currentScriptPath).await()
            println("Service worker $currentScriptPath registered")
        }
    }
}
