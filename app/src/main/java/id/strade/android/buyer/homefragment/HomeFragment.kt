package id.strade.android.buyer.homefragment


import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import android.widget.Toast
import id.strade.android.buyer.CustomAdapter
import id.strade.android.buyer.R
import id.strade.android.buyer.model.Store
import org.androidannotations.annotations.AfterViews
import org.androidannotations.annotations.EFragment
import org.androidannotations.annotations.ViewById

@EFragment(R.layout.fragment_home)
open class HomeFragment : Fragment() {
    @ViewById
    lateinit var rv: RecyclerView

    @AfterViews
    fun init() {
        val obj_adapter = CustomAdapter(getLists(),rv,context)
        Toast.makeText(context, "${getLists().size}", Toast.LENGTH_SHORT).show()
        rv.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
        rv.adapter = obj_adapter
    }

    fun getLists(): ArrayList<Store> {
        var lists = ArrayList<Store>()
        lists.add(Store(1, 1, "Bakso Pak Mamat", 0, "08.00", "16.00"))
        lists.add(Store(1, 1, "Siomay Bang Jek", 0, "08.00", "16.00"))
        lists.add(Store(1, 1, "Jamu Gendong Uhuy", 0, "08.00", "16.00"))
        return lists;
    }
}