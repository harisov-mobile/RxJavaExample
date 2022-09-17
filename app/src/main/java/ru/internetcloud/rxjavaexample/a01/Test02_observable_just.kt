package ru.internetcloud.rxjavaexample.a01

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

fun main() {

    val observable = Observable.just(
        "item01", "item02", "item03", "item04"
    )

    val observer = object : Observer<String> {

        override fun onSubscribe(d: Disposable) {
            println("onSubscribe : " + Thread.currentThread().name)
            println("")
        }

        override fun onNext(t: String) {
            println("onNext : $t")
        }

        override fun onError(e: Throwable) {
            println("onError : $e")
        }

        override fun onComplete() {
            println()
            println("onComplete")
        }
    }

    // подписываемся
    observable.subscribe(observer)
}
