# Cek Password

## Getting Started

#### 1. Import .aar file into libs
[passwordmatter-1.0.aar](https://github.com/tyangjawi03/cekpassword/blob/master/passwordmatter-1.0.aar)

#### 2. Implements interface Cek.CekView
    public class MainActivity extends AppCompatActivity implements Cek.CekView {

#### 3. CreateObject CekPresenter as global in your activity
    private CekPresenter cekPresenter;

#### 4. call method howSecure in yourTextWatcher

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

#### 5. result of the password metter define in method passwordStrength as Strength result
    @Override
    public void passwordStrength(Strength result) {
        pbPassword.setProgress(result.getStrength());
        txPassword.setText(result.getDescription());
    }
    
#### 6. use result as you wish.


## Credit
to compute Password Strength we used algorithm from [http://www.passwordmeter.com/](http://www.passwordmeter.com/) 


## License
    
    Copyright (C) 2016  Bashir Arrohman

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.