package nguyenduchung.ndh.recyclerview04092019;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText mEdtten,mEdtMota,mEdtGia;
    Button mBtnDongy,mBtnHuy;
    RecyclerView mMonAnRecyclerView;
    ArrayList<MonAn> mArrayMonan;
    MonAnAdapter mMonAnAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 1 : tao class mon an
        // 2 : tao layout item mon an
        // 3 : tao ra adapter cho recycle
        // 4 : Gan layout cho recycler
        //anh xa
        mMonAnRecyclerView=findViewById(R.id.recyclerviewMoan);
        mEdtten=findViewById(R.id.edittextTen);
        mEdtMota=findViewById(R.id.edittextMota);
        mEdtGia=findViewById(R.id.edittextGia);
        mBtnDongy=findViewById(R.id.buttonDongy);
        mBtnHuy=findViewById(R.id.buttonHuybo);

         mArrayMonan = new ArrayList<>();
         mArrayMonan.add(new MonAn("Gỏi cuốn","Đặt sản miền trung",10000,R.drawable.goicuon));
         mArrayMonan.add(new MonAn("Tôm chiên","Món ăn dân gia",50000,R.drawable.tomchien));
         mArrayMonan.add(new MonAn("Há cảo","Món ăn trung hoa",35000,R.drawable.hacao));
         mArrayMonan.add(new MonAn("Phở","Đặt sản Việt Nam",950000,R.drawable.pho));
         mArrayMonan.add(new MonAn("Sushi","Món ăn Nhật Bản",42000,R.drawable.sushi));

         mMonAnAdapter = new MonAnAdapter(mArrayMonan);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        mMonAnRecyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this, DividerItemDecoration.VERTICAL));
        mMonAnRecyclerView.setLayoutManager(linearLayoutManager);
        mMonAnRecyclerView.setAdapter(mMonAnAdapter);


    }
}
