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
    
}
