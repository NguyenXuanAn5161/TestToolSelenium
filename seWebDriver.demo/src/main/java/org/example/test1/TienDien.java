package org.example.test1;

public class TienDien {
	private int id;
	private int chiSoCu;
	private int chiSoMoi;
	private double thanhTien;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getChiSoCu() {
		return chiSoCu;
	}

	public void setChiSoCu(int chiSoCu) {
		this.chiSoCu = chiSoCu;
	}

	public int getChiSoMoi() {
		return chiSoMoi;
	}

	public void setChiSoMoi(int chiSoMoi) {
		this.chiSoMoi = chiSoMoi;
	}

	public double getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}

	public TienDien(int id, int chiSoCu, int chiSoMoi, double thanhTien) {
		super();
		this.id = id;
		this.chiSoCu = chiSoCu;
		this.chiSoMoi = chiSoMoi;
		this.thanhTien = thanhTien;
	}

	public TienDien(int chiSoCu, int chiSoMoi, double thanhTien) {
		super();
		this.chiSoCu = chiSoCu;
		this.chiSoMoi = chiSoMoi;
		this.thanhTien = thanhTien;
	}

	public TienDien(int id) {
		super();
		this.id = id;
	}

	public TienDien() {
		super();
	}

	@Override
	public String toString() {
		return "TinhTienDien [id=" + id + ", chiSoCu=" + chiSoCu + ", chiSoMoi=" + chiSoMoi + ", thanhTien=" + thanhTien
				+ "]";
	}

}
