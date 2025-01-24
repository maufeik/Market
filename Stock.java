package SUper;

import java.util.Scanner;

public class Stock {

    private String[] products;
    private int[] numStock;
    private double[] prices;
    private int maxProduct;

    public void initStock() {
        maxProduct = 5;
        products = new String[maxProduct];
        numStock = new int[maxProduct];
        prices = new double[maxProduct];

        products[0] = "PlayGame";
        products[1] = "Wash Machine";
        products[2] = "Books";
        products[3] = "TV";
        products[4] = "T-Shirt";

        for (int i = 0; i < maxProduct; i++) {
            numStock[i] = 10;
        }

        prices[0] = 69.99;
        prices[1] = 598.78;
        prices[2] = 35.30;
        prices[3] = 1000.01;
        prices[4] = 23.45;
    }
    public int getMaxProducts(){
        return maxProduct;
    }

    public void showStock() {
        for (int i = 0; i < products.length; i++) {
            showElementOfStock(i, products[i], numStock[i], prices[i]);
        }
    }

    public String getProduct(int i){
        if(i<products.length)return products[i];
        else return "";
    }
    public double getPrice(int i){
        if(i<prices.length) return prices[i];
        else return -1.0;
    }
    
    public int getStock(int idx){        
        return numStock[idx];
    }
    
    public void showElementOfStock(int i, String name, int num, double price) {
        StringBuilder sb = new StringBuilder();
        sb.append(i).append("--")
                .append(name).append("--")
                .append(num).append("--")
                .append(String.format("%.2f", price));
        System.out.println(sb.toString());
    }

    public boolean sellProducts(int i, int numProduct){
        boolean res=false;
        if(i<numStock.length){
            if(numStock[i] >= numProduct){
                numStock[i]-=numProduct;
                res=true;
            }
        }
        return res;
    }
    public void fillStock(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Si quiere rellenar solo un producto escriba 0 si quiere rellenar todo escriba 1:");
        int option = teclado.nextInt();
        if(option==0){
            showStock();
            System.out.println("Ingrese el numero del producto a rellenar: ");
            int opcion = teclado.nextInt();
            numStock[opcion]=10;
        }else{
            for (int i = 0; i < products.length; i++) {
                numStock[i]=10;
            }
        }
    }
}
