package com.example

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class AutoTellerMachineTest: StringSpec({
    "should print a receipt if money is withdrawn successfully" {
        val fakePrinter = FakePrinter()
        val fakeBankingService = FakeBankingService(true)
        val autoTellerMachine = AutoTellerMachine(fakePrinter,fakeBankingService)
        autoTellerMachine.withdraw(1000)
        fakePrinter.printCalled shouldBe "1000 withdrawn successful"
        fakePrinter.countPrint shouldBe 1
        autoTellerMachine.withdraw(2000)
        fakePrinter.printCalled shouldBe "2000 withdrawn successful"
        fakePrinter.countPrint shouldBe 2

    }


    "should throw exception if banking service throws an exception" {
        val fakePrinter = FakePrinter()
        val fakeBankingService = FakeBankingService(false)
        val autoTellerMachine = AutoTellerMachine(fakePrinter,fakeBankingService)
        val exception = shouldThrow<IllegalStateException> {
            autoTellerMachine.withdraw(100)
        }
        fakePrinter.countPrint shouldBe 0
        exception.message shouldBe "100 withdrawn unsuccessful"

    }
})