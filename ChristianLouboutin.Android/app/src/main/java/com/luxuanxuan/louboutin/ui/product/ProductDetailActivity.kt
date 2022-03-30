package com.luxuanxuan.louboutin.ui.product

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.luxuanxuan.louboutin.R
import com.luxuanxuan.louboutin.models.ItemCartDto
import com.luxuanxuan.louboutin.repository.attributes
import com.luxuanxuan.louboutin.repository.listPumbs
import com.luxuanxuan.louboutin.repository.medias
import com.luxuanxuan.louboutin.repository.productInfos
import com.luxuanxuan.louboutin.ui.BaseActivity
import com.luxuanxuan.louboutin.ui.product.attribute.AttributeAdapter
import com.luxuanxuan.louboutin.ui.product.information.ProductInfoAdapter
import kotlinx.android.synthetic.main.activity_product_detail.*

class ProductDetailActivity : BaseActivity() {

  private var itemCount: Int = 0
  private var notifyAddItemToCartDialog : NotifyAddItemToCartDialog? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_product_detail)

    initView()
    productViewpager.adapter = MediaViewpagerAdapter(medias)
    wormDotsIndicator.setViewPager(productViewpager)


    attributeRecyclerView.adapter = AttributeAdapter(attributes)
    productInfoRecyclerView.adapter = ProductInfoAdapter(productInfos)
    productSuggestRecyclerView.adapter = ProductAdapter(listPumbs, true)
  }

  private fun initView() {
    getLouboutinToolbar()

    notifyAddItemToCartDialog = NotifyAddItemToCartDialog(this)

    collapsingToolbarLayout("Christian Louboutin So Kate 120 Patent")

    attributeRecyclerView.layoutManager = LinearLayoutManager(this)
    productInfoRecyclerView.layoutManager = LinearLayoutManager(this)
    productSuggestRecyclerView.layoutManager =
      LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)

    decreaseButton.setOnClickListener {
      if (itemCount > 1) {
        itemCount--
        itemCountTextView.text = itemCount.toString()
      }
    }

    increaseButton.setOnClickListener {
      itemCount++
      itemCountTextView.text = itemCount.toString()
    }

    addToCartButton.setOnClickListener {
      val newItem = ItemCartDto().apply {
        id = 1
        productPrice = 675.0
      }
      notifyAddItemToCartDialog?.setNewItemCart(newItem)
      notifyAddItemToCartDialog?.showDialog()
    }
  }
}