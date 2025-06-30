# 🔐 Giải thích lý thuyết: Chữ ký số ECDSA qua ví dụ ông già Noel 🎅

## 1. Chữ ký số là gì?

**Chữ ký số (Digital Signature)** là một cơ chế trong mật mã học giúp:
- Xác thực **ai** là người gửi dữ liệu
- Đảm bảo **dữ liệu không bị thay đổi**
- Ngăn chặn việc **giả mạo thông điệp**

Khác với chữ ký tay, chữ ký số được tạo bằng **thuật toán mã hóa bất đối xứng** (asymmetric cryptography) như RSA hoặc ECDSA.

---

## 2. Tại sao cần chữ ký số?

Hãy tưởng tượng:
> Ông già Noel gửi thư cho bé Alice. Làm sao bé biết **lá thư đó do chính tay ông gửi**, **không phải bố mẹ viết giả**?

Nếu không có chữ ký số, bất kỳ ai (kể cả người xấu) có thể viết một lá thư giả mạo.

---

## 3. ECDSA là gì?

**ECDSA (Elliptic Curve Digital Signature Algorithm)** là một thuật toán chữ ký số dựa trên **mật mã đường cong elliptic**.

Nó có ưu điểm:
- Bảo mật mạnh với khóa nhỏ (nhẹ hơn RSA)
- Hiệu quả và được sử dụng phổ biến trong nhiều hệ thống: Bitcoin, SSH, v.v.

---

## 4. Chữ ký số hoạt động như thế nào?

### 🖊️ Quá trình ký:
1. Người gửi (ví dụ: ông già Noel) dùng **private key** để ký vào dữ liệu (lá thư).
2. Tạo ra một **chữ ký số** – giống như "nét bút điện tử" duy nhất cho nội dung đó.

### 🔍 Quá trình xác minh:
1. Người nhận (bé Alice) dùng **public key** tương ứng để kiểm tra chữ ký.
2. Nếu chữ ký **khớp với nội dung**, thì:
   - Dữ liệu không bị sửa
   - Đúng là do người nắm private key ký (ông già Noel thật)

---

## 5. Nếu người khác thay đổi nội dung thư thì sao?

✅ Nếu nội dung giữ nguyên → chữ ký vẫn hợp lệ  
❌ Nếu nội dung bị thay đổi (dù chỉ một dấu chấm) → chữ ký sẽ **không còn hợp lệ**

⛔ Điều này giúp phát hiện mọi hành vi giả mạo hoặc chỉnh sửa nội dung.

---

## 6. Có thể giả mạo chữ ký số không?

Không, trừ khi kẻ giả mạo:
- **Có được private key** của người gửi (rất khó nếu lưu trữ đúng cách)
- Hoặc phá được thuật toán mật mã (hiện tại bất khả thi với ECDSA đủ mạnh)

---

## 7. Sự khác biệt giữa ECDSA và các thuật toán khác?

| Thuật toán | Loại | Ưu điểm | Sử dụng ở đâu? |
|------------|------|---------|----------------|
| **ECDSA** | Bất đối xứng | Nhẹ, nhanh, bảo mật cao | Blockchain, SSH, TLS |
| RSA | Bất đối xứng | Dễ hiểu, phổ biến lâu năm | Email, HTTPS |
| AES | Đối xứng | Rất nhanh, dùng cho mã hóa nội dung | Sau khi chia khóa bằng ECDH |

---

## 8. Ví dụ thực tế: Ông già Noel gửi thư

| Vai trò | Tương ứng kỹ thuật |
|--------|---------------------|
| Ông già Noel | Người ký bằng private key (ECDSA) |
| Bé Alice | Người nhận, xác minh bằng public key |
| Lá thư | Nội dung được ký |
| Bố mẹ | Kẻ có thể nhìn trộm nhưng không ký được nếu không có private key |

📦 Nếu nội dung lá thư bị thay đổi (ví dụ: yêu cầu thêm quà), chữ ký sẽ không còn hợp lệ và bị phát hiện là giả mạo.

---

## 9. Tại sao lại cần lưu khóa công khai (public key)?

- Bé Alice cần **public key của ông già Noel** để kiểm tra chữ ký.
- Public key có thể được công bố rộng rãi, không cần giữ bí mật.
- Chỉ **private key** phải được giữ kín tuyệt đối.

---

## 10. Tổng kết: Vì sao chữ ký số quan trọng?

- ✔️ **Chứng minh nguồn gốc**: Biết chắc ai là người gửi
- ✔️ **Bảo toàn nội dung**: Biết chắc nội dung không bị sửa
- ❌ **Không thể giả mạo** nếu không có private key

Chữ ký số là **nền tảng bảo mật cho email, phần mềm, blockchain, hợp đồng số, v.v.**

---

📌 *Phần tiếp theo: [Bài tập thực hành – Ký và xác minh chữ ký ECDSA trong Python](./sign_message.py)*

