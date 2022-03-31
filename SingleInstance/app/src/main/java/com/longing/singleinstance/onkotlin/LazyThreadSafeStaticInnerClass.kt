package com.longing.singleinstance.onkotlin

class LazyThreadSafeStaticInnerClass {
    companion object {
        fun getInstance() = Holder.instance
    }

    private object Holder {
        val instance = LazyThreadSafeStaticInnerClass()
    }
}