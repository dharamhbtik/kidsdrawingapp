package com.dkumar.kidsdrawingapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.core.content.ContextCompat
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_brush_size.*

class MainActivity : AppCompatActivity() {
    private var mImageButtonCurrentPaint:ImageButton? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    private fun init(){
        //drawing_view.setSizeForBrush(20.toFloat())
        mImageButtonCurrentPaint = ll_paint_colors[1] as ImageButton
        mImageButtonCurrentPaint!!.setImageDrawable(
            ContextCompat.getDrawable(this,R.drawable.pallet_pressed)
        )
        ib_brush.setOnClickListener{
            showBrushSizeChooserDialog()
        }
    }
     fun paintClicked(view: View){
         if(view!= mImageButtonCurrentPaint){
             val imageButton = view as ImageButton
             val colorTag = imageButton.tag.toString()
             drawing_view.setColor(colorTag)
             imageButton.setImageDrawable(
                 ContextCompat.getDrawable(this,R.drawable.pallet_pressed)
             )
             mImageButtonCurrentPaint!!.setImageDrawable(
                 ContextCompat.getDrawable(this,R.drawable.pallet_normal)
             )
             mImageButtonCurrentPaint = view
         }
     }
    private fun showBrushSizeChooserDialog(){
        var brushDialog = Dialog(this)
        brushDialog.setContentView(R.layout.dialog_brush_size)
        brushDialog.setTitle("Brush size: ")
        val smallButton = brushDialog.ib_small_brush
        smallButton.setOnClickListener{
            drawing_view.setSizeForBrush((10.toFloat()))
            brushDialog.dismiss()
        }
        val mediumButton = brushDialog.ib_medium_brush
        mediumButton.setOnClickListener{
            drawing_view.setSizeForBrush((20.toFloat()))
            brushDialog.dismiss()
        }
        val largeButton = brushDialog.ib_large_brush
        largeButton.setOnClickListener{
            drawing_view.setSizeForBrush((30.toFloat()))
            brushDialog.dismiss()
        }
        brushDialog.show()
    }
}