package pt.isec.a2020134077.sketches

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import pt.isec.a2020134077.sketches.databinding.ActivityConfigColorBinding

class ConfigColorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityConfigColorBinding

    private val currentColor : Int
    get() = Color.rgb(
        binding.seekRed.progress,
        binding.seekGreen.progress,
        binding.seekBlue.progress,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfigColorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.seekRed.apply {
            max = 255
            progress = 255
            setOnSeekBarChangeListener(seekBarChangeListener)
        }

        binding.seekBlue.apply {
            max = 255
            progress = 255
            setOnSeekBarChangeListener(seekBarChangeListener)
        }

        binding.seekGreen.apply {
            max = 255
            progress = 255
            setOnSeekBarChangeListener(seekBarChangeListener)
        }

        binding.frPreview.setBackgroundColor(currentColor)

    }

    private val seekBarChangeListener = object : OnSeekBarChangeListener{
        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            binding.frPreview.setBackgroundColor(currentColor)
        }
        override fun onStartTrackingTouch(seekBar: SeekBar?) {}
        override fun onStopTrackingTouch(seekBar: SeekBar?) {}

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_create_sketches,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.mnCriate){
            if(binding.edTitle.text.trim().isEmpty()) {
                /*Snackbar.make(
                    binding.edTitle,
                    R.string.msg_empty_title,
                    Snackbar.LENGTH_LONG
                ).show()*/
                Toast.makeText(
                    this,
                    getString(R.string.msg_empty_title),
                    Toast.LENGTH_LONG
                    ).show()
                binding.edTitle.requestFocus()
                return true
            }
            val intent = Intent(this,DrawingAreaActivity::class.java)
            intent.putExtra("title",binding.edTitle.text.toString())
            intent.putExtra("color",currentColor)
            startActivity(intent)
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

}