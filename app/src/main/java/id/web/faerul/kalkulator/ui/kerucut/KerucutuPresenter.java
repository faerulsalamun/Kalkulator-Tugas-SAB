package id.web.faerul.kalkulator.ui.kerucut;

/**
 * Created by faerulsalamun on 9/6/16.
 */
public class KerucutuPresenter {

    private KerucutView mKubusView;

    public KerucutuPresenter(KerucutView mKubusView) {
        this.mKubusView = mKubusView;
    }

    public void hitungKerucut(String sisi, String jariJari, String tinggi) {

        mKubusView.clearInputLayout();

        if (sisi.equals("")) {
            mKubusView.showErrorSisi();
        } else if (jariJari.equals("")) {
            mKubusView.showErrorJariJari();
        }else if (tinggi.equals("")) {
            mKubusView.showErrorTinggi();
        } else {

            Double doubleJariJari = Double.valueOf(jariJari);
            Double doubleSisi = Double.valueOf(sisi);
            Double doubleTinggi = Double.valueOf(tinggi);

            Double hitungLuasPermukaan = (3.14 * (doubleJariJari * doubleJariJari)) + (3.14 + doubleJariJari + doubleSisi);
            Double hitungVolume = (1.0/3.0) * 3.14 * (doubleJariJari * doubleJariJari) * doubleTinggi;

            mKubusView.showHitung(hitungLuasPermukaan, hitungVolume);
        }

    }
}
