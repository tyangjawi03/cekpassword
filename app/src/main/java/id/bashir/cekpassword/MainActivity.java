package id.bashir.cekpassword;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Cek.CekView {

    EditText etPassword;
    ProgressBar pbPassword;
    TextView txPassword;

    private CekPresenter cekPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPassword = (EditText) findViewById(R.id.etPassword);
        pbPassword = (ProgressBar) findViewById(R.id.pbPassword);
        txPassword = (TextView) findViewById(R.id.txPassword);

        cekPresenter = new CekPresenter(this);
        etPassword.addTextChangedListener(textWatcher);

    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            cekPresenter.howSecure(etPassword.getText().toString());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    @Override
    public void passwordStrength(Strength result) {
        pbPassword.setProgress(result.getStrength());
        txPassword.setText(result.getDescription());
    }

}
