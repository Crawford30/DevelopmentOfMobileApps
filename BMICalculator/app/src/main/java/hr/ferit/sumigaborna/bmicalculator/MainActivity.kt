package hr.ferit.sumigaborna.bmicalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calculateButton : Button = findViewById(R.id.buttonCalcID)


        calculateButton.setOnClickListener{
            if(heightEditID.text.toString() !="" && weightEditID.text.toString() !=""){
            calculateBMI()
            }else{
                Toast.makeText(this,"Please enter values",Toast.LENGTH_SHORT).show()
            }
        } //calling function on click of "Button"
    }

    fun calculateBMI(){
        val fHeight  = heightEditID.text.toString().toFloat() //gets input from user, from EditText Height
        val fWeight  = weightEditID.text.toString().toFloat()


        if(fHeight>2.5f || fHeight <=0f) { //checking if user entered supported values
            Toast.makeText(this, R.string.warningForHeight, Toast.LENGTH_SHORT).show()
        }else if(fWeight>350f || fWeight <=0f){ //checking if user entered supported values
                Toast.makeText(this,R.string.warningForWeight,Toast.LENGTH_SHORT).show()
        }else {
            val fResult : Float = fWeight / (fHeight*fHeight)

            BMINumberID.text = fResult.toString() //passing BMI value to TextView

            if(fResult >= 30f){
                BMITextID.text = "Obese"
                textBMIExplain.text = getString(R.string.textForObese)
            }else if (fResult <30f && fResult >=25f){
                BMITextID.text = "Overweight"
                textBMIExplain.text = getString(R.string.textForOverweight)
            }else if (fResult <25f && fResult >=18.5f){
                BMITextID.text = "Normal"
                textBMIExplain.text = getString(R.string.textForNormal)
            }else if (fResult <18.5f){
                BMITextID.text = "Underweight"
                textBMIExplain.text = getString(R.string.textForUnderweight)
            }
        }



        //Log.d("Tag",fHeight.toString())
    }
}
