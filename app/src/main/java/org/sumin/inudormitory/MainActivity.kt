package org.sumin.inudormitory

import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toolbar
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayoutMediator
import org.sumin.inudormitory.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    val binding by lazy{ActivityMainBinding.inflate(layoutInflater)}

    private lateinit var homeFragment: HomeFragment
    private lateinit var demeritFragment: DemeritFragment
    private lateinit var billFragment: BillFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)    //툴바 설정해줌

        //첫 로그인시 홈화면이 선택되도록
        homeFragment = HomeFragment.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.frame_layout,homeFragment).commit()

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
                    demeritFragment = DemeritFragment.newInstance()
                    supportFragmentManager.beginTransaction().replace(R.id.frame_layout,demeritFragment).commit()
                }
            }
        }

    }

    fun setToolbarTitle(title: String){
        var toolbarTitle = findViewById<TextView>(R.id.toolbar_title)
        toolbarTitle.setText(title)
    }
}