package id.web.faerul.kalkulator.ui.bola;

import android.util.Log;

/**
 * Created by faerulsalamun on 9/6/16.
 */
public class BolaPresenter {

    private BolaView mBolaView;

    public BolaPresenter(BolaView mBolaView) {
        this.mBolaView = mBolaView;
    }

    public void hitungBola(String jariJari) {

        mBolaView.clearInputLayout();

        if (jariJari.equals("")) {
            mBolaView.showErrorJariJari();
        } else {

            Double doubleJariJari = Double.valueOf(jariJari);

            Double hitungLuasPermukaan = 4 * 3.14 * (doubleJariJari * doubleJariJari);
            Double hitungVolume = (4.0/3.0) * 3.14 * (doubleJariJari * doubleJariJari * doubleJariJari);

            mBolaView.showHitung(hitungLuasPermukaan, hitungVolume);
        }

    }
}
