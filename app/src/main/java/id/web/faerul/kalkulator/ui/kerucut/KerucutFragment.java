package id.web.faerul.kalkulator.ui.kerucut;


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
public class KerucutFragment extends BaseFragment
        implements KerucutView {


    @BindView(R.id.edit_text_sisi) EditText mEditTextSisi;
    @BindView(R.id.edit_text_jari_jari) EditText mEditTextJariJari;
    @BindView(R.id.edit_text_tinggi) EditText mEditTextTinggi;
    @BindView(R.id.text_input_layout_sisi) TextInputLayout mTextInputLayoutSisi;
    @BindView(R.id.text_input_layout_jari_jari) TextInputLayout mTextInputLayoutJariJari;
    @BindView(R.id.text_input_layout_tinggi) TextInputLayout mTextInputLayoutTinggi;
    @BindView(R.id.text_luas) TextView mTextLuas;
    @BindView(R.id.text_volume) TextView mTextVolume;

    private KerucutuPresenter mKerucutPresenter;
    private View focusView = null;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupPresenter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tabung, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.button_hitung)
    public void doHitung() {
        mKerucutPresenter.hitungKerucut(
                mEditTextSisi.getText().toString(),
                mEditTextJariJari.getText().toString(),
                mEditTextTinggi.getText().toString());
    }

    private void setupPresenter() {
        if (mKerucutPresenter == null) {
            mKerucutPresenter = new KerucutuPresenter(this);
        }
    }

    @Override
    public void clearInputLayout() {
        mTextInputLayoutSisi.setError(null);
        mTextInputLayoutSisi.setErrorEnabled(false);
        mTextInputLayoutJariJari.setError(null);
        mTextInputLayoutJariJari.setErrorEnabled(false);
        mTextInputLayoutTinggi.setError(null);
        mTextInputLayoutTinggi.setErrorEnabled(false);
    }

    @Override
    public void showErrorJariJari() {
        mTextInputLayoutJariJari.setError(getString(R.string.error_field_required));
        focusView = mTextInputLayoutJariJari;
        focusView.requestFocus();
    }

    @Override
    public void showErrorTinggi() {
        mTextInputLayoutTinggi.setError(getString(R.string.error_field_required));
        focusView = mTextInputLayoutTinggi;
        focusView.requestFocus();
    }

    @Override
    public void showErrorSisi() {
        mTextInputLayoutSisi.setError(getString(R.string.error_field_required));
        focusView = mTextInputLayoutSisi;
        focusView.requestFocus();
    }

    @Override
    public void showHitung(Double luas, Double volume) {
        mTextLuas.setVisibility(View.VISIBLE);
        mTextVolume.setVisibility(View.VISIBLE);
        mTextLuas.setText("Luas : " + luas + "");
        mTextVolume.setText("Volume : " + volume + "");
    }
}
