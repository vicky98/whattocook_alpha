package project.tp.whattocook;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button login = (Button) findViewById(R.id.login_login_button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Action_Forward(view);
            }
        });

        Button forgottenPassword = (Button) findViewById(R.id.login_forgotten_password);
        forgottenPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Action_LoginToForgottenPassword(view);
            }
        });
    }

    //@Override
    public void Action_Forward (View view)
    {
        Intent intent = new Intent(getApplicationContext(), RecipeOfTheDay.class);
        startActivity(intent);
    }

    public void Action_LoginToForgottenPassword (View view)
    {
        Intent intent = new Intent(getApplicationContext(), ForgottenPassword.class);
        startActivity(intent);
    }
}
