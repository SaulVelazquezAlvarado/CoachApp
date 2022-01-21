package mx.easycode.coachapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import mx.easycode.coachapp.databinding.ItemRetosBinding

class RetosAdapter(val retos: ArrayList<RetoEnt>,val listener:(RetoEnt) -> Unit ):
    RecyclerView.Adapter<RetosAdapter.RetoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetoViewHolder {
        val binding = ItemRetosBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RetoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RetoViewHolder, position: Int) {
        holder.bind(retos[position],listener)
    }

    override fun getItemCount(): Int {
        return retos.size
    }

    class RetoViewHolder(val binding: ItemRetosBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(reto: RetoEnt, listener: (RetoEnt) -> Unit){

            binding.apply {

                ivReto.setImageDrawable(root.context.getDrawable(R.drawable.img_sentadillas))
                tvNombreReto.text = reto.nombre.uppercase()
                root.setOnClickListener {
                    listener(reto)
                }

            }

        }

    }

}