package kr.sofac.itsskinua.ui.splash

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kr.sofac.itsskinua.R
import kr.sofac.itsskinua.data.model.Category
import kr.sofac.itsskinua.ui.navigation.NavigationActivity
import kr.sofac.itsskinua.util.AppPreference

class SplashActivity : AppCompatActivity(), SplashContract.View {

    private lateinit var presenter : SplashContract.Presenter
    lateinit var appPreference: AppPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        presenter = SplashPresenter(this)
        appPreference = AppPreference(this)
        presenter.sendingGoogleCloudKey(appPreference.getGoogleCloudKey())
        presenter.loadCategories()

    }

    override fun setLoading(isLoading: Boolean) {
        if(isLoading){

        }
        else{

        }
    }

    override fun onLoadError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onLoaded(categories: List<Category>) {
        appPreference.setCategories(categories)
        startNavigationActivity()

    }

    override fun startNavigationActivity() {
        startActivity(Intent(this, NavigationActivity::class.java)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
        finishAffinity()
    }


}
