package com.steve_md.smartmkulima.utils

import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FirebaseAnalyticsHelper @Inject constructor(
    private val analytics: FirebaseAnalytics
){
    fun logEvent(name: String, params: Bundle? = null) = analytics.logEvent(name, params)

    fun logScreen(screenName: String) = logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, Bundle().apply {
        putString(FirebaseAnalytics.Param.SCREEN_NAME, screenName)
    })
}