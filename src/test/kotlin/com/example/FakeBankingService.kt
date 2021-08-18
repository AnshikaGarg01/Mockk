package com.example

class FakeBankingService(val transactionSuccessful : Boolean ) : BankingService{
    override fun withdraw(amount : Int)  : Boolean{
        return transactionSuccessful
    }
}