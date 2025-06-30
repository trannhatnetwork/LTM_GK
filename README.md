📘 Tổng hợp: Chữ ký số ECDSA & Bài tập kiểm chứng
🧠 1. Mục đích học
Bạn muốn hiểu và kiểm chứng:

Chữ ký số là gì và tại sao nó đảm bảo tính xác thực nội dung?

Làm sao để biết lá thư (dữ liệu) là do chính ông già Noel ký, không phải do bố mẹ giả mạo?

Sự khác biệt giữa nội dung đúng + chữ ký đúng và nội dung giả + chữ ký đúng (sai ngữ cảnh)

# 🎅 ECDSA Signature Verification – Lá Thư Ông Già Noel

## 📌 Mục tiêu

Dự án nhỏ này nhằm giúp bạn **hiểu rõ cơ chế chữ ký số (digital signature)** sử dụng thuật toán **ECDSA (Elliptic Curve Digital Signature Algorithm)** thông qua một câu chuyện thú vị về ông già Noel gửi thư.

Thông qua mã nguồn Python đơn giản, bạn sẽ:
- Tạo và lưu **cặp khóa ECDSA** (private & public key)
- **Ký một thông điệp** bằng khóa bí mật
- **Lưu chữ ký số**
- **Xác minh tính hợp lệ của chữ ký**
- Hiểu được cách phát hiện **thư bị giả mạo**

---


