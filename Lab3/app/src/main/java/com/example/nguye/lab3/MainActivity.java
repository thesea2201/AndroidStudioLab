package com.example.nguye.lab3;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.example.nguye.lab3.DatabaseHandler;
import com.example.nguye.lab3.Contact;

public class MainActivity extends AppCompatActivity {
    /*
    private DbAdapter dbAdapter;
    private Cursor cursor;
    private List<String> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbAdapter = new DbAdapter(this);
        dbAdapter.open();
        dbAdapter.deleteAllUsers();
        for (int i = 0; i < 20; i++) {
            dbAdapter.createUser("Nguyễn An " + i);
        }
        users = getData();
        showData();
    }

    private void showData() {
        ListView lvUser = (ListView) findViewById(R.id.lv_user);
        ArrayAdapter<String> userAdapter = new
                ArrayAdapter<String>(MainActivity.this, R.layout.item_user, users);
        lvUser.setAdapter(userAdapter);
    }

    private List<String> getData() {
        List<String> users = new ArrayList<>();
        cursor = dbAdapter.getAllUsers();
        while (cursor.moveToNext()) {
            users.add(cursor.getString(cursor.getColumnIndex(DbAdapter.KEY_NAME)));
        }
        return users;
    }
    */

    private ListView lvUser;
    private DatabaseHandler db;
    ArrayList<Contact> contacts;
    ArrayAdapter<Contact> userAdapter = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvUser = (ListView) findViewById(R.id.lv_user);
        db = new DatabaseHandler(this);
        /**
         * CRUD Operations
         * */
        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
        db.addContact(new Contact("Ravi", "9100000000"));
        db.addContact(new Contact("Srinivas", "9199999999"));
        db.addContact(new Contact("Tommy", "9522222222"));
        db.addContact(new Contact("Karthik", "9533333333"));

        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        contacts = db.getAllContacts();
        for (Contact cn : contacts) {
            String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
            // Writing Contacts to log
            Log.d("Name: ", log);
        }
        userAdapter = new
                ArrayAdapter<Contact>(MainActivity.this, R.layout.item_user, contacts);
        lvUser.setAdapter(userAdapter);

        lvUser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected = (String)parent.getItemAtPosition(position).toString();
                TextView tvSelected = (TextView)findViewById(R.id.tv_selected);
                tvSelected.setText("Your selected: " + selected);
            }
        });
        lvUser.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Contact contactSelected = (Contact) parent.getItemAtPosition(position);
                db.deleteContact(contactSelected);
                contacts.remove(position);
                userAdapter.notifyDataSetChanged();
                return false;
            }
        });
    }
}