package pt.isec.a2020134077.sketches

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pt.isec.a2020134077.sketches.databinding.ActivityDrawingAreaBinding

class DrawingAreaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDrawingAreaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDrawingAreaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.app_name) + " " + intent.getStringExtra("title")

        binding.background.setBackgroundColor(intent.getIntExtra("color",0))
    }
}