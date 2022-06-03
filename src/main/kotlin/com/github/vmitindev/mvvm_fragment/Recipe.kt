package com.github.vmitindev.mvvm_fragment

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.addAllKotlinDependencies
import com.github.vmitindev.mvvm_fragment.files.*

fun RecipeExecutor.mvvmFragmentTemplateSetup(
    moduleData: ModuleTemplateData,
    packageName: String,
    entityName: String,
    layoutName: String
) {
    val (_, srcOut, resOut) = moduleData

    addAllKotlinDependencies(moduleData)

    val fragmentClass = "${entityName}Fragment"
    val viewModelClass = "${entityName}ViewModel"

    save(
        fragment(packageName, entityName),
        srcOut.resolve("$fragmentClass.kt")
    )
    save(
        viewModel(packageName, entityName),
        srcOut.resolve("$viewModelClass.kt")
    )
    save(
        viewState(packageName),
        srcOut.resolve("ViewState.kt")
    )
    save(
        event(packageName),
        srcOut.resolve("Event.kt")
    )
    save(
        fragmentLayout(packageName, entityName),
        resOut.resolve("layout/$layoutName.xml")
    )
}