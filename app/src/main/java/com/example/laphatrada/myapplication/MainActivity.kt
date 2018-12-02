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
            operatorStr(cal, "+")
        }

        bt_minus.setOnClickListener {
            operatorStr(cal, "-")
        }

        bt_multiply.setOnClickListener {
            operatorStr(cal, "*")
        }

        bt_divide.setOnClickListener {
            operatorStr(cal, "/")
        }

        bt_result.setOnClickListener {
            calculate(cal)
        }

        bt_clear.setOnClickListener {
            cal.reset()
            tv_monitor.text = ""
        }
    }

    private fun initNum(cal: Calculator, self: Int) {
        var tmp : String
        var monitorTxt :String = tv_monitor.text.toString()
        if("N1"==cal.step){
            tmp = cal.num1.toString()
            tmp+=self.toString()
            cal.num1 = tmp.toInt()
            monitorTxt = cal.num1.toString()
        }else{
            tmp = cal.num2.toString()
            tmp+=self.toString()
            cal.num2 = tmp.toInt()
            monitorTxt = "${cal.num1} ${cal.operatorStr} ${cal.num2}"
        }
        tv_monitor.text = monitorTxt
    }

    private fun operatorStr(cal: Calculator, ope : String){
        cal.operatorStr = ope
        cal.step = "N2"
        var monitorTxt :String = tv_monitor.text.toString()
        monitorTxt+= " ${ope}"
        tv_monitor.text = monitorTxt
    }

    private fun calculate(cal: Calculator){
        var monitorTxt :String = tv_monitor.text.toString()
        var result :String = when(cal.operatorStr){
            "+" -> (cal.num1 + cal.num2).toString()
            "-" -> (cal.num1 - cal.num2).toString()
            "*" -> (cal.num1 * cal.num2).toString()
            "/" -> (cal.num1 / cal.num2).toString()
            else -> "fail"
        }
        monitorTxt+= " = ${result}"
        tv_monitor.text = monitorTxt
    }



}
