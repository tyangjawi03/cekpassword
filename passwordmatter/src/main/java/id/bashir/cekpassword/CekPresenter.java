package id.bashir.cekpassword;

/**
 * Created by Bashir on 08/06/2016.
 */
public class CekPresenter implements Cek.CekPresenter, Cek.CekListener {

    private CekInterceptor mCekInterceptor;
    private Cek.CekView mCekView;

    public CekPresenter(Cek.CekView cekView) {
        mCekView = cekView;
    }

    @Override
    public void howSecure(String password) {
        mCekInterceptor = new CekInterceptor(this);
        mCekInterceptor.execute(password);
    }

    @Override
    public void passwordStrength(Strength result) {
        mCekView.passwordStrength(result);
    }
}
