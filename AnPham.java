public abstract class AnPham {
    protected String tuaDe;
    protected double giaMua;
    protected String nhaSanXuat;
    protected int soLuongBan;
    protected double giaBan;

    public AnPham() {
    }

    public AnPham(String tuaDe, double giaMua, String nhaSanXuat, int soLuongBan, double giaBan) {
        this.tuaDe = tuaDe;
        this.giaMua = giaMua;
        this.nhaSanXuat = nhaSanXuat;
        this.soLuongBan = soLuongBan;
        this.giaBan = giaBan;
    }

    public abstract void nhap();

    public double tongTriGiaBan() {
        return (double) soLuongBan * this.giaBan;
    }

    public void xuat() {
        System.out.printf("Tua de: %s\nGia mua: %s\nNha san xuat: %s\nSo luong ban: %s\nGia ban: %s\n", tuaDe, giaMua,
                nhaSanXuat, soLuongBan, giaBan);
    }
}