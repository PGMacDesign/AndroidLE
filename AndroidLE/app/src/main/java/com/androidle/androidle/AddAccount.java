package com.androidle.androidle;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import JavaLEWrapper.Empire;
import Server;
import com.google.gson.Gson;


public class AddAccount extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_account);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    public void OnLoginClick(View v){
        EditText etusername = (EditText)findViewById(R.id.username);
        String username = etusername.getText();
        EditText etpassword = (EditText)findViewById(R.id.password);
        String password = etpassword.getText();
        RadioGroup rg=(RadioGroup)findViewById(R.id.radioGroupServerSelection);
        CheckBox cbdfAccount = (CheckBox)findViewById(R.id.checkBoxMakeDefault);
        String server;
        int serverid = rg.getCheckedRadioButtonId();
        switch (serverID) {
        	case -1: server = null;
        		break;
        	case 0: server = "https://us1.lacunaexpanse.com";
        		break;
        	case 1: server = "https://pt.lacunaexpanse.com";
        		break;
        }
        
        String request = static JavaLEWrapper.Empire.Login(username, password, 1);
        Server.ServerRequest sRequest = new Sever.ServerRequest(server, Empire.url, request);
        String reply = new Server.Server().execute(sRequest);
        
        //dfAccount.
        //String radiovalue=  (RadioButton)this.findViewById(rg.getCheckedRadioButtonId()).getId();

        //AccountMan.AccountMan.AddAccount(username.getText(), password.getText());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_account, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_add_account, container, false);
            return rootView;
        }
    }
}
