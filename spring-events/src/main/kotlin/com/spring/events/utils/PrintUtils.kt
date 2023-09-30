package com.spring.events.utils

import mu.KotlinLogging
import org.springframework.transaction.support.TransactionSynchronizationManager

private val logger = KotlinLogging.logger {}

object PrintUtils {
    fun printWithThread(str: Any) {
        logger.info { "[${TransactionSynchronizationManager.getCurrentTransactionName()}] $str" }
    }
}
