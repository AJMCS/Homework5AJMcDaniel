package com.example.homework005

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.homework005.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
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

        // Add a marker in Sydney and move the camera
        // Santa Rosa Plateau Ecological Reserve
        val srpe = LatLng(33.50881, -117.29393);
        // Menifee Lakes Country Club
        val mlcc = LatLng(33.6905, -117.1650)
        // March Field Air Museum
        val mfam = LatLng(33.8789, -117.2631)
        mMap.addMarker(MarkerOptions()
            .position(srpe)
            .title("Santa Rosa Plateau Ecological Reserve")
            .snippet("A beautiful nature preserve known for its vernal pools, oak woodlands, and hiking trails. It's southwest of Murrieta."));
        mMap.addMarker(MarkerOptions()
            .position(mlcc)
            .title("Menifee Lakes Country Club")
            .snippet("A notable landmark and golf course in the city of Menifee, which is north of Murrieta.")
        );
        mMap.addMarker(MarkerOptions()
            .position(mfam)
            .title("March Field Air Museum")
            .snippet("A major aerospace museum with an extensive collection of military aircraft, located near Riverside, further north of Menifee."));


        mMap.addMarker(MarkerOptions().position(srpe).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(srpe))
        mMap.uiSettings.isZoomControlsEnabled = true
    }
}