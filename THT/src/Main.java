import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<LayananEkspedisi> paket = new ArrayList<>();

        paket.add(new LayananReguler("REG-11", 2, 50, 50, 50));
        paket.add(new LayananExpress("EXP-22", 5, 10, 10, 10));
        paket.add(new LayananInternasional("INT-33",3,20,20,20,"Korea", 100));
        double total = 0;
        // looping semua paket untuk cetak resi, hitung ongkir, dan fitur tambahan
        for (LayananEkspedisi p : paket) {
            p.cetakResi();
            double ongkir = p.hitungOngkir();
            System.out.println("Ongkir Dasar : Rp" + ongkir);
            total += ongkir;

            if (p instanceof LayananExpress) {
                ((LayananExpress) p).klaimAsuransi(1500000);
            } else if (p instanceof LayananInternasional) {
                ((LayananInternasional) p).cetakManifest();
            } else if (p instanceof LayananReguler) {
                double hasil =((LayananReguler) p).hitungOngkir(true, 25);
                System.out.println("Ongkir Promo : Rp" + hasil);
            }
            System.out.println();
        }
        System.out.println(
                "Total Pendapatan : Rp" + total);
    }
}