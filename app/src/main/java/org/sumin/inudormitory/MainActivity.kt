package org.sumin.inudormitory

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.sumin.inudormitory.databinding.ActivityMainBinding
import org.sumin.inudormitory.databinding.FragmentPointBinding


class MainActivity : AppCompatActivity() {

    private val binding by lazy{ActivityMainBinding.inflate(layoutInflater)}
    private val pointBinding by lazy{ FragmentPointBinding.inflate(layoutInflater)}

    private lateinit var homeFragment: HomeFragment
    private lateinit var pointFragment: PointFragment
    private lateinit var billFragment: BillFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)    //툴바 설정해줌

        //첫 로그인시 홈화면이 선택되도록
        homeFragment = HomeFragment.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.frame_layout,homeFragment).commit()


        //바텀바로 탭 이동
        binding.bottomNavigation.setOnItemSelectedListener { id->
            when(id){
                R.id.menu_home->{
                    Log.d("메인엑티비티","homeFragment")
                    homeFragment = HomeFragment.newInstance()
                    supportFragmentManager.beginTransaction().replace(R.id.frame_layout,homeFragment).commit()
                }
                R.id.menu_bill->{
                    Log.d("메인엑티비티","billFragment")
                    billFragment = BillFragment.newInstance()
                    supportFragmentManager.beginTransaction().replace(R.id.frame_layout,billFragment).commit()
                }
                R.id.menu_demerits->{
                    Log.d("메인엑티비티","demeritsFragment")
                    pointFragment = PointFragment.newInstance()
                    supportFragmentManager.beginTransaction().replace(R.id.frame_layout,pointFragment).commit()
                }
            }
        }


        //벌점리스트, 상점리스트 액티비티 재활용

        pointBinding.plusListButton.setOnClickListener {

            Log.d("버튼클릭","상점리스트")
        }
    }


    fun setToolbarTitle(title: String){
        var toolbarTitle = findViewById<TextView>(R.id.toolbar_title)
        toolbarTitle.setText(title)
    }

}