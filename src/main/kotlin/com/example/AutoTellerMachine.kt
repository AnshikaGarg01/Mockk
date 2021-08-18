package com.example

class AutoTellerMachine( val printer : Printer, val bankingService: BankingService) {

    fun withdraw(amount: Int) {
        //WRITE CODE HERE.

            if(bankingService.withdraw(amount))
                printer.print("$amount withdrawn successful")
            else
                throw error("$amount withdrawn unsuccessful")

    }
}