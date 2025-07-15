import java.util.Scanner;

public class Bang extends AnPham {
    protected int thoiGian;

    public Bang() {
    }

    public Bang(String tuaDe, double giaMua, int thoiGian, 
    String nhaSanXuat, int soLuongBan, double giaBan) {
        super(tuaDe, giaMua, nhaSanXuat, soLuongBan, giaBan);
        this.thoiGian = thoiGian;
    }

    @Override
    public void nhap(Scanner sc) {
        System.out.print("Nhap tua de: ");
        tuaDe = sc.nextLine();
        System.out.print("Nhap gia mua: ");
        giaMua = sc.nextDouble();
        sc.nextLine();
        System.out.print("Nhap thoi gian (tinh theo phut): ");
        thoiGian = sc.nextInt();
        sc.nextLine();
        System.out.print("Nhap nha san xuat: ");
        nhaSanXuat = sc.nextLine();
        System.out.print("Nhap so luong ban: ");
        soLuongBan = sc.nextInt();
        sc.nextLine();
        System.out.print("Nhap gia ban: ");
        giaBan = sc.nextDouble();
        sc.nextLine();
    }

    /*public void nhapBang() {
        nhap();
    }*/

    @Override
    public void xuat() {
        System.out.printf(
            "Tua de: %s\nGia mua: %s\nThoi gian (tinh theo phut): %s\nNha san xuat: %s\nSo luong ban: %s\nGia ban: %s\n",
            tuaDe, giaMua, thoiGian, nhaSanXuat, soLuongBan, giaBan);
    }

    /*public void xuatBang() {
        xuat();
    }*/
}