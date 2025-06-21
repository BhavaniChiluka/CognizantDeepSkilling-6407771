import java.util.Arrays;
import java.util.Comparator;

public class SearchDemo {

    //Linear search by product name
    public static Product linearSearch(Product[] products, String name) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    //Binary search by product name (assume it is a sorted array)
    public static Product binarySearch(Product[] products, String name) {
        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(name);

            if (cmp == 0)
                return products[mid];
            else if (cmp < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shoes", "Fashion"),
            new Product(103, "Watch", "Accessories"),
            new Product(104, "Phone", "Electronics"),
            new Product(105, "Bag", "Travel")
        };

        //Linear Search
        System.out.println("Linear Search Result:");
        //searching for "Phone"
        Product found1 = linearSearch(products, "Phone");
        if (found1 != null) found1.display();
        else System.out.println("Product not found.");

        //Sorting array for binary search
        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));

        //Binary Search
        System.out.println("Binary Search Result:");
        //searching for "Phone"
        Product found2 = binarySearch(products, "Phone");
        if (found2 != null) found2.display();
        else System.out.println("Product not found.");
    }
}

//analysis:
// Linear Search checks each product one by one until it finds a match, it is simple but slow for large datasets. its time complexity is O(n).
//Binary search is fast and best for larger datasets, but requires the array to be sorted. Its time complexity is O(log n).
//It is recommended to use binary search for larger datasets where the array is sorted, as it significantly reduces the number of comparisons needed to find an item.

