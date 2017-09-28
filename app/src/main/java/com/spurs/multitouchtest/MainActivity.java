package com.spurs.multitouchtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RelativeLayout layout;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout=(RelativeLayout)findViewById(R.id.layout);
        tv=(TextView)findViewById(R.id.tv);

        layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                //터치 이벤트를 발생시키는 포인터의 개수
                int cnt=event.getPointerCount();

                StringBuffer buffer=new StringBuffer();

                for(int i=0; i<cnt; i++){
                    int id=event.getPointerId(i);
                    int index=event.getActionIndex();
                    int action=event.getActionMasked();
                    int x=(int)event.getX(i);
                    int y=(int)event.getY(i);

                    buffer.append("id:"+id+", index"+index+", action"+action+", x:"+x+", y:"+y);
                    buffer.append("\n\n");
                }
                tv.setText(buffer.toString());


                //int action=event.getActionMasked();
/*                switch (action){
                    case MotionEvent.ACTION_DOWN:
                        tv.setText("down");
                        break;

                    case MotionEvent.ACTION_UP:
                        tv.setText("up");
                        break;

                    case MotionEvent.ACTION_MOVE:
                        tv.setText("move");
                        break;

                    case MotionEvent.ACTION_POINTER_DOWN:
                        tv.setText("pointer down");
                        break;

                    case MotionEvent.ACTION_POINTER_UP:
                        tv.setText("pointer up");
                        break;
                }*/

                return true;
            }
        });
    }
}
