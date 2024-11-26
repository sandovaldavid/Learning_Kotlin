package devsandoval.me.whilesandconditions

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val enteredNumber: EditText = findViewById(R.id.enterValue)
        val btn1: Button = findViewById(R.id.btn1)
        val message: TextView = findViewById(R.id.outputMessage)
        var random = randomNumber(10)
        var count = 0
        btn1.setOnClickListener{
            count++
            val enteredValue = enteredNumber.text.toString().toInt()
            if (random < enteredValue) message.text = "The number is less than $enteredValue"
            else if (random > enteredValue) message.text = "The number is greater than $enteredValue"
            else message.text = "Congratulations!!! You guessed the number in $count tries. The number was $enteredValue"
        }
    }

    fun randomNumber(num: Int): Int {
        var random = Random.nextInt(1, num)
        return random
    }
}