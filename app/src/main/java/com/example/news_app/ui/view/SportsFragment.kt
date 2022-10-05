package com.example.news_app.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.preference.PreferenceManager
import com.example.news_app.databinding.FragmentSportsBinding
import com.example.news_app.model.repository.NewsRepo
import com.example.news_app.network.NewsClient
import com.example.news_app.ui.adapter.NewsAdapter
import com.example.news_app.ui.viewmodel.NewsViewModel
import com.example.news_app.ui.viewmodel.NewsViewModelFactory

class SportsFragment() : Fragment(){

    private var _binding: FragmentSportsBinding? = null
    private val binding get() = _binding!!
    private var catogeryType: String = ""
    private var isSearch : Boolean = false
    private val newsVMFactory by lazy {
        NewsViewModelFactory(NewsRepo.getInstance(NewsClient.getInstance()))
    }
    private val newsVM by lazy {
        ViewModelProvider(this,newsVMFactory)[NewsViewModel::class.java]
    }
    private val  newsAdapter by lazy {
        NewsAdapter(requireContext())
    }

    private val prefrence by lazy{
        PreferenceManager.getDefaultSharedPreferences(requireContext())
    }
    constructor(catogeryType: String,isSearch : Boolean) : this() {
        this.catogeryType = catogeryType
        this.isSearch = isSearch
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSportsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onResume() {
        super.onResume()
        if(!isSearch){
            newsVM.getNews(catogeryType,prefrence.getString("country","us")!!)
        }
        else{
            newsVM.getNewsSearch(NewsViewModel.textSearch,prefrence.getString("search","publishedAt")!!)
        }
        observeNews()
    }
    private fun observeNews(){
        newsVM.newsList.removeObservers(this)
        newsVM.newsList.observe(viewLifecycleOwner){
            binding.progress.visibility = View.INVISIBLE
            binding.recyclerNews.visibility = View.VISIBLE
            newsAdapter.setData(it.articles)
            binding.recyclerNews.adapter = newsAdapter
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}