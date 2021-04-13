package com.example.doquangdu.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.google.android.material.circularreveal.CircularRevealHelper;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface ProductDao {
@Insert(onConflict =  REPLACE)

  void  insertProduct (ProductEntity product);

@Update
  void  updateProduct(ProductEntity product);


@Query("SELECT * FROM Product")
  List<ProductEntity> getAllProduct();
}
