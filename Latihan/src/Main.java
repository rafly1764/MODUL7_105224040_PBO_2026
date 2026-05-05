public class Main {
    public static void main(String[] args) {

        PerangkatPintar alat1 = new LampuPintar();

        /*alat1.aturKecerahan(75, "Putih"); 
         ERROR: method tidak dikenali

         Walaupun objek aslinya LampuPintar, variabel alat1 bertipe PerangkatPintar.
         Java hanya mengizinkan pemanggilan method yang ada di class PerangkatPintar.
         Method aturKecerahan() hanya ada di LampuPintar, jadinya tidak bisa dipanggil langsung.
        */

        // Perbaikan dengan downcasting
        if (alat1 instanceof LampuPintar) {
            LampuPintar lampu = (LampuPintar) alat1;
            lampu.aturKecerahan(75, "Putih");
        }
    }
}