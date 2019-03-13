package com.example.retrofitexample;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private CustomAdapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDoalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressDoalog = new ProgressDialog(MainActivity.this);
        progressDoalog.setMessage("Loading...");
        progressDoalog.show();
        // φτιαξε ενα service. Φτιαξε ενα αντικειμενο του retrofit και καλεσε αυτου την create() και δωστου σαν παραμετρο
        // το interface που θα κανει τα call στο server. Ετσι φτιαχνεις ενα αντικειμενο service το οποιο περιεχει τα calls
        // που μπορει να κανει.
        //Στη συνεχεια φτιαξε ενα call object που θα εχει μεσα την λιστα αυτων που θες και μεσω του service καλεσε την
        //αντιστοιχη μεθοδο για να παρεις το αποτελεσμα. Τελος καλεσε στο αντικειμενο που πηρες απο το service
        // και αν ολα εχουν παει καλα παρε το response και παρε τα δεδομενα αλλιως κατι πηγε στραβα και δεν τα πηρες.



        //enqueue asynchronously sends the request and notifies the app when a response comes back
        //retrofit uses a background thread in order not to block the UI thread.
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<RetroPhoto>> call = service.getAllPhotos();
        call.enqueue(new Callback<List<RetroPhoto>>() {
            @Override
            public void onResponse(Call<List<RetroPhoto>> call, Response<List<RetroPhoto>> response) {
                progressDoalog.dismiss();
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<RetroPhoto>> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateDataList(List<RetroPhoto> list) {
        recyclerView = findViewById(R.id.customRecyclerView);
        adapter = new CustomAdapter(this, list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
