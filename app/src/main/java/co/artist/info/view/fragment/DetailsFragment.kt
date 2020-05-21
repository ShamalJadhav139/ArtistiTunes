package co.artist.info.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.artist.info.databinding.FragmentDetailsBinding
import co.artist.info.model.ArtistiTunesResponse
import co.artist.info.view.BaseFragment



class DetailsFragment : BaseFragment() {
    private var fragmentDetailsBinding: FragmentDetailsBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentDetailsBinding = FragmentDetailsBinding.inflate(LayoutInflater.from(context), container, false)
        return fragmentDetailsBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (arguments != null) {
            val data = arguments!!.getSerializable("objectdetails") as ArtistiTunesResponse.Projects
            fragmentDetailsBinding!!.detailsObj = data

        }
    }

}