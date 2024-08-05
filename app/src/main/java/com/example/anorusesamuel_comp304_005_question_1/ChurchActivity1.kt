package com.example.anorusesamuel_comp304_005_question_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.anorusesamuel_comp304_005_question_1.databinding.ActivityChurch1Binding
import com.google.android.gms.maps.model.LatLngBounds

class ChurchActivity1 : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityChurch1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityChurch1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Enable Zoom Controls
        mMap.uiSettings.isZoomControlsEnabled = true

        // Marker for St. Michael's Cathedral Basilica
        val stMichaels = LatLng(43.6546, -79.3778)
        mMap.addMarker(MarkerOptions().position(stMichaels).title("St. Michael's Cathedral Basilica"))

        // Marker for Metropolitan United Church
        val metropolitan = LatLng(43.6525, -79.3783)
        mMap.addMarker(MarkerOptions().position(metropolitan).title("Metropolitan United Church"))

        // Marker for St. James Cathedral
        val stJames = LatLng(43.6501, -79.3743)
        mMap.addMarker(MarkerOptions().position(stJames).title("St. James Cathedral"))

        // Marker for Holy Trinity Church
        val holyTrinity = LatLng(43.6549, -79.3832)
        mMap.addMarker(MarkerOptions().position(holyTrinity).title("Holy Trinity Church"))

        // Adjust the camera to show all markers
        val builder = LatLngBounds.Builder()
        builder.include(stMichaels)
        builder.include(metropolitan)
        builder.include(stJames)
        builder.include(holyTrinity)
        val bounds = builder.build()

        // Adjust this value based on screen size or preference
        val padding = 100
        val cu = CameraUpdateFactory.newLatLngBounds(bounds, padding)
        mMap.animateCamera(cu)
    }
}