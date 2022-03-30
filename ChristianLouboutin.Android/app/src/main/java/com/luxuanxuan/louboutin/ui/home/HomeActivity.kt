package com.luxuanxuan.louboutin.ui.home

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.luxuanxuan.louboutin.R
import com.luxuanxuan.louboutin.models.ItemBannerDto
import com.luxuanxuan.louboutin.repository.*
import com.luxuanxuan.louboutin.ui.BaseActivity
import com.luxuanxuan.louboutin.ui.cart.CartActivity
import com.luxuanxuan.louboutin.ui.home.searchtab.CategoryAdapter
import com.luxuanxuan.louboutin.ui.product.ProductAdapter
import com.luxuanxuan.louboutin.ui.search.SearchActivity
import com.zhpan.bannerview.BannerViewPager
import com.zhpan.bannerview.constants.PageStyle.MULTI_PAGE
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity() {

  private lateinit var louboutinBanner: BannerViewPager<ItemBannerDto>

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_home)

    initView()  
    getDataForNavigationDrawerView()
    getHomePageContent()
  }

  private fun initView() {
    setSupportActionBar(toolbar)
    supportActionBar?.title = ""
    louboutinBanner = findViewById(R.id.louboutinBanner)

    toolbar.setNavigationOnClickListener {
      drawerLayout.open()
    }

    categoryRecyclerView.layoutManager = LinearLayoutManager(this)

    navigateAccountButton.setOnClickListener {

    }
  }

  override fun onStop() {
    drawerLayout.closeDrawers()
    super.onStop()
  }

  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    menuInflater.inflate(R.menu.menu_home_toolbar, menu)
    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    when (item.itemId) {
      R.id.menu_cart -> {
        navigateTo(CartActivity::class.java)
        return true
      }
      R.id.menu_search -> {
        navigateTo(SearchActivity::class.java)
        return true
      }
    }
    return super.onOptionsItemSelected(item)
  }

  private fun getDataForNavigationDrawerView() {
    // We need to get the category data from `Data Catcher`
    // `Data Catcher` that is store at internal disk in the first time using app

    categoryRecyclerView.adapter = CategoryAdapter(categoryParent).apply {

      // get listen events from `CategoryAdapter`
      setListener(object : CategoryAdapter.CategoryAdapterListener {
        override fun onItemClick(category: String?) {

          //Navigate to deeper level categories
          //To show the child categories by adding a new fragment in this Navigation Drawer
          addFragmentWithBackStack(
            R.id.fragmentContainer,
            CategoryDetailFragment(),
            CategoryDetailFragment.tag
          )
        }
      })
    }
  }

  private fun getHomePageContent() {
    homeRecyclerView.adapter = HomeAdapter(homes)
    louboutinBanner.apply {
  
      adapter = BannerAdapter()
      // Set LouboutinBanner property
      setCanLoop(false) 
      setLifecycleRegistry(lifecycle)
      setPageStyle(MULTI_PAGE)
    }.create(banners)
  }
}