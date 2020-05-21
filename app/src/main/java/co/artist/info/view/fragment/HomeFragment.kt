package co.artist.info.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import co.artist.info.R
import co.artist.info.adapter.HomeAdapter
import co.artist.info.constant.ApiConstants
import co.artist.info.databinding.FragmentHomeBinding
import co.artist.info.model.ArtistiTunesResponse
import co.artist.info.network.MainContract
import co.artist.info.presenter.MainActivityPresenter
import co.artist.info.view.BaseFragment
import co.artist.info.viewmodel.ProjectsViewModel
import com.google.gson.Gson


class HomeFragment : BaseFragment(), MainContract.View {
    private var binding: FragmentHomeBinding? = null
    private var presenter: MainContract.Presenter? = null
    private lateinit var homeAdapter: HomeAdapter
    private var mViewModel: ProjectsViewModel? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        presenter = MainActivityPresenter(this)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init(){
        mViewModel = ViewModelProviders.of(this).get(ProjectsViewModel::class.java)
        binding!!.iTunesGrid.layoutManager = GridLayoutManager(context!!, 3)
        homeAdapter = HomeAdapter()
        binding!!.iTunesGrid.adapter = homeAdapter
        mViewModel!!.allWords.observe(activity!!,
            Observer<List<ArtistiTunesResponse.Projects>> { words ->
                homeAdapter.setData(words)

            })

        binding!!.submitBtn.setOnClickListener {
            if(binding!!.searchEditText.text.isNotEmpty()){
            presenter!!.onClick(
                ApiConstants.artistiTunes,
                arrayOf(binding!!.searchEditText.text.toString()),
                requireContext(),
                true
            )
            }else{
                showToast("Please enter artist name in search box")
            }
        }

    }
    companion object {
        private val TAG = HomeFragment::class.java.name
    }

    override fun initView() {

    }

    override fun setViewData(data: String, view: ApiConstants) {
        when (view) {
            ApiConstants.artistiTunes -> {
                val response = Gson().fromJson(data, ArtistiTunesResponse::class.java)
                if(response.results!=null){
                    homeAdapter.setData(response.results)
                    mViewModel!!.deleteAll()
                    mViewModel!!.insertAll(response.results)




                }
            }
        }
    }




}