package ca.qc.bdeba17.tpa17

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar


class MembreViewModel() : ViewModel() {
    val listeMembre: MutableList<Membre> = mutableListOf()
}

class ConditionsAdhesionActivity : AppCompatActivity() {

    // ... Le reste de votre code ...

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_comite_gestion -> {
                startActivity(Intent(this, ComiteGestionActivity::class.java))
                return true
            }
            R.id.action_comite_soutien -> {
                startActivity(Intent(this, ComiteSoutienActivity::class.java))
                return true
            }
            R.id.action_suivi_evaluation -> {
                startActivity(Intent(this, SuiviEvaluationActivity::class.java))
                return true
            }
            R.id.action_faire_don -> {
                startActivity(Intent(this, FaireDonActivity::class.java))
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: MembreAdapter
    val viewModel: MembreViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conditions_adhesion)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        recyclerView = findViewById(R.id.recycler_view)
        adapter = MembreAdapter(viewModel.listeMembre)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        viewModel.listeMembre.add(Membre("Wesly", "LOUIS", "514-555-5555", "wl@gmail.com"))
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_conditions_adhesion, menu)
        return true
    }
    val ajouterContactLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == RESULT_OK) {
                adapter.notifyDataSetChanged()
            }
        }
    fun clicAjout(view: View) {
        val intent = Intent(this, InscriptionActivity::class.java)
        ajouterContactLauncher.launch(intent)
    }
}