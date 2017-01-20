package harsh.com.task_6;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView tv;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        tv = (TextView) findViewById(R.id.tv);
        iv = (ImageView) findViewById(R.id.iv);

        if (findViewById(R.id.fl) != null) {

            if (savedInstanceState != null) {
                return;
            }

            HFragment firstFragment = new HFragment();

            firstFragment.setArguments(getIntent().getExtras());

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fl, firstFragment).commit();

            tv.setVisibility(View.VISIBLE);
            iv.setVisibility(View.INVISIBLE);
        }

        final HFragment newFragment = new HFragment();
        /*Bundle args = new Bundle();
        args.putInt(HFragment.ARG_POSITION, position);
        newFragment.setArguments(args);*/

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                transaction.replace(R.id.fl, newFragment);
                //transaction.addToBackStack(null);

                transaction.commit();

                newFragment.setArguments(getIntent().getExtras());

                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fl, newFragment).commit();

                tv.setVisibility(View.INVISIBLE);
                iv.setVisibility(View.VISIBLE);
            }
        });

    }
}
