package project.tp.whattocook;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button listOfRecipes = (Button) findViewById(R.id.search_listOfRecipes_button);
        listOfRecipes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
    //            Action_SearchToListOfRecipes(view);
            }
        });
    }

    /*public void Action_SearchToListOfRecipes(View view)
    {
        Intent intent = new Intent(getApplicationContext(), ListOfRecipes.class);
        startActivity(intent);
    }*/
}
