package com.serdar.countdowntimer_notification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.serdar.countdowntimer_notification.Constant.Companion.DESCRIPTION
import com.serdar.countdowntimer_notification.Constant.Companion.TITLE
import com.serdar.countdowntimer_notification.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        object : CountDownTimer(20000, 1000)
        {

            override fun onTick(p0: Long)

            {
                binding.textView.text = "Kalan: ${p0 / 1000}"
            }

            override fun onFinish() {
             binding.textView.text = "Kalan 0"
                Notification.timerNotification(this@MainActivity,TITLE, DESCRIPTION)
            }

        }.start()
        
    }

}