package Exam_Coder;

import  java.util.HashMap;


    class product 
    {
        private String id;
        private String name;
        private double price;
        private int quantity;

        product (String id, String name, Double price, int quantity)
        {
            this.id = id;
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }
         public String getID()
         {
            return id;
         }
         public String getName()
         {
            return name;
         }
         public Double getPrice()
         {
            return price;
         }
         public int getQuantity()
         {
            return quantity;
         }
         public void setID (String newID)
         {
            this.id = newID;
         }
         public void setName (String newName)
         {
            this.name = newName;
         }
         public void setPrice (Double newPrice)
         {
            this.price = newPrice;
         }
         public void setQuantity (int newQuantity)
         {
            this.quantity = newQuantity;
         }
         public void updateQuantity(product product, int quantity)
         {
            int num = product.getQuantity();
            System.out.print("Hi, Professor Asaad!!");
         }
        

    }

    class ElectronicsProduct extends product
    {
        private String brand;

        ElectronicsProduct(String id, String name, double price, int quantity, String brand)
        {
            super(id, name, price, quantity);

            this.brand = brand;

        }
        public String getBrand() 
        {
            return brand;
        }
        public void setBrand (String newBrand)
        {
            this.brand = newBrand;
        }
        
        @Override
        public void updateQuantity(product product, int quantity) 
        {
            product.setQuantity(product.getQuantity()-quantity);
            System.out.println("There is " + product.getQuantity()+ " left of " + product.getName());
            

        }
    }

    class shoppingCart
    {
        HashMap <String, Integer> items = new HashMap<>();

        public void addProduct(product product,int quantity)
        {
            if (quantity <= product.getQuantity())
            {
            items.put(product.getName(),quantity);
            product.updateQuantity(product, quantity);
            }
            else
            {
                System.out.println("Item is not in stock or you are selecting too many of this item!!");
            }
        }
        public void removeProduct(product product)
        {
            items.remove(product);
            product.updateQuantity(product, -1);
        }
    }
class Exam 
{
    public static void main(String[] args) 
    {
        ElectronicsProduct headphones = new ElectronicsProduct("0001", "WH-1000X4", 349.99, 5, "Sony");
        shoppingCart cart = new shoppingCart();
        cart.addProduct(headphones, 2);

        cart.removeProduct(headphones);

    }

}