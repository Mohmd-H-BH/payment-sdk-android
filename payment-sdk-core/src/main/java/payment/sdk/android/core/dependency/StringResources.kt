package payment.sdk.android.core.dependency

import android.support.annotation.StringRes

interface StringResources {

    fun getString(@StringRes resourceId: Int) : String

    fun getString(@StringRes resourceId: Int, vararg formatArgs: Any): String
}