package id.bashir.cekpassword;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by Bashir on 08/06/2016.
 */
public class CekInterceptor extends AsyncTask<String, Void, Integer> {

    private String TAG = "CekInterceptor";

    private Cek.CekListener mCekListener;

    public CekInterceptor(Cek.CekListener cekListener) {
        mCekListener = cekListener;
    }

    @Override
    protected Integer doInBackground(String... params) {
        if (params == null) return null;

        int passStength = 0;
        String password = params[0];

        int passLen   = password.length();
        int upperCase = cekUpperCase(password);
        int lowerCase = cekLowerCase(password);
        int numberLen = cekNumber(password);
        int symbolLen = cekSymbol(password);
        int letterSeq = cekSequenceLetter(password);
        int numberSeq = cekSequenceNumber(password);
        int symbolSeq = cekSequenceSymbol(password);
        int repeatChr = cekRepeatChar(password);
        int midNumSym = cekMiddleNumberOrSymbol(password);

        // http://www.passwordmeter.com/

        Log.e(TAG, "================================================");
        Log.e(TAG, "Additions       ================================");
        // Additions
        passStength += passLen*4; //n*4 (Number of Characters)
        Log.e(TAG, "Number of Characters : " + passLen*4);

        passStength += (upperCase != 0) ? (passLen - upperCase)*2 : 0; // (len - n)*2 (Uppercase Letters)
        Log.e(TAG, "Uppercase Letters : " + ((upperCase != 0) ? (passLen - upperCase)*2 : 0));

        passStength += (upperCase != 0) ? (passLen - lowerCase)*2 : 0; // (len - n)*2 (Lowercase Letters)
        Log.e(TAG, "Lowercase Letters : " + ((upperCase != 0) ? (passLen - lowerCase)*2 : 0));

        passStength += numberLen*4; // n *4 (Numbers)
        Log.e(TAG, "Numbers : " + numberLen*4);

        passStength += symbolLen*6; // n *6 (Symbols)
        Log.e(TAG, "Symbols : " + symbolLen*6);

        passStength += midNumSym*2; // n *2 (Middle Numbers or Symbols)
        Log.e(TAG, "Middle Numbers or Symbols : " + midNumSym*2);

        // Requirements
        Log.e(TAG, "Requirements : 0");


        Log.e(TAG, "Deductions     =================================");
        //Deductions
        passStength -= ((numberLen + symbolLen) == 0) ? passLen : 0; // n (Letters Only)
        Log.e(TAG, "Letters Only : " + (((numberLen + symbolLen) == 0) ? passLen : 0));

        passStength -= ((upperCase + lowerCase + symbolLen) == 0) ? passLen: 0; // n (Numbers Only)
        Log.e(TAG, "Numbers Only : " + (((upperCase + lowerCase + symbolLen) == 0) ? passLen: 0));

        passStength -= repeatChr; // (Repeat Characters (Case Insensitive))
        Log.e(TAG, "Numbers Only : " + repeatChr);

        // (Consecutive Uppercase Letters)
        Log.e(TAG, "Symbols : 0");

        // (Consecutive Lowercase Letters)
        Log.e(TAG, "Consecutive Uppercase Letters : 0");

        // (Consecutive Numbers)
        Log.e(TAG, "Consecutive Numbers : 0");

        passStength -= (letterSeq * 3); // (Sequential Letters (3+))
        Log.e(TAG, "Sequential Letters (3+) : " + letterSeq * 3);

        passStength -= (numberSeq * 3); // (Sequential Numbers (3+))
        Log.e(TAG, "Sequential Numbers (3+) : " + numberSeq * 3);

        passStength -= (symbolSeq * 3); // (Sequential Symbols (3+))
        Log.e(TAG, "Sequential Symbols (3+) : " + symbolSeq * 3);

        Log.e(TAG, "================================================");

        return passStength;
    }

    @Override
    protected void onPostExecute(Integer passStrength) {
        super.onPostExecute(passStrength);

        if (passStrength > 80) mCekListener.passwordStrength(PasswordStrength.VERYSTRONG);
        else if (passStrength > 60) mCekListener.passwordStrength(PasswordStrength.STRONG);
        else if (passStrength > 40) mCekListener.passwordStrength(PasswordStrength.NORMAL);
        else if (passStrength > 20) mCekListener.passwordStrength(PasswordStrength.WEAK);
        else if (passStrength > 0) mCekListener.passwordStrength(PasswordStrength.VERYWEAK);
        else mCekListener.passwordStrength(PasswordStrength.EMPTY);

    }

    private int cekLowerCase(String password) {
        int strength = 0;
        int n = password.length();

        for (int i=0; i<n; i++) {
            char pass = password.charAt(i);

                 if (pass == 'a') strength++;
            else if (pass == 'b') strength++;
            else if (pass == 'c') strength++;
            else if (pass == 'd') strength++;
            else if (pass == 'e') strength++;
            else if (pass == 'f') strength++;
            else if (pass == 'g') strength++;
            else if (pass == 'h') strength++;
            else if (pass == 'i') strength++;
            else if (pass == 'j') strength++;
            else if (pass == 'k') strength++;
            else if (pass == 'l') strength++;
            else if (pass == 'm') strength++;
            else if (pass == 'n') strength++;
            else if (pass == 'o') strength++;
            else if (pass == 'p') strength++;
            else if (pass == 'q') strength++;
            else if (pass == 'r') strength++;
            else if (pass == 's') strength++;
            else if (pass == 't') strength++;
            else if (pass == 'u') strength++;
            else if (pass == 'v') strength++;
            else if (pass == 'w') strength++;
            else if (pass == 'x') strength++;
            else if (pass == 'y') strength++;
            else if (pass == 'z') strength++;
            else ;

        }

        return strength;
    }

    private int cekUpperCase(String password) {
        int strength = 0;
        int n = password.length();

        for (int i=0; i<n; i++) {
            char pass = password.charAt(i);

                 if (pass == 'A') strength++;
            else if (pass == 'B') strength++;
            else if (pass == 'C') strength++;
            else if (pass == 'D') strength++;
            else if (pass == 'E') strength++;
            else if (pass == 'F') strength++;
            else if (pass == 'G') strength++;
            else if (pass == 'H') strength++;
            else if (pass == 'I') strength++;
            else if (pass == 'J') strength++;
            else if (pass == 'K') strength++;
            else if (pass == 'L') strength++;
            else if (pass == 'M') strength++;
            else if (pass == 'N') strength++;
            else if (pass == 'O') strength++;
            else if (pass == 'P') strength++;
            else if (pass == 'Q') strength++;
            else if (pass == 'R') strength++;
            else if (pass == 'S') strength++;
            else if (pass == 'T') strength++;
            else if (pass == 'U') strength++;
            else if (pass == 'V') strength++;
            else if (pass == 'W') strength++;
            else if (pass == 'X') strength++;
            else if (pass == 'Y') strength++;
            else if (pass == 'Z') strength++;
            else ;

        }

        return strength;
    }

    private int cekNumber(String password) {
        int strength = 0;
        strength = (password.contains("0")) ? strength + 1 : strength + 0;
        strength = (password.contains("1")) ? strength + 1 : strength + 0;
        strength = (password.contains("2")) ? strength + 1 : strength + 0;
        strength = (password.contains("3")) ? strength + 1 : strength + 0;
        strength = (password.contains("4")) ? strength + 1 : strength + 0;
        strength = (password.contains("5")) ? strength + 1 : strength + 0;
        strength = (password.contains("6")) ? strength + 1 : strength + 0;
        strength = (password.contains("7")) ? strength + 1 : strength + 0;
        strength = (password.contains("8")) ? strength + 1 : strength + 0;
        strength = (password.contains("9")) ? strength + 1 : strength + 0;
        return strength;
    }

    private int cekSymbol(String password) {
        int strength = 0;
        strength = (password.contains(".")) ? strength + 1 : strength + 0;
        strength = (password.contains(",")) ? strength + 1 : strength + 0;
        strength = (password.contains("/")) ? strength + 1 : strength + 0;
        strength = (password.contains("<")) ? strength + 1 : strength + 0;
        strength = (password.contains(">")) ? strength + 1 : strength + 0;
        strength = (password.contains("?")) ? strength + 1 : strength + 0;
        strength = (password.contains(";")) ? strength + 1 : strength + 0;
        strength = (password.contains(":")) ? strength + 1 : strength + 0;
        strength = (password.contains("'")) ? strength + 1 : strength + 0;
        strength = (password.contains("\"")) ? strength + 1 : strength + 0;
        strength = (password.contains("\\")) ? strength + 1 : strength + 0;
        strength = (password.contains("|")) ? strength + 1 : strength + 0;
        strength = (password.contains("]")) ? strength + 1 : strength + 0;
        strength = (password.contains("}")) ? strength + 1 : strength + 0;
        strength = (password.contains("{")) ? strength + 1 : strength + 0;
        strength = (password.contains("[")) ? strength + 1 : strength + 0;
        strength = (password.contains("=")) ? strength + 1 : strength + 0;
        strength = (password.contains("+")) ? strength + 1 : strength + 0;
        strength = (password.contains("-")) ? strength + 1 : strength + 0;
        strength = (password.contains("_")) ? strength + 1 : strength + 0;
        strength = (password.contains(")")) ? strength + 1 : strength + 0;
        strength = (password.contains("(")) ? strength + 1 : strength + 0;
        strength = (password.contains("*")) ? strength + 1 : strength + 0;
        strength = (password.contains("&")) ? strength + 1 : strength + 0;
        strength = (password.contains("^")) ? strength + 1 : strength + 0;
        strength = (password.contains("%")) ? strength + 1 : strength + 0;
        strength = (password.contains("$")) ? strength + 1 : strength + 0;
        strength = (password.contains("#")) ? strength + 1 : strength + 0;
        strength = (password.contains("@")) ? strength + 1 : strength + 0;
        strength = (password.contains("!")) ? strength + 1 : strength + 0;
        strength = (password.contains("`")) ? strength + 1 : strength + 0;
        strength = (password.contains("~")) ? strength + 1 : strength + 0;
        return strength;
    }

    private int cekSequenceLetter(String password) {
        int nSeqAlpha = 0;
        String sAlphas = "abcdefghijklmnopqrstuvwxyz";

        for (int s=0; s < 23; s++) {
            String sFwd = sAlphas.substring(s, s+3);
            String sRev = new StringBuilder(sFwd).reverse().toString();
            if (password.toLowerCase().indexOf(sFwd) != -1 || password.toLowerCase().indexOf(sRev) != -1) {
                nSeqAlpha++;
            }
        }
        return nSeqAlpha;
    }

    private int cekSequenceNumber(String password) {
        int nSeqNumber = 0;
        String sNumerics = "01234567890";
        for (int s=0; s < 8; s++) {
            String sFwd = sNumerics.substring(s, s+3);
            String sRev = new StringBuilder(sFwd).reverse().toString();
            if (password.toLowerCase().indexOf(sFwd) != -1 || password.toLowerCase().indexOf(sRev) != -1) {
                nSeqNumber++;
            }
        }
        return nSeqNumber;
    }

    private int cekSequenceSymbol(String password) {
        int nSeqSymbol = 0;
        String sSymbols = ")!@#$%^&*()";
        for (int s=0; s < 8; s++) {
            String sFwd = sSymbols.substring(s, (s+3));
            String sRev = new StringBuilder(sFwd).reverse().toString();
            if (password.toLowerCase().indexOf(sFwd) != -1 || password.toLowerCase().indexOf(sRev) != -1) {
                nSeqSymbol++;
            }
        }
        return nSeqSymbol;
    }

    private int cekRepeatChar(String password) {
        int n = password.length();
        int result = 0;

        for (int i=0; i<n-1; i++) {
            if (password.charAt(i) == password.charAt(i+1)) {
                result++;
            }
        }

        return result;
    }

    private int cekMiddleNumberOrSymbol(String password) {
        if (password.length() == 0) return 0;

        String pass = password.substring(1);
        pass = pass.substring(0, pass.length());

        int result = cekNumber(pass);
        result += cekSymbol(pass);

        return result;
    }

}
