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
            System.out.println("1. Nhap tu file input.txt");
            System.out.println("2. Xuat ra file output.txt");
            System.out.println("3. Tinh tong gia ban moi loai");
            System.out.println("4. Hien thi tat ca an pham");
            System.out.println("5. Tinh loi nhuan");
            System.out.println("6. Tinh tong gia mua moi loai");
            System.out.println("7. Cap nhat gia ban");
            System.out.println("8. Tim an pham doanh thu cao/thap nhat");
            System.out.println("9. Xuat du lieu ra file CSV");
            System.out.println("10. Nhap du lieu tu file CSV");
            System.out.println("0. Ket thuc");
            System.out.print("Chon: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1:
                    ql.nhapTuFileText("input.txt");
                    break;
                case 2:
                    ql.xuatKetQuaRaFile("output.txt");
                    break;
                case 3:
                    ql.tinhTongTriGiaBan(); 
                    break;
                case 4:
                    ql.xuatDanhSach();
                    break;
                case 5:
                    ql.tinhLoiNhuan();
                    break;
                case 6:
                    ql.tinhTongGiaMuaTheoLoai();
                    break;
                case 7:
                    ql.capNhatGiaBan(sc);
                    break;
                case 8:
                    ql.timAnPhamDoanhThu();
                    break;
                case 9:
                    System.out.print("Nhap ten file output CSV (vi du: output.csv): ");
                    String outputFile = sc.nextLine();
                    ql.xuatRaFileCSV(outputFile);
                    break;
                case 10:
                    System.out.print("Nhap ten file input CSV (vi du: input.csv): ");
                    String inputFile = sc.nextLine();
                    ql.nhapTuFileCSV(inputFile);
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