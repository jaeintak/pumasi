package com.example.myapplication3.Login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication3.Entity.Brand;
import com.example.myapplication3.Entity.Category;
import com.example.myapplication3.Entity.ShoppingMall;
import com.example.myapplication3.Entity.SpotsInMall;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.util.Listener;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class LoadingActivity extends Activity {//앱을 실행했을 때의 로딩화면
    private FirebaseFirestore db;
    private ArrayList<ShoppingMall> mallList;//서비스를 제공하는 쇼핑몰의 리스트
    private ShoppingMall mall;
    private Category category;
    private ArrayList<Category> catList;
    private Integer check;
    private SpotsInMall spot;
    private Brand brand;
    private ArrayList<Brand> brandList;
    private ArrayList<SpotsInMall> spotList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("스플레시 화면 클래스 접근");
        mallList = new ArrayList<>();//리스트 초기화
        catList= new ArrayList<>();
        spotList = new ArrayList<>();
        brandList = new ArrayList<>();
        try{//몇 초동안 로딩화면 띄워지는지 설정
            db = FirebaseFirestore.getInstance();
            FirebaseFirestore db2 = FirebaseFirestore.getInstance();
            check=1;

            //쇼핑몰 클래스 생성
            mall = new ShoppingMall();
            mall.setMName("pajuPremiumOutlet");
            mall.setMNumber("M1");

            //카테고리 클래스 생성
            category = new Category();
            category.setCNr("c1");
            category.setCName("해외명품");
            category.setInMall(mall);
            mall.setCategoryLIst(category);

            category = new Category();
            category.setCNr("c2");
            category.setCName("컨템포러리");
            category.setInMall(mall);
            mall.setCategoryLIst(category);

            category = new Category();
            category.setCNr("c3");
            category.setCName("여성의류");
            category.setInMall(mall);
            mall.setCategoryLIst(category);

            category = new Category();
            category.setCNr("c4");
            category.setCName("남성의류");
            category.setInMall(mall);
            mall.setCategoryLIst(category);

            category = new Category();
            category.setCNr("c5");
            category.setCName("진/캐쥬얼/SPA");
            category.setInMall(mall);
            mall.setCategoryLIst(category);

            category = new Category();
            category.setCNr("c6");
            category.setCName("슈즈/핸드백");
            category.setInMall(mall);
            mall.setCategoryLIst(category);

            category = new Category();
            category.setCNr("c7");
            category.setCName("스포츠/골프/아웃도어");
            category.setInMall(mall);
            mall.setCategoryLIst(category);

            category = new Category();
            category.setCNr("c8");
            category.setCName("잡화");
            category.setInMall(mall);
            mall.setCategoryLIst(category);

            category = new Category();
            category.setCNr("c9");
            category.setCName("아동");
            category.setInMall(mall);
            mall.setCategoryLIst(category);

            category = new Category();
            category.setCNr("c10");
            category.setCName("생활");
            category.setInMall(mall);
            mall.setCategoryLIst(category);

            category = new Category();
            category.setCNr("c11");
            category.setCName("기타");
            category.setInMall(mall);
            mall.setCategoryLIst(category);

            category = new Category();
            category.setCNr("c12");
            category.setCName("에스컬레이터밑엘리베이터");
            category.setInMall(mall);
            mall.setCategoryLIst(category);

            category = new Category();
            category.setCNr("c13");
            category.setCName("음식");
            category.setInMall(mall);
            mall.setCategoryLIst(category);
           // System.out.println(mall.getCategoryList().get(12).getCName());
            //디비 정보 읽고 shoppingMall, Category,Brand 클래스 생성
            System.out.println("before");
           readMall(new MyCallback() {
               @Override
               public void onCallback(ArrayList<SpotsInMall> spotList, ArrayList<Brand> brandList) {
                   //System.out.println("긑");
                   //System.out.println(brandList.get(0).getSpotName());
               }
           });



        Thread.sleep(2000);
            System.out.println("로딩 화면 띄워지는 시간");

        } catch (InterruptedException e) {//로딩 실패했을 때
            e.printStackTrace();
            Toast.makeText(this,"앱을 실행할 수 없습니다.",Toast.LENGTH_LONG).show();
        }
        startActivity(new Intent(this,MainActivity.class));//로그인 화면으로 전환
        finish();

    }


   public void readMall(final MyCallback mycall) {//쇼핑몰 찾아서 클래스 생성 후, 쇼핑몰 리스트에 추가
       for (Integer i = 0; i < mall.getCategoryList().size(); i++) {
           final Integer finalI = i;

           db.collection("shoppingMall").document("M1").collection("category").document(mall.getCategoryList().get(i).getCNr()).collection("brand")
                   .get()
                   .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                       @Override
                       public void onComplete(@NonNull Task<QuerySnapshot> task) {
                           if (task.isSuccessful()) {
                               for (QueryDocumentSnapshot document : task.getResult()) {
                                   // Log.d(TAG, document.getId() + " => " + document.getData().get("bName").toString());
                                   // System.out.println(mall.getCategoryList().get(finalI).getCNr());
                                   if (mall.getCategoryList().get(finalI).getCName().equals("음식") || mall.getCategoryList().get(finalI).getCName().equals("에스컬레이터및엘리베이터")) {
                                       spot = new SpotsInMall();
                                       spot.setSpotNr(document.getId());
                                       spot.setSpotName(document.getData().get("bName").toString());
                                       spot.setInCategory(mall.getCategoryList().get(finalI));
                                       spot.setSpotFloor(Integer.parseInt(document.getData().get("floor").toString()));
                                       spot.setSpotType(mall.getCategoryList().get(finalI).getCName());
                                       spot.setSpotLocation(Integer.parseInt(document.getData().get("x").toString()), Integer.parseInt(document.getData().get("y").toString()));
                                       spotList.add(spot);
                                       System.out.println(spot.getSpotName());

                                   } else {//일반 브랜드인 경우
                                       brand = new Brand();
                                       brand.setSpotNr(document.getId());
                                       brand.setSpotName(document.getData().get("bName").toString());
                                       brand.setInCategory(mall.getCategoryList().get(finalI));
                                       brand.setSpotFloor(Integer.parseInt(document.getData().get("floor").toString()));
                                       brand.setSpotType(mall.getCategoryList().get(finalI).getCName());
                                       brand.setSpotLocation(Integer.parseInt(document.getData().get("x").toString()), Integer.parseInt(document.getData().get("y").toString()));
                                       brand.setPriceLevel(document.getData().get("priceLevel").toString());
                                       brandList.add(brand);
                                       System.out.println(brand.getSpotName());
                                   }

                               }
                               mycall.onCallback(spotList,brandList);
                           } else {
                               Log.d(TAG, "Error getting documents: ", task.getException());
                           }
                       }
                   });;
       }
   }
  public interface MyCallback {
      void onCallback(ArrayList<SpotsInMall> spotList,ArrayList<Brand> brandList);
  }

}


