package id.strade.android.buyer.homefragment


import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import id.strade.android.buyer.R
import id.strade.android.buyer.adapter.CategoryAdapter
import id.strade.android.buyer.model.Category
import org.androidannotations.annotations.AfterViews
import org.androidannotations.annotations.EFragment
import org.androidannotations.annotations.ViewById

@EFragment(R.layout.fragment_home)
open class HomeFragment : Fragment() {
    @ViewById
    lateinit var rv: RecyclerView

    @AfterViews
    fun init() {
        val adapter = CategoryAdapter(getLists(), context)
        rv.layoutManager = GridLayoutManager(context, 3)
        rv.adapter = adapter
    }

    private fun getLists(): ArrayList<Category> {
        val lists = ArrayList<Category>()
        lists.add(Category("Makanan Ringan", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR0Y3cjPgzsITf7twf2iVQtA2wbTq9mfzwus4eIYqKObbWxbzoS", "Jajanan dan sejenisnya"))
        lists.add(Category("Minuman Segar", "https://2.bp.blogspot.com/-hMzpKRhpXqc/V0yhEsBPpyI/AAAAAAAABxA/pXYn4I98nj48sVVgQ7G4yqKW4N9uFAHqQCLcB/s1600/Minuman%2BSegar%2BDingin4.jpg", "Aneka minuman dan sejenisnya"))
        lists.add(Category("Makanan Berat", "https://res.cloudinary.com/hellofresh/image/upload/dpr_auto,f_auto,fl_lossy,q_80,w_auto:100:1280/v1/hellofresh_s3/image/nasi-goreng-5fba5348.jpg", "Nasi goreng, sate, bakso, dll"))
        lists.add(Category("Perabotan", "http://assets.kompas.com/data/photo/2016/04/21/1342273IMG-20160421-121008-HDR-1461220746570780x390.jpg", "Alat-alat rumah tangga"))
        lists.add(Category("Jasa", "http://cdn1-a.production.images.static6.com/4M19rTVeBGxTuBS0rGcfOPayyXk=/1280x720/smart/filters:quality(75):strip_icc():format(jpeg)/liputan6-media-production/medias/1631646/original/008050700_1498128021-Penjahit-Keliling-Banjir-Order-Jelang-Lebaran1.jpg", "Aneka jasa keliling"))
        lists.add(Category("Sayur dan Buah", "http://2.bp.blogspot.com/-BNPWxWocT4I/VXZnn_z6qzI/AAAAAAAASug/-YHXN8Fj6jg/s1600/1.Menggiurkannya-Pedagang-Sayur-Keliling-2.jpg", "Sayur mayu dan buah-buahan"))
        lists.add(Category("Mainan", "http://cdn2.tstatic.net/bangka/foto/bank/images/pedagang-keliling_20170823_143910.jpg", "Mainan anak-anak"))
        return lists
    }
}