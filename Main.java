import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("1 - Ürün Ekle");
            System.out.println("2 - Ürün Çıkar");
            System.out.println("3 - Sepeti Görüntüle");
            System.out.println("4 - Ödeme Yap");
            System.out.println("0 - Çıkış");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Boşluğu temizle

            switch (choice) {
                case 0:
                    running = false;
                    break;
                case 1:
                    System.out.println("Ürün Adı: ");
                    String productName = scanner.nextLine();
                    System.out.println("Ürün Fiyatı: ");
                    double productPrice = scanner.nextDouble();
                    scanner.nextLine(); // Boşluğu temizle
                    Product product = new Product(productName, productPrice);
                    cart.addProduct(product);
                    break;
                case 2:
                    System.out.println("Çıkarılacak Ürün Adı: ");
                    String removedProductName = scanner.nextLine();
                    for (Product p : cart.getProducts()) {
                        if (p.getName().equals(removedProductName)) {
                            cart.removeProduct(p);
                            break;
                        }
                    }
                    break;
                case 3:
                    cart.printInvoice();
                    break;
                case 4:

                    cart.printInvoice();
                    System.out.println("Ödeme gerçekleştirildi.");
                    running = false;
                    break;
                default:
                    System.out.println("Geçersiz seçenek. Tekrar deneyin.");
            }
        }
    }
}