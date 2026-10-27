package vn.edu.vlu.kiemtra_laptrinhungdungdidong_2574802011742

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    private lateinit var tvProfileTitle: TextView
    private lateinit var tvUserEmail: TextView
    private lateinit var btnLogout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Ánh xạ View bằng findViewById truyền thống (Yêu cầu bắt buộc)
        tvProfileTitle = findViewById(R.id.tvProfileTitle)
        tvUserEmail = findViewById(R.id.tvUserEmail)
        btnLogout = findViewById(R.id.btnLogout)

        // Nhận dữ liệu Email được truyền từ LoginActivity qua Intent
        val email = intent.getStringExtra("EXTRA_EMAIL") ?: ""
        tvUserEmail.text = "Email: $email"

        // Xử lý sự kiện click nút 'Đăng xuất'
        btnLogout.setOnClickListener {
            finish()
        }
    }
}
