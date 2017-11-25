package id.strade.android.buyer.homefragment


import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import android.widget.Toast
import id.strade.android.buyer.R
import id.strade.android.buyer.model.Store
import org.androidannotations.annotations.AfterViews
import org.androidannotations.annotations.EFragment
import org.androidannotations.annotations.ViewById
import id.strade.android.buyer.adapter.CategoryAdapter
import id.strade.android.buyer.model.Category

@EFragment(R.layout.fragment_home)
open class HomeFragment : Fragment() {
    @ViewById
    lateinit var rv: RecyclerView

    @AfterViews
    fun init() {
        val obj_adapter = CategoryAdapter(getLists(), rv, context)
        rv.layoutManager = GridLayoutManager(context, 3)
        rv.adapter = obj_adapter
    }

    fun getLists(): ArrayList<Category> {
        var lists = ArrayList<Category>()
        lists.add(Category("Makanan Ringan","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR0Y3cjPgzsITf7twf2iVQtA2wbTq9mfzwus4eIYqKObbWxbzoS","jajanan dan sejenisnya"))
        lists.add(Category("Minuman Segar","https://2.bp.blogspot.com/-hMzpKRhpXqc/V0yhEsBPpyI/AAAAAAAABxA/pXYn4I98nj48sVVgQ7G4yqKW4N9uFAHqQCLcB/s1600/Minuman%2BSegar%2BDingin4.jpg","es, jus, dan sejenisnya"))
        lists.add(Category("Makanan Berat","","nasi goreng,sate,bakso"))
        lists.add(Category("Perabotan","http://assets.kompas.com/data/photo/2016/04/21/1342273IMG-20160421-121008-HDR-1461220746570780x390.jpg","alat-alat rumah tangga"))
        lists.add(Category("Jasa","http://cdn1-a.production.images.static6.com/4M19rTVeBGxTuBS0rGcfOPayyXk=/1280x720/smart/filters:quality(75):strip_icc():format(jpeg)/liputan6-media-production/medias/1631646/original/008050700_1498128021-Penjahit-Keliling-Banjir-Order-Jelang-Lebaran1.jpg","sol sepatu atau jahit"))
        lists.add(Category("Sayur dan Buah","http://2.bp.blogspot.com/-BNPWxWocT4I/VXZnn_z6qzI/AAAAAAAASug/-YHXN8Fj6jg/s1600/1.Menggiurkannya-Pedagang-Sayur-Keliling-2.jpg","sayur mayu dan buah-buahan"))
        lists.add(Category("Mainan","http://cdn2.tstatic.net/bangka/foto/bank/images/pedagang-keliling_20170823_143910.jpg","mainan anak-anak"))
        return lists;
    }
}