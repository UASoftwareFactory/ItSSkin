package kr.sofac.itsskin.ui.navigation

import kr.sofac.itsskin.data.model.Product

interface NavigationGridContract {

    interface View{
        fun onProductsLoaded(products : MutableList<Product>)
        fun onLoadError(message : String)
    }

    interface Presenter{
        fun loadProducts()
    }
}