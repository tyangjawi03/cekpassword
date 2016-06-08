package id.bashir.cekpassword;

/**
 * Created by Bashir on 08/06/2016.
 */
public class PasswordStrength {

    public static Strength EMPTY = new Strength(0, "Empty");
    public static Strength VERYWEAK = new Strength(20, "Very Weak");
    public static Strength WEAK = new Strength(40, "Weak");
    public static Strength NORMAL = new Strength(60, "Normal");
    public static Strength STRONG = new Strength(80, "Strong");
    public static Strength VERYSTRONG = new Strength(100, "Very Strong");

}
