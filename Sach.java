import java.util.Scanner;

public class Sach extends AnPham {
    protected int soTrang;

    public Sach() {
    }

    public Sach(String tuaDe, double giaMua, int soTrang, String nhaSanXuat, int soLuongBan, double giaBan) {
        super("", 0.0, "", 0, 0.0);
        this.soTrang = soTrang;
    }

    @Override
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap tua de: ");
        tuaDe = sc.nextLine();
        System.out.print("Nhap gia mua: ");
        giaMua = sc.nextDouble();
        System.out.print("Nhap so trang: ");
        soTrang = sc.nextInt();
        System.out.print("Nhap nha xuat ban: ");
        nhaSanXuat = sc.nextLine();
        System.out.print("Nhap so luong ban: ");
        soLuongBan = sc.nextInt();
        System.out.print("Nhap gia ban: ");
        giaBan = sc.nextDouble();
    }

    public void nhapSach() {
        nhap();
    }

    @Override
    public void xuat() {
        System.out.printf("Tua de: %s\nGia mua: %s\nSo trang %s\nNha xuat ban: %s\nSo luong ban: %s\nGia ban: %s\n",
                tuaDe, giaMua, soTrang, nhaSanXuat, soLuongBan, giaBan);
    }

    public void xuatSach() {
        xuat();
    }
}
