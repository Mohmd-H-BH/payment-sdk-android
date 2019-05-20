package payment.sdk.android.demo

import payment.sdk.android.demo.dependency.AppComponent
import payment.sdk.android.demo.dependency.BaseComponent
import payment.sdk.android.demo.dependency.DaggerAppComponent
import payment.sdk.android.demo.dependency.configuration.Configuration
import android.support.multidex.MultiDexApplication
import android.support.v7.app.AppCompatDelegate
import com.facebook.stetho.Stetho
import javax.inject.Inject

class App : MultiDexApplication() {

    @Inject
    lateinit var configuration: Configuration

    lateinit var baseComponent: BaseComponent

    override fun onCreate() {
        super.onCreate()

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)


        Stetho.initializeWithDefaults(this)

        baseComponent = DaggerAppComponent
                .builder()
                .application(this)
                .build()
        (baseComponent as AppComponent).inject(this)
    }
}