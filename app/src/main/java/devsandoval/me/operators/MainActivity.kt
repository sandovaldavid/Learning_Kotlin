package devsandoval.me.operators

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import devsandoval.me.operators.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myNumber:EditText = findViewById(R.id.lbl_Age)
        val myButton:Button = findViewById(R.id.btn_verifyAge)
        val textResult: TextView = findViewById(R.id.txt_AgeResult)

        myButton.setOnClickListener {
            val result = myNumber.text.toString().toIntOrNull()

/*            if (result == null)
                textResult.text = "Please enter a number"
            else if(result < 18)
                textResult.text = "You are a minor"
            else if (result > 18)
                textResult.text = "You are an adult"
            else
                textResult.text = "You are 18 years old"*/
            verifyAge(result, textResult)
        }
        //Sum of two numbers:
        val textNum1:EditText = findViewById(R.id.editTextText4)
        val textNum2:EditText = findViewById(R.id.editTextText5)
        val textResult2: TextView = findViewById(R.id.textView5)
        val myButtonSum:Button = findViewById(R.id.button2)

        myButtonSum.setOnClickListener {
            val num1 = textNum1.text.toString().toIntOrNull()
            val num2 = textNum2.text.toString().toIntOrNull()
            textResult2.text =
                            if (num1 == null || num2 == null) "Please enter a number"
                            else "The Result is ${num1 + num2}"
        }

        // aumentar en 1 el valor de un número y disminuir en 1 el valor de un número
        val btn_add: Button = findViewById(R.id.btn_add)
        val btn_subtract: Button = findViewById(R.id.btn_rest)

        btn_add.setOnClickListener {
            var age = myNumber.text.toString().toIntOrNull()
            if (age == null) textResult.text = "Please enter a number"
            else {
                myNumber.setText((++age).toString())
                verifyAge(age, textResult)
            }
        }
        btn_subtract.setOnClickListener {
            var age = myNumber.text.toString().toIntOrNull()
            if(age == null) textResult.text = "Please enter a number"
            else {
                myNumber.setText((--age).toString())
                verifyAge(age, textResult)
            }
        }
    }
    private fun verifyAge(age: Int?, textResult: TextView){
        val message = when{
            !(age != null) -> "Please enter a number"
            age <= 0 || age > 110 -> "Enter a valid age"
            age  < 18 || age > 80 -> "You are a minor or an old person"
//            age < 18 -> "You are a minor"
//            age > 18 && age <= 30 -> "You are an young adult"
//            age >30 -> "You are an adult"
            else -> "You are 18 years old"
        }
        textResult.text = message
    }
}
