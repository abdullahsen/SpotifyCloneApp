package com.iafnstudios.spotifycloneapp.radios

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.iafnstudios.spotifycloneapp.R
import com.iafnstudios.spotifycloneapp.Radio
import com.iafnstudios.spotifycloneapp.RadioServiceProvider
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RadiosFragment : Fragment() {

    private val radioServiceProvider = RadioServiceProvider()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_radios, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        radioServiceProvider
            .getRadioService()
            .getPopularRadios().enqueue(object : Callback<List<Radio>> {
                override fun onFailure(call: Call<List<Radio>>, t: Throwable) {
                    Log.v("TEST", "Failed!")
                }

                override fun onResponse(call: Call<List<Radio>>, response: Response<List<Radio>>) {
                    Log.v("TEST", "Success: ${response.body()}")
                }

            })


        radioServiceProvider
            .getRadioService()
            .getLocationRadios().enqueue(object : Callback<List<Radio>> {
                override fun onFailure(call: Call<List<Radio>>, t: Throwable) {
                    Log.v("TEST", "Failed! ${t.toString()}")
                }

                override fun onResponse(call: Call<List<Radio>>, response: Response<List<Radio>>) {
                    Log.v("TEST", "Success: ${response.body()}")
                }
            }
            )

    }

    companion object {
        fun newInstance(): Fragment {
            return RadiosFragment()
        }
    }
}