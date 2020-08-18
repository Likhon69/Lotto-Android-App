package com.example.lottoecommrceapp.addtocart;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "AddToCartModel")
public class AddToCartModel {
    @PrimaryKey(autoGenerate = true)
     public int id;
    @ColumnInfo(name = "articleMasterImage")
    public String articleMasterImage;
    @ColumnInfo(name = "standardPrice" )
    public int standardPrice;
    @ColumnInfo(name ="discountPrice")
    public int discountPrice;
    @ColumnInfo(name="discountRate")
    public int discountRate;
    @ColumnInfo(name = "articleTitle")
    public String articleTitle;
    @ColumnInfo(name = " articleId")
    public int articleId;
    @ColumnInfo(name = "quantity")
    public int quantity;


}
