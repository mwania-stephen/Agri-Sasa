package com.steve_md.smartmkulima.utils

/**
 * Centralized Firebase Analytics event names and parameter keys
 * to prevent typos and fragmented event reporting.
 */
object AnalyticsEvents {
    // M-Pesa Payment Funnel
    const val MPESA_STK_PUSH_SENT = "mpesa_stk_push_sent"
    const val MPESA_STK_PUSH_FAILED = "mpesa_stk_push_failed"
    const val MPESA_PAYMENT_FAILED = "mpesa_payment_failed"
}

object AnalyticsParams {
    const val FAILURE_REASON = "failure_reason"
    const val PAYMENT_METHOD_MPESA = "mpesa"
    const val CURRENCY_KES = "KES"
}
