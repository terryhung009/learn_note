package com.hkc.atm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import android.Manifest.permission.*
import android.content.pm.PackageManager
import android.provider.ContactsContract
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.hkc.atm.databinding.ActivityContactsBinding
import com.hkc.atm.databinding.ContactRowBinding

class ContactsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContactsBinding

    companion object {
        val REQUEST_CONTACTS = 100
    }
    val contacts = mutableListOf<Contact>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_contacts)

        binding = ActivityContactsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        class ContactViewHolder (val contactRowBinding: ContactRowBinding) : RecyclerView.ViewHolder(contactRowBinding.root){
        }

        val permission = ActivityCompat.checkSelfPermission(this, READ_CONTACTS)
        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(READ_CONTACTS, WRITE_CONTACTS),
                REQUEST_CONTACTS
            )
        } else {
            readContacts()
        }
        //data
//        val contacts = listOf<Contact>(
//            Contact("Hank", "6661234"),
//            Contact("Jack", "99838882"),
//            Contact("Jenny", "98881234"),
//            Contact("Eric", "77366363"))
//        setupRecyclerView()


    }

    private fun readContacts() {
        val cursor = contentResolver.query(
            ContactsContract.Contacts.CONTENT_URI,
            null,
            null,
            null,
            null
        )
        cursor?.run{
            while (cursor.moveToNext()){
                var id = cursor.getInt(cursor.getColumnIndex(ContactsContract.Contacts._ID))
//                Log.d("HKC","$id")
//                var id = cursor.getInt(
//                    cursor.getColumnIndex(ContactsContract.Contacts._ID))
                var name = cursor.getString(
                    cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
//                Log.d("HKC","$name")
                contacts.add(Contact(name,""))


            }

        }
        setupRecyclerView()

    }

    private fun setupRecyclerView() {

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            REQUEST_CONTACTS ->{
            if (grantResults.size > 1 &&
                grantResults[0] == PackageManager.PERMISSION_GRANTED
            ) {
                readContacts()
            } else {
            AlertDialog.Builder(this)
                .setMessage("必須允許聯絡人權限才能顯示資料")
                .setPositiveButton("OK",null)
                .show()
            }
        }
    }

    }
}