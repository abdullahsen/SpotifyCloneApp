package com.iafnstudios.spotifycloneapp.radios

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.iafnstudios.spotifycloneapp.R

class RadiosFragment:Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_radios,container,false)
    }

    companion object {
        fun newInstance():Fragment{
            return RadiosFragment()
        }
    }
}