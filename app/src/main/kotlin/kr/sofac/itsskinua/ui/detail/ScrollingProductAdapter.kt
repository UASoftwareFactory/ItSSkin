package kr.sofac.itsskinua.ui.detail

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_product_image_title_price.view.*
import kr.sofac.itsskinua.R
import kr.sofac.itsskinua.data.model.GlideApp
import kr.sofac.itsskinua.data.model.Product
import kr.sofac.itsskinua.data.network.ServerConfig

class ScrollingProductAdapter(private val listProducts: List<Product>, private val onItemClickListener : OnItemClickListener) : RecyclerView.Adapter<ScrollingProductAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onMyClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_product_image_title_price, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = listProducts.size

    override fun onBindViewHolder(holder: ScrollingProductAdapter.ViewHolder, position: Int) {
        holder.itemView.textTitleProduct.text = listProducts[position].name
        holder.itemView.textPriceProduct.text = listProducts[position].variant?.price
        GlideApp.with(holder.itemView)
                .load(ServerConfig.IMAGE_URL + listProducts[position].image!!.filename)
                .override(600, 600)
                .into(holder.itemView.imageSimilarProduct)
        holder.itemView.setOnClickListener { onItemClickListener.onMyClick(position) }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

}