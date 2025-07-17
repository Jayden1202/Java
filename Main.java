import java.util.*;

public class Main {
    private static QuanLyAnPham ql = new QuanLyAnPham();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        int chon;
        do {
            System.out.println("---- HE THONG QUAN LY AN PHAM ----");
            System.out.println("1. Nhap du lieu tu ban phim");
            System.out.println("2. Nhap du lieu tu file CSV");
            System.out.println("3. Xuat du lieu ra file CSV");
            System.out.println("4. Tinh tong gia ban moi loai");
            System.out.println("5. Hien thi tat ca an pham");
            System.out.println("6. Tinh loi nhuan");
            System.out.println("7. Tinh tong gia mua moi loai");
            System.out.println("8. Cap nhat gia ban");
            System.out.println("9. Tim an pham doanh thu cao/thap nhat");
            System.out.println("10. Xoa an pham theo ten");
            System.out.println("0. Ket thuc");
            System.out.print("Chon: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1:
                    ql.nhapAnPham(sc);;
                    break;
                case 2:
                    System.out.print("Nhap ten file input CSV (vi du: input.csv): ");
                    String inputFile = sc.nextLine();
                    ql.nhapTuFileCSV(inputFile);
                    break;
                case 3:
                    System.out.print("Nhap ten file output CSV (vi du: output.csv): ");
                    String outputFile = sc.nextLine();
                    ql.xuatRaFileCSV(outputFile);
                    break;
                case 4:
                    ql.tinhTongTriGiaBan(); 
                    break;
                case 5:
                    ql.xuatDanhSach();
                    break;
                case 6:
                    ql.tinhLoiNhuan();
                    break;
                case 7:
                    ql.tinhTongGiaMuaTheoLoai();
                    break;
                case 8:
                    ql.capNhatGiaBan(sc);
                    break;
                case 9:
                    ql.timAnPhamDoanhThu();
                    break;
                case 10:
                    ql.xoaAnPham(sc);
                    break;
                case 0:
                    System.out.println("Ket thuc chuong trinh!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (chon != 0);
        sc.close();
    }
}