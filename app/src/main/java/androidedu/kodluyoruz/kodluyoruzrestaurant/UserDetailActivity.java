package androidedu.kodluyoruz.kodluyoruzrestaurant;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import androidedu.kodluyoruz.kodluyoruzrestaurant.enumaration.UserInformation;

/**
 * Created by Gökhan ÖZTÜRK
 * 8.03.2017
 * CodeProject.G@gmail.com
 */
public class UserDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userdetail);

        initView();
    }

    private void initView() {

        //userOne
        View incViewUserOne = findViewById(R.id.activity_userdetail_incViewUserOne);
        TextView txtUserHeader1 = (TextView) incViewUserOne.findViewById(R.id.user_detail_item_txtUserHeader);
        TextView txtBaslangicYemek1 = (TextView) incViewUserOne.findViewById(R.id.user_detail_item_txtBaslangicYemek);
        TextView txtAnaYemek1 = (TextView) incViewUserOne.findViewById(R.id.user_detail_item_txtAmaYemek);
        TextView txtTatli1 = (TextView) incViewUserOne.findViewById(R.id.user_detail_item_txtTatli);
        TextView txtIcecek1 = (TextView) incViewUserOne.findViewById(R.id.user_detail_item_txtIcecek);

        initEvent("2", txtUserHeader1, txtBaslangicYemek1, txtAnaYemek1, txtTatli1, txtIcecek1);

        //userTwo
        View incViewUserTwo = findViewById(R.id.activity_userdetail_incViewUserTwo);
        TextView txtUserHeader2 = (TextView) incViewUserTwo.findViewById(R.id.user_detail_item_txtUserHeader);
        TextView txtBaslangicYemek2 = (TextView) incViewUserTwo.findViewById(R.id.user_detail_item_txtBaslangicYemek);
        TextView txtAnaYemek2 = (TextView) incViewUserTwo.findViewById(R.id.user_detail_item_txtAmaYemek);
        TextView txtTatli2 = (TextView) incViewUserTwo.findViewById(R.id.user_detail_item_txtTatli);
        TextView txtIcecek2 = (TextView) incViewUserTwo.findViewById(R.id.user_detail_item_txtIcecek);

        initEvent("3", txtUserHeader2, txtBaslangicYemek2, txtAnaYemek2, txtTatli2, txtIcecek2);

        //userThree
        View incViewUserThree3 = findViewById(R.id.activity_userdetail_incViewUserThree);
        TextView txtUserHeader3 = (TextView) incViewUserThree3.findViewById(R.id.user_detail_item_txtUserHeader);
        TextView txtBaslangicYemek3 = (TextView) incViewUserThree3.findViewById(R.id.user_detail_item_txtBaslangicYemek);
        TextView txtAnaYemek3 = (TextView) incViewUserThree3.findViewById(R.id.user_detail_item_txtAmaYemek);
        TextView txtTatli3 = (TextView) incViewUserThree3.findViewById(R.id.user_detail_item_txtTatli);
        TextView txtIcecek3 = (TextView) incViewUserThree3.findViewById(R.id.user_detail_item_txtIcecek);

        initEvent("4", txtUserHeader3, txtBaslangicYemek3, txtAnaYemek3, txtTatli3, txtIcecek3);
    }

    private void initEvent(String userIndex, TextView txtUserHeader, TextView txtBaslangicYemek,
                           TextView txtAnaYemek, TextView txtTatli, TextView txtIcecek) {

        String baslangic = getIntent().getExtras().getString(UserInformation.BASLANGIC.toString() + userIndex, "");
        String anaYemek = getIntent().getExtras().getString(UserInformation.ANAYEMEK.toString() + userIndex, "");
        String tatli = getIntent().getExtras().getString(UserInformation.TATLI.toString() + userIndex, "");
        String icecek = getIntent().getExtras().getString(UserInformation.ICECEK.toString() + userIndex, "");

        txtUserHeader.setText(String.format("%s%s", getString(R.string.musteri), Integer.parseInt(userIndex) - 1));
        txtBaslangicYemek.setText(baslangic);
        txtAnaYemek.setText(anaYemek);
        txtTatli.setText(tatli);
        txtIcecek.setText(icecek);
    }
}
