package androidedu.kodluyoruz.kodluyoruzrestaurant;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidedu.kodluyoruz.kodluyoruzrestaurant.enumaration.UserInformation;

/**
 * Created by Gökhan ÖZTÜRK
 * 8.03.2017
 * CodeProject.G@gmail.com
 */
public class UserInformationFragment extends Fragment implements View.OnClickListener {

    private EditText edtBaslangicYemegi = null, edtAnaYemek = null, edtTatli = null, edtIcecek = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_userinformation, container, false);

        initView(view);

        return view;
    }

    private void initView(View view) {

        edtBaslangicYemegi = (EditText) view.findViewById(R.id.user_information_fields_edtBaslangicYemegi);
        edtAnaYemek = (EditText) view.findViewById(R.id.user_information_fields_edtAnaYemek);
        edtTatli = (EditText) view.findViewById(R.id.user_information_fields_edtTatli);
        edtIcecek = (EditText) view.findViewById(R.id.user_information_fields_edtIcecek);
        AppCompatButton btnLokantayaIlet = (AppCompatButton) view.findViewById(R.id.user_information_fields_btnLokantayaIlet);

        initEvents(btnLokantayaIlet);
    }

    private void initEvents(AppCompatButton btnLokantayaIlet) {

        btnLokantayaIlet.setOnClickListener(this);
    }

    private void setData(Intent intent, String userIndex) {

        if (userIndex.equalsIgnoreCase("")) {

            userIndex = "2";

        } else if (userIndex.equalsIgnoreCase("2")) {

            getOldData(intent, "2");

            userIndex = "3";
        } else if (userIndex.equalsIgnoreCase("3")) {

            getOldData(intent, "2");
            getOldData(intent, "3");

            userIndex = "4";
        }

        intent.putExtra(UserInformation.INDEX.toString(), userIndex);
        intent.putExtra(UserInformation.BASLANGIC.toString() + userIndex, edtBaslangicYemegi.getText().toString());
        intent.putExtra(UserInformation.ANAYEMEK.toString() + userIndex, edtAnaYemek.getText().toString());
        intent.putExtra(UserInformation.TATLI.toString() + userIndex, edtTatli.getText().toString());
        intent.putExtra(UserInformation.ICECEK.toString() + userIndex, edtIcecek.getText().toString());

        Log.i("New Data : " + userIndex, " Başlangıç : " + edtBaslangicYemegi.getText().toString()
                + " Ana Yemek : " + edtAnaYemek.getText().toString()
                + " Tatlı : " + edtTatli.getText().toString()
                + " İçcecek : " + edtIcecek.getText().toString());
    }

    private void getOldData(Intent intent, String index) {

        String baslangic = getActivity().getIntent().getExtras().getString(UserInformation.BASLANGIC.toString() + index, "");
        String anaYemek = getActivity().getIntent().getExtras().getString(UserInformation.ANAYEMEK.toString() + index, "");
        String tatli = getActivity().getIntent().getExtras().getString(UserInformation.TATLI.toString() + index, "");
        String icecek = getActivity().getIntent().getExtras().getString(UserInformation.ICECEK.toString() + index, "");

        intent.putExtra(UserInformation.INDEX.toString(), index);
        intent.putExtra(UserInformation.BASLANGIC.toString() + index, baslangic);
        intent.putExtra(UserInformation.ANAYEMEK.toString() + index, anaYemek);
        intent.putExtra(UserInformation.TATLI.toString() + index, tatli);
        intent.putExtra(UserInformation.ICECEK.toString() + index, icecek);

        Log.i("Old Data : " + index, " Başlangıç : " + baslangic
                + " Ana Yemek : " + anaYemek
                + " Tatlı : " + tatli
                + " İçcecek : " + icecek);
    }

    @Override
    public void onClick(View v) {

        String userIndex;
        if (getActivity().getIntent().getExtras() != null) {

            userIndex = getActivity().getIntent().getExtras().getString(UserInformation.INDEX.toString(), "");
        } else {
            userIndex = "";
        }

        Intent intent;
        switch (userIndex) {

            case "":
                intent = new Intent(getActivity(), UserTwoActivity.class);
                break;
            case "2":
                intent = new Intent(getActivity(), UserThreeActivity.class);
                break;

            default:
                intent = null;
                break;
        }

        setData(intent, userIndex);

        startActivity(intent);

        getActivity().finish();
    }
}
