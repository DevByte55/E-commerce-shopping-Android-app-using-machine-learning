package com.app.shoprecommendationsystem;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.view.View;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class AdminCategoryActivity extends AppCompatActivity {
    private ImageView tShirts, sportsTShirts, femaleDresses, sweathers;
    private ImageView glasses, hatsCaps, walletsBagsPurses, shoes;
    private ImageView headPhonesHandFree, Laptops, watches, mobilePhones;
    private ImageView foodcategorey,healthcare, household, stationery;
    private ImageView bedding,baggage,virtual,sportss;
    private ImageView bookss,notebook,calculator,schoolbag;
    private ImageView makeup,foam,personalhygiene,skincare;
    private ImageButton LogoutBtn, CheckOrdersBtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_category);

        LogoutBtn = (ImageButton) findViewById(R.id.admin_logout_btn);
        LogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(AdminCategoryActivity.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });
        CheckOrdersBtn = (ImageButton) findViewById(R.id.check_orders_btn);


        CheckOrdersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(AdminCategoryActivity.this,AdminNewOrdersActivity.class);
                startActivity(intent);
            }
        });



        tShirts = (ImageView) findViewById(R.id.t_shirts);
        sportsTShirts = (ImageView) findViewById(R.id.sports_t_shirts);
        femaleDresses = (ImageView) findViewById(R.id.female_dresses);
        sweathers = (ImageView) findViewById(R.id.sweathers);

        glasses = (ImageView) findViewById(R.id.glasses);
        hatsCaps = (ImageView) findViewById(R.id.hats_caps);
        walletsBagsPurses = (ImageView) findViewById(R.id.purses_bags_wallets);
        shoes = (ImageView) findViewById(R.id.shoes);

        headPhonesHandFree = (ImageView) findViewById(R.id.headphones_handfree);
        Laptops = (ImageView) findViewById(R.id.laptop_pc);
        watches = (ImageView) findViewById(R.id.watches);
        mobilePhones = (ImageView) findViewById(R.id.mobilephones);

        foodcategorey = (ImageView) findViewById(R.id.food_categorey);
        healthcare = (ImageView) findViewById(R.id.healthcare);
        household = (ImageView) findViewById(R.id.household);
        stationery = (ImageView) findViewById(R.id.stationery);

        bedding = (ImageView) findViewById(R.id.bedding);
        baggage = (ImageView) findViewById(R.id.baggage);
        virtual = (ImageView) findViewById(R.id.virtual);
        sportss = (ImageView) findViewById(R.id.sportss);

        bookss = (ImageView) findViewById(R.id.bookss);
        notebook = (ImageView) findViewById(R.id.notebook);
        calculator = (ImageView) findViewById(R.id.calculator);
        schoolbag = (ImageView) findViewById(R.id.schoolbag);

        makeup = (ImageView) findViewById(R.id.makeup);
        foam = (ImageView) findViewById(R.id.foam);
        personalhygiene = (ImageView) findViewById(R.id.personalhygiene);
        skincare = (ImageView) findViewById(R.id.skincare);




        tShirts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, com.app.shoprecommendationsystem.AdminAddNewProductActivity.class);
                intent.putExtra("category", "tShirts");
                startActivity(intent);
            }
        });
        sportsTShirts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, com.app.shoprecommendationsystem.AdminAddNewProductActivity.class);
                intent.putExtra("category", "Sports tShirts");
                startActivity(intent);
            }
        });


        femaleDresses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, com.app.shoprecommendationsystem.AdminAddNewProductActivity.class);
                intent.putExtra("category", "Female Dresses");
                startActivity(intent);
            }
        });


        sweathers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, com.app.shoprecommendationsystem.AdminAddNewProductActivity.class);
                intent.putExtra("category", "Sweathers");
                startActivity(intent);
            }
        });


        glasses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, com.app.shoprecommendationsystem.AdminAddNewProductActivity.class);
                intent.putExtra("category", "Glasses");
                startActivity(intent);
            }
        });


        hatsCaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, com.app.shoprecommendationsystem.AdminAddNewProductActivity.class);
                intent.putExtra("category", "Hats Caps");
                startActivity(intent);
            }
        });



        walletsBagsPurses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, com.app.shoprecommendationsystem.AdminAddNewProductActivity.class);
                intent.putExtra("category", "Wallets Bags Purses");
                startActivity(intent);
            }
        });


        shoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, com.app.shoprecommendationsystem.AdminAddNewProductActivity.class);
                intent.putExtra("category", "Shoes");
                startActivity(intent);
            }
        });



        headPhonesHandFree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, com.app.shoprecommendationsystem.AdminAddNewProductActivity.class);
                intent.putExtra("category", "HeadPhones HandFree");
                startActivity(intent);
            }
        });


        Laptops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, com.app.shoprecommendationsystem.AdminAddNewProductActivity.class);
                intent.putExtra("category", "Laptops");
                startActivity(intent);
            }
        });


        watches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, com.app.shoprecommendationsystem.AdminAddNewProductActivity.class);
                intent.putExtra("category", "Watches");
                startActivity(intent);
            }
        });


        mobilePhones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, com.app.shoprecommendationsystem.AdminAddNewProductActivity.class);
                intent.putExtra("category", "Mobile Phones");
                startActivity(intent);
            }
        });

        foodcategorey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, com.app.shoprecommendationsystem.AdminAddNewProductActivity.class);
                intent.putExtra("category", "food_categorey");
                startActivity(intent);
            }
        });

        healthcare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, com.app.shoprecommendationsystem.AdminAddNewProductActivity.class);
                intent.putExtra("category", "healthcare");
                startActivity(intent);
            }
        });

        household.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, com.app.shoprecommendationsystem.AdminAddNewProductActivity.class);
                intent.putExtra("category", "household");
                startActivity(intent);
            }
        });

        stationery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, com.app.shoprecommendationsystem.AdminAddNewProductActivity.class);
                intent.putExtra("category", "stationery");
                startActivity(intent);
            }
        });

        bedding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, com.app.shoprecommendationsystem.AdminAddNewProductActivity.class);
                intent.putExtra("category", "bedding");
                startActivity(intent);
            }
        });

        baggage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, com.app.shoprecommendationsystem.AdminAddNewProductActivity.class);
                intent.putExtra("category", "baggage");
                startActivity(intent);
            }
        });

        virtual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, com.app.shoprecommendationsystem.AdminAddNewProductActivity.class);
                intent.putExtra("category", "virtual");
                startActivity(intent);
            }
        });

        sportss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, com.app.shoprecommendationsystem.AdminAddNewProductActivity.class);
                intent.putExtra("category", "sportss");
                startActivity(intent);
            }
        });

        bookss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, com.app.shoprecommendationsystem.AdminAddNewProductActivity.class);
                intent.putExtra("category", "bookss");
                startActivity(intent);
            }
        });

        notebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, com.app.shoprecommendationsystem.AdminAddNewProductActivity.class);
                intent.putExtra("category", "notebook");
                startActivity(intent);
            }
        });

        calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, com.app.shoprecommendationsystem.AdminAddNewProductActivity.class);
                intent.putExtra("category", "calculator");
                startActivity(intent);
            }
        });

        schoolbag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, com.app.shoprecommendationsystem.AdminAddNewProductActivity.class);
                intent.putExtra("category", "schoolbag");
                startActivity(intent);
            }
        });

        makeup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, com.app.shoprecommendationsystem.AdminAddNewProductActivity.class);
                intent.putExtra("category", "makeup");
                startActivity(intent);
            }
        });

        foam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, com.app.shoprecommendationsystem.AdminAddNewProductActivity.class);
                intent.putExtra("category", "foam");
                startActivity(intent);
            }
        });

        personalhygiene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, com.app.shoprecommendationsystem.AdminAddNewProductActivity.class);
                intent.putExtra("category", "personalhygiene");
                startActivity(intent);
            }
        });

        skincare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, com.app.shoprecommendationsystem.AdminAddNewProductActivity.class);
                intent.putExtra("category", "skincare");
                startActivity(intent);
            }
        });
    }

}
