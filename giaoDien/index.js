function FunctionTienDien() {
  var chiSoCu = parseInt(document.getElementById("chiSoCu").value);
  var chiSoMoi = parseInt(document.getElementById("chiSoMoi").value);

  var thanhTienVAT = 0;

  if (chiSoCu > chiSoMoi || chiSoCu < 0 || chiSoMoi < 0) {
    thanhTienVAT = -1;
  } else {
    var soKw = chiSoMoi - chiSoCu;
    var thanhTien = 0;
    if (soKw <= 50) {
      thanhTien = soKw * 1484;
    } else if (soKw <= 100) {
      thanhTien = 50 * 1484 + (soKw - 50) * 1533;
    } else if (soKw <= 200) {
      thanhTien = 50 * 1484 + 50 * 1533 + (soKw - 100) * 1786;
    } else if (soKw <= 300) {
      thanhTien = 50 * 1484 + 50 * 1533 + 100 * 1786 + (soKw - 200) * 2242;
    } else if (soKw <= 400) {
      thanhTien =
        50 * 1484 + 50 * 1533 + 100 * 1786 + 100 * 2242 + (soKw - 300) * 2503;
    } else {
      thanhTien =
        50 * 1484 +
        50 * 1533 +
        100 * 1786 +
        100 * 2242 +
        100 * 2503 +
        (soKw - 400) * 2587;
    }

    thanhTienVAT = thanhTien * 1.1;
  }

  // Làm tròn giá trị `thanhtienVAT` thành 2 chữ số thập phân
  thanhTienVAT = thanhTienVAT.toFixed(2);

  document.getElementById("thanhtien").innerHTML = thanhTienVAT;
}
