package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button2)
        // Roll a random dice to show user at start
        rollDice()

        rollButton.setOnClickListener {
            rollDice()
            val toast = Toast.makeText(this, "Dice rolled!", Toast.LENGTH_SHORT)
            toast.show()
        }
    }

    /**
     * Roll the dice and update screen with result
     */
    private fun rollDice() {
        // Create dice with 6 sides
        val dice1 = Dice(6)
        val dice2 = Dice(6)
        val dice1Roll = dice1.roll()
        val dice2Roll = dice2.roll()
        // Update screen result
        var diceImage1: ImageView = findViewById(R.id.imageView6)
        var diceImage2: ImageView = findViewById(R.id.imageView7)

        val drawableResource1 = when (dice1Roll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        val drawableResource2 = when (dice2Roll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage1.setImageResource(drawableResource1)
        diceImage1.contentDescription = dice1Roll.toString()

        diceImage2.setImageResource(drawableResource2)
        diceImage2.contentDescription = dice2Roll.toString()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}