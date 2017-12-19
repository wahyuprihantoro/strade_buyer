package id.strade.android.buyer.homefragment


import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import id.strade.android.buyer.R
import id.strade.android.buyer.adapter.CategoryAdapter
import id.strade.android.buyer.model.Category
import id.strade.android.buyer.network.ApiClient
import org.androidannotations.annotations.AfterViews
import org.androidannotations.annotations.Bean
import org.androidannotations.annotations.EFragment
import org.androidannotations.annotations.ViewById

@EFragment(R.layout.fragment_home)
open class HomeFragment : Fragment() {
    @ViewById
    lateinit var rv: RecyclerView
    @Bean
    lateinit var apiClient: ApiClient

    @AfterViews
    fun init() {
        val adapter = CategoryAdapter(getLists(), context)
        rv.layoutManager = GridLayoutManager(context, 3)
        rv.adapter = adapter
    }

    private fun getLists(): ArrayList<Category> {
        val lists = ArrayList<Category>()
        lists.add(Category("Makanan Ringan", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR0Y3cjPgzsITf7twf2iVQtA2wbTq9mfzwus4eIYqKObbWxbzoS",1))
        lists.add(Category("Minuman Segar", "https://2.bp.blogspot.com/-hMzpKRhpXqc/V0yhEsBPpyI/AAAAAAAABxA/pXYn4I98nj48sVVgQ7G4yqKW4N9uFAHqQCLcB/s1600/Minuman%2BSegar%2BDingin4.jpg", 2))
        lists.add(Category("Makanan Berat", "http://1.bp.blogspot.com/-GPf-3mkr8zQ/UeDjKWCJ2FI/AAAAAAAAMQY/UdrtaFszt9Y/s320/Malaysia+-+Nasi+Lemak.jpg", 3))
        lists.add(Category("Perabotan", "http://assets.kompas.com/data/photo/2016/04/21/1342273IMG-20160421-121008-HDR-1461220746570780x390.jpg", 4))
        lists.add(Category("Jasa", "http://cdn1-a.production.images.static6.com/4M19rTVeBGxTuBS0rGcfOPayyXk=/1280x720/smart/filters:quality(75):strip_icc():format(jpeg)/liputan6-media-production/medias/1631646/original/008050700_1498128021-Penjahit-Keliling-Banjir-Order-Jelang-Lebaran1.jpg", 5))
        lists.add(Category("Sayur dan Buah", "http://2.bp.blogspot.com/-BNPWxWocT4I/VXZnn_z6qzI/AAAAAAAASug/-YHXN8Fj6jg/s1600/1.Menggiurkannya-Pedagang-Sayur-Keliling-2.jpg", 6))
        lists.add(Category("Mainan", "http://cdn2.tstatic.net/bangka/foto/bank/images/pedagang-keliling_20170823_143910.jpg", 7))
        return lists
    }
}