package co.artist.info

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import co.artist.info.model.ArtistiTunesResponse
import co.artist.info.view.fragment.DetailsFragment
import co.artist.info.view.fragment.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        launchFragment(HomeFragment(),getString(R.string.home))
    }


    private fun launchFragment(fragment: Fragment, fragmentTitle: String) {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.main_layout, fragment, fragmentTitle)
            .addToBackStack(getString(R.string.home))
            .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left)
            .commitAllowingStateLoss()
    }

    fun launchDetailsFragment(objectDetails: ArtistiTunesResponse.Projects){
        val details = DetailsFragment()
        val bundle = Bundle()
        bundle.putSerializable("objectdetails", objectDetails)
        details.arguments = bundle
        launchFragment(details, getString(R.string.details))


    }


}


