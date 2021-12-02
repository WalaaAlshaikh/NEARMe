//package com.example.nearme.views.main
//
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Toast
//import androidx.fragment.app.activityViewModels
//import androidx.navigation.fragment.findNavController
//import com.example.nearme.R
//import com.example.nearme.adaptersimport.FavoriteImageAdapter
//import com.example.nearme.databinding.FragmentFavoriteImageFragmentBinding
//import com.example.nearme.views.main.FavoriteViewModel
//
//
//class favorite_image_fragment : Fragment() {
//   private lateinit var binding: FragmentFavoriteImageFragmentBinding
//   private val favoriteViewModel: FavoriteViewModel by activityViewModels()
//    private lateinit var favoriteImageAdapter: FavoriteImageAdapter
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        binding = FragmentFavoriteImageFragmentBinding.inflate(inflater,container,false)
//        return  binding.root
//        return inflater.inflate(R.layout.fragment_favorite_image_fragment, container, false)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        observers()
////        favoriteImageAdapter = FavoriteImageAdapter()
//        binding.favoritesRecyclerview.adapter = favoriteImageAdapter
//
//        favoriteViewModel.callFavorite()
//        binding.favoritesRecyclerview.setOnClickListener{
////            findNavController().navigate(R.id.action)
//        }
//    }
//    fun observers(){
//        favoriteViewModel.favoritesLiveData.observe(viewLifecycleOwner,{
//            binding.favoritesRecyclerview.animate().alpha(0f)
//
//
//        })
//    }
//
//}