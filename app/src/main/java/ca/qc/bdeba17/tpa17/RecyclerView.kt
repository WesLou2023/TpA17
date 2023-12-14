package ca.qc.bdeba17.tpa17

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


data class Membre(
    var prenom: String,
    var nom: String,
    var telephone: String,
    var email: String
)


class MembreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val prenom: TextView
    val nom: TextView
    val telephone: TextView
    val email: TextView


    init {
        nom = itemView.findViewById(R.id.nom)
        prenom = itemView.findViewById(R.id.prenom)
        telephone = itemView.findViewById(R.id.telephone)
        email = itemView.findViewById(R.id.email)
    }

    fun lier(membre: Membre) {
        nom.text = membre.prenom + " " + membre.nom
        telephone.text = membre.telephone
        email.text = membre.email
    }
}

class MembreAdapter(private val listeMembre: List<Membre>) :
    RecyclerView.Adapter<MembreViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MembreViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.inscrit, parent, false)
        return MembreViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listeMembre.size
    }

    override fun onBindViewHolder(holder: MembreViewHolder, position: Int) {
        holder.lier(listeMembre.get(position))
    }
}

