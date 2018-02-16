package kr.sofac.itsskin.ui.navigation

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_grid.view.*
import kr.sofac.itsskin.R
import kr.sofac.itsskin.data.model.Product
import kr.sofac.itsskin.data.model.callback.GridCallback

class GridFragment : Fragment(), NavigationGridContract.View {

    private lateinit var presenter: NavigationGridContract.Presenter
    private lateinit var adapter: GridAdapter
    private lateinit var products: MutableList<Product>


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_grid, container, false)
        products = arrayListOf()
        adapter = GridAdapter(products, object : GridCallback {
            override fun itemClick(position: Int) {

            }
        })
        view.gridRecycler.layoutManager = LinearLayoutManager(activity)
        view.gridRecycler.adapter = adapter
        presenter = NavigationGridPresenter(this)
        presenter.loadDefaultProducts()
        return view
    }

    override fun onProductsLoaded(loadedProducts: MutableList<Product>) {
        products.clear()
        products.addAll(loadedProducts)
        adapter.notifyDataSetChanged()
    }

    override fun onLoadError(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

    fun loadCategoryProducts(categoryURL : String){
        presenter.loadCategoryProducts(categoryURL)
    }
}