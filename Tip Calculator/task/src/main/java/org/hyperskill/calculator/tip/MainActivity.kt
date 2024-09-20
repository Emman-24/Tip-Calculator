package org.hyperskill.calculator.tip

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.SeekBar
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import org.hyperskill.calculator.tip.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val tip: TipViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val editText = binding.editText

        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(sb: SeekBar?, progress: Int, fromUser: Boolean) {
                if (editText.text.isEmpty() || editText.text.toString().toDoubleOrNull() == 0.0) {
                    binding.tipPercentTv.text = ""
                    binding.billValueTv.text = ""
                    binding.tipAmountTv.text = ""
                } else {
                    binding.tipPercentTv.text = String.format(Locale.getDefault(), "Tip: %d%%", progress)
                    binding.tipAmountTv.text = String.format(Locale.getDefault(), "Tip Amount: $%.2f", editText.text.toString().toDouble() * progress / 100
                    )
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })

        binding.editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(s: Editable) {
                if (s.isEmpty() || s.toString().toDoubleOrNull() == 0.0) {
                    binding.tipPercentTv.text = ""
                    binding.billValueTv.text = ""
                    binding.tipAmountTv.text = ""

                } else {

                    val progress = binding.seekBar.progress
                    binding.billValueTv.text = String.format(Locale.getDefault(), "Bill Value: $%.2f", s.toString().toDouble())
                    binding.tipPercentTv.text = String.format(Locale.getDefault(), "Tip: %d%%", tip.tipPercent.value)
                    binding.tipAmountTv.text = String.format(Locale.getDefault(), "Tip Amount: $%.2f", editText.text.toString().toDouble() * progress / 100)

                }

            }
        })

    }

}