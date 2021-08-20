package org.sumin.inudormitory

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.sumin.inudormitory.databinding.FragmentPointBinding

class PointFragment : Fragment() {
    lateinit var pointBinding:FragmentPointBinding
    //메모리에 올라갔을때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("tag","DemeritFragment onCreate")
    }

    //프래그먼트와 레이아웃을 연결시켜주는 부분
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        pointBinding = FragmentPointBinding.inflate(inflater,container,false)
        return pointBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pointBinding.plusListButton.setOnClickListener {
            Log.d("버튼클릭","상점리스트")
        }
        pointBinding.minusListButton.setOnClickListener {
            Log.d("버튼클릭","벌점리스트")
        }
    }

    override fun onResume() {
        super.onResume()
        val mainActivity = requireActivity() as MainActivity
        mainActivity.setToolbarTitle("상·벌점조회")
        
    }

    companion object {
        fun newInstance():PointFragment{
            return PointFragment()
        }
    }

}