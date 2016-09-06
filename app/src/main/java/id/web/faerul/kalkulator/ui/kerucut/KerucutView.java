package id.web.faerul.kalkulator.ui.kerucut;

/**
 * Created by faerulsalamun on 9/6/16.
 */
public interface KerucutView {

    void showHitung(Double luas, Double volume);

    void showErrorSisi();

    void showErrorJariJari();

    void showErrorTinggi();

    void clearInputLayout();
}
