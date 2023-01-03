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
//                Log.d("", "查無資料")
            }
        }
    }

    private fun getPharmacyData() {
        binding.progressBar.visibility = View.VISIBLE


        //口罩資料網址
        val pharmaciesDataUrl =
            "https://raw.githubusercontent.com/thishkt/pharmacies/master/data/info.json"

        //Part 1: 宣告 OkHttpClient
        val okHttpClient = OkHttpClient().newBuilder().build()

        //Part 2: 宣告 Request，要求要連到指定網址
        val request: Request = Request.Builder().url(pharmaciesDataUrl).get().build()

        //Part 3: 宣告 Call
        val call = okHttpClient.newCall(request)

        //執行 Call 連線後，採用 enqueue 非同步方式，獲取到回應的結果資料
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
                //更新頻率
                locationRequest.interval = 1000
                //更新次數，若沒設定，會持續更新
                locationRequest.numUpdates = 2
                mLocationProviderClient.requestLocationUpdates(
                    locationRequest,
                    object : LocationCallback() {
                        override fun onLocationResult(locationResult: LocationResult?) {
                            locationResult ?: return
//                            Log.d(
//                                "HKT",
//                                "緯度:${locationResult.lastLocation.latitude} , 經度:${locationResult.lastLocation.longitude} "
//                            )
                            val currentLocation = LatLng(locationResult.lastLocation.latitude,
                            locationResult.lastLocation.longitude
                            )

//                            googleMap?.addMarker(
//                                MarkerOptions().position(currentLocation).title("現在位置")
//                            )
//                            googleMap?.moveCamera(
//                                CameraUpdateFactory.newLatLngZoom(
//                                    currentLocation, 15f
//                                )
//                            )





                            //清除所有標記
                            //googleMap?.clear()

                            //清除上一次位置標記
//                            mCurrLocationMarker?.remove()

                            //當下位置存到一個 Marker 變數中，好讓下一次可以清除
//                            mCurrLocationMarker =googleMap?.addMarker(
//                                MarkerOptions().position(currentLocation).title("現在位置")
//                            )
//                            mCurrLocationMarker?.remove()

                            googleMap?.setInfoWindowAdapter(MyInfoWindowAdapter(mContext))

//                            mCurrLocationMarker = googleMap?.addMarker(
//                                MarkerOptions()
//                                    .position(currentLocation)
//                                    .title("現在位置")
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
        //檢查權限

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            Toast.makeText(this, "已獲取到位置權限，可以準備開始獲取經緯度", Toast.LENGTH_SHORT).show()
            locationPermissionGranted = true
            checkGPSState()

        } else {
            //詢問要求獲取權限
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
                .setMessage("此應用程式需要位置權限，才能正常使用")
                .setPositiveButton("確定") { _, _ ->
                    ActivityCompat.requestPermissions(
                        this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                        REQUEST_LOCATION_PERMISSION
                    )
                }
                .setNegativeButton("取消") { _, _ -> requestLocationPermission() }
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
                        //已獲取權限
                        locationPermissionGranted = true
                        checkGPSState()

                    } else if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
                        if (!ActivityCompat.shouldShowRequestPermissionRationale(
                                this,
                                Manifest.permission.ACCESS_FINE_LOCATION
                            )
                        ) {
                            //權限被永久拒絕
                            Toast.makeText(this, "位置權限已被關閉，功能將會無法正常使用", Toast.LENGTH_SHORT).show()

                            AlertDialog.Builder(this)
                                .setTitle("開啟位置權限")
                                .setMessage("此應用程式，位置權限已被關閉，需開啟才能正常使用")
                                .setPositiveButton("確定") { _, _ ->
                                    val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                                    startActivityForResult(intent, REQUEST_LOCATION_PERMISSION)
                                }
                                .setNegativeButton("取消") { _, _ -> requestLocationPermission() }
                                .show()
                        }else {
                            //權限被拒絕
                            Toast.makeText(this, "位置權限被拒絕，功能將會無法正常使用", Toast.LENGTH_SHORT).show()
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
                .setTitle("GPS 尚未開啟")
                .setMessage("使用此功能需要開啟 GSP 定位功能")
                .setPositiveButton("前往開啟",
                    DialogInterface.OnClickListener { _, _ ->
                        startActivityForResult(
                            Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS), REQUEST_ENABLE_GPS
                        )
                    })
                .setNegativeButton("取消", null)
                .show()
        }else{
            getDeviceLocation()
            Toast.makeText(this, "已獲取到位置權限且GPS已開啟，可以準備開始獲取經緯度", Toast.LENGTH_SHORT).show()
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
