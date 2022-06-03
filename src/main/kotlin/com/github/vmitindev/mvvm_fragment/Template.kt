package com.github.vmitindev.mvvm_fragment

import com.android.tools.idea.wizard.template.*
private val humps = "(?<=.)(?=\\p{Upper})".toRegex()
fun String.toSnakeCase() = replace(humps, "_").toLowerCase()

val mvvmFragmentTemplate
    get() = template {
        name = "Fragment (Saldo)"
        description = "Creates a Fragment, VM, ViewState and Event."
        minApi = 16
        category = Category.Fragment // Check other categories
        formFactor = FormFactor.Mobile
        screens = listOf(WizardUiContext.FragmentGallery, WizardUiContext.MenuEntry,
            WizardUiContext.NewProject, WizardUiContext.NewModule)

        val packageNameParam = defaultPackageNameParameter
        val entityName = stringParameter {
            name = "Entity Name"
            default = ""
            help = "The name of the entity class to create and use in Fragment and ViewModel"
            constraints = listOf(Constraint.NONEMPTY)
        }

        val layoutName = stringParameter {
            name = "Layout Name"
            default = ""
            help = "The name of the layout to create for the fragment"
            constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
            suggest = {
                "fragment_" + entityName.value.toSnakeCase()
            }
        }

        widgets(
            TextFieldWidget(entityName),
            TextFieldWidget(layoutName),
            PackageNameWidget(packageNameParam)
        )

        recipe = { data: TemplateData ->
            mvvmFragmentTemplateSetup(
                data as ModuleTemplateData,
                packageNameParam.value,
                entityName.value,
                layoutName.value
            )
        }
    }

val defaultPackageNameParameter get() = stringParameter {
    name = "Package name"
    visible = { !isNewModule }
    default = "com.mycompany.myapp"
    constraints = listOf(Constraint.PACKAGE)
    suggest = { packageName }
}