package ru.internetcloud.rxjavaexample.a01

import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

fun main() {

    val observable = Observable.create(object : ObservableOnSubscribe<String> {

        override fun subscribe(emitter: ObservableEmitter<String>) {
            emitter.onNext("Java");
            emitter.onNext("Kotlin");
            emitter.onNext("Go");
            emitter.onNext("Cpp");
            emitter.onNext("Python");
            emitter.onComplete();
        }
    })

    val observer = object : Observer<String> {

        override fun onSubscribe(d: Disposable) {
            System.out.println("onSubscribe: " + Thread.currentThread().name);
        }

        override fun onNext(t: String) {
            System.out.println("onNext: " + t);
        }

        override fun onError(e: Throwable) {
            System.out.println("onError: " + e);
        }

        override fun onComplete() {
            System.out.println("onComplete");
        }
    }

    // подписываемся
    observable.subscribe(observer)

}
