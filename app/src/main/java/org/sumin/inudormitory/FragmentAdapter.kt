package org.sumin.inudormitory

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    var fragmentList = listOf<Fragment>()       //프래그먼트 목록을 담아줄 리스트

    override fun getItemCount(): Int {          //어댑터가 화면에 보여줄 프래그먼트의 개수를 반환해주는 메소드
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {      //position에 해당하는 위치의 프래그먼트를 만들어서 안드로이드에 반환해줌
        return fragmentList[position]
    }
}