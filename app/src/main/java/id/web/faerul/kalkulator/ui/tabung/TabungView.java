package id.web.faerul.kalkulator.ui.tabung;

/**
 * Created by faerulsalamun on 9/6/16.
 */
public interface TabungView {

    void showHitung(Double luas, Double volume);

    void showErrorJariJari();

    void showErrorTinggi();

    void clearInputLayout();

}
