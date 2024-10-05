package com.waaztech.jmti.util

import com.waaztech.jmti.model.Product
import com.waaztech.jmti.model.Seller
import com.waaztech.jmti.model.User
import com.waaztech.jmti.model.UserOrder

class Storage {

    fun saveId(id: String){
        Stash.put("userId", id)
    }

    fun getId(): String{
        return Stash.getString("userId", "")
    }

    fun saveBuyerOrder(userOrderList: List<UserOrder>){
        Stash.put("buyerOrder", userOrderList)
    }

    fun getBuyerOrder(): List<UserOrder>{
        return Stash.getArrayList(
            "buyerOrder",
            UserOrder::class.java
        )
    }

    fun saveProducts(productList: List<Product>){
        Stash.put("Products", productList)
    }

    fun getProducts(): List<Product>{
        return Stash.getArrayList(
            "Products",
            Product::class.java
        )
    }

    fun getSingleProduct(id: String): Product?{
        for(product in getProducts()){
            if(product.id == id){
                return product
            }
        }
        return null
    }

    fun saveUsers(users: List<User>){
        Stash.put("Users", users)
    }

    fun getUsers(): List<User>{
        return try {
            Stash.getArrayList(
                "Users",
                User::class.java
            )
        } catch (e: Exception){
            emptyList()
        }
    }

    fun getSpecificUser(id: String): User{
        for(user in getUsers()){
            if(user.email == id){
                return user
            }
        }

        return User("","","","")
    }

    fun saveSellers(sellers: List<Seller>){
        Stash.put("Sellers", sellers)
    }

    fun getSellers(): List<User>{
        return try {
            Stash.getArrayList(
                "Sellers",
                Seller::class.java
            )
        } catch (e: Exception){
            emptyList()
        }
    }
}