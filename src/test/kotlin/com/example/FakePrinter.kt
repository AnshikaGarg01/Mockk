package com.example

class FakePrinter : Printer{

    var printCalled = ""
    var countPrint =0

    override fun print(message : String){
        // print
        printCalled = message
        countPrint++
    }
}