package kr.sofac.itsskinapp.ui.ordering


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kr.sofac.itsskinapp.R


/**
 * A simple [Fragment] subclass.
 */
class OrderingFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ordering, container, false)
    }

}
