package org.sumin.inudormitory

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class HomeFragment : Fragment() {

    //메모리에 올라갔을때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("tag","HomeFragment onCreate")
    }

    //엑티비티에 붙었을때
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("tag","HomeFragment onAttach")
    }

    //프래그먼트와 레이아웃을 연결시켜주는 부분
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onResume() {
        super.onResume()
        val mainActivity = requireActivity() as MainActivity
        mainActivity.setToolbarTitle("인천대학교 기숙사")
    }

    companion object {
        fun newInstance():HomeFragment{
            return HomeFragment()
        }
    }
}