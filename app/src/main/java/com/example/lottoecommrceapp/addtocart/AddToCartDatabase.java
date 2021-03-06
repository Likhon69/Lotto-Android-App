package com.example.lottoecommrceapp.addtocart;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = AddToCartModel.class,version = 6,exportSchema = false)
public abstract class AddToCartDatabase extends RoomDatabase {
    public abstract AddToCartDao addToCartDao();
    private static AddToCartDatabase INSTANCE;

    public  static  AddToCartDatabase getInstance(Context context){
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context, AddToCartDatabase.class, "CartDatabase")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
}
