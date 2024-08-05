package com.example.anorusesamuel_comp304_005_question_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.anorusesamuel_comp304_005_question_1.databinding.ActivityCinema1Binding
import com.google.android.gms.maps.model.LatLngBounds

class CinemaActivity1 : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityCinema1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCinema1Binding.inflate(layoutInflater)
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

        // Marker for TIFF Bell Lightbox
        val tiffBellLightbox = LatLng(43.6465, -79.3904)
        mMap.addMarker(MarkerOptions().position(tiffBellLightbox).title("TIFF Bell Lightbox"))

        // Marker for Scotiabank Theatre Toronto
        val scotiabankTheatre = LatLng(43.6487, -79.3888)
        mMap.addMarker(MarkerOptions().position(scotiabankTheatre).title("Scotiabank Theatre Toronto"))

        // Marker for Cineplex Cinemas Yonge-Dundas and VIP
        val cineplexYongeDundas = LatLng(43.6564, -79.3807)
        mMap.addMarker(MarkerOptions().position(cineplexYongeDundas).title("Cineplex Cinemas Yonge-Dundas and VIP"))

        // Marker for The Royal Cinema
        val theRoyalCinema = LatLng(43.6552, -79.4148)
        mMap.addMarker(MarkerOptions().position(theRoyalCinema).title("The Royal Cinema"))

        // Adjust the camera to show all markers
        val builder = LatLngBounds.Builder()
        builder.include(tiffBellLightbox)
        builder.include(scotiabankTheatre)
        builder.include(cineplexYongeDundas)
        builder.include(theRoyalCinema)
        val bounds = builder.build()

        // Adjust this value based on screen size or preference
        val padding = 100
        val cu = CameraUpdateFactory.newLatLngBounds(bounds, padding)
        mMap.animateCamera(cu)
    }
}