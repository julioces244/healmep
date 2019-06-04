package com.tecsup.apaza.healmepaciente;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.tecsup.apaza.healmepaciente.Adapters.UsersAdapter;
//import com.tecsup.apaza.healmepaciente.Class.Doctor;
import com.tecsup.apaza.healmepaciente.Class.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DoctorListActivity extends AppCompatActivity {

    private static final String TAG = DoctorListActivity.class.getSimpleName();

    private RecyclerView doctorsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list);

        doctorsList = (RecyclerView) findViewById(R.id.recyclerview);
        doctorsList.setLayoutManager(new LinearLayoutManager(this));

        doctorsList.setAdapter(new UsersAdapter());

        initialize();

    }


    private void initialize() {

        ApiService service = ApiServiceGenerator.createService(ApiService.class);

        Call<List<User>> call = service.getUsers();

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                try {

                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code: " + statusCode);

                    if (response.isSuccessful()) {

                        List<User> users = response.body();
                        Log.d(TAG, "doctors: " + users);

                        UsersAdapter adapter = (UsersAdapter) doctorsList.getAdapter();
                        adapter.setDoctos(users);
                        adapter.notifyDataSetChanged();

                    } else {
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Error en el servicio");
                    }

                } catch (Throwable t) {
                    try {
                        Log.e(TAG, "onThrowable: " + t.toString(), t);
                        Toast.makeText(DoctorListActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }catch (Throwable x){}
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(DoctorListActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }

        });
    }

}
