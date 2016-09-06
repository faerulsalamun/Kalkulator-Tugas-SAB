package id.web.faerul.kalkulator.ui.kubus;


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
public class KubusFragment extends BaseFragment
        implements KubusView {


    @BindView(R.id.edit_text_sisi) EditText mEditTextSisi;
    @BindView(R.id.text_input_layout_sisi) TextInputLayout mTextInputLayoutSisi;
    @BindView(R.id.text_luas) TextView mTextLuas;
    @BindView(R.id.text_volume) TextView mTextVolume;

    private KubusPresenter mKubusPresenter;
    private View focusView = null;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupPresenter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_kubus, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.button_hitung)
    public void doHitung() {
        mKubusPresenter.hitungKubus(mEditTextSisi.getText().toString());
    }

    private void setupPresenter() {
        if (mKubusPresenter == null) {
            mKubusPresenter = new KubusPresenter(this);
        }
    }

    @Override
    public void clearInputLayout() {
        mTextInputLayoutSisi.setError(null);
        mTextInputLayoutSisi.setErrorEnabled(false);
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
