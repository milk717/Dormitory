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
    private val pointBinding by lazy{ FragmentPointBinding.inflate(layoutInflater)}
    //메모리에 올라갔을때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("tag","DemeritFragment onCreate")
    }

    //엑티비티에 붙었을때
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("tag","DemeritFragment onAttach")
    }

    //프래그먼트와 레이아웃을 연결시켜주는 부분
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_point, container, false)
        setButtonClickEvent()
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

    private fun setButtonClickEvent(){
        pointBinding.plusListButton.setOnClickListener{onClick(pointBinding.plusListButton)}
        pointBinding.minusListButton.setOnClickListener{onClick(pointBinding.minusListButton)}
    }

    private fun onClick(view:View)=View.OnClickListener {
        when(view){
            pointBinding.plusListButton->{
                Log.d("버튼클릭","상점리스트")
            }
            pointBinding.minusListButton->{
                Log.d("버튼클릭","벌점리스트")
            }
        }
    }

}