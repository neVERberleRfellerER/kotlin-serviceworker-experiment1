package com.example.demo.frontend.main

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.promise
import org.w3c.dom.WorkerGlobalScope
import org.w3c.workers.ExtendableEvent

@JsName("self")
private external val workerSelf: WorkerGlobalScope

fun serviceWorkerMain() {
    println("Registering install listener")
    workerSelf.addEventListener("install", { event ->
        println("Handling install event")
        if (event is ExtendableEvent) {
            val cachePromise = GlobalScope.promise {
                // do the important stuff here

                println("Hello, world!")
                GlobalScope.launch {
                    println("Hello world 2")
                }
            }
            event.waitUntil(cachePromise)
        }
    })
}
