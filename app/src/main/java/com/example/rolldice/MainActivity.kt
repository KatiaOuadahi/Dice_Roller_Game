package com.example.rolldice

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        val msg :TextView = findViewById(R.id.textView2)
        val mydice :ImageView =findViewById(R.id.imageView)
        rollButton.setOnClickListener {

           val toast = Toast.makeText(this,"dice Rolled!",Toast.LENGTH_SHORT)
            toast.show()

           val result:TextView = rolldice()
            msg.text=when(result.text){
                "1" -> "So sorry! Try again!"
                "2" -> "Sadly,  Try again!"
                "3" -> "Unfortunately, Try again!"
                "4" -> "Don't cry!  Try again!"
               "5"  -> "Apologies!  Try again!"
                "6" -> "Congrats ! you won"
                else -> ""
            }
            when(result.text) {

                "1" -> mydice.setImageResource(R.drawable.dice_1)
                "2" ->mydice.setImageResource(R.drawable.dice_2)
                "3" ->mydice.setImageResource(R.drawable.dice_3)
                "4" ->mydice.setImageResource(R.drawable.dice_4)
                "5"  ->mydice.setImageResource(R.drawable.dice_5)
                "6" ->mydice.setImageResource(R.drawable.dice_6)
                //else -> mydice.setImageResource(R.drawable.dice_6)

            }

        }

    }

    private fun rolldice():TextView {
        val dice = Dice(6)
        val diceroll =dice.roll()
        val resultTextView : TextView =findViewById(R.id.textView)
        resultTextView.text=diceroll.toString()
        return resultTextView


    }
}
class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}