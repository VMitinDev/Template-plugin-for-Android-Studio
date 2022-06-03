package com.github.vmitindev.mvvm_fragment.files

fun fragment(
    packageName: String,
    entityName: String,
) = """
package $packageName

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.saldo.core.lifecycle.observe
import com.saldo.core.lifecycle.observeViewState
import com.saldo.finance.databinding.Fragment${entityName}Binding
import com.saldo.finance.ui.base.fragment.BindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ${entityName}Fragment : BindingFragment<Fragment${entityName}Binding>() {
    private val viewModel by viewModels<${entityName}ViewModel>()
    override val commonViewModel
        get() = viewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return Fragment${entityName}Binding.inflate(inflater).also(attachViews).root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initControls()
        with(viewModel) {
            observeViewState(viewState, ::updateUI)
            observe(event, ::handleEvent)
        }
    }
    
    private fun initControls() {
        withViews {
            
        }
    }

    private fun handleEvent(event: Event?) {
        when (event) {
            
        }
    }

    private fun updateUI(viewState: ViewState?) {
        when (viewState) {
            
        }
    }
}
"""

fun viewModel(
    packageName: String,
    entityName: String,
) = """
package $packageName

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.saldo.core.lifecycle.SingleLiveEvent
import com.saldo.finance.ui.base.CommonViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ${entityName}ViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
) : CommonViewModel() {

    private val loadingView by lazy { MutableLiveData<ViewState.Loading>() }

    override val viewState = listOf(
        loadingView
    )
    val event by lazy { SingleLiveEvent<Event>() }

}
"""

fun viewState(
    packageName: String,
) = """
package $packageName

import com.saldo.core.lifecycle.BaseViewState

sealed class ViewState : BaseViewState() {
    class Loading(val isVisible: Boolean) : ViewState()    
}    
"""

fun event(
    packageName: String,
) = """
package $packageName

sealed class Event {
    
}    
"""

fun fragmentLayout(
    packageName: String,
    entityName: String) = """
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="${packageName}.${entityName}Fragment">

</androidx.constraintlayout.widget.ConstraintLayout>
"""