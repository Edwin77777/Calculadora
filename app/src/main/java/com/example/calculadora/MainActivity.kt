package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {


     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



         btn0.setOnClickListener {
             appendOnExpresstion("0",true)

         }
         btn1.setOnClickListener {
             appendOnExpresstion("1",true)

         }
         btn2.setOnClickListener {
             appendOnExpresstion("2",true)

         }
         btn3.setOnClickListener {
             appendOnExpresstion("3",true)

         }
         btn4.setOnClickListener {
             appendOnExpresstion("4",true)

         }
         btn5.setOnClickListener {
             appendOnExpresstion("5",true)

         }
         btn6.setOnClickListener {
             appendOnExpresstion("6",true)

         }
         btn7.setOnClickListener {
             appendOnExpresstion("7",true)

         }
         btn8.setOnClickListener {
             appendOnExpresstion("8",true)

         }
         btn9.setOnClickListener {
             appendOnExpresstion("9",true)

         }
         btnpu.setOnClickListener {
             appendOnExpresstion(".",true)

         }

         btnma.setOnClickListener {
             appendOnExpresstion("+",false)

         }
         btnme.setOnClickListener {
             appendOnExpresstion("-",false)

         }
         btnpo.setOnClickListener {
             appendOnExpresstion("*",false)

         }
         btnd.setOnClickListener {
             appendOnExpresstion("/",false)

         }
         btnc.setOnClickListener {
             tvresul.text = ""
             tvdisp.text = ""

         }
         btni.setOnClickListener {
             try {
                 val expression = ExpressionBuilder(tvdisp.text.toString()).build()
                 val result = expression.evaluate()
                 val longResult = result.toLong()
                 if (result == longResult.toDouble())
                     tvresul.text = longResult.toString()
                 else
                     tvresul.text = result.toString()
             }catch (e:Exception){
                 Log.d("Exception","message : " + e.message)
             }

         }




    }

    fun appendOnExpresstion( string: String,canClear: Boolean){
        if (tvresul.text.isNotEmpty()){

            tvdisp.text = ""
        }
        if(canClear){
            tvresul.text = ""
            tvdisp.append(string)
        }else{
            tvdisp.append(tvresul.text)
            tvdisp.append(string)
            tvresul.text = ""
        }


    }
}
