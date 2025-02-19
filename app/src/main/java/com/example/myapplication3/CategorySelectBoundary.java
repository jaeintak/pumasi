package com.example.myapplication3;


import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.myapplication3.RecommendedListBoundary.Fragment1;
import com.example.myapplication3.RecommendedListBoundary.Fragment2;
import com.example.myapplication3.RecommendedListBoundary.Fragment3;
import com.example.myapplication3.RecommendedListBoundary.Fragment4;
import com.example.myapplication3.RecommendedListBoundary.Fragment5;
import com.example.myapplication3.RecommendedListBoundary.Fragment6;

public class CategorySelectBoundary extends AppCompatActivity implements View.OnClickListener{

    private final int FRAGMENT1 = 1;
    private final int FRAGMENT2 = 2;
    private final int FRAGMENT3 = 3;
    private final int FRAGMENT4 = 4;
    private final int FRAGMENT5 = 5;
    private final int FRAGMENT6 = 6;
    private final int FRAGMENT7 = 7;
    private final int FRAGMENT8 = 8;
    private final int FRAGMENT9 = 9;
    private final int FRAGMENT10 = 10;
    private final int FRAGMENT11 = 11;

    private ImageButton bt_tab1, bt_tab2, bt_tab3, bt_tab4, bt_tab5,
            bt_tab6, bt_tab7, bt_tab8, bt_tab9, bt_tab10, bt_tab11;
    ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.brandrecommend);

        // tab_button_widget
        bt_tab1 = (ImageButton)findViewById(R.id.simpleImageButton1);
        bt_tab2 = (ImageButton)findViewById(R.id.simpleImageButton2);
        bt_tab3 = (ImageButton)findViewById(R.id.simpleImageButton3);
        bt_tab4 = (ImageButton)findViewById(R.id.simpleImageButton4);
        bt_tab5 = (ImageButton)findViewById(R.id.simpleImageButton5);
        bt_tab6 = (ImageButton)findViewById(R.id.simpleImageButton6);
        /*
        bt_tab7 = (ImageButton)findViewById(R.id.simpleImageButton7);

        bt_tab8 = (ImageButton)findViewById(R.id.simpleImageButton8);
        bt_tab9 = (ImageButton)findViewById(R.id.simpleImageButton9);
        bt_tab10 = (ImageButton)findViewById(R.id.simpleImageButton10);
        bt_tab11 = (ImageButton)findViewById(R.id.simpleImageButton11);

         */

        // tab button click listenr connect
        bt_tab1.setOnClickListener(this);
        bt_tab2.setOnClickListener(this);
        bt_tab3.setOnClickListener(this);
        bt_tab4.setOnClickListener(this);
        bt_tab5.setOnClickListener(this);
        bt_tab6.setOnClickListener(this);
        /*
        bt_tab7.setOnClickListener(this);

        bt_tab8.setOnClickListener(this);
        bt_tab9.setOnClickListener(this);
        bt_tab10.setOnClickListener(this);
        bt_tab11.setOnClickListener(this);
        */

        // first view
        callFragment(FRAGMENT1);


    }
    //show (clikced category-brand)
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.simpleImageButton1 :
                // 'button1' click => call 'fragment1'
                callFragment(FRAGMENT1);
                break;

            case R.id.simpleImageButton2 :
                // 'button2' click => call 'fragment2'
                callFragment(FRAGMENT2);
                break;

            case R.id.simpleImageButton3 :
                // 'button3' click => call 'fragment3'
                callFragment(FRAGMENT3);
                break;
            case R.id.simpleImageButton4 :
                // 'button4' click => call 'fragment4'
                callFragment(FRAGMENT4);
                break;
            case R.id.simpleImageButton5 :
                // 'button5' click => call 'fragment5'
                callFragment(FRAGMENT5);
                break;
            case R.id.simpleImageButton6 :
                // 'button6' click => call 'fragment6'
                callFragment(FRAGMENT6);
                break;
/*
            case R.id.simpleImageButton7 :
                // 'button7' click => call 'fragment7'
                callFragment(FRAGMENT7);
                break;

            case R.id.simpleImageButton8 :
                // 'button8' click => call 'fragment8'
                callFragment(FRAGMENT8);
                break;

            case R.id.simpleImageButton9 :
                // 'button9' click => call 'fragment9'
                callFragment(FRAGMENT9);
                break;

            case R.id.simpleImageButton10 :
                // 'button10' click => call 'fragment10'
                callFragment(FRAGMENT10);
                break;

            case R.id.simpleImageButton11 :
                // 'button11' click => call 'fragment11'
                callFragment(FRAGMENT11);
                break;

  */

        }
    }

    private void callFragment(int frament_no){

        // fragment call define
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch (frament_no){
            case 1:
                // '?꾨옒洹몃㉫??' ?몄텧
                Fragment1 fragment1 = new Fragment1();
                transaction.replace(R.id.fragment_container, fragment1);
                transaction.commit();
                break;

            case 2:
                // '?꾨옒洹몃㉫??' ?몄텧
                Fragment2 fragment2 = new Fragment2();
                transaction.replace(R.id.fragment_container, fragment2);
                transaction.commit();
                break;

            case 3:
                // '?꾨옒洹몃㉫??' ?몄텧
                Fragment3 fragment3 = new Fragment3();
                transaction.replace(R.id.fragment_container, fragment3);
                transaction.commit();
                break;

            case 4:
                // '?꾨옒洹몃㉫??' ?몄텧
                Fragment4 fragment4 = new Fragment4();
                transaction.replace(R.id.fragment_container, fragment4);
                transaction.commit();
                break;

            case 5:
                // '?꾨옒洹몃㉫??' ?몄텧
                Fragment5 fragment5 = new Fragment5();
                transaction.replace(R.id.fragment_container, fragment5);
                transaction.commit();
                break;
            case 6:
                // '?꾨옒洹몃㉫??' ?몄텧
                Fragment6 fragment6 = new Fragment6();
                transaction.replace(R.id.fragment_container, fragment6);
                transaction.commit();
                break;
                /*
            case 7:
                // '?꾨옒洹몃㉫??' ?몄텧
                Fragment7 fragment7 = new Fragment7();
                transaction.replace(R.id.fragment_container, fragment7);
                transaction.commit();
                break;

            case 8:
                // '?꾨옒洹몃㉫??' ?몄텧
                Fragment8 fragment8 = new Fragment8();
                transaction.replace(R.id.fragment_container, fragment8);
                transaction.commit();
                break;

            case 9:
                // '?꾨옒洹몃㉫??' ?몄텧
                Fragment9 fragment9 = new Fragment9();
                transaction.replace(R.id.fragment_container, fragment9);
                transaction.commit();
                break;
            case 10:
                // '?꾨옒洹몃㉫??0' ?몄텧
                Fragment10 fragment10 = new Fragment10();
                transaction.replace(R.id.fragment_container, fragment10);
                transaction.commit();
                break;
            case 11:
                // '?꾨옒洹몃㉫??1' ?몄텧
                Fragment11 fragment11 = new Fragment11();
                transaction.replace(R.id.fragment_container, fragment11);
                transaction.commit();
                break;

                 */
        }

    }


}
