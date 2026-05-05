class AcPintar extends PerangkatPintar {

    @Override
    void aktifkan() {
        System.out.println("AC menyala dan mulai mendinginkan ruangan.");
    }

    void aturSuhu(int suhu) {
        System.out.println("Suhu ruangan diatur menjadi " + suhu + " derajat.");
    }
}