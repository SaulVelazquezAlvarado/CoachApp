package mx.easycode.coachapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.os.Handler


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed(Runnable { //This method will be executed once the timer is over
            val i = Intent(this, AuthActivity::class.java)
            startActivity(i)
            finish()
        }, 3000)

    }
}