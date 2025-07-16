package ke.co.tvnetapp

import android.app.AlertDialog
import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.journeyapps.barcodescanner.BarcodeEncoder
import kotlin.random.Random

class QrCodeFragment : Fragment() {
    private lateinit var qrCodeImage: ImageView
    private lateinit var connectionId: TextView
    private lateinit var refreshButton: Button
    private var qrCodeGenerated = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_qr_code, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        qrCodeImage = view.findViewById(R.id.qr_code_image)
        connectionId = view.findViewById(R.id.connection_id)
        refreshButton = view.findViewById(R.id.btn_refresh_qr)
        
        refreshButton.setOnClickListener { generateQrCode() }
        
        if (!qrCodeGenerated) {
            showQrCodePopup()
        }
    }

    private fun showQrCodePopup() {
        AlertDialog.Builder(requireContext())
            .setTitle("Get QR Code")
            .setMessage("Generate QR code for device pairing?")
            .setPositiveButton("Yes") { _, _ -> 
                generateQrCode()
                qrCodeGenerated = true
            }
            .setCancelable(false)
            .show()
    }

    private fun generateQrCode() {
        val id = generateConnectionId()
        connectionId.text = "Connection ID: $id"
        
        try {
            val encoder = BarcodeEncoder()
            val bitmap: Bitmap = encoder.encodeBitmap("TV_CONNECT:$id", BarcodeFormat.QR_CODE, 300, 300)
            qrCodeImage.setImageBitmap(bitmap)
        } catch (e: WriterException) {
            e.printStackTrace()
        }
    }

    private fun generateConnectionId(): String {
        val chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
        return (1..6).map { chars.random() }.joinToString("")
    }
}