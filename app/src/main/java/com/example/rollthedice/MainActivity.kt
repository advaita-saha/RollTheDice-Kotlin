package com.example.rollthedice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var random_number : Int = 0
    var score_player_A : Int = 0
    var score_player_B : Int = 0
    var ACTIVE_PLAYER_A : Boolean = true
    var ACTIVE_PLAYER_B : Boolean = true
    var GAME_POINT : Int = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dice_image.isEnabled = false

        btn_start.setOnClickListener {
            dice_image.isEnabled = true

            score_player_A = 0
            score_player_B = 0
            ACTIVE_PLAYER_A = true
            ACTIVE_PLAYER_B = true

            tv_GamePointA.setText(score_player_A.toString())
            tv_GamePointB.setText(score_player_B.toString())
            textView2.setText("")
        }

        dice_image.setOnClickListener {

            btn_start.isEnabled = false
            btn_start.text = "RESET"

            random_number = (1..6).random()
            when(random_number){

                1 -> {
                    dice_image.setImageResource(R.drawable.dice1)
                }
                2 -> {
                    dice_image.setImageResource(R.drawable.dice2)
                }
                3 -> {
                    dice_image.setImageResource(R.drawable.dice3)
                }
                4 -> {
                    dice_image.setImageResource(R.drawable.dice4)
                }
                5 -> {
                    dice_image.setImageResource(R.drawable.dice5)
                }
                6 -> {
                    dice_image.setImageResource(R.drawable.dice6)
                }

            }

            if (ACTIVE_PLAYER_A){
                score_player_A += random_number
                ACTIVE_PLAYER_A = false
                ACTIVE_PLAYER_B = true

                //check for winner
                if (score_player_A >= 100){
                    textView2.setText("GAME OVER, PLAYER A WON")
                    dice_image.isEnabled = false
                    btn_start.isEnabled = true
                }

            }
            else{
                score_player_B += random_number
                ACTIVE_PLAYER_A = true
                ACTIVE_PLAYER_B = false

                if (score_player_B >= 100){
                    textView2.setText("GAME OVER, PLAYER B WON")
                    dice_image.isEnabled = false
                    btn_start.isEnabled = true
                }
            }

            tv_GamePointA.setText(score_player_A.toString())
            tv_GamePointB.setText(score_player_B.toString())
        }
    }
}
