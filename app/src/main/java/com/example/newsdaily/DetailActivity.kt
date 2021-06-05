package com.example.newsdaily

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val url =intent.getStringExtra("URL")
        if(url!=null)
        {
            val web =findViewById<WebView>(R.id.detailWebView)
            val pro = findViewById<ProgressBar>(R.id.progressBar5)
            web.settings.javaScriptEnabled=true
            web.settings.userAgentString="Mozilla/5.0 (Linux; Android 10; Pixel 3a XL) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.117 Mobile Safari/537.36"
            web.webViewClient=object : WebViewClient()
            {
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    pro.visibility= View.GONE
                    web.visibility= View.VISIBLE

                }
            }

            web.loadUrl(url)



        }



    }
}