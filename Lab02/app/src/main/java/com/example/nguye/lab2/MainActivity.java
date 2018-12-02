package com.example.nguye.lab2;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity {
    /*
    //truong hop 1
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1. Khởi tạo dữ liệu cho mảng arr (còn gọi là data source)
        final String arr[]={"Teo","Ty","Bin","Bo"};
        //2. Lấy đối tượng Listview dựa vào id
        ListView lv=(ListView) findViewById(R.id.lv_person);
        //3. Gán Data source vào ArrayAdapter
        ArrayAdapter<String> adapter=new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, arr);
        //4. Đưa Data source vào ListView
        lv.setAdapter(adapter);
        final TextView txt=(TextView) findViewById(R.id.txt_selection);
        //5. Thiết lập sự kiện cho Listview, khi chọn phần tử nào thì hiển thị lên TextView
        lv.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> arg0,
                                            View arg1,
                                            int arg2,
                                            long arg3) {
                        //đối số arg2 là vị trí phần tử trong Data Source (arr)
                        txt.setText("position :"+arg2+" ; value ="+arr[arg2]);
                    }
                });
    }
    */

    /*//truong hop 2
    EditText txtten;
    TextView txtchon;
    Button btn;
    ListView lv;
    ArrayList<String> arrList=null;
    ArrayAdapter<String> adapter=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtten=(EditText) findViewById(R.id.txtTen);
        txtchon=(TextView) findViewById(R.id.txtselection);

        lv=(ListView) findViewById(R.id.lvperson);
        //1. Tạo ArrayList object
        arrList=new ArrayList<String>();
        //2. Gán Data Source (ArrayList object) vào ArrayAdapter
        adapter=new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, arrList);
        //3. gán Adapter vào ListView
        lv.setAdapter(adapter);

        btn=(Button) findViewById(R.id.btnNhap);
        //4. Xử lý sự kiện nhấn nút Nhập
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                arrList.add(txtten.getText()+"");
                adapter.notifyDataSetChanged();
            }
        });
        //5. Xử lý sự kiện chọn một phần tử trong ListView
        lv.setOnItemClickListener(new AdapterView
                .OnItemClickListener() {
            public void onItemClick(
                    AdapterView<?> arg0,View arg1,
                    int arg2,long arg3) {

                txtchon.setText("position : "+ arg2+
                        "; value ="+arrList.get(arg2));
            }
        });
        //6. xử lý sự kiện Long click
        lv.setOnItemLongClickListener(new AdapterView
                .OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int arg2, long arg3) {
                arrList.remove(arg2);//xóa phần tử thứ arg2
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }*/

    //truong hop 4
    EditText editId,editName;
    Button btnNhap;
    RadioGroup radgroup;
    CheckBox checkBox;
    ListView lvNhanvien;
    ArrayList<Employee>arrEmployee=new ArrayList<Employee>();
    ArrayAdapter<Employee>adapter=null;
    //Khai báo 1 employee object
    Employee employee= null;
    EmployeeAdapter emAdapter = null;
    int currentPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editId=(EditText) findViewById(R.id.editID);
        editName=(EditText) findViewById(R.id.editName);
        btnNhap=(Button) findViewById(R.id.btnnhap1);
        radgroup=(RadioGroup) findViewById(R.id.radiogroud1);
        checkBox = (CheckBox)findViewById(R.id.checkbox1);
        lvNhanvien=(ListView) findViewById(R.id.lvnhanvien1);
        //đưa Data Source là các employee vào Adapter
        adapter=new ArrayAdapter<Employee>(this,
                android.R.layout.simple_list_item_1,
                arrEmployee);
        //đưa adapter vào ListView
        lvNhanvien.setAdapter(adapter);
        new EmployeeAdapter(this,R.layout.activity_main, arrEmployee );
        btnNhap.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                processNhap();
            }
        });
    }
    //Xử lý sự kiện nhập
    public void processNhap()
    {
        employee= new EmployeeFullTime();
        String id=editId.getText()+"";
        String name=editName.getText()+"";
        if(checkBox.isChecked()){
            int position = 1;
        }

        //FullTime hay Partime thì cũng là Employee
        //nên có các hàm này là hiển nhiên
        employee.setId(id);
        employee.setName(name);
        //Đưa employee vào ArrayList
        arrEmployee.add(employee);
        //Cập nhập giao diện
        adapter.notifyDataSetChanged();
    }
}