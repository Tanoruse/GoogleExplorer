package com.example.anorusesamuel_comp304_005_question_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.anorusesamuel_comp304_005_question_1.databinding.ActivityStadium1Binding
import com.google.android.gms.maps.model.LatLngBounds

class StadiumActivity1 : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityStadium1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStadium1Binding.inflate(layoutInflater)
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

        // Marker for Rogers Centre
        val rogersCentre = LatLng(43.6414, -79.3894)
        mMap.addMarker(MarkerOptions().position(rogersCentre).title("Rogers Centre"))

        // Marker for Scotiabank Arena
        val scotiabankArena = LatLng(43.6435, -79.3791)
        mMap.addMarker(MarkerOptions().position(scotiabankArena).title("Scotiabank Arena"))

        // Marker for BMO Field
        val bmoField = LatLng(43.6333, -79.4186)
        mMap.addMarker(MarkerOptions().position(bmoField).title("BMO Field"))

        // Marker for Lamport Stadium
        val lamportStadium = LatLng(43.6388, -79.4242)
        mMap.addMarker(MarkerOptions().position(lamportStadium).title("Lamport Stadium"))

        // Adjust the camera to show all markers
        val builder = LatLngBounds.Builder()
        builder.include(rogersCentre)
        builder.include(scotiabankArena)
        builder.include(bmoField)
        builder.include(lamportStadium)
        val bounds = builder.build()

        // Adjust this value based on screen size or preference
        val padding = 100
        val cu = CameraUpdateFactory.newLatLngBounds(bounds, padding)
        mMap.animateCamera(cu)
    }
}