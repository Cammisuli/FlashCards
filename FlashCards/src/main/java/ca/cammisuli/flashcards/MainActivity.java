package ca.cammisuli.flashcards;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(android.R.id.content, new MainFragment())
                    .commit();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class MainFragment extends Fragment implements View.OnClickListener {

        Button create, choose;

        public MainFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_main, container, false);

            create = (Button) view.findViewById(R.id.btnCreate);
            create.setOnClickListener(this);

            choose = (Button) view.findViewById(R.id.btnChoose);
            choose.setOnClickListener(this);

            return view;
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnChoose:
                    //TODO: Open new activity - Choose
                    Toast.makeText(this.getActivity(), "Choose selected", Toast.LENGTH_SHORT).show();

                    break;
                case R.id.btnCreate:
                    //todo: open new activity - create
                    Toast.makeText(this.getActivity(), "Create selected", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(this.getActivity(), CreateActivity.class);
                    startActivity(i);

                    break;
            }
        }
    }

}
