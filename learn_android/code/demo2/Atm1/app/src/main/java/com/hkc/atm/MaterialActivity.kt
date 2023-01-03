package com.hkc.atm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hkc.atm.databinding.ActivityMaterialBinding
import com.hkc.atm.Contact
import com.hkc.atm.databinding.ContactRowBinding

class MaterialActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMaterialBinding
//    private lateinit var binding2: ContactRowBinding
//    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMaterialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

//        val navController = findNavController(R.id.nav_host_fragment_content_material)
//        appBarConfiguration = AppBarConfiguration(navController.graph)
//        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        class ContactViewHolder (val contactRowBinding: ContactRowBinding) : RecyclerView.ViewHolder(contactRowBinding.root){
        }

        //    class MyViewHolder (val itemViewBinding: ItemViewBinding) : RecyclerView.ViewHolder(itemViewBinding.root){
//    }
        //    class ContactViewHolder(view: View): RecyclerView.ViewHolder(view){
//        val name = view.contact_name
//        val phone = view.contact_phone
//    }

        //data
        val contacts = listOf<Contact>(
            Contact("Hank","6661234"),
            Contact("Jack","998388882"),
            Contact("Jenny","98881234"),
            Contact("Eric","77366363"),
        )
//        binding.layoutInclude.recycler.setHasFixSize(true)
//        binding.layoutInclude.recycler.layoutManager = LinearLayoutManager(this)

        binding.layoutInclude.recycler.layoutManager = LinearLayoutManager(this)
        val adapter = object : RecyclerView.Adapter<ContactViewHolder>() {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
                val contactRowBinding =
                    ContactRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)

                return ContactViewHolder(contactRowBinding)

//                val view =
//                    layoutInflater.inflate(R.layout.contact_row,parent,false)
//                return ContactViewHolder(view)
            }

            override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
                holder.contactRowBinding.contactName.setText(contacts.get(position).name)
                holder.contactRowBinding.contactPhone.setText(contacts.get(position).phone)
            }

            override fun getItemCount(): Int {
                return contacts.size
            }

        }
        binding.layoutInclude.recycler.adapter = adapter


    }





//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.nav_host_fragment_content_material)
//        return navController.navigateUp(appBarConfiguration)
//                || super.onSupportNavigateUp()
//    }
}