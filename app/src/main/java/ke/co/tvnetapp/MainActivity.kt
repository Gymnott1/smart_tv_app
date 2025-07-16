package ke.co.tvnetapp

import android.app.UiModeManager
import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

class MainActivity : FragmentActivity() {
    private lateinit var btnQrCode: Button
    private lateinit var btnGuide: Button
    private lateinit var btnAbout: Button
    private var currentTab = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        if (!isTvDevice()) {
            showNonTvWarning()
            return
        }
        
        setContentView(R.layout.activity_main)
        initViews()
        setupNavigation()
        showFragment(QrCodeFragment())
    }

    private fun isTvDevice(): Boolean {
        val uiModeManager = getSystemService(Context.UI_MODE_SERVICE) as UiModeManager
        return uiModeManager.currentModeType == Configuration.UI_MODE_TYPE_TELEVISION
    }

    private fun showNonTvWarning() {
        Toast.makeText(this, "This app is designed for Android TV devices", Toast.LENGTH_LONG).show()
        finish()
    }

    private fun initViews() {
        btnQrCode = findViewById(R.id.btn_qr_code)
        btnGuide = findViewById(R.id.btn_guide)
        btnAbout = findViewById(R.id.btn_about)
    }

    private fun setupNavigation() {
        btnQrCode.setOnClickListener { switchTab(0, QrCodeFragment()) }
        btnGuide.setOnClickListener { switchTab(1, GuideFragment()) }
        btnAbout.setOnClickListener { switchTab(2, AboutFragment()) }
        
        btnQrCode.requestFocus()
    }

    private fun switchTab(tabIndex: Int, fragment: Fragment) {
        currentTab = tabIndex
        showFragment(fragment)
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.content_frame, fragment)
            .commit()
    }
}