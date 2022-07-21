package com.example.lab3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab3.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    //TODO 2: Create an instance of view binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //TODO 3: Initialize the view binding
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener {
            val age = binding.spinnerAge.selectedItemPosition
            val gender  =binding.radioGroupGender.checkedRadioButtonId
            val smoker = binding.checkBoxSmoker.isChecked

            var extrapaymentofmale = 0
            var extrapaymentofsmoker = 0

            var premium = 0
            //if(age == 0)
            //{
            //    premium += 60
            //}

            premium = when(age)
            {
                0->60
                1->70
                2->90
                3->120
                else->150
            }

            if(gender == binding.radioButtonMale.id)
            {
                premium += when(age)
                {
                    0->0
                    1->50
                    2->100
                    3->150
                    else->200
                }
            }

            if(smoker)
            {
                premium += when(age)
                {
                    0->0
                    1->100
                    2->150
                    3->200
                    4->250
                    else->300
                }
            }

            val output_premium = NumberFormat.getCurrencyInstance().format(premium)
            binding.textViewPremium.text = output_premium
        }

        binding.buttonReset.setOnClickListener {
            binding.spinnerAge.setSelection(0)

            binding.radioGroupGender.clearCheck()

            binding.checkBoxSmoker.isChecked=false

            binding.textViewPremium.text = null
        }
    }
}