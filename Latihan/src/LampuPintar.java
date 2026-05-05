class LampuPintar extends PerangkatPintar {

    @Override
    void aktifkan() {
        System.out.println("Lampu menyala dengan tingkat kecerahan standar.");
    }

    // Overloading
    void aturKecerahan(int level) {
        System.out.println("Kecerahan lampu diatur ke level " + level + "%.");
    }

    void aturKecerahan(int level, String warna) {
        System.out.println("Kecerahan lampu diatur ke level " + level + "% dengan warna cahaya " + warna + ".");
    }
}