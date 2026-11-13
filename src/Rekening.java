public abstract class Rekening {
    private String nomor;
    private String pemilik;
    protected int saldo;

    public Rekening(String nomor, String pemilik, int saldo) {
        this.nomor = nomor;
        this.pemilik = pemilik;
        this.saldo = saldo;
    }

    public String getNomor() {
        return nomor;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setor(int jumlah) {
        if (jumlah > 0) {
            saldo += jumlah;
        }
    }

    public boolean tarik(int jumlah) {
        if (jumlah > 0 && jumlah <= saldo) {
            saldo -= jumlah;
            return true;
        }

        return false;
    }

    public abstract int biayaAdminBulanan();

    public int potongBiayaAdmin() {
        int biaya = biayaAdminBulanan();
        saldo -= biaya;
        return biaya;
    }

    public void cetakInfo() {
        System.out.printf("%s | %-6s | %12s",
                nomor, pemilik, formatRupiah(saldo));
    }

    protected static String formatRupiah(int angka) {
        java.text.DecimalFormat format =
                new java.text.DecimalFormat("#,##0",
                        new java.text.DecimalFormatSymbols(
                                new java.util.Locale("id", "ID")));

        return "Rp" + format.format(angka);
    }
}
