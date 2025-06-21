import java.util.Scanner;

public class Dia extends AnPham {
    protected int thoiGian;

    public Dia() {
    }

    public Dia(String tuaDe, double giaMua, int thoiGian, String nhaSanXuat, int soLuongBan, double giaBan) {
        super("", 0.0, "", 0, 0.0);
        this.thoiGian = thoiGian;
    }

    @Override
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap tua de: ");
        tuaDe = sc.nextLine();
        System.out.print("Nhap gia mua: ");
        giaMua = sc.nextDouble();
        System.out.print("Nhap thoi gian (tinh theo phut): ");
        thoiGian = sc.nextInt();
        System.out.print("Nhap nha san xuat: ");
        nhaSanXuat = sc.nextLine();
        System.out.print("Nhap so luong ban: ");
        soLuongBan = sc.nextInt();
        System.out.print("Nhap gia ban: ");
        giaBan = sc.nextDouble();
    }

    public void nhapDia() {
        nhap();
    }

    @Override
    public void xuat() {
        System.out.printf(
                "Tua de: %s\nGia mua: %s\nThoi gian (tinh theo phut): %s\nNha san xuat: %s\nSo luong ban: %s\nGia ban: %s\n",
                tuaDe, giaMua, thoiGian, nhaSanXuat, soLuongBan, giaBan);
    }

    public void xuatDia() {
        xuat();
    }
}
