package id.strade.android.buyer.homefragment

import android.support.v4.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import id.strade.android.buyer.R
import org.androidannotations.annotations.AfterViews
import org.androidannotations.annotations.EFragment

@EFragment(R.layout.fragment_map)
open class MapFragment : Fragment(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap

    @AfterViews
    fun init() {
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val location = LatLng(-6.364600, 106.828673)
        mMap.addMarker(MarkerOptions().position(location).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location,18.0f))
    }

}