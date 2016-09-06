package id.web.faerul.kalkulator.ui.bola;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.web.faerul.kalkulator.R;
import id.web.faerul.kalkulator.ui.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class BolaFragment extends BaseFragment
        implements BolaView {


    @BindView(R.id.edit_text_jari_jari) EditText mEditTextJariJari;
    @BindView(R.id.text_input_layout_jari_jari) TextInputLayout mTextInputLayoutJariJari;
    @BindView(R.id.text_luas) TextView mTextLuas;
    @BindView(R.id.text_volume) TextView mTextVolume;

    private BolaPresenter mBolaPresenter;
    private View focusView = null;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupPresenter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_bola, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.button_hitung)
    public void doHitung() {
        mBolaPresenter.hitungBola(mEditTextJariJari.getText().toString());
    }

    private void setupPresenter() {
        if (mBolaPresenter == null) {
            mBolaPresenter = new BolaPresenter(this);
        }
    }

    @Override
    public void clearInputLayout() {
        mTextInputLayoutJariJari.setError(null);
        mTextInputLayoutJariJari.setErrorEnabled(false);
    }

    @Override
    public void showErrorJariJari() {
        mTextInputLayoutJariJari.setError(getString(R.string.error_field_required));
        focusView = mTextInputLayoutJariJari;
        focusView.requestFocus();
    }

    @Override
    public void showHitung(Double luas, Double volume) {
        mTextLuas.setVisibility(View.VISIBLE);
        mTextVolume.setVisibility(View.VISIBLE);
        mTextLuas.setText("Luas Permukaan : " + luas + "");
        mTextVolume.setText("Volume : " + volume + "");
    }
}
