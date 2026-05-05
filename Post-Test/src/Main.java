import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<MetodePembayaran> list = new ArrayList<>();

        list.add(new EWallet());
        list.add(new KartuKredit());

        for (MetodePembayaran m : list) {
            m.bayar(100000);
        }
    }
}