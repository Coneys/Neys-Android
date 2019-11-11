package com.github.coneys.androidArchitecture.blockScope

class FunctionBlockScopeLogger{
    private fun log(message:String){
        println("FunctionBlockScope|     $message")
    }

     fun executed(tag:String) = log("Executed $tag")
     fun skipped(tag:String) = log("Skipped $tag")
}
