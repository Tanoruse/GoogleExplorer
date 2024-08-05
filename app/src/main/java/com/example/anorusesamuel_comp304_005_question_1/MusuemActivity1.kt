package com.example.anorusesamuel_comp304_005_question_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.anorusesamuel_comp304_005_question_1.databinding.ActivityMusuem1Binding
import com.google.android.gms.maps.model.LatLngBounds

class MusuemActivity1 : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMusuem1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMusuem1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Royal Ontario Museum
        val rom = LatLng(43.6677, -79.3948)
        mMap.addMarker(MarkerOptions().position(rom).title("Royal Ontario Museum"))

        // Art Gallery of Ontario
        val ago = LatLng(43.6536, -79.3925)
        mMap.addMarker(MarkerOptions().position(ago).title("Art Gallery of Ontario"))

        // Ontario Science Centre
        val osc = LatLng(43.7163, -79.3390)
        mMap.addMarker(MarkerOptions().position(osc).title("Ontario Science Centre"))

        // Bata Shoe Museum
        val bsm = LatLng(43.6673, -79.4000)
        mMap.addMarker(MarkerOptions().position(bsm).title("Bata Shoe Museum"))

        // Move camera to a central position in Toronto and adjust zoom level
        val torontoCenter = LatLng(43.65107, -79.347015)
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(torontoCenter, 12f))
        val builder = LatLngBounds.Builder()
        builder.include(ago)
        builder.include(osc)
        builder.include(rom)
        builder.include(torontoCenter)
        val bounds = builder.build()

        val padding = 100
        val cu = CameraUpdateFactory.newLatLngBounds(bounds, padding)
        mMap.animateCamera(cu)
    }
}
