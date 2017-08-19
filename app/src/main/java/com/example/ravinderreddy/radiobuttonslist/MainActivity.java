package com.example.ravinderreddy.radiobuttonslist;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Model> mModelList = null;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mModelList = new ArrayList<>();
        createDummyList();
    }


    private void createDummyList() {
        Model model = new Model();
        model.setId(8471);
        model.setName("Java");
        mModelList.add(model);

        Model model1 = new Model();
        model1.setId(152);
        model1.setName("Android");
        mModelList.add(model1);

        Model model3 = new Model();
        model3.setId(4853);
        model3.setName("Python");
        mModelList.add(model3);
    }

    public void showDialog(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final String[] mStringList = mGetStringsListFromModel(mModelList);
        // Set the dialog title
        builder.setTitle(R.string.pick_toppings)
                // Specify the list array, the items to be selected by default (null for none),
                // and the listener through which to receive callbacks when items are selected
                .setSingleChoiceItems(mStringList, 2, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Clicked "+mModelList.get(i).getId(), Toast.LENGTH_SHORT).show();
                    }
                }).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        })
                .show();
    }

    private String[] mGetStringsListFromModel(List<Model> mModelList) {
        List<String> mStringList = new ArrayList<>();
        for (int i = 0; i < mModelList.size(); i++) {
            mStringList.add(mModelList.get(i).getName());
        }
        return mStringList.toArray(new String[]{});
    }
}
