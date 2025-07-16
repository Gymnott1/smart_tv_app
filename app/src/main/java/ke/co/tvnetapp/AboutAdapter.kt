package ke.co.tvnetapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AboutAdapter(private val items: List<AboutItem>) : RecyclerView.Adapter<AboutAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val stepTitle: TextView = view.findViewById(R.id.step_title)
        val stepDescription: TextView = view.findViewById(R.id.step_description)
        val stepIcon: ImageView = view.findViewById(R.id.step_icon)
        val stepNumber: TextView = view.findViewById(R.id.step_number)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_guide_step, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.stepNumber.visibility = View.GONE
        holder.stepTitle.text = item.title
        holder.stepDescription.text = item.description
        holder.stepIcon.setImageResource(item.iconRes)
    }

    override fun getItemCount() = items.size
}