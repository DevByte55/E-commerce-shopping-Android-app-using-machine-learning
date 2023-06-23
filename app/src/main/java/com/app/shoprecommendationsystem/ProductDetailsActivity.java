package com.app.shoprecommendationsystem;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.app.shoprecommendationsystem.Model.Products;
import com.app.shoprecommendationsystem.Prevalent.Prevalent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.tensorflow.lite.support.image.TensorImage;
import org.tensorflow.lite.support.label.Category;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class ProductDetailsActivity<productImage> extends AppCompatActivity {
    private Button addToCartButton;
    private ImageView productImage;

   private Button productaddress,btnfeedback;
    private ElegantNumberButton numberButton;
    private TextView productPrice,productDescription,productName,feedback_textview;
    private String productID="", state = "Normal";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        productID = getIntent().getStringExtra("pid");
        addToCartButton = (Button) findViewById(R.id.pd_add_to_cart_button);
        numberButton = (ElegantNumberButton) findViewById(R.id.number_btn);
        productImage = (ImageView) findViewById(R.id.product_image_details);
        productName = (TextView) findViewById(R.id.product_name_details);
        productDescription = (TextView) findViewById(R.id.product_description_details);
        productPrice = (TextView) findViewById(R.id.product_price_details);
        productaddress = (Button) findViewById(R.id.product_address);
        btnfeedback = (Button) findViewById(R.id.btn_feedback);
        feedback_textview = (TextView) findViewById(R.id.feedback_textview);

        getProductDetails(productID);





        // Get a reference to the Firebase Realtime Database
        FirebaseDatabase database = FirebaseDatabase.getInstance();







// Get a reference to the Firebase Realtime Database
        //FirebaseDatabase database = FirebaseDatabase.getInstance();

// Get a reference to the "products" node
        DatabaseReference productsRef = database.getReference("Products");

// Add a new product to the database
        String newProductId = productsRef.push().getKey();
        Products newProduct = new Products("Product Name", "Product Description", "Product Price", "Product Image URL", "Product Category", newProductId, "Product Date", "Product Time", "Product Address");
        productsRef.child(newProductId).setValue(newProduct);

// Set a listener to retrieve the product data from the database
        productsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // Loop through all products in the database
                for (DataSnapshot productSnapshot : snapshot.getChildren()) {
                    // Get the product ID
                    String pid = productSnapshot.getKey();

                    // Get the product's "address" value
                    String address = productSnapshot.child("address").getValue(String.class);

                    // Set the address as the button text
                    productaddress.setText(address);

                    // Set a click listener for the "productaddress" button
                    productaddress.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (TextUtils.isEmpty(address)) {
                                // Handle empty or null address here
                                return;
                            }
                            try {
                                String currentLocation = "";
                                String destinationLocation = address;
                                Uri uri = Uri.parse("https://www.google.co.in/maps/dir/?api=1&origin=" + currentLocation + "&destination=" + destinationLocation);
                                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                intent.setPackage("com.google.android.apps.maps");
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                            } catch (ActivityNotFoundException e) {
                                Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps");
                                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                intent.setPackage("com.google.android.apps.maps");
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                            }
                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle errors here
            }
        });








        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (state.equals("Order Placed") || state.equals("Order Shipped")) {
                    Toast.makeText(ProductDetailsActivity.this, "You can add Purchase more product, once your order is shipped or confirmed", Toast.LENGTH_LONG).show();
                } else {
                    addingToCartList();
                }
            }
        });
    }






    @Override
    protected void onStart() {
        super.onStart();
        CheckOrderState();
    }

    private void addingToCartList() {
        String saveCurrentTime,saveCurrentDate;
        Calendar calForDate = Calendar.getInstance();
        SimpleDateFormat currentDate = new SimpleDateFormat("MMM dd. yyy");
        saveCurrentDate = currentDate.format(calForDate.getTime());
        SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss a");
        saveCurrentTime = currentDate.format(calForDate.getTime());
        final DatabaseReference cartListRef = FirebaseDatabase.getInstance().getReference().child("Cart List");
        final HashMap<String, Object>cartMap = new HashMap<>();
        cartMap.put("pid",productID);
        cartMap.put("pname",productName.getText().toString());
        cartMap.put("price",productPrice.getText().toString());
        cartMap.put("date",saveCurrentDate);
        cartMap.put("time",saveCurrentTime);
        cartMap.put("quantity",numberButton.getNumber());
        cartMap.put("location",productaddress.getText().toString());
        cartMap.put("discount","");

        cartListRef.child("User view").child(Prevalent.currentOnlineUser.getPhone()).child("Products").child(productID).updateChildren(cartMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    cartListRef.child("Admin view").child(Prevalent.currentOnlineUser.getPhone())
                            .child("Products").child(productID)
                            .updateChildren(cartMap)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){
                                        Toast.makeText(ProductDetailsActivity.this,"Added to cart List",Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(ProductDetailsActivity.this,HomeActivity.class);
                                        startActivity(intent);
                                    }
                                }
                            });
                }
            }
        });








    }

    private void getProductDetails(String productID) {
        DatabaseReference productsRef = FirebaseDatabase.getInstance().getReference().child("Products");
        productsRef.child(productID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    Products products=dataSnapshot.getValue(Products.class);
                    productName.setText(products.getPname());
                    productPrice.setText(products.getPrice());
                    productDescription.setText(products.getDescription());
                    productaddress.setText(products.getAddress());
                    Picasso.get().load(products.getImage()).into(productImage);

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }



    private void CheckOrderState() {
        DatabaseReference ordersRef;
        ordersRef = FirebaseDatabase.getInstance().getReference().child("Orders").child(Prevalent.currentOnlineUser.getPhone());
        ordersRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    String shippingState = dataSnapshot.child("state").getValue().toString();
                    if (shippingState.equals("Shipped")) {
                        state = "Order Shipped";
                    } else if (shippingState.equals("Not Shipped")) {
                        state = "Order Placed";
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        btnfeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(ProductDetailsActivity.this, FeedbackActivity.class);

                startActivity(intent);
                finish();
            }
        });





    }
}



