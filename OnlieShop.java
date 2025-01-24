
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
        
        stock.showStock();
        cart.showCart();
    }
    
    public int showSelectMenu(){
        int option;
        Scanner teclado = new Scanner(System.in);
        String [] options = {"Exit","Show stock","Add product to cart","Show cart","Buy","Fill stock"};
        for (int i = 0; i < options.length; i++) {
            System.out.println(i+" "+options[i]);            
        }
        return option=teclado.nextInt();
    }
}
