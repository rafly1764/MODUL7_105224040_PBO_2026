public class LayananEkspedisi {

    protected String nomorResi;
    protected double beratAktualKg;
    protected double panjang;
    protected double lebar;
    protected double tinggi;

    public LayananEkspedisi(String nomorResi,double beratAktualKg,double panjang,double lebar,double tinggi) {
        this.nomorResi = nomorResi;
        this.beratAktualKg = beratAktualKg;
        this.panjang = panjang;
        this.lebar = lebar;
        this.tinggi = tinggi;
    }
    public double hitungBeratEfektif() {
        double beratVolumetrik = (panjang * lebar * tinggi) / 6000.0;
        if (beratVolumetrik > beratAktualKg) {
            return beratVolumetrik;
        }
        return beratAktualKg;
    }

    // menampilkan data resi
    public void cetakResi() {
        System.out.println("===== DATA RESI =====");
        System.out.println("Nomor Resi : " + nomorResi);
       System.out.printf("Berat Efektif : %.2f Kg\n", hitungBeratEfektif()); // Jika tidak menggunakan %.2f Kg\n maka hasilnya akan menampilkan banyak angka
    }
    public double hitungOngkir() {  // method polymorphism
        return 0.0;
    }
}

class LayananReguler extends LayananEkspedisi {
    public LayananReguler(String nomorResi,double beratAktualKg,double panjang, double lebar,double tinggi) {
        super(nomorResi,beratAktualKg,panjang,lebar,tinggi);
    }
    @Override
    public double hitungOngkir() {
        return 15000 * hitungBeratEfektif();
    }
    public double hitungOngkir(boolean isMember, int jarakKm) {
        double total = hitungOngkir();

        // diskon member 10% untuk pelanggan yang terdaftar sebagai member
        if (isMember) {
            total = total - (total * 0.10);
        }
        total = total + (500 * jarakKm);
        return total;
    }
}

// subkelas untuk layanan express dengan fitur tambahan klaim asuransi prioritas
class LayananExpress extends LayananEkspedisi {
    public LayananExpress(String nomorResi, double beratAktualKg,double panjang,double lebar,double tinggi) {
        super(nomorResi,beratAktualKg,panjang,lebar,tinggi);
    }

    @Override
    public double hitungOngkir() {
        return 30000 * hitungBeratEfektif();
    }

    public void klaimAsuransi(double nilaiBarang) {
        if (nilaiBarang > 1000000) {
            System.out.println("Klaim Asuransi VIP Rp" + nilaiBarang + " untuk resi "+ nomorResi + " sedang diproses prioritas.");
        } else {
            System.out.println("Klaim Asuransi Standar diproses dalam 7 hari kerja.");
        }
    }
}
class LayananInternasional extends LayananEkspedisi {
    String negaraTujuan;
    double nilaiBarangUSD;

    public LayananInternasional(String nomorResi,double beratAktualKg,double panjang,double lebar,double tinggi,String negaraTujuan,double nilaiBarangUSD) {
        super(nomorResi,beratAktualKg,panjang,lebar,tinggi);
        this.negaraTujuan = negaraTujuan;
        this.nilaiBarangUSD = nilaiBarangUSD;
    }

    // override ongkir dengan tambahan perhitungan bea cukai untuk barang bernilai tinggi
    @Override
    public double hitungOngkir() {
        double ongkir = 200000 * hitungBeratEfektif();
        if (nilaiBarangUSD > 50) {
            ongkir = ongkir + (ongkir * 0.20);
        }
        return ongkir;
    }
    public void cetakManifest() {
        System.out.println("Manifest Internasional ke "+ negaraTujuan + " - Deklarasi Nilai : $" + nilaiBarangUSD);
    }
}