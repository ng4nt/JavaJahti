package fi.ngantran.javajahti

import android.os.Bundle
import android.webkit.JavascriptInterface
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class StatsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val webView = WebView(this)
        setContentView(webView)

        webView.settings.javaScriptEnabled = true

        val json = """
        {
          "correct": ${intent.getIntExtra("correct", 0)},
          "wrong": ${intent.getIntExtra("wrong", 0)},
          "syntax": ${intent.getIntExtra("syntax", 0)},
          "type": ${intent.getIntExtra("type", 0)},
          "logic": ${intent.getIntExtra("logic", 0)},
          "comparison": ${intent.getIntExtra("comparison", 0)}
        }
        """.trimIndent()

        webView.addJavascriptInterface(object {
            @JavascriptInterface
            fun getStats() = json

            @JavascriptInterface
            fun finish() {
                runOnUiThread {
                    finish()
                }
            }
        }, "Android")

        webView.loadUrl("file:///android_asset/stats.html")
    }
}