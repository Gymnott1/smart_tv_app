package ke.co.tvnetapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GuideAdapter(private val steps: List<GuideStep>) : RecyclerView.Adapter<GuideAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val stepNumber: TextView = view.findViewById(R.id.step_number)
        val stepTitle: TextView = view.findViewById(R.id.step_title)
        val stepDescription: TextView = view.findViewById(R.id.step_description)
        val stepIcon: ImageView = view.findViewById(R.id.step_icon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_guide_step, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val step = steps[position]
        holder.stepNumber.text = step.number.toString()
        holder.stepTitle.text = step.title
        holder.stepDescription.text = step.description
        holder.stepIcon.setImageResource(step.iconRes)
    }

    override fun getItemCount() = steps.size
}