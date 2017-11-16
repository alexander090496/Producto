package com.example.jonmid.productos.Views;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jonmid.productos.Helpers.SqliteHelper;
import com.example.jonmid.productos.IndexActivity;
import com.example.jonmid.productos.R;
import com.example.jonmid.productos.Utilities.ConstantsUtilities;

public class EditProductActivity extends AppCompatActivity {

    TextView textViewId;
    TextInputEditText textInputEditTextName;
    TextInputEditText textInputEditTextDescription;
    TextInputEditText textInputEditTextPrice;
    TextInputEditText textInputEditTextImage;
    SqliteHelper sqliteHelper;
    Integer idproduc;
    String name,descrip,preci,image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_product);

        textViewId = (TextView) findViewById(R.id.id_tv_edit_idproduc);
        textInputEditTextName = (TextInputEditText) findViewById(R.id.id_tiet_edit_name);
        textInputEditTextDescription = (TextInputEditText) findViewById(R.id.id_tiet_edit_description);
        textInputEditTextPrice = (TextInputEditText) findViewById(R.id.id_tiet_edit_price);
        textInputEditTextImage = (TextInputEditText) findViewById(R.id.id_tiet_edit_image);

        sqliteHelper = new SqliteHelper(this, "bd_products", null, 1);
        idproduc=getIntent().getExtras().getInt("id");
        name=getIntent().getExtras().getString("name");
        descrip=getIntent().getExtras().getString("descripcion");
        preci=getIntent().getExtras().getString("precio");
        image=getIntent().getExtras().getString("imagen");


        textViewId.setText(idproduc);
        textInputEditTextName.setText(name);
        textInputEditTextDescription.setText(descrip);
        textInputEditTextPrice.setText(preci);
        textInputEditTextImage.setText(image);

    }

    public void editProduct(View view){


        SQLiteDatabase db = sqliteHelper.getReadableDatabase();

        db.execSQL("UPDATE products SET name="+"'"+textInputEditTextName.getText()+"'"+",descri="+"'"+textInputEditTextDescription.getText()+"'"+",precio="+"'"+textInputEditTextPrice.getText()+"'"+",image="+"'"+textInputEditTextImage.getText()+"'"+"where id="+idproduc);

        Toast.makeText(this, "Contacto eliminado correctamente", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, IndexActivity.class);
        startActivity(intent);

        //
    }
}
