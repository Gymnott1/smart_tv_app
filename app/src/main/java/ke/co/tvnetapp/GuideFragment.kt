package ke.co.tvnetapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GuideFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: GuideAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_guide, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        recyclerView = view.findViewById(R.id.guide_recycler_view)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val steps = listOf(
            GuideStep(1, "WiFi Connection", "Connect your TV to WiFi network from Settings > Network", R.drawable.ic_wifi),
            GuideStep(2, "Ethernet Setup", "Connect ethernet cable to TV for stable connection", R.drawable.ic_ethernet),
            GuideStep(3, "Mobile Hotspot", "Use phone hotspot as backup connection method", R.drawable.ic_hotspot),
            GuideStep(4, "Network Test", "Test connection speed and stability", R.drawable.ic_test),
            GuideStep(5, "App Installation", "Download companion app on mobile device", R.drawable.ic_download),
            GuideStep(6, "QR Code Pairing", "Scan QR code from mobile app to pair devices", R.drawable.ic_qr)
        )
        
        adapter = GuideAdapter(steps)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
    }
}