package com.hkc.maskinfo

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hkc.maskinfo.ViewModel.PharmacyDetailViewModel

class PharmacyDetailFragment : Fragment() {

    companion object {
        fun newInstance() = PharmacyDetailFragment()
    }

    private lateinit var viewModel: PharmacyDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.pharmacy_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PharmacyDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}