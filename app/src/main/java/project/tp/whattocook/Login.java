package project.tp.whattocook;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final EditText etUsername = (EditText) findViewById(R.id.username_login);
        final EditText etPassword = (EditText) findViewById(R.id.password_login);
        final Button bLogin = (Button) findViewById(R.id.login_login_button);

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String username = etUsername.getText().toString();
                final String password = etPassword.getText().toString();

                // Response received from the server
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if (success) {
                            //    String  = jsonResponse.getString("name");

                                Intent intent = new Intent(Login.this, User.class);
                                intent.putExtra("password", password);
                                intent.putExtra("username", username);
                                Login.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                                builder.setMessage("Login Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                LoginRequest loginRequest = new LoginRequest(username, password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Login.this);
                queue.add(loginRequest);
                Action_Forward(view);
            }
        });

        Button forgottenPassword = (Button) findViewById(R.id.login_forgotten_password);
        forgottenPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
