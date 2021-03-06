package id.strade.android.buyer.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import id.strade.android.buyer.R
import id.strade.android.buyer.model.Product


/**
 * Created by wahyu on 18 November 2017.
 */
class ProductAdapter(var context: Context, var products: List<Product>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {


    companion object {
        var productIds: MutableMap<Int, Int> = HashMap()
    }

    override fun getItemCount() = products.size


    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView = itemView.findViewById(R.id.imageView)
        var name: TextView = itemView.findViewById(R.id.name)
        var price: TextView = itemView.findViewById(R.id.price)
        var editText: EditText = itemView.findViewById(R.id.edit_text)
        fun bind(product: Product) {
            Glide.with(context).load(product.imageUrl).into(image)
            name.text = product.name
            price.text = product.price.toString()
            editText.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable) {
                    try {
                        if (s.toString().toInt() > 0) {
                            productIds[product.id] = s.toString().toInt()
                            Log.d("wahyu et", s.toString())
                            Log.d("wahyu et1", product.id.toString())
                            Log.d("wahyu et2", productIds[product.id].toString())
                        }
                    } catch (ignored: Exception) {

                    }
                }

                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                }
            })
        }
    }

    fun getProductIds(): List<Int>? {
        val ids = ArrayList<Int>()
        Log.d("wahyu key", productIds.keys.toString())
        productIds.keys.forEach {
            for (i in 1..productIds[it]!!)
                ids.add(it)
        }
        Log.d("wahyu ids", ids.toString())
        return ids
    }
}