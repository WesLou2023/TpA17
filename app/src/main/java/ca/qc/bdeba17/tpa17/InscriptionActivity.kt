package ca.qc.bdeba17.tpa17

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModel


class InscriptionActivity : AppCompatActivity() {
    lateinit var prenom: EditText
    lateinit var nom: EditText
    lateinit var telephone: EditText
    lateinit var email: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inscription)

        findViewById<Button>(R.id.button).setOnClickListener{
            clicOK()
        }
    }
    fun clicOK(){
        setResult(RESULT_OK)
        finish()
    }
}