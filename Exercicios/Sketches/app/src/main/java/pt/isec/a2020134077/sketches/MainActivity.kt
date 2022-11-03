package pt.isec.a2020134077.sketches

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import pt.isec.a2020134077.sketches.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGallery.setOnClickListener {
            Toast.makeText(this,getString(R.string.msg_soon),Toast.LENGTH_LONG).show()
        }
        binding.btnPhoto.setOnClickListener {
            Toast.makeText(this,getString(R.string.msg_soon),Toast.LENGTH_LONG).show()
        }
        binding.btnHistory.setOnClickListener {
            Snackbar.make(it,getString(R.string.msg_soon),Snackbar.LENGTH_LONG).show()
        }
        binding.btnSolidColor.setOnClickListener {
            startActivity(Intent(this,ConfigColorActivity::class.java))
        }
    }

}