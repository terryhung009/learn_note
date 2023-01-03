package com.hkc.maskinfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hkc.maskinfo.databinding.ActivityMainBinding
import com.hkc.maskinfo.Repository.CountyUtil
import com.hkc.maskinfo.Repository.Feature
import com.hkc.maskinfo.ViewModel.MainViewModel

class MainActivity : AppCompatActivity(), MainAdapter.IItemClickListener {



    private lateinit var binding: ActivityMainBinding
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var viewAdapter: MainAdapter
    private lateinit var mainViewModel : MainViewModel

    private var currentCounty : String = "臺東縣"
    private var currentTown : String = "池上鄉"
//    private var pharmacyInfo : pharmacyInfoAuto? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        initView()

        getPharmacyData()


    }

    private fun initView() {

        val adaptercounty = ArrayAdapter(this,
            android.R.layout.simple_spinner_dropdown_item,
            CountyUtil.getAllCountiesName()
        )
        binding.spinnerCounty.adapter = adaptercounty
        binding.spinnerCounty.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                currentCounty = binding.spinnerCounty.selectedItem.toString()
                setSpinnerTown()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

        binding.spinnerTown.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                currentTown = binding.spinnerTown.selectedItem.toString()
                if (mainViewModel.pharmacyInfo != null){
                    updateRecyclerView()


                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

        setDefaultCountyWithTown()

        viewManager = LinearLayoutManager(this)
        viewAdapter = MainAdapter(this)

//        binding.recyclerView.layoutManager = viewManager
//        binding.recyclerView.adapter = viewAdapter

        binding.recyclerView.apply{
            layoutManager = viewManager
            adapter = viewAdapter


        }

    }

    private fun setDefaultCountyWithTown() {
        binding.spinnerCounty.setSelection(CountyUtil.getCountyIndexByName(currentCounty))
        setSpinnerTown()
    }

    private fun setSpinnerTown() {
        val adapterTown = ArrayAdapter(this,
            android.R.layout.simple_spinner_dropdown_item,
            CountyUtil.getTownsByCountyName(currentCounty)
        )
        binding.spinnerTown.adapter = adapterTown
        binding.spinnerTown.setSelection(CountyUtil.getTownIndexByName(currentCounty,currentTown))
    }


    private fun getPharmacyData() {
    binding.progressBar.visibility = View.VISIBLE

    mainViewModel.makecall

//    //口罩資料網址
//    val pharmaciesDataUrl =
//        "https://raw.githubusercontent.com/thishkt/pharmacies/master/data/info.json"
//
//    //Part 1: 宣告 OkHttpClient
//    val okHttpClient = OkHttpClient().newBuilder().build()
//
//    //Part 2: 宣告 Request，要求要連到指定網址
//    val request: Request = Request.Builder().url(pharmaciesDataUrl).get().build()
//
//    //Part 3: 宣告 Call
//    val call = okHttpClient.newCall(request)
//
//    //執行 Call 連線後，採用 enqueue 非同步方式，獲取到回應的結果資料
//    call.enqueue(object: Callback{
//        override fun onFailure(call: Call, e: IOException) {
//
//        }
//
//        override fun onResponse(call: Call, response: Response) {
//
//            val pharmaciesData = response.body?.string()
//
//            pharmacyInfo = Gson().fromJson(pharmaciesData, pharmacyInfoAuto::class.java)

//            val countyData = pharmacyInfo.features.groupBy { it.properties.county }
//            for(county in countyData){
//                Log.d("HKC",county.key)
//                val townData = county.value.groupBy { it.properties.town }
//                for(town in townData){
//                    Log.d("HKC","------${town.key}")
//                    for(pharmacy in town.value){
//                        Log.d("HKC","${pharmacy.properties.name}, 成人：${pharmacy.properties.mask_adult},小孩：${pharmacy.properties.mask_child}")
//                    }
//
//                }
//            }

//            val data = pharmacyInfo.features.filter { it.properties.county == "臺東縣" && it.properties.town == "池上鄉" }
//
//            data.forEach {
//                println(it.properties.name)
//            }
            runOnUiThread {
//            viewAdapter.pharmacyList = pharmacyInfo.features
            updateRecyclerView()
            binding.progressBar.visibility = View.GONE

            }
    }






//}

    private fun updateRecyclerView() {
        val filterData =
            mainViewModel.pharmacyInfo?.features?.filter {
            it.properties.county == currentCounty && it.properties.town == currentTown
        }

        if (filterData != null){
            viewAdapter.pharmacyList = filterData

        }
    }

    override fun onItemClickListener(data: Feature) {
    val intent = Intent(this,PharmacyDetailActivity::class.java)
        intent.putExtra("data",data)
        startActivity(intent)

    }
}