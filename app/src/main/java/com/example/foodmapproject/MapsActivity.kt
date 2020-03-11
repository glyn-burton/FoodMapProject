package com.example.foodmapproject

import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.mapType = GoogleMap.MAP_TYPE_HYBRID
        val geocoder = Geocoder(this)
        val ATL = LatLng(33.7570174,-84.410121)
        //
        val bonton_location = LatLng(33.7729895,-84.3825974)
        val bonton = geocoder.getFromLocationName(BONTON_LOCATION,1)
        val bon_title = bonton[0].getAddressLine(0)
        mMap.addMarker(MarkerOptions()
            .position(bonton_location)
            .title(bon_title)
            .icon(BitmapDescriptorFactory.fromResource(BONTON_PICTURE)))
        //
        val banshee_location = LatLng(33.7399618,-84.3481159)
        val banshee = geocoder.getFromLocationName(BANSHEE_LOCATION,1)
        val ban_title = banshee[0].getAddressLine(0)

        mMap.addMarker(MarkerOptions()
            .position(banshee_location)
            .title(ban_title)
            .icon(BitmapDescriptorFactory.fromResource(BANSHEE_PICTURE)))
        //
        val momo_location = LatLng(33.779782,-84.3922934)
        val momo = geocoder.getFromLocationName(MOMONOKI_LOCATION,1)
        val momo_title = momo[0].getAddressLine(0)

        mMap.addMarker(MarkerOptions()
            .position(momo_location)
            .title(momo_title)
            .icon(BitmapDescriptorFactory.fromResource(MOMONOKI_PICTURE)))
        //

        val slutty_vegan_location = LatLng(33.7432783,-84.4401907)
        val slutty_vegan = geocoder.getFromLocationName(SLUTTY_VEGAN_LOCATION,1)
        val slu_title = slutty_vegan[0].getAddressLine(0)

        mMap.addMarker(MarkerOptions()
            .position(slutty_vegan_location)
            .title(slu_title)
            .icon(BitmapDescriptorFactory.fromResource(SLUTTY_VEGAN_PICTURE)))
        //
        val sweet_hut_location = LatLng(33.8369442,-84.4041921)
        val sweet_hut = geocoder.getFromLocationName(SWEET_HUT_CAFE_LOCATION,1)
        val sweet_hut_title = sweet_hut[0].getAddressLine(0)

        mMap.addMarker(MarkerOptions()
            .position(sweet_hut_location)
            .title(sweet_hut_title)
            .icon(BitmapDescriptorFactory.fromResource(SWEET_HUT_CAFE_PICTURE)))
        ///////

        mMap.moveCamera(CameraUpdateFactory.newLatLng(ATL))
        mMap.moveCamera(CameraUpdateFactory.zoomTo(10.0f))
    }


}
