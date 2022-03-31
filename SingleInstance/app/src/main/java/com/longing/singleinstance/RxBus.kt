package com.longing.singleinstance

import java.util.*


class RxBus private constructor() {
    private val subject: Subject<Any>

    init {
        subject = PublishSubject.create().toSerialized()

    }

    fun post(any: Any) {
        subject.onNext(any)
    }

    fun <T> Observable<T> toObservable(Class<T>eventType) {
        return subject.ofType(eventType)
    }
	
	conpain object{
	val instance by lazy(){
	RxBus()
	}
	}
}