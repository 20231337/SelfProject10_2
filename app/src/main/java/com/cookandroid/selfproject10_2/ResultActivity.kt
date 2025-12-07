package com.cookandroid.selfproject10_2

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)   // ★★ 검은 화면 해결 핵심 ★★

        title = "투표 결과"

        val voteResult = intent.getIntArrayExtra("VoteCount")!!
        val imageName = intent.getStringArrayExtra("ImageName")!!

        val imageField = arrayOf(
            R.drawable.pic1, R.drawable.pic2, R.drawable.pic3,
            R.drawable.pic4, R.drawable.pic5, R.drawable.pic6,
            R.drawable.pic7, R.drawable.pic8, R.drawable.pic9
        )

        // 가장 많은 득표 그림 찾기
        var maxIndex = 0
        for (i in voteResult.indices) {
            if (voteResult[i] > voteResult[maxIndex]) {
                maxIndex = i
            }
        }

        // 상단 이름 + 이미지
        val tvTop = findViewById<TextView>(R.id.tvTop)
        val ivTop = findViewById<ImageView>(R.id.ivTop)

        tvTop.text = imageName[maxIndex]
        tvTop.setTextColor(Color.BLUE)
        tvTop.setTypeface(null, Typeface.BOLD)

        ivTop.setImageResource(imageField[maxIndex])

        // 그림 9개 ratingbar 채우기
        val tv = arrayOf(
            R.id.tv1, R.id.tv2, R.id.tv3,
            R.id.tv4, R.id.tv5, R.id.tv6,
            R.id.tv7, R.id.tv8, R.id.tv9
        )

        val rbar = arrayOf(
            R.id.rbar1, R.id.rbar2, R.id.rbar3,
            R.id.rbar4, R.id.rbar5, R.id.rbar6,
            R.id.rbar7, R.id.rbar8, R.id.rbar9
        )

        for (i in voteResult.indices) {
            val textView = findViewById<TextView>(tv[i])
            val ratingBar = findViewById<RatingBar>(rbar[i])

            textView.text = imageName[i]
            ratingBar.rating = voteResult[i].toFloat()
        }
    }
}
