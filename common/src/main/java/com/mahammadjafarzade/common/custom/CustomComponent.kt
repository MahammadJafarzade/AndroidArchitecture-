package com.mahammadjafarzade.common.custom

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import org.jetbrains.annotations.Nullable

class CustomComponent : ConstraintLayout {
    constructor(context : Context?) : super(context!!) {
        initLayout()
    }
    constructor(context: Context?, @Nullable attrs : AttributeSet?) : super(context!!, attrs) {
        initLayout()
    }

    constructor(context: Context?, @Nullable attrs : AttributeSet?, defStyleAttr : Int) : super(context!!, attrs, defStyleAttr) {
        initLayout()
    }
    private val id1 = 1
    private val button1 = getButton(id1)

    private val id2 = 2
    private val button2 = getButton(id2)
    private fun initLayout(){
        this.setBackgroundColor(Color.RED)

        this.addView(button1)
        this.addView(button2)

        val set = ConstraintSet()
        set.clone(this)

        set.connect(button1.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, 50)
        set.connect(button1.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 50)
        set.connect(button1.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, 50)

        set.connect(button2.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, 50)
        set.connect(button2.id, ConstraintSet.TOP, button1.id, ConstraintSet.BOTTOM, 50)
        set.connect(button2.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, 50)
        set.connect(button2.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, 50)

        set.applyTo(this)    }
    fun getButton(id : Int) : Button{
        val button = Button(context)
        button.id = id
        button.text = "Button $id"
        return button
    }
}