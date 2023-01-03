package com.hkc.maskinfo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.hkc.maskinfo.databinding.InfoWindowBinding
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker

class MyInfoWindowAdapter (_context: Context) : GoogleMap.InfoWindowAdapter {

    private val context = _context

    private fun render(marker: Marker, infoWindowBinding: InfoWindowBinding){
        val mask = marker.snippet.toString().split(",")
        infoWindowBinding.tvName.text = marker.title
        infoWindowBinding.tvAdultAmount.text = mask[0]
        infoWindowBinding.tvChildAmount.text = mask[1]
    }



    override fun getInfoWindow(p0: Marker): View? {
        return null
    }

    override fun getInfoContents(p0: Marker): View? {
        val infoWindowBinding =
            InfoWindowBinding.inflate(context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
        render(p0,infoWindowBinding)
        return infoWindowBinding.root

    }
}