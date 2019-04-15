package layout.milad.com.testsqli;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import layout.milad.com.testsqli.storage.MySqliteDB;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private EditText enterName, enterFamily;
    private Button btnSave, btnGetData,btnSecond;
    private MySqliteDB mySqliteDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterName = findViewById(R.id.enterName);
        enterFamily = findViewById(R.id.enterFamily);
        btnSave = findViewById(R.id.btn_save);
        btnSecond = findViewById(R.id.btn_activity_two);
        btnGetData = findViewById(R.id.btn_get_data);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = enterName.getText().toString().trim();
                String family = enterFamily.getText().toString().trim();
                mySqliteDB = new MySqliteDB(MainActivity.this);
                mySqliteDB.insertData(name, family);

            }
        });

        btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor allData = mySqliteDB.getAllData();
                String data = null;
                StringBuffer buffer = new StringBuffer();
                while (allData.moveToNext()) {
                    buffer.append("Id :" + allData.getString(0) + "\n");
                    buffer.append("Name :" + allData.getString(1) + "\n\n");
                    buffer.append("Family :" + allData.getString(2) + "\n\n");
                }

                dialogView("Data", buffer.toString());
            }
        });

        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });

    }

    public void dialogView(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.create();
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
