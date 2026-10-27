package vn.edu.vlu.kiemtra_laptrinhungdungdidong_2574802011742

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvStatus: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Ánh xạ View bằng findViewById truyền thống (Yêu cầu bắt buộc)
        edtEmail = findViewById(R.id.edtEmail)
        edtPassword = findViewById(R.id.edtPassword)
        btnLogin = findViewById(R.id.btnLogin)
        tvStatus = findViewById(R.id.tvStatus)

        // Xử lý sự kiện click vào Button 'Đăng nhập'
        btnLogin.setOnClickListener {
            val email = edtEmail.text.toString().trim()
            val password = edtPassword.text.toString().trim()

            // 1. Kiểm tra bỏ trống Email hoặc Mật khẩu
            if (email.isEmpty() || password.isEmpty()) {
                tvStatus.setTextColor(getColor(android.R.color.holo_red_dark))
                tvStatus.text = "Lỗi: Email hoặc Mật khẩu không được để trống!"
                return@setOnClickListener
            }

            // 2. Kiểm tra định dạng Email bằng Patterns.EMAIL_ADDRESS
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                tvStatus.setTextColor(getColor(android.R.color.holo_red_dark))
                tvStatus.text = "Lỗi: Email sai định dạng!"
                return@setOnClickListener
            }

            // 3. Kiểm tra Mật khẩu < 6 ký tự
            if (password.length < 6) {
                tvStatus.setTextColor(getColor(android.R.color.holo_red_dark))
                tvStatus.text = "Lỗi: Mật khẩu phải có ít nhất 6 ký tự!"
                return@setOnClickListener
            }

            // 4. Dữ liệu hoàn toàn hợp lệ -> Chuyển sang ProfileActivity bằng Intent
            tvStatus.setTextColor(getColor(android.R.color.holo_green_dark))
            tvStatus.text = "Xác thực thành công!"

            val intent = Intent(this, ProfileActivity::class.java).apply {
                putExtra("EXTRA_EMAIL", email)
            }
            startActivity(intent)
        }
    }
}
