package jp.ac.meijou.android.s241205095;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import jp.ac.meijou.android.s241205095.databinding.ActivityMain2Binding;
import jp.ac.meijou.android.s241205095.databinding.ActivityMain4Binding;

public class MainActivity4 extends AppCompatActivity {

    private ActivityMain4Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMain4Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //setContentView(R.layout.activity_main4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        var editText = getIntent().getStringExtra("text");
        binding.textViewsend.setText(editText);

        binding.OKbutton.setOnClickListener(view -> {
            var intent = new Intent();
            intent.putExtra("ret", "Hello from Activity4");
            setResult(RESULT_OK, intent);
            finish();
        });

        binding.cancelbutton.setOnClickListener(view -> {
            setResult(RESULT_CANCELED);
            finish();
        });
    }
}