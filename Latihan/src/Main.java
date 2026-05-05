import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<PerangkatPintar> list = new ArrayList<>();

        list.add(new LampuPintar());
        list.add(new AcPintar());

        for (PerangkatPintar p : list) {
            p.aktifkan();

            if (p instanceof AcPintar) {
                AcPintar ac = (AcPintar) p;
                ac.aturSuhu(20);
            }
        }
    }
}