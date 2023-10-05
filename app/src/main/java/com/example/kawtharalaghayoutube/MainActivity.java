package com.example.kawtharalaghayoutube;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.kawtharalaghayoutube.databinding.ActivityMainBinding;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

   //TextView textView;

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        parseJsonFromString();

       // textView=findViewById(R.id.tvParseJson);

    }

    private void parseJsonFromString() {

        String json="{\n" +
                "\"book\": {\n" +
                "\"title\": \"The Great Gatsby\",\n" +
                "\"author\": \"F. Scott Fitzgerald\",\n" +
                "\"publicationYear\": 1925,\n" +
                "\"publisher\": {\n" +
                "\"name\": \"Scribner\",\n" +
                "\"location\": \"New York\"\n" +
                "}\n" +
                "}\n" +
                "}";

        try {
            JSONObject jsonObject1=new JSONObject(json);
            JSONObject jsonObject2=jsonObject1.getJSONObject("book");
           String title= jsonObject2.getString("title");
           String author=jsonObject2.getString("author");
           int publicationYear=jsonObject2.getInt("publicationYear");

           JSONObject jsonObject3=jsonObject2.getJSONObject("publisher");
           String name=jsonObject3.getString("name");
          String location= jsonObject3.getString("location");

          publisher publisher=new publisher(name,location);
          book book=new book(title,author,publicationYear,publisher);

          binding.tvParseJson.setText(title+"\n"+author+"\n"+publicationYear+"\n"+name+"\n"+location);


        } catch (JSONException e) {
            throw new RuntimeException(e);
        }


    }
}