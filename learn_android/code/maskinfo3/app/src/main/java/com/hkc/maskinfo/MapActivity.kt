package com.hkc.maskinfo

import android.Manifest
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import com.hkc.maskinfo.Repository.pharmacyInfoAuto
import com.hkc.maskinfo.databinding.ActivityMapBinding
import com.google.android.gms.location.*
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException


class MapActivity : AppCompatActivity() , OnMapReadyCallback , GoogleMap.OnInfoWindowClickListener {

    private lateinit var binding :ActivityMapBinding
    private var locationPermissionGranted = false
    private lateinit var mContext: Context
    private lateinit var mLocationProviderClient : FusedLocationProviderClient
    private var googleMap: GoogleMap? = null
    private var mCurrLocationMarker: Marker? = null
    private var pharmacyInfo : pharmacyInfoAuto? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_map)
        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)


        mContext = this
        mLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)

//        getLocationPermission()
    }

    override fun onInfoWindowClick(marker: Marker?) {
        marker?.title?.let { title ->
//            Log.d("HKT", title)

            val filterData =
                pharmacyInfo?.features?.filter {
                    it.properties.name == (title)
                }

            if (filterData?.size!! > 0) {
                val intent = Intent(this, PharmacyDetailActivity::class.java)
                intent.putExtra("data", filterData.first())
                startActivity(intent)
            } else {
//                Log.d("", "????????????")
            }
        }
    }

    private fun getPharmacyData() {
        binding.progressBar.visibility = View.VISIBLE


        //??????????????????
        val pharmaciesDataUrl =
            "https://raw.githubusercontent.com/thishkt/pharmacies/master/data/info.json"

        //Part 1: ?????? OkHttpClient
        val okHttpClient = OkHttpClient().newBuilder().build()

        //Part 2: ?????? Request??????????????????????????????
        val request: Request = Request.Builder().url(pharmaciesDataUrl).get().build()

        //Part 3: ?????? Call
        val call = okHttpClient.newCall(request)

        //?????? Call ?????????????????? enqueue ????????????????????????????????????????????????
        call.enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {

            }

            override fun onResponse(call: Call, response: Response) {

                val pharmaciesData = response.body?.string()

                pharmacyInfo = Gson().fromJson(pharmaciesData, pharmacyInfoAuto::class.java)


                runOnUiThread {
                    binding.progressBar.visibility = View.GONE
                    addAllMarker()

                }
            }




        })

    }

    private fun addAllMarker() {
        pharmacyInfo?.features?.forEach{ feature ->
            val pinMarker = googleMap?.addMarker(
                MarkerOptions()
                    .position(
                        LatLng(
                            feature.geometry.coordinates[1],
                            feature.geometry.coordinates[0]
                        )
                    )
                    .title(feature.properties.name)
                    .snippet(
                        "${feature.properties.mask_adult}," +
                                "${feature.properties.mask_child}"
                    )

            )

        }
    }

    override fun onMapReady(googleMap: GoogleMap){
        this.googleMap = googleMap

        googleMap?.setInfoWindowAdapter(MyInfoWindowAdapter(mContext))
        googleMap?.setOnInfoWindowClickListener(this)


        getLocationPermission()

        getPharmacyData()


    }




    private fun getDeviceLocation(){
        try {
            if (locationPermissionGranted
            ) {
                val locationRequest = LocationRequest()
                locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
                //????????????
                locationRequest.interval = 1000
                //?????????????????????????????????????????????
                locationRequest.numUpdates = 2
                mLocationProviderClient.requestLocationUpdates(
                    locationRequest,
                    object : LocationCallback() {
                        override fun onLocationResult(locationResult: LocationResult?) {
                            locationResult ?: return
//                            Log.d(
//                                "HKT",
//                                "??????:${locationResult.lastLocation.latitude} , ??????:${locationResult.lastLocation.longitude} "
//                            )
                            val currentLocation = LatLng(locationResult.lastLocation.latitude,
                            locationResult.lastLocation.longitude
                            )

//                            googleMap?.addMarker(
//                                MarkerOptions().position(currentLocation).title("????????????")
//                            )
//                            googleMap?.moveCamera(
//                                CameraUpdateFactory.newLatLngZoom(
//                                    currentLocation, 15f
//                                )
//                            )





                            //??????????????????
                            //googleMap?.clear()

                            //???????????????????????????
//                            mCurrLocationMarker?.remove()

                            //???????????????????????? Marker ???????????????????????????????????????
//                            mCurrLocationMarker =googleMap?.addMarker(
//                                MarkerOptions().position(currentLocation).title("????????????")
//                            )
//                            mCurrLocationMarker?.remove()

                            googleMap?.setInfoWindowAdapter(MyInfoWindowAdapter(mContext))

//                            mCurrLocationMarker = googleMap?.addMarker(
//                                MarkerOptions()
//                                    .position(currentLocation)
//                                    .title("????????????")
//                                    .snippet("100,66")
//                            )
                            mCurrLocationMarker?.showInfoWindow()

                            googleMap?.moveCamera(
                                CameraUpdateFactory.newLatLngZoom(
                                    currentLocation, 15f
                                )
                            )

                        }
                    },
                    null
                )



            } else {
                getLocationPermission()
            }
        } catch (e: SecurityException) {
            Log.e("Exception: %s", e.message, e)
        }
    }

//    override fun onMapReady(googleMap: GoogleMap) {
//        mMap = googleMap




    private fun getLocationPermission() {
        //????????????

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            Toast.makeText(this, "????????????????????????????????????????????????????????????", Toast.LENGTH_SHORT).show()
            locationPermissionGranted = true
            checkGPSState()

        } else {
            //????????????????????????
            requestLocationPermission()
        }
    }

    private fun requestLocationPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(
                this@MapActivity,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
        ){
            AlertDialog.Builder(this)
                .setMessage("??????????????????????????????????????????????????????")
                .setPositiveButton("??????") { _, _ ->
                    ActivityCompat.requestPermissions(
                        this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                        REQUEST_LOCATION_PERMISSION
                    )
                }
                .setNegativeButton("??????") { _, _ -> requestLocationPermission() }
                .show()

        } else {
            ActivityCompat.requestPermissions(
                this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), REQUEST_LOCATION_PERMISSION
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {
            REQUEST_LOCATION_PERMISSION -> {
                if (grantResults.isNotEmpty()) {
                    if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        //???????????????
                        locationPermissionGranted = true
                        checkGPSState()

                    } else if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
                        if (!ActivityCompat.shouldShowRequestPermissionRationale(
                                this,
                                Manifest.permission.ACCESS_FINE_LOCATION
                            )
                        ) {
                            //?????????????????????
                            Toast.makeText(this, "?????????????????????????????????????????????????????????", Toast.LENGTH_SHORT).show()

                            AlertDialog.Builder(this)
                                .setTitle("??????????????????")
                                .setMessage("????????????????????????????????????????????????????????????????????????")
                                .setPositiveButton("??????") { _, _ ->
                                    val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                                    startActivityForResult(intent, REQUEST_LOCATION_PERMISSION)
                                }
                                .setNegativeButton("??????") { _, _ -> requestLocationPermission() }
                                .show()
                        }else {
                            //???????????????
                            Toast.makeText(this, "??????????????????????????????????????????????????????", Toast.LENGTH_SHORT).show()
                            requestLocationPermission()
                        }

                    }


                }

            }
        }
    }

    private fun checkGPSState() {
        val locationManager = mContext.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            AlertDialog.Builder(mContext)
                .setTitle("GPS ????????????")
                .setMessage("??????????????????????????? GSP ????????????")
                .setPositiveButton("????????????",
                    DialogInterface.OnClickListener { _, _ ->
                        startActivityForResult(
                            Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS), REQUEST_ENABLE_GPS
                        )
                    })
                .setNegativeButton("??????", null)
                .show()
        }else{
            getDeviceLocation()
            Toast.makeText(this, "???????????????????????????GPS?????????????????????????????????????????????", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            REQUEST_LOCATION_PERMISSION -> {
                getLocationPermission()
            }
            REQUEST_ENABLE_GPS -> {
                checkGPSState()
            }
        }
    }

}
