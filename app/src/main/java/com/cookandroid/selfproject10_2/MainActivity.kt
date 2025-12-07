package com.cookandroid.selfproject10_2

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // 투표 수 배열 (9개)
    var voteCount = IntArray(9)

    // 이미지 이름 배열
    var imageName = arrayOf(
        "그림1", "그림2", "그림3",
        "그림4", "그림5", "그림6",
        "그림7", "그림8", "그림9"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ImageView ID 배열
        val imageId = arrayOf(
            R.id.iv1, R.id.iv2, R.id.iv3,
            R.id.iv4, R.id.iv5, R.id.iv6,
            R.id.iv7, R.id.iv8, R.id.iv9
        )

        // 이미지 클릭 설정
        for (i in imageId.indices) {
            val img = findViewById<ImageView>(imageId[i])
            img.setOnClickListener {
                voteCount[i]++
                Toast.makeText(
                    this,
                    "${imageName[i]} : 현재 ${voteCount[i]}표",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        // 결과 보기 버튼 기능
        val btnResult = findViewById<android.widget.Button>(R.id.btnResult)
        btnResult.setOnClickListener {

            val intent = Intent(this, ResultActivity::class.java)

            // 투표 수 전달
            intent.putExtra("VoteCount", voteCount)
            intent.putExtra("ImageName", imageName)

            startActivity(intent)
        }
    }
}
