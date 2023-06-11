public class snackbar 
{
    
    public static void main(String[] args)
    {
        int NUM_ITEMS = 10;
        menuItem[] menu = new menuItem[NUM_ITEMS];

        for(int i = 0; i < NUM_ITEMS; i++)
        {
            menu[i] = new menuItem();
        }

        menu[0].item = "Burger";
        menu[0].price = 9.5;
        menu[1].item = "Vegan Burger";
        menu[1].price = 11;
        menu[2].item = "Hot Dog";
        menu[2].price = 5;
        menu[3].item = "Cheese Dog";
        menu[3].price = 7;
        menu[4].item = "Fries";
        menu[4].price = 5;
        menu[5].item = "Cheese Fries";
        menu[5].price = 6;
        menu[6].item = "Cold Pressed Juice";
        menu[6].price = 7;
        menu[7].item = "Cold Brew";
        menu[7].price = 3;
        menu[8].item = "Water";
        menu[8].price = 2;
        menu[9].item = "Soda";
        menu[9].price = 2;

        double priceTest = getCost("soda", menu);
        System.out.println(priceTest);
        

        
    }

    static double getCost(String item, menuItem[] menu)
    {
        int menuLength = menu.length;
        double price = 0;
        boolean available = false;

        for(int i = 0; i < menuLength; i++)
        {
            String menui = menu[i].item;
            menui = menui.toUpperCase();
            System.out.println(menui);

            item = item.toUpperCase();
            System.out.println(item);

            if(menui == item)
            {
                price = menu[i].price;
                available = true;
                break;
            }            
            //System.out.println("Item not available");
        }

        if(!available)
        {
            System.out.println("Item Not available");
        }

        return price;
    }

}

class menuItem{
    String item;
    double price;
}
