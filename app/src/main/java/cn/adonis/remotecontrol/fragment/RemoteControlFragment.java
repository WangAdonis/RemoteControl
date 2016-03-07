package cn.adonis.remotecontrol.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

import cn.adonis.remotecontrol.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RemoteControlFragment extends Fragment {

    private TextView mSelectedTextView;
    private TextView mWorkingTextView;

    public RemoteControlFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_remote_control, container, false);
        mSelectedTextView=(TextView)v.findViewById(R.id.fragment_remote_control_selectedTextView);
        mWorkingTextView=(TextView)v.findViewById(R.id.fragment_remote_control_workingTextView);
//        Button zeroButton=(Button)v.findViewById(R.id.fragment_remote_control_zeroButton);
//        Button oneButton=(Button)v.findViewById(R.id.fragment_remote_control_oneButton);
        Button enterButton=(Button)v.findViewById(R.id.fragment_remote_control_enterButton);

        View.OnClickListener numberButtonListener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView=(TextView)v;
                String working=mWorkingTextView.getText().toString();
                String text=textView.getText().toString();
                if(working.equals("0")){
                    mWorkingTextView.setText(text);
                }else {
                    mWorkingTextView.setText(working+text);
                }
            }
        };

//        zeroButton.setOnClickListener(numberButtonListener);
//        oneButton.setOnClickListener(numberButtonListener);
        TableLayout tableLayout=(TableLayout)v.findViewById(R.id.fragment_remote_control_tableLayout);
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence working=mWorkingTextView.getText();
                if(working.length()>0){
                    mSelectedTextView.setText(working);
                }
                mWorkingTextView.setText("0");
            }
        });
        return v;
    }

}
