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

    fun getSellerId(): String{
        return Stash.getString("sellerId", "")
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

    fun getSpecificSeller(id: String): Seller{
        for(user in getSellers()){
            if(user.email == id){
                return user
            }
        }

        return Seller("","","","", "", "")
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
                id = "Chocolate Cake",
                price = "89.90",
                text = "Chocolate Cake",
                image = "https://sprinkles.com/cdn/shop/products/DarkChocolate_Whole8-inchLayerCake_Shopify1024x1024.png?v=1620409691",
                category = "food",
                description = "Cake!"
            )
        )
        data.add(
            Product(
                id = "Rubber Duck",
                price = "3.20",
                text = "Rubber Duck",
                image = "https://www.ft.com/__origami/service/image/v2/images/raw/https%3A%2F%2Fwww.ft.com%2F__origami%2Fservice%2Fimage%2Fv2%2Fimages%2Fraw%2Fhttps%253A%252F%252Fd1e00ek4ebabms.cloudfront.net%252Fproduction%252F71611bc2-1cd9-484d-9a64-5fa70091c4e8.png%3Fsource%3Dnext-article%26fit%3Dscale-down%26quality%3Dhighest%26width%3D700%26dpr%3D1?source=next-opengraph&fit=scale-down&width=900",
                category = "toy",
                description = "Rubber Duck"
            )
        )
        data.add(
            Product(
                id = "Formal Shoe",
                price = "67.90",
                text = "Shoe",
                image = "https://p3.aprimocdn.net/ecco/b5e6f5c4-4aec-46a4-9c99-b08b00bb1b59/520314-01001-m_eCom.png?auto=webp&width=960&quality=95ng",
                category = "fashion",
                description = "Dark Formal Shoe"
            )
        )
        data.add(
            Product(
                id = "Jersey",
                price = "16.50",
                text = "Jersey",
                image = "https://www.spized.com/media/30/1a/2b/1639578261/esports-trikot2-min.png",
                category = "fashion",
                description = "Jersey"
            )
        )

        return data
    }
}