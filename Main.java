import java.util.*;


public class Main {
    public static void main(String[] args) {
        //
    }

    public static void menu(){

        Scanner sc = new Scanner(System.in);
        int chon;
        System.out.println("---- HỆ THỐNG NHẬP - XUẤT ẤN PHẨM ----");

        //option
        System.out.println("--- CHỌN ẤN PHẨM ---");
        System.out.println("1./ BĂNG");
        System.out.println("2./ ĐĨA");
        System.out.println("3./ SÁCH");
        System.out.println("0./ KẾT THÚC");

        System.out.print("Chọn: ");
        chon = sc.nextInt();
        sc.nextLine();

        sc.close();
        
        switch (chon) {
            case 0:
                System.out.println("-- Kết thúc chương trình --");
                break;
            case 1:
                menuMain();


            default: 
                System.out.println("Vui lòng nhập đúng số có trong hệ thống");
        }

        while (chon != 0);

    }

    public static void menuMain(){

        Scanner sc = new Scanner(System.in);
        int chon;

        //option
        System.out.println("");
        System.out.println("1./ Nhập ấn phẩm");
        System.out.println("2./ Xuất ấn phẩm");
        System.out.println("3./ Tổng giá trị mua của ấn phẩm");
        System.out.println("4./ Tổng giá trị bán của ấn phẩm");
        System.out.println("5./ Lợi nhuận dự kiến");
        System.out.println("0./ Kết thúc");

        System.out.println("Chọn: ");
        chon = sc.nextInt();
        sc.nextLine();

        sc.close();

        switch (chon) {
            case 0:
                System.out.println("-- Kết thúc chương trình --");
                break;
        
            default:
                break;
        }
        while (chon != 0);
    }
}
