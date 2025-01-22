package SUper;

public class Stock {

    private String[] products;
    private int[] numStock;
    private double[] prices;

    public void initStock() {
        int maxProduct = 5;
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
    
    private void showElementOfStock(int i, String name, int num, double price) {
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
    
}
