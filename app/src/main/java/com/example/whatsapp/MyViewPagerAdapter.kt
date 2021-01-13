package com.example.whatsapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MyViewPagerAdapter (fm:FragmentManager): FragmentPagerAdapter(fm) {
    var frags =ArrayList<Fragment>()
    var titleTabs =ArrayList<String>()

    fun addFragment(frag:Fragment ,title:String){
        frags.add(frag)
        titleTabs.add(title)
    }
    override fun getCount(): Int {
       return frags.size
    }

    override fun getItem(position: Int): Fragment {
        return frags[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {

        return titleTabs[position]
    }
}