import java.util.*;
import java.io.*;

public class QuanLyAnPham {
    private List<AnPham> dsAnPham = new ArrayList<>();

    public void nhapAnPham(Scanner sc) {
        System.out.println("Chon loai an pham (1-Bang, 2-Dia, 3-Sach): ");
        int loai = sc.nextInt();
        sc.nextLine();

        AnPham ap = null;
        switch (loai) {
            case 1:
                ap = new Bang();
                break;
            case 2:
                ap = new Dia();
                break;
            case 3:
                ap = new Sach();
                break;
            default:
                System.out.println("Loai khong hop le!");
                return;
        }

        ap.nhap(sc);
        dsAnPham.add(ap);
        System.out.println("Da them an pham!");
    }

    public void xuatDanhSach() {
        if (dsAnPham.isEmpty()) {
            System.out.println("Danh sach rong!");
            return;
        }
        for (AnPham ap : dsAnPham) {
            ap.xuat();
        }
    }

    public void tinhTongGiaMuaTheoLoai() {
        double tongBang = 0, tongDia = 0, tongSach = 0;

        for (AnPham ap : dsAnPham) {
            double giaMua = ap.giaMua * ap.soLuongBan;
            if (ap instanceof Bang)
                tongBang += giaMua;
            else if (ap instanceof Dia)
                tongDia += giaMua;
            else if (ap instanceof Sach)
                tongSach += giaMua;
        }

        System.out.println("Tong gia mua Bang: " + tongBang);
        System.out.println("Tong gia mua Dia: " + tongDia);
        System.out.println("Tong gia mua Sach: " + tongSach);
    }

    public void tinhTongTriGiaBan() {
        double tongBang = 0, tongDia = 0, tongSach = 0;

        for (AnPham ap : dsAnPham) {
            double triGiaBan = ap.tongTriGiaBan();
            if (ap instanceof Bang)
                tongBang += triGiaBan;
            else if (ap instanceof Dia)
                tongDia += triGiaBan;
            else if (ap instanceof Sach)
                tongSach += triGiaBan;
        }

        System.out.println("Tong tri gia ban Bang: " + tongBang);
        System.out.println("Tong tri gia ban Dia: " + tongDia);
        System.out.println("Tong tri gia ban Sach: " + tongSach);
    }

    public void tinhLoiNhuan() {
        double loiNhuan = 0;
        for (AnPham ap : dsAnPham) {
            loiNhuan += ap.loiNhuan();
        }
        System.out.println("Tong loi nhuan: " + loiNhuan);
    }

    public void capNhatGiaBan(Scanner sc) {
        System.out.print("Nhap tua de can cap nhat: ");
        String tuaDe = sc.nextLine();

        for (AnPham ap : dsAnPham) {
            if (ap.tuaDe.equalsIgnoreCase(tuaDe)) {
                System.out.print("Nhap gia ban moi: ");
                double giaBanMoi = sc.nextDouble();
                sc.nextLine();
                ap.capNhatGiaBan(giaBanMoi);
                System.out.println("Da cap nhat gia ban!");
                return;
            }
        }
        System.out.println("Khong tim thay tua de!");
    }

    public void timAnPhamDoanhThu() {
        if (dsAnPham.isEmpty()) {
            System.out.println("Danh sach rong!");
            return;
        }

        AnPham max = null;
        AnPham min = null;

        for (AnPham ap : dsAnPham) {
            if (max == null || ap.tongTriGiaBan() > max.tongTriGiaBan())
                max = ap;
            if (min == null || ap.tongTriGiaBan() < min.tongTriGiaBan())
                min = ap;
        }

        System.out.println("An pham doanh thu cao nhat:");
        max.xuat();
        System.out.println("An pham doanh thu thap nhat:");
        min.xuat();
    }

    public void nhapTuFileCSV(String tenFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(tenFile))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length < 7)
                    continue;

                String loai = data[0];
                String tuaDe = data[1];
                double giaMua = Double.parseDouble(data[2]);
                String nhaSanXuat = data[4];
                int soLuongBan = Integer.parseInt(data[5]);
                double giaBan = Double.parseDouble(data[6]);

                AnPham ap = null;
                switch (loai) {
                    case "BANG":
                        int thoiGian = Integer.parseInt(data[3]);
                        ap = new Bang(tuaDe, giaMua, thoiGian, nhaSanXuat, soLuongBan, giaBan);
                        break;
                    case "DIA":
                        thoiGian = Integer.parseInt(data[3]);
                        ap = new Dia(tuaDe, giaMua, thoiGian, nhaSanXuat, soLuongBan, giaBan);
                        break;
                    case "SACH":
                        int soTrang = Integer.parseInt(data[3]);
                        ap = new Sach(tuaDe, giaMua, soTrang, nhaSanXuat, soLuongBan, giaBan);
                        break;
                }

                if (ap != null) {
                    dsAnPham.add(ap);
                }
            }
            System.out.println("Da nhap du lieu tu file CSV thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi khi doc file CSV: " + e.getMessage());
        }
    }

    public void xuatRaFileCSV(String tenFile) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(tenFile))) {
            pw.println("Loai,Tua de,Gia mua,Thoi gian/So trang,Nha san xuat,So luong ban,Gia ban");
            for (AnPham ap : dsAnPham) {
                if (ap instanceof Bang) {
                    Bang b = (Bang) ap;
                    pw.printf("BANG,%s,%.2f,%d,%s,%d,%.2f%n",
                            b.tuaDe, b.giaMua, b.thoiGian, b.nhaSanXuat, b.soLuongBan, b.giaBan);
                } else if (ap instanceof Dia) {
                    Dia d = (Dia) ap;
                    pw.printf("DIA,%s,%.2f,%d,%s,%d,%.2f%n",
                            d.tuaDe, d.giaMua, d.thoiGian, d.nhaSanXuat, d.soLuongBan, d.giaBan);
                } else if (ap instanceof Sach) {
                    Sach s = (Sach) ap;
                    pw.printf("SACH,%s,%.2f,%d,%s,%d,%.2f%n",
                            s.tuaDe, s.giaMua, s.soTrang, s.nhaSanXuat, s.soLuongBan, s.giaBan);
                }
            }
            System.out.println("Da xuat du lieu ra file CSV thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi khi ghi file CSV: " + e.getMessage());
        }
    }

    public void nhapTuFileText(String tenFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(tenFile))) {
            String line;
            int count = 0;
            String loai = null;
            String tuaDe = null;
            double giaMua = 0;
            int thoiGianOrSoTrang = 0;
            String nhaSanXuat = null;
            int soLuongBan = 0;
            double giaBan = 0;

            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                
                switch (count % 7) {
                    case 0: loai = line; break;
                    case 1: tuaDe = line; break;
                    case 2: giaMua = Double.parseDouble(line); break;
                    case 3: thoiGianOrSoTrang = Integer.parseInt(line); break;
                    case 4: nhaSanXuat = line; break;
                    case 5: soLuongBan = Integer.parseInt(line); break;
                    case 6: 
                        giaBan = Double.parseDouble(line);
                        themAnPhamTuDuLieu(loai, tuaDe, giaMua, thoiGianOrSoTrang, nhaSanXuat, soLuongBan, giaBan);
                        break;
                }
                count++;
            }
            System.out.println("Da nhap du lieu tu file text thanh cong!");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Loi doc file text: " + e.getMessage());
        }
    }

    public void xuatKetQuaRaFile(String tenFile) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(tenFile))) {
            pw.println("KET QUA TINH TOAN");
            pw.println();
            
            pw.println("3. TONG TRI GIA BAN MOI LOAI:");
            double tongBangBan = 0, tongDiaBan = 0, tongSachBan = 0;
            for (AnPham ap : dsAnPham) {
                double triGiaBan = ap.tongTriGiaBan();
                if (ap instanceof Bang) tongBangBan += triGiaBan;
                else if (ap instanceof Dia) tongDiaBan += triGiaBan;
                else if (ap instanceof Sach) tongSachBan += triGiaBan;
            }
            pw.println("Tong tri gia ban Bang: " + tongBangBan);
            pw.println("Tong tri gia ban Dia: " + tongDiaBan);
            pw.println("Tong tri gia ban Sach: " + tongSachBan);
            pw.println();
            
            pw.println("4. DANH SACH AN PHAM:");
            for (AnPham ap : dsAnPham) {
                if (ap instanceof Bang) {
                    Bang b = (Bang) ap;
                    pw.println("BANG");
                    pw.println("Tua de: " + b.tuaDe);
                    pw.println("Gia mua: " + b.giaMua);
                    pw.println("Thoi gian: " + b.thoiGian + " phut");
                    pw.println("Nha san xuat: " + b.nhaSanXuat);
                    pw.println("So luong ban: " + b.soLuongBan);
                    pw.println("Gia ban: " + b.giaBan);
                } else if (ap instanceof Dia) {
                    Dia d = (Dia) ap;
                    pw.println("DIA");
                    pw.println("Tua de: " + d.tuaDe);
                    pw.println("Gia mua: " + d.giaMua);
                    pw.println("Thoi gian: " + d.thoiGian + " phut");
                    pw.println("Nha san xuat: " + d.nhaSanXuat);
                    pw.println("So luong ban: " + d.soLuongBan);
                    pw.println("Gia ban: " + d.giaBan);
                } else if (ap instanceof Sach) {
                    Sach s = (Sach) ap;
                    pw.println("SACH");
                    pw.println("Tua de: " + s.tuaDe);
                    pw.println("Gia mua: " + s.giaMua);
                    pw.println("So trang: " + s.soTrang);
                    pw.println("Nha xuat ban: " + s.nhaSanXuat);
                    pw.println("So luong ban: " + s.soLuongBan);
                    pw.println("Gia ban: " + s.giaBan);
                }
                pw.println();
            }
            
            pw.println("5. TONG LOI NHUAN:");
            double loiNhuan = 0;
            for (AnPham ap : dsAnPham) {
                loiNhuan += ap.loiNhuan();
            }
            pw.println("Tong loi nhuan: " + loiNhuan);
            pw.println();
            
            pw.println("6. TONG GIA MUA MOI LOAI:");
            double tongBangMua = 0, tongDiaMua = 0, tongSachMua = 0;
            for (AnPham ap : dsAnPham) {
                double giaMua = ap.giaMua * ap.soLuongBan;
                if (ap instanceof Bang) tongBangMua += giaMua;
                else if (ap instanceof Dia) tongDiaMua += giaMua;
                else if (ap instanceof Sach) tongSachMua += giaMua;
            }
            pw.println("Tong gia mua Bang: " + tongBangMua);
            pw.println("Tong gia mua Dia: " + tongDiaMua);
            pw.println("Tong gia mua Sach: " + tongSachMua);
            pw.println();
            
            pw.println("8. AN PHAM DOANH THU CAO NHAT/THAP NHAT:");
            if (dsAnPham.isEmpty()) {
                pw.println("Danh sach rong!");
            } else {
                AnPham max = dsAnPham.get(0);
                AnPham min = dsAnPham.get(0);
                for (AnPham ap : dsAnPham) {
                    if (ap.tongTriGiaBan() > max.tongTriGiaBan()) max = ap;
                    if (ap.tongTriGiaBan() < min.tongTriGiaBan()) min = ap;
                }

                pw.println("An pham doanh thu cao nhat:");
                if (max instanceof Bang) {
                    Bang b = (Bang) max;
                    pw.println("BANG");
                    pw.println("Tua de: " + b.tuaDe);
                    pw.println("Doanh thu: " + b.tongTriGiaBan());
                } else if (max instanceof Dia) {
                    Dia d = (Dia) max;
                    pw.println("DIA");
                    pw.println("Tua de: " + d.tuaDe);
                    pw.println("Doanh thu: " + d.tongTriGiaBan());
                } else if (max instanceof Sach) {
                    Sach s = (Sach) max;
                    pw.println("SACH");
                    pw.println("Tua de: " + s.tuaDe);
                    pw.println("Doanh thu: " + s.tongTriGiaBan());
                }
                pw.println();

                pw.println("An pham doanh thu thap nhat:");
                if (min instanceof Bang) {
                    Bang b = (Bang) min;
                    pw.println("BANG");
                    pw.println("Tua de: " + b.tuaDe);
                    pw.println("Doanh thu: " + b.tongTriGiaBan());
                } else if (min instanceof Dia) {
                    Dia d = (Dia) min;
                    pw.println("DIA");
                    pw.println("Tua de: " + d.tuaDe);
                    pw.println("Doanh thu: " + d.tongTriGiaBan());
                } else if (min instanceof Sach) {
                    Sach s = (Sach) min;
                    pw.println("SACH");
                    pw.println("Tua de: " + s.tuaDe);
                    pw.println("Doanh thu: " + s.tongTriGiaBan());
                }
            }
            
            System.out.println("Da xuat ket qua ra file: " + tenFile);
        } catch (IOException e) {
            System.out.println("Loi ghi file text: " + e.getMessage());
        }
    }

    private void themAnPhamTuDuLieu(String loai, String tuaDe, double giaMua, int value,
            String nhaSanXuat, int soLuongBan, double giaBan) {
        AnPham ap = null;
        switch (loai) {
            case "BANG":
                ap = new Bang(tuaDe, giaMua, value, nhaSanXuat, soLuongBan, giaBan);
                break;
            case "DIA":
                ap = new Dia(tuaDe, giaMua, value, nhaSanXuat, soLuongBan, giaBan);
                break;
            case "SACH":
                ap = new Sach(tuaDe, giaMua, value, nhaSanXuat, soLuongBan, giaBan);
                break;
        }
        if (ap != null) {
            dsAnPham.add(ap);
        }
    }
}