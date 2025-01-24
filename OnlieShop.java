
package SUper;

import java.util.Scanner;

public class OnlieShop {

    private Stock stock;
    private shopCart cart;

    public static void main(String[] args) {
        OnlieShop os = new OnlieShop();
        os.run();
    }

    public OnlieShop() {

        stock = new Stock();
        stock.initStock();
        cart = new shopCart(3);
    }

    public void run() {
        boolean exit=false;
        do {
            switch (showSelectMenu()) {
                case 0:
                    System.out.println("End program");
                    exit=true;
                    break;
                case 1:
                    System.out.println("-----Product Stock-----");
                    stock.showStock();
                    
                    break;
                case 2:
                    System.out.println("-----Select product-----");
                    selectProducstToCart();
                    break;
                case 3:
                    System.out.println("-----My Cart-----");
                    cart.showCart();
                    break;
                case 4:
                    System.out.println("-----Buy-----");
                    cart.buy();
                    break;
                case 5:
                    System.out.println("-----Fill Stock-----");
                    stock.fillStock();
                    break;
                default:
                    System.out.println("Invalid option!! Please enter 0-5");
                    break;
            }
        } while (!exit);
    }
    
    public int showSelectMenu(){
        int option=-1;
        Scanner teclado = new Scanner(System.in);
        String [] options = {"Exit","Show stock","Add product to cart","Show cart","Buy","Fill stock"};
        for (int i = 0; i < options.length; i++) {
            System.out.println(i+" "+options[i]);            
        }
        return option=teclado.nextInt();
    }
    public void selectProducstToCart(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Plese tell us the product");
        int prodId = teclado.nextInt();
        
        if(prodId>=0&&prodId<stock.getMaxProducts()){
            //product in stock ok
            if(stock.getStock(prodId)>0){
                String product = stock.getProduct(prodId);
                int numStock = stock.getStock(prodId);
                double price = stock.getPrice(prodId);
                stock.showElementOfStock(prodId, product, numStock, price);
                System.out.println("Please tell us how many units you want");
                int numProduc = teclado.nextInt();
                
                if(stock.sellProducts(prodId, numProduc)){
                    //Can add to cart
                    if(cart.addElement(product, numProduc, price)){
                    System.out.println("Product added succesfully");
                    }
                    else{
                        System.out.println("Your cart is full, please finish your purchase");
                    }
                }else System.out.println("Not enought stock ...");
            }else{
                System.out.println("Product out stock");
            }
        }else{
            System.out.println("This product out stock");
        }
    }
}
