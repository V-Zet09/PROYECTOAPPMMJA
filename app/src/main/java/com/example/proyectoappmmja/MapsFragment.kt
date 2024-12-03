package com.example.proyectoappmmja

import androidx.fragment.app.Fragment
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class MapsFragment : Fragment(R.layout.fragment_maps), OnMapReadyCallback {

    private lateinit var map: GoogleMap

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        val sydney = LatLng(18.344976106105108, -100.63933083571149)
        map.addMarker(MarkerOptions().position(sydney).title("ALTAMIRANO"))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 100f))
    }
}