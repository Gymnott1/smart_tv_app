package ke.co.tvnetapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AboutFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AboutAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_guide, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        recyclerView = view.findViewById(R.id.guide_recycler_view)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val aboutItems = listOf(
            AboutItem("App Purpose", "Connect your TV to mobile devices easily", R.drawable.ic_tv),
            AboutItem("Mobile App", "Download companion app from Play Store", R.drawable.ic_download),
            AboutItem("Privacy", "No personal data is collected or stored", R.drawable.ic_privacy),
            AboutItem("Support", "Contact support for technical assistance", R.drawable.ic_support)
        )
        
        adapter = AboutAdapter(aboutItems)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
    }
}