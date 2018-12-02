package com.example.laphatrada.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var cal  = Calculator()

        bt0.setOnClickListener{
            initNum(cal, 0)
        }

        bt1.setOnClickListener{
           initNum(cal, 1)
        }

        bt2.setOnClickListener{
            initNum(cal, 2)
        }

        bt3.setOnClickListener{
            initNum(cal, 3)
        }

        bt4.setOnClickListener{
            initNum(cal, 4)
        }

        bt5.setOnClickListener{
            initNum(cal, 5)
        }

        bt6.setOnClickListener{
            initNum(cal, 6)
        }

        bt7.setOnClickListener{
            initNum(cal, 7)
        }

        bt8.setOnClickListener{
            initNum(cal, 8)
        }

        bt9.setOnClickListener{
            initNum(cal, 9)
        }

        bt_plus.setOnClickListener {
            operetorStr(cal, "+")
        }

        bt_minus.setOnClickListener {
            operetorStr(cal, "-")
        }

        bt_multiply.setOnClickListener {
            operetorStr(cal, "*")
        }

        bt_divide.setOnClickListener {
            operetorStr(cal, "/")
        }

        btn_result.setOnClickListener {
            calculate(cal)
        }

        bt_clear.setOnClickListener {
            cal.reset()
            tv_monitor.text = ""
        }
    }

    private fun initNum(cal: Calculator, self: Int) {
        var tmp = ""
        if("N1"==cal.step){
            tmp = cal.num1.toString()
            tmp+=self.toString()
            cal.num1 = tmp.toInt()
        }else{
            tmp = cal.num2.toString()
            tmp+=self.toString()
            cal.num2 = tmp.toInt()
        }
    }

    private fun operetorStr(cal: Calculator, ope : String){
        cal.operatorStr = ope
        cal.step = "N2"
    }

    private fun calculate(cal: Calculator){
        when(cal.operatorStr){
            "+" -> tv_monitor.text = (cal.num1 + cal.num2).toString()
            "-" -> tv_monitor.text = (cal.num1 - cal.num2).toString()
            "*" -> tv_monitor.text = (cal.num1 * cal.num2).toString()
            "/" -> tv_monitor.text = (cal.num1 / cal.num2).toString()
        }
    }



}
