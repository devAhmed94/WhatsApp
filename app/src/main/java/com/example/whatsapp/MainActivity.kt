package com.example.whatsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.whatsapp.fragments.CallsFragment
import com.example.whatsapp.fragments.ChatsFragment
import com.example.whatsapp.fragments.StatusFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myToolbar.title = "WhatsApp"
        setSupportActionBar(this.myToolbar)
        var myAdapter =MyViewPagerAdapter(supportFragmentManager)
        myAdapter.addFragment(ChatsFragment(),"Chats")
        myAdapter.addFragment(StatusFragment(),"Status")
        myAdapter.addFragment(CallsFragment(),"Calls")
        myPager.adapter =myAdapter
        mytab.setupWithViewPager(myPager)
        btn_contextual.setOnClickListener {
           startSupportActionMode(MyContextual())
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.search ->{
                Toast.makeText(this,"search",Toast.LENGTH_SHORT).show()
            }
            R.id.newBroadcast ->{
                Toast.makeText(this,"newBroadcast",Toast.LENGTH_SHORT).show()

            }
            R.id.newGroup ->{
                Toast.makeText(this,"newGroup",Toast.LENGTH_SHORT).show()

            }
            R.id.starMessage ->{
                Toast.makeText(this,"starMessage",Toast.LENGTH_SHORT).show()

            }
            R.id.web ->{
                Toast.makeText(this,"web",Toast.LENGTH_SHORT).show()

            }
            R.id.setting ->{
                Toast.makeText(this,"setting",Toast.LENGTH_SHORT).show()

            }
        }
        return true
    }

    inner class MyContextual :androidx.appcompat.view.ActionMode.Callback {

        override fun onCreateActionMode(
            mode: androidx.appcompat.view.ActionMode?,
            menu: Menu?
        ): Boolean {
            mode?.menuInflater?.inflate(R.menu.contextual,menu)
            return true
        }

        override fun onPrepareActionMode(
            mode: androidx.appcompat.view.ActionMode?,
            menu: Menu?
        ): Boolean {
            mode?.title ="My contextual "
            return true
        }

        override fun onActionItemClicked(
            mode: androidx.appcompat.view.ActionMode?,
            item: MenuItem?
        ): Boolean {
            Toast.makeText(this@MainActivity,"contextual menu",Toast.LENGTH_SHORT).show()
          return true
        }

        override fun onDestroyActionMode(mode: androidx.appcompat.view.ActionMode?) {
            mode?.finish()
        }


    }
}