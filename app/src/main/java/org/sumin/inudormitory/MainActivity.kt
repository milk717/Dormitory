package org.sumin.inudormitory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.google.android.material.tabs.TabLayoutMediator
import org.sumin.inudormitory.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy{ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val fragmentList = listOf(HomeFragment(),DemeritFragment(),BillFragment(),ListFragment())       //프래그먼트 목록 생성
        val adapter = FragmentAdapter(this)         //어댑터 생성
        adapter.fragmentList = fragmentList     //어댑터에 프래그먼트 목록 저장
        binding.viewpager.adapter = adapter     //뷰페이저 불러오고 어댑터 적용

        val tabTitle = listOf<String>("디폴트","벌점","공공요금","더보기")      //디자인 끝나면 아이콘으로 바꾸기
        TabLayoutMediator(binding.tabs,binding.viewpager){tab,position->
            tab.text=tabTitle[position]
        }.attach()

    }

    fun setActionBarTitle(title:String){
        var actionBar = getSupportActionBar()
        if(actionBar != null){
            actionBar.setTitle(title)
        }
    }
}