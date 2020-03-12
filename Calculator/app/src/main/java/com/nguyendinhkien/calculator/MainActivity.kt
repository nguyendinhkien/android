package com.nguyendinhkien.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var btn0:Button
    private lateinit var btn1:Button
    private lateinit var btn2:Button
    private lateinit var btn3:Button
    private lateinit var btn4:Button
    private lateinit var btn5:Button
    private lateinit var btn6:Button
    private lateinit var btn7:Button
    private lateinit var btn8:Button
    private lateinit var btn9:Button
    private lateinit var btnResult:Button

    private lateinit var btnPlus:Button
    private lateinit var btnMinus:Button
    private lateinit var btnDiv:Button
    private lateinit var btnX:Button

    private lateinit var btnC:Button


    private lateinit var history:TextView
    private lateinit var current:TextView

    private var temp:Double = 0.0
    private var result:Double = 0.0
    private var historyString:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addControls()
        addEvents()
    }

    private fun addEvents() {
        btnC.setOnClickListener{
            history.text = ""
            current.text = "0"
            temp = 0.0
            result = 0.0
        }
        btn1.setOnClickListener {
            xuLySo('1')
        }
        btn2.setOnClickListener({
            xuLySo('2')
        })
        btn3.setOnClickListener({
            xuLySo('3')
        })
        btn4.setOnClickListener({
            xuLySo('4')
        })
        btn5.setOnClickListener({
            xuLySo('5')
        })
        btn6.setOnClickListener({
            xuLySo('6')
        })
        btn7.setOnClickListener({
            xuLySo('7')
        })
        btn8.setOnClickListener({
            xuLySo('8')
        })
        btn9.setOnClickListener({
            xuLySo('9')
        })
        btnPlus.setOnClickListener{
            if (temp!=0.0) {
                historyString = history.text.toString()+current.text.toString()+"+"
                setNumber(sum(temp,result))
            }

        }
        btnMinus.setOnClickListener{
            if (temp!=0.0) {
                historyString = history.text.toString()+current.text.toString()+"-"
                setNumber(dif(result,temp))
            }

        }
        btnResult.setOnClickListener{
            if (historyString.isNotEmpty()){
                when (historyString.get(historyString.length-1)){
                    '+'-> {
                        historyString = history.text.toString()+current.text.toString()+"="
                        setNumber(sum(temp,result))
                    }
                    '-'-> {
                        historyString = history.text.toString()+current.text.toString()+"="
                        setNumber(dif(result,temp))
                    }

                }
                current.text = result.toString()
            }

        }
    }

    private fun xuLySo(c: Char) {
        var n : String = current.text as String
        n = n+c
        while (n[0].equals('0')){
            n = n.substring(1)
        }
        var h:String = " "+history.text.toString()
        if (h[h.length-1]=='+'||h[h.length-1]=='-'||h[h.length-1]=='x'||h[h.length-1]=='/'){
            current.text = "$c"
        }
        else{
            current.text = "${n}"
        }
        temp = temp*10 + "$c".toDouble()
        Toast.makeText(this,temp.toString(),Toast.LENGTH_SHORT).show()
    }


    private fun setNumber(r:Double) {
        history.text = historyString
        if (r-r.toLong()==0.0) {
            current.text = r.toLong().toString()
        }
        else{
            current.text = r.toString()
        }
        result = r
        temp=0.0
    }

    private fun addControls() {
        history = findViewById(R.id.history)
        current = findViewById(R.id.current)
        btn0 = findViewById(R.id.btn0)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)
        btnResult = findViewById(R.id.btnResult)
        btnPlus = findViewById(R.id.btnPlus)
        btnMinus = findViewById(R.id.btnMinus)
        btnX = findViewById(R.id.btnX)
        btnDiv = findViewById(R.id.btnDiv)
        btnC = findViewById(R.id.btnC)
    }
    private fun sum(a:Double,b:Double):Double{
        return a+b;
    }
    private fun dif(a:Double,b:Double):Double{
        return a-b;
    }

}
