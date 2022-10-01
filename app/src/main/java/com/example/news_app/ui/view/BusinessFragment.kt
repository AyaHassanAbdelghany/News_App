package com.example.news_app.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.news_app.databinding.FragmentBusinessBinding
import com.example.news_app.model.repository.NewsRepo
import com.example.news_app.network.NewsClient
import com.example.news_app.pojo.Articles
import com.example.news_app.ui.adapter.NewsAdapter
import com.example.news_app.ui.adapter.OnClickListner
import com.example.news_app.ui.viewmodel.NewsViewModel
import com.example.news_app.ui.viewmodel.NewsViewModelFactory

class BusinessFragment() : Fragment(),OnClickListner {

    private var _binding: FragmentBusinessBinding? = null
    private val binding get() = _binding!!
    private var catogeryType: String = ""
    private val newsVMFactory by lazy {
        NewsViewModelFactory(NewsRepo.getInstance(NewsClient.getInstance()))
    }
    private val newsVM by lazy {
        ViewModelProvider(this,newsVMFactory)[NewsViewModel::class.java]
    }
    private val  newsAdapter by lazy {
        NewsAdapter(requireContext(),this)
    }

    constructor(catogeryType: String) : this() {
        this.catogeryType = catogeryType
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentBusinessBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newsVM.getNews(catogeryType,"us")
    }

    override fun onResume() {
        super.onResume()
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

    override fun onClickItem(articles: Articles) {
        TODO("Not yet implemented")
    }

    override fun onClickShare(articles: Articles) {
        TODO("Not yet implemented")
    }
}