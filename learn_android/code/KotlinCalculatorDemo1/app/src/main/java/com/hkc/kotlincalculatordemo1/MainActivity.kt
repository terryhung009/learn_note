package com.hkc.kotlincalculatordemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{

    private var canAddOperation = false
    private var canAddDecimal = true

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numberAction(view: android.view.View)
    {
        if(view is Button){
            if (view.text == ".")
            {
                if (canAddDecimal)
                    workingsTextView.append(view.text)
                canAddDecimal=false
            }else
            workingsTextView.append(view.text)
            canAddOperation = true

        }

    }
    fun operatorAction(view: android.view.View)
    {
        if(view is Button && canAddOperation){
            workingsTextView.append(view.text)
            canAddOperation = false
            canAddDecimal = true
        }
    }
    fun allClearAction(view: android.view.View)
    {
        workingsTextView.text = ""
        resultsTextView.text = ""
    }
    fun backSpaceAction(view: android.view.View)
    {
        val length = workingsTextView.length()
        if(length > 0){
            workingsTextView.text = workingsTextView.text.subSequence(0,length - 1)
        }
    }
    fun euqalsAction(view: android.view.View) {
        resultsTextView.text = calculateResults()
    }

    private fun calculateResults(): String {
        val digitsOperators = digitsOperators()

        if(digitsOperators.isEmpty()) return ""

        val timeDivision = timeDivisionCalculate(digitsOperators)
        if(timeDivision.isEmpty()) return ""

        val result = addSubtractCalculate(timeDivision)


        return result.toString()
    }

    private fun addSubtractCalculate(passedList: MutableList<Any>): Float
    {
        var result = passedList[0] as Float

        for (i in passedList.indices)
        {
            if (passedList[i] is Char && i != passedList.lastIndex)
            {
                val operator = passedList[i]
                val nextDigit = passedList[i + 1] as Float
                if(operator == '+')
                    result += nextDigit
                if(operator == '-')
                    result -= nextDigit
            }
        }
        return result
    }

    private fun timeDivisionCalculate(passlist: MutableList<Any>): MutableList<Any>
    {

        var list = passlist
        while (list.contains('x') || list.contains('/'))
            {
                list = calcTimesDiv(list)
            }
            return list
    }

    private fun calcTimesDiv(passedList: MutableList<Any>): MutableList<Any>
    {
        val newList = mutableListOf<Any>()
        var restartIndex = passedList.size

        for(i in passedList.indices)
        {
            if (passedList[i] is Char && i != passedList.lastIndex && i < restartIndex)
            {
                val operator = passedList[i]
                val prevDigit = passedList[i - 1] as Float
                val nextDigit = passedList[i + 1] as Float
                when(operator)
                {
                    'x' ->
                    {
                        newList.add(prevDigit * nextDigit)
                        restartIndex = i + 1
                    }
                    '/' ->
                    {
                        newList.add(prevDigit / nextDigit)
                        restartIndex = i + 1
                    }
                    else ->
                    {
                        newList.add(prevDigit)
                        newList.add(operator)
                    }
                }
            }
            if( i > restartIndex )
                newList.add(passedList[i])

        }



        return newList
    }


    private fun digitsOperators():MutableList<Any>{
        val list = mutableListOf<Any>()
        var currentDigit = ""
        for (character in workingsTextView.text){
            if (character.isDigit() || character == '.')
                currentDigit += character
            else{
                list.add(currentDigit.toFloat())
                currentDigit = ""
                list.add(character)
            }
            if (currentDigit != "")
                list.add(currentDigit.toFloat())



        }



        return list
    }
}