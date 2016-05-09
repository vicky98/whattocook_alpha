package project.tp.whattocook;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Home extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                Toast.makeText(Home.this, "Email: whattocookAlpha@gmail.com", Toast.LENGTH_LONG).show();
                //        .setAction("Action", null).show();
            }

        });

        Button login_button = (Button) findViewById(R.id.home_login_button);
        login_button.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                Action_Login(view);
            }

        });

        Button signup_button = (Button) findViewById(R.id.home_signup_button);
        signup_button.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                Action_Signup(view);
            }

        });
    }

    //@Override
    public void Action_Login (View view)
    {
        Intent intent = new Intent(getApplicationContext(), Login.class);
        startActivity(intent);
    }

    //@Override
    public void Action_Signup (View view)
    {
        Intent intent = new Intent(getApplicationContext(), Signup.class);
        startActivity(intent);
    }
}
