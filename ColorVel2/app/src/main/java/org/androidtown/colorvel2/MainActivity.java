package org.androidtown.colorvel2;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.TabHost;

public class MainActivity extends TabActivity {
    //TabHost mTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* TabHost 부분 */
        TabHost mTab = getTabHost(); //탭호스트 변수 생성
        TabHost.TabSpec spec;

        LayoutInflater.from(this).inflate(R.layout.activity_main, mTab.getTabContentView(), true);

        spec = mTab.newTabSpec("tab1").setIndicator("ALBUM").setContent(R.id.tab1);
        mTab.addTab(spec);

        spec = mTab.newTabSpec("tab2").setIndicator("MAP").setContent(R.id.tab2);
        mTab.addTab(spec);

        spec = mTab.newTabSpec("tab3").setIndicator("COLOR").setContent(R.id.tab3);
        mTab.addTab(spec);

    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.moreImageButton:
                Intent albumIntent = new Intent(MainActivity.this, AlbumActivity.class);
                startActivity(albumIntent);

            case R.id.openLayout:
                Intent intent = new Intent(MainActivity.this, ImageListActivity.class);
                startActivity(intent);

                break;
        }
    }

    /* 지역 선택 버튼 */
    /*public void districtButton(View v) {
        AlertDialog.Builder districtAlert = new AlertDialog.Builder(MainActivity.this);
        View districtView = getLayoutInflater().inflate(R.layout.district_dialog, null);
        districtAlert.setTitle("지역을 선택해주세요.");
        final Spinner spinner = (Spinner) districtView.findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.spinner1));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        districtAlert.setView(districtView);
        districtAlert.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (!spinner.getSelectedItem().toString().equalsIgnoreCase("도 선택")) {
                    Toast.makeText(MainActivity.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        districtAlert.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        districtAlert.show();
    }*/

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}