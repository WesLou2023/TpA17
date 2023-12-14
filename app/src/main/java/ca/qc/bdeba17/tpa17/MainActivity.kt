package ca.qc.bdeba17.tpa17

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onInscriptionLinkClick(view: View) {
        // Créez une intention pour démarrer l'activité Inscription
        val intent = Intent(this, ConditionsAdhesionActivity::class.java)

        // Démarrez l'activité
        startActivity(intent)
    }
}