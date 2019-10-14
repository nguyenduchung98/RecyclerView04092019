package nguyenduchung.ndh.recyclerview04092019;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText mEdtten,mEdtMota,mEdtGia;
    Button mBtnDongy,mBtnHuy;
    RecyclerView mMonAnRecyclerView;
    ArrayList<MonAn> mArrayMonan;
    MonAnAdapter mMonAnAdapter;
    int mIndext=0;
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

        mBtnDongy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mBtnDongy.getText().equals("Đồng ý")){
                    Toast.makeText(MainActivity.this, "Thêm thành công.", Toast.LENGTH_SHORT).show();
                }
                else if(mBtnDongy.getText().equals("Cập Nhật")){
                    MonAn monAn= mArrayMonan.get(mIndext);
                    monAn.setTen(mEdtten.getText().toString());
                    monAn.setMota(mEdtMota.getText().toString());
                    monAn.setGia(Integer.parseInt(mEdtGia.getText().toString()));
                    mBtnDongy.setText("Đồng ý");
                    mMonAnAdapter.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "Cập nhật thành công.", Toast.LENGTH_SHORT).show();

                }
            }
        });

        if(((MonAnAdapter)mMonAnRecyclerView.getAdapter()) != null){
            ((MonAnAdapter)mMonAnRecyclerView.getAdapter()).setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onClick(View v, @NonNull int position) {
                   MonAn monAn= mArrayMonan.get(position);
                   mEdtten.setText(monAn.getTen().toString());
                   mEdtMota.setText(monAn.getMota().toString());
                   mEdtGia.setText(monAn.getGia().toString());
                   mIndext=position;
                   mBtnDongy.setText("Cập Nhật");
                }

                @Override
                public void onLongClick(View v, @NonNull int position) {
                    mArrayMonan.remove(position);
                    mMonAnAdapter.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "Xóa Thành công!", Toast.LENGTH_SHORT).show();
                }
            });
        }



    }
}
