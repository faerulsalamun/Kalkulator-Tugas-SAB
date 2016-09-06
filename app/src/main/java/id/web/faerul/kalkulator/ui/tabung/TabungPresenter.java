package id.web.faerul.kalkulator.ui.tabung;

/**
 * Created by faerulsalamun on 9/6/16.
 */
public class TabungPresenter {

    private TabungView mTabungView;


    public TabungPresenter(TabungView mTabungView) {
        this.mTabungView = mTabungView;
    }

    public void hitungTabung(String jariJari, String tinggi) {

        mTabungView.clearInputLayout();

        if (jariJari.equals("")) {
            mTabungView.showErrorJariJari();
        } else if (tinggi.equals("")) {
            mTabungView.showErrorTinggi();
        } else {

            Double doubleJariJari = Double.valueOf(jariJari);
            Double doubleTinggi = Double.valueOf(tinggi);

            Double hitungLuasPermukaan = 2 * 3.14 * doubleJariJari * doubleTinggi;
            Double hitungVolume = 3.14 * (doubleJariJari * doubleJariJari) * doubleTinggi;

            mTabungView.showHitung(hitungLuasPermukaan, hitungVolume);
        }

    }
}
