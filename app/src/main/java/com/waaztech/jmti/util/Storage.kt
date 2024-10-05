package com.waaztech.jmti.util

import com.waaztech.jmti.model.Product
import com.waaztech.jmti.model.Seller
import com.waaztech.jmti.model.User
import com.waaztech.jmti.model.UserOrder

class Storage {

    fun saveId(id: String){
        Stash.put("userId", id)
    }

    fun saveSellerId(id: String){
        Stash.put("sellerId", id)
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
        for(product in returnAllProd()){
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

    fun getSellers(): List<Seller>{
        return try {
            Stash.getArrayList(
                "Sellers",
                Seller::class.java
            )
        } catch (e: Exception){
            emptyList()
        }
    }

    fun returnAllProd(): List<Product>{

        val data = Storage().getProducts().toMutableList()
        data.add(
            Product(
                id = "CSR Sugar",
                price = "7.80",
                text = "CSR Sugar",
                image = "https://csr-malaysia.com.my/storage/2023/08/CSR_BetterWhite_Jernih.png",
                category = "food",
                description = "Sugar"
            )
        )
        data.add(
            Product(
                id = "CSR Sugar",
                price = "7.80",
                text = "CSR Sugar",
                image = "https://www.wcrf-uk.org/wp-content/uploads/2021/06/Kiwi_A-Z-Fruit13-300x300.jpg",
                category = "food",
                description = "Sugar"
            )
        )
        data.add(
            Product(
                id = "CSR Sugar",
                price = "7.80",
                text = "CSR Sugar",
                image = "https://www.wcrf-uk.org/wp-content/uploads/2021/06/Kiwi_A-Z-Fruit13-300x300.jpg",
                category = "food",
                description = "Sugar"
            )
        )
        data.add(
            Product(
                id = "CSR Sugar",
                price = "7.80",
                text = "CSR Sugar",
                image = "https://www.wcrf-uk.org/wp-content/uploads/2021/06/Kiwi_A-Z-Fruit13-300x300.jpg",
                category = "food",
                description = "Sugar"
            )
        )
        data.add(
            Product(
                id = "CSR Sugar",
                price = "7.80",
                text = "CSR Sugar",
                image = "https://www.wcrf-uk.org/wp-content/uploads/2021/06/Kiwi_A-Z-Fruit13-300x300.jpg",
                category = "food",
                description = "Sugar"
            )
        )
        data.add(
            Product(
                id = "CSR Sugar",
                price = "7.80",
                text = "CSR Sugar",
                image = "https://www.wcrf-uk.org/wp-content/uploads/2021/06/Kiwi_A-Z-Fruit13-300x300.jpg",
                category = "food",
                description = "Sugar"
            )
        )

        return data
    }
}