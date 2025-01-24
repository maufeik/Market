package SUper;

public class shopCart {

    private int maxCart;
    private String[] product;
    private int[] numProd;
    private double[] price;
    private int contProduct;
    
    public shopCart(int maxCart){
        this.maxCart=maxCart;
        product = new String[maxCart];
        numProd= new int[maxCart];
        price = new double[maxCart];
        contProduct=0;
    }
    public boolean addElement(String product, int numProd, double price){
        boolean res= false;
        if(contProduct<maxCart){
            this.product[contProduct]=product;
            this.numProd[contProduct]=numProd;
            this.price[contProduct]=price;
            contProduct++;
            res=true;
        }
        return res;
    }
    public void buy(){
        showCart();
        System.out.println("TOTAL");
        double total=0.0;
        for (int i = 0; i < contProduct; i++) {
            total+=(numProd[i]*price[i]);
        }        
        System.out.println(String.format("%.2f", total));
        contProduct=0;
    }
    public void showCart(){
        for (int i = 0; i < contProduct; i++) {
            showElementOfStock(i, product[i], numProd[i], price[i]);
        }
    }
    private void showElementOfStock(int i, String name, int num, double price) {
        StringBuilder sb = new StringBuilder();
        sb.append(i).append("--")
                .append(name).append("--")
                .append(num).append("--")
                .append(String.format("%.2f", price*num));
        System.out.println(sb.toString());
    }
}
