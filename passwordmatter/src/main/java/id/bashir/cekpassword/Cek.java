package id.bashir.cekpassword;

/**
 * Created by Bashir on 08/06/2016.
 */
public interface Cek {

    interface CekView {
        void passwordStrength(Strength result);
    }

    interface CekPresenter {
        void howSecure(String password);
    }

    interface CekListener {
        void passwordStrength(Strength result);
    }

}
