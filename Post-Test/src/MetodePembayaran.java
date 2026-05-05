class MetodePembayaran {
    void bayar(double nominal) {
        System.out.println("Memproses pembayaran umum sebesar Rp" + nominal);
    }
}

class EWallet extends MetodePembayaran {
    @Override
    void bayar(double nominal) {
        System.out.println("Memotong saldo E-Wallet sebesar Rp" + nominal);
    }
}

class KartuKredit extends MetodePembayaran {
    @Override
    void bayar(double nominal) {
        System.out.println("Mencetak tagihan Kartu Kredit sebesar Rp" + nominal);
    }
}