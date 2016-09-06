package id.web.faerul.kalkulator.ui.kubus;

/**
 * Created by faerulsalamun on 9/6/16.
 */
public class KubusPresenter {

    private KubusView mKubusView;

    public KubusPresenter(KubusView mKubusView) {
        this.mKubusView = mKubusView;
    }

    public void hitungKubus(String sisi) {

        mKubusView.clearInputLayout();

        if (sisi.equals("")) {
            mKubusView.showErrorSisi();
        } else {

            Double doubleSisi = Double.valueOf(sisi);
            Double hitungLuas = 6 * (doubleSisi * doubleSisi);
            Double hitungVolume = doubleSisi * doubleSisi * doubleSisi;

            mKubusView.showHitung(hitungLuas, hitungVolume);
        }

    }
}
