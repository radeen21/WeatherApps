package com.example.weatherapps.presentation.search.result

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.example.weatherapps.core.BaseAdapter
import com.example.weatherapps.databinding.ItemSearchResultBinding
import com.example.weatherapps.db.entity.CitiesForSearchEntity

class SearchResultAdapter(private val callBack: (CitiesForSearchEntity) -> Unit) : BaseAdapter<CitiesForSearchEntity>(
    diffCallback
) {

    override fun createBinding(parent: ViewGroup, viewType: Int): ViewDataBinding {
        val mBinding = ItemSearchResultBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        val viewModel = SearchResultItemViewModel()
        mBinding.viewModel = viewModel

        mBinding.rootView.setOnClickListener {
            mBinding.viewModel?.item?.get()?.let {
                callBack.invoke(it)
            }
        }
        return mBinding
    }

    override fun bind(binding: ViewDataBinding, position: Int) {
        (binding as ItemSearchResultBinding).viewModel?.item?.set(getItem(position))
        binding.executePendingBindings()
    }
}

val diffCallback = object : DiffUtil.ItemCallback<CitiesForSearchEntity>() {
    override fun areContentsTheSame(oldItem: CitiesForSearchEntity, newItem: CitiesForSearchEntity): Boolean =
        oldItem == newItem

    override fun areItemsTheSame(oldItem: CitiesForSearchEntity, newItem: CitiesForSearchEntity): Boolean =
        oldItem.name == newItem.name
}
