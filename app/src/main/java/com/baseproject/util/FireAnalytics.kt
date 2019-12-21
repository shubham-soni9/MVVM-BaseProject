package com.baseproject.util

import android.content.Context
import android.os.Bundle
import com.baseproject.common.isRelease
import com.google.firebase.analytics.FirebaseAnalytics

object FireAnalytics {
    private lateinit var mFirebaseAnalytics: FirebaseAnalytics

    fun logFirebaseEvent(event: String) {
        val params = Bundle()
        logFirebaseEvent(event, params)
    }

    fun logFirebaseEvent(event: String, params: Bundle) {
        if(isRelease()) mFirebaseAnalytics.logEvent(event, params)
    }

    /**
     * Builder class for the Builder instance. You only have to call this once in the Application
     * onCreate. And in the rest of the code base you can call FireAnalytics.method name.
     */
    class Builder {
        private var mContext: Context? = null

        /**
         * Set the Context used to instantiate the SharedPreferences
         *
         * @param context the application context
         * @return the [Builder] object.
         */
        fun setContext(context: Context?): FireAnalytics.Builder {
            mContext = context
            return this
        }

        /**
         * Initialize the SharedPreference instance to used in the application.
         *
         * @throws RuntimeException if Context has not been set.
         */
        fun build() {
            if (mContext == null) {
                throw RuntimeException("Context not set, please set context before building the Prefs instance.")
            }
            FireAnalytics.init(mContext!!)
        }
    }

    private fun init(mContext: Context) {
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(mContext);
    }
}