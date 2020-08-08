package com.ysvg2tafy.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numClick(view: View){
        val num=(view as Button).text
        Display.append(num)
    }

    fun signClick(view: View){
        val sign=(view as Button).text
        if (sign!="-" && Display.text.length>0 && Display.text.last() !in "+-*/"){
            Display.append(sign)
        }
        if(sign=="-" && Display.text.length>0 && Display.text.last()!='-'){
                Display.append(sign)
        }
        if(sign=="-" && Display.text.length==0){
            Display.append(sign)
        }
    }

    fun equalClick(view: View){
        var eqn=Display.text.toString()
        var net_eqn=""
        var str_list:Any
        var ans:Double=0.0
        var prefix=1
        if (eqn[0]=='-'){
            net_eqn = eqn.substring(1)
            prefix=-1
        }
        else {
            net_eqn=eqn
        }

        if ('+' in net_eqn) {
            str_list=net_eqn.split("+")
            ans=prefix*(str_list[0].toDouble())+str_list[1].toDouble()
        } else if ('-' in net_eqn) {
            str_list=net_eqn.split("-")
            ans=prefix*(str_list[0].toDouble())-str_list[1].toDouble()
        } else if ('*' in net_eqn) {
            str_list=net_eqn.split("*")
            ans=prefix*(str_list[0].toDouble())*str_list[1].toDouble()
        } else if ('/' in net_eqn) {
            str_list=net_eqn.split("/")
            ans=prefix*((str_list[0].toDouble())/str_list[1].toDouble())
        }

        Display.text= ans.toString()


    }

    fun acClick(view: View){
        Display.text=""
    }

}
