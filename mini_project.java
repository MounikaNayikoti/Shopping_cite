import java.util.*;

import javax.lang.model.util.ElementScanner14;
//-----------------------------------------------------------user class-----------------------------------------------------
class User
{
    //-------------------------------------------------private fields of a user
    Scanner sc=new Scanner(System.in);
    private String name;
    private String mobile_num;
    private String email;
    private String password;
    private int MPIN=1234;
    boolean register=false;
    private int cvv=1230;
    private int card_last_digits=402040;
    static int total_amount=0;
    int get_cvv()
    {
        return cvv;
    }
    int card_last_digits()
    {
        return card_last_digits;
    }
    int getMPIN()// ENCAPSULATION TO GET M-PIN
    {
        return MPIN;
    }
    void display_otp(int a)
    {
        System.out.println(App.bold+App.YELLOW+a+App.RESET);
    }
    //-------------------------------------------------------method for signup---------------------------------
    void sign_up(String name,String mobile_num,String email,String password,int MPIN)
    {
        this.MPIN=MPIN;
        this.name=name;
        int mobile_num_count=0;
        for(int i=0;i<mobile_num.length();i++)
        {
            if(mobile_num.charAt(i)>='0' && mobile_num.charAt(i)<='9')
            {
                mobile_num_count++;
            }
        }
        if(mobile_num_count!=10)//------------------------------mobile number validation---------------------
        {
            System.out.println(App.bold+App.RED+"Invalid Mobile Number!"+App.RESET);
        }
        else{
            this.mobile_num=mobile_num;
        }
        int email_count1=0,email_count2=0;
        for(int i=0;i<email.length();i++)//-----------------------email validation------------------------
        {
            if(email.charAt(i)=='@')
            {
                email_count1++;
            }
            if(email.charAt(i)=='.')
            {
                email_count2++;
            }
        }
        if(email_count1==1 && email_count2==1)
        {
            this.email=email;
        }
        else
        {
            System.out.println(App.bold+App.RED+"Invalid E_Mail ID!"+App.RESET);
        }
        if(password.length()>6)//--------------------------password validation----------------------------------
        {
            this.password=password;
        }
        else
        {
            System.out.println(App.bold+App.RED+"Weak Password!! PASSWORD LENGTH MUST BE GREATER THAN 6"+App.RESET);
        }
    }
    //------------------------------------------------------------METHOD FOR SIGN-IN using name and password--------------------------------------
    int sign_in(String name,String password)        //POLYMORPHISM METHOD-OVERLOADING
    {
        if(this.name.equals(name) && this.password.equals(password))
        {
            System.out.println(App.bold+App.GREEN+"<---------------------------------Login successful------------------------------------>"+App.RESET);
            return 1;
        }
        else 
        {
            System.out.println(App.bold+App.RED+"<----------------------------CHECK YOUR (NAME) AND (PASSWORD) AND TRY AGAIN!-------------------------------->"+App.RESET);
            return 0;
        }

    }
    //------------------------------------------------------------METHOD FOR SIGN-IN using email and password--------------------------------------
    int sign_in(String email,String password,int a)
    {
        if(this.email.equals(email) && this.password.equals(password))
        {
            System.out.println(App.bold+App.GREEN+"<---------------------------------Login successful------------------------------------>"+App.RESET);
            return 1;
        }
        else 
        {
            System.out.println(App.bold+App.RED+"<----------------------------CHECK YOUR (MAIL) AND (PASSWORD) AND TRY AGAIN!-------------------------------->"+App.RESET);
            return 0;
        }
    }
    void set(String name,String password) //ENCAPSULATION USING SETTER()
    {
        this.name=name;
        this.password=password;
        System.out.println(App.bold+App.GREEN+"<---------------------------------Details Updated Successfully!!------------------------------>"+App.RESET);
    }
}
//----------------------------------------------------------------CLASS AZIO----------------------------------------------------------------------------
class Azio extends User //INHERITANCE  SINGLE
{
    static Scanner sc=new Scanner(System.in);
    static boolean shop=false,login=false;
    static
    {
        System.out.println("<---------------------------------------WELCOME TO AZIO--------------------------------------->");
    }
    Azio()
    {
        User obj=new User();
        int n;
        do
        {
            System.out.println(App.bold+App.CYAN+"1.New user? Register           2.Already Existing User? Login");
            n=sc.nextInt();
            switch(n)
            {
                case 1: if(register==false)
                        {
                            System.out.print(App.BLUE+"Enter Your Name : "+App.RESET);
                            String name=sc.next();
                            System.out.print(App.BLUE+"Enter your Mobile Number : "+App.RESET);
                            String mobile_num=sc.next();
                            System.out.print(App.BLUE+"Enter your E-Mail ID : "+App.RESET);
                            String email=sc.next();
                            System.out.print(App.BLUE+"Enter your Password : "+App.RESET);
                            String password=sc.next();
                            System.out.print(App.BLUE+"Enter your MPIN (Useful when U forgot the password. DO NOT FORGET IT!) : "+App.RESET);
                            int MPIN=sc.nextInt();
                            obj.sign_up(name,mobile_num,email,password,MPIN);//register method calling
                            if(register=true)
                            {
                                System.out.println(App.bold+App.GREEN+"<------------------------------------Registered Successfully-------------------------------------->"+App.RESET);
                            }   
                        }
                        else    
                        {
                            System.out.println(App.bold+App.RED+"<--------------------------------You have Already Registered! PLEASE LOGIN----------------------------->"+App.RESET);
                        }
                    break;
                case 2:if(register==true)
                        {
                            System.out.println(App.black+App.bgYellow+" Enter Your Choice "+App.RESET+App.bold+App.CYAN+"\n1.Login Using Name                2.Login Using E_Mail"+App.RESET);
                            int login_choice=sc.nextInt();
                            if(login_choice==1)
                            {
                                System.out.print(App.BLUE+"Enter your Name : "+App.RESET);
                                String login_name=sc.next();
                                System.out.print(App.BLUE+"Enter your Password : "+App.RESET);
                                String login_password=sc.next();
                                int login_check=obj.sign_in(login_name,login_password);//login method calling
                                if(login_check==1)
                                {
                                    login=true;
                                }
                                if(login_check==0)
                                {
                                    String login_password_new1="";
                                    String login_password_new2="";
                                    System.out.print(App.BLUE+"Forgot Name/Password? (YES|N0) : "+App.RESET);
                                    String update_key=sc.next().toUpperCase();
                                    do{
                                        if(update_key.equals("YES"))
                                        {
                                            System.out.print(App.BLUE+"Enter MPIN :"+App.RESET);
                                            int mpin=sc.nextInt();
                                            if(mpin==obj.getMPIN())
                                            {
                                                System.out.print(App.BLUE+"Enter your Name : "+App.RESET);
                                                String login_name_new=sc.next();
                                                System.out.print(App.BLUE+"Enter your Password : "+App.RESET);
                                                login_password_new1=sc.next();
                                                System.out.print(App.BLUE+"Re-Enter your Password : "+App.RESET);
                                                login_password_new2=sc.next();
                                                if(login_password_new1.equals(login_password_new2))
                                                {
                                                    obj.set(login_name_new,login_password_new1);//update using setter method
                                                    break;
                                                }
                                                else
                                                {
                                                    System.out.println(App.RED+"<--------------------------Password doesn't Matched!!----------------------->"+App.RESET);
                                                }
                                            }
                                            else
                                            {
                                                System.out.println(App.RED+"WRONG MPIN!"+App.RESET);
                                            }
                                        }
                                    }while (update_key=="YES" || login_password_new1!=login_password_new2);
                                }
                            } 
                            else if(login_choice==2)
                            {
                                System.out.print(App.BLUE+"Enter your E_Mail : "+App.RESET);
                                String login_email=sc.next();
                                System.out.print(App.BLUE+"Enter your Password : "+App.RESET);
                                String login_password=sc.next();
                                int login_check=obj.sign_in(login_email,login_password,10);
                                if(login_check==1)
                                {
                                    login=true;
                                }
                                if(login_check==0)
                                {
                                    String login_password_new1="";
                                    String login_password_new2="";
                                    System.out.print(App.BLUE+"Forgot E-Mail/Password? (YES|N0) : "+App.RESET);
                                    String update_key=sc.next();
                                    do{
                                        if(update_key.equals("YES"))
                                        {
                                            System.out.println(App.BLUE+"Enter MPIN :"+App.RESET);
                                            int mpin=sc.nextInt();
                                            if(mpin==obj.getMPIN())
                                            {
                                                System.out.print(App.BLUE+"Enter your E-Mail : "+App.RESET);
                                                String login_email_new=sc.next();
                                                System.out.print(App.BLUE+"Enter your Password : "+App.RESET);
                                                login_password_new1=sc.next();
                                                System.out.print(App.BLUE+"Re-Enter your Password : "+App.RESET);
                                                login_password_new2=sc.next();
                                                if(login_password_new1.equals(login_password_new2))
                                                {
                                                    obj.set(login_email_new,login_password_new1);
                                                    break;
                                                }
                                                else
                                                {
                                                    System.out.println(App.RED+"<--------------------------Password doesn't Matched!!----------------------->"+App.RESET);
                                                }
                                            }
                                            else
                                            {
                                                System.out.println(App.RED+"WRONG MPIN!"+App.RESET);
                                            }
                                        }
                                    }while (update_key=="YES" || login_password_new1!=login_password_new2);
                                }
                            }
                            else
                            {
                                System.out.println(App.RED+"<---------------------------------Wrong Choice!!------------------------------------>"+App.RESET);
                            }
                        }
                        else
                        {
                            System.out.println(App.RED+"<-----------------------------YOU HAVE NOT YET SIGNED-UP!! KINDLY SIGN-UP FIRST---------------------------->"+App.RESET);
                        }
                    break;
            }
        }while(login==false);

        do
        {
            System.out.println("1.shop\n2.Logout");
            n=sc.nextInt();
            switch (n) {
                case 1:if(login==true)
                        {
                            shop=true;
                            shop shopping=new shop();
                            shopping.welcome("azio");
                            shopping.buy_products();
                        }
                        else
                        {
                            System.out.println("<------------------------------YOU HAVE NOT YET SIGNED-IN!! KINDLY SIGN-IN FIRST------------------------------>");
                        }
                    break;
                default:if(n!=2)
                        {
                            System.out.println("Oh NO Unable to recognise your step!! TRY AGAIN ");
                        }
                    break;
            }
        }while(n!=2  && shop==false);
    }

    

}
class Mynthra extends User
{
   static Scanner sc=new Scanner(System.in);
    static boolean shop=false,login=false;
    static
    {
        System.out.println(App.YELLOW+"<---------------------------------------WELCOME TO MYNTHRA--------------------------------------->"+App.RESET);
    }
    Mynthra()
    {
        User obj=new User();
        int n;
        do
        {
            System.out.println(App.bold+App.CYAN+"1.New user? Register           2.Already Existing User? Login"+App.RESET);
            n=sc.nextInt();
            switch(n)
            {
                case 1: if(register==false)
                        {
                            System.out.print(App.BLUE+"Enter Your Name : "+App.RESET);
                            String name=sc.next();
                            System.out.print(App.BLUE+"Enter your Mobile Number : "+App.RESET);
                            String mobile_num=sc.next();
                            System.out.print(App.BLUE+"Enter your E-Mail ID : "+App.RESET);
                            String email=sc.next();
                            System.out.print(App.BLUE+"Enter your Password : "+App.RESET);
                            String password=sc.next();
                            System.out.print(App.BLUE+"Enter your MPIN (Useful when U forgot the password. DO NOT FORGET IT!) : "+App.RESET);
                            int MPIN=sc.nextInt();
                            obj.sign_up(name,mobile_num,email,password,MPIN);//register method calling
                            if(register=true)
                            {
                                System.out.println(App.bold+App.GREEN+"<------------------------------------Registered Successfully-------------------------------------->"+App.RESET);
                            }   
                        }
                        else    
                        {
                            System.out.println(App.bold+App.RED+"<--------------------------------You have Already Registered! PLEASE LOGIN----------------------------->"+App.RESET);
                        }
                    break;
                case 2:if(register==true)
                        {
                            System.out.println(App.black+App.bgYellow+" Enter Your Choice "+App.RESET+App.bold+App.CYAN+"\n1.Login Using Name                2.Login Using E_Mail"+App.RESET);
                            int login_choice=sc.nextInt();
                            if(login_choice==1)
                            {
                                System.out.print(App.BLUE+"Enter your Name : "+App.RESET);
                                String login_name=sc.next();
                                System.out.print(App.BLUE+"Enter your Password : "+App.RESET);
                                String login_password=sc.next();
                                int login_check=obj.sign_in(login_name,login_password);//login method calling
                                if(login_check==1)
                                {
                                    login=true;
                                }
                                if(login_check==0)
                                {
                                    String login_password_new1="";
                                    String login_password_new2="";
                                    System.out.print(App.BLUE+"Forgot Name/Password? (YES|N0) : "+App.RESET);
                                    String update_key=sc.next().toUpperCase();
                                    do{
                                        if(update_key.equals("YES"))
                                        {
                                            System.out.print(App.BLUE+"Enter MPIN :"+App.RESET);
                                            int mpin=sc.nextInt();
                                            if(mpin==obj.getMPIN())
                                            {
                                                System.out.print(App.BLUE+"Enter your Name : "+App.RESET);
                                                String login_name_new=sc.next();
                                                System.out.print(App.BLUE+"Enter your Password : "+App.RESET);
                                                login_password_new1=sc.next();
                                                System.out.print(App.BLUE+"Re-Enter your Password : "+App.RESET);
                                                login_password_new2=sc.next();
                                                if(login_password_new1.equals(login_password_new2))
                                                {
                                                    obj.set(login_name_new,login_password_new1);//update using setter method
                                                    break;
                                                }
                                                else
                                                {
                                                    System.out.println(App.RED+"<--------------------------Password doesn't Matched!!----------------------->"+App.RESET);
                                                }
                                            }
                                            else
                                            {
                                                System.out.println(App.RED+"WRONG MPIN!"+App.RESET);
                                            }
                                        }
                                    }while (update_key=="YES" || login_password_new1!=login_password_new2);
                                }
                            } 
                            else if(login_choice==2)
                            {
                                System.out.print(App.BLUE+"Enter your E_Mail : "+App.RESET);
                                String login_email=sc.next();
                                System.out.print(App.BLUE+"Enter your Password : "+App.RESET);
                                String login_password=sc.next();
                                int login_check=obj.sign_in(login_email,login_password,10);
                                if(login_check==1)
                                {
                                    login=true;
                                }
                                if(login_check==0)
                                {
                                    String login_password_new1="";
                                    String login_password_new2="";
                                    System.out.print(App.BLUE+"Forgot E-Mail/Password? (YES|N0) : "+App.RESET);
                                    String update_key=sc.next();
                                    do{
                                        if(update_key.equals("YES"))
                                        {
                                            System.out.println(App.BLUE+"Enter MPIN :"+App.RESET);
                                            int mpin=sc.nextInt();
                                            if(mpin==obj.getMPIN())
                                            {
                                                System.out.print(App.BLUE+"Enter your E-Mail : "+App.RESET);
                                                String login_email_new=sc.next();
                                                System.out.print(App.BLUE+"Enter your Password : "+App.RESET);
                                                login_password_new1=sc.next();
                                                System.out.print(App.BLUE+"Re-Enter your Password : "+App.RESET);
                                                login_password_new2=sc.next();
                                                if(login_password_new1.equals(login_password_new2))
                                                {
                                                    obj.set(login_email_new,login_password_new1);
                                                    break;
                                                }
                                                else
                                                {
                                                    System.out.println(App.RED+"<--------------------------Password doesn't Matched!!----------------------->"+App.RESET);
                                                }
                                            }
                                            else
                                            {
                                                System.out.println(App.RED+"WRONG MPIN!"+App.RESET);
                                            }
                                        }
                                    }while (update_key=="YES" || login_password_new1!=login_password_new2);
                                }
                            }
                            else
                            {
                                System.out.println(App.RED+"<---------------------------------Wrong Choice!!------------------------------------>"+App.RESET);
                            }
                        }
                        else
                        {
                            System.out.println(App.RED+"<-----------------------------YOU HAVE NOT YET SIGNED-UP!! KINDLY SIGN-UP FIRST---------------------------->"+App.RESET);
                        }
                    break;
            }
        }while(login==false);

        do
        {
            System.out.println("1.shop\n2.Logout");
            n=sc.nextInt();
            switch (n) {
                case 1:if(login==true)
                        {
                            shop=true;
                            shop shopping=new shop();
                            shopping.welcome("Mynthra");
                            shopping.buy_products();
                        }
                        else
                        {
                            System.out.println("<------------------------------YOU HAVE NOT YET SIGNED-IN!! KINDLY SIGN-IN FIRST------------------------------>");
                        }
                    break;
                default:if(n!=2)
                        {
                            System.out.println("Oh NO Unable to recognise your step!! TRY AGAIN ");
                        }
                    break;
            }
        }while(n!=2  && shop==false);
    }

    

}
class App 
{
    static  String RESET = "\u001B[0m"; //for colors
     static String RED = "\u001B[31m";
     static String GREEN = "\u001B[32m";
     static String YELLOW = "\u001B[33m";
     static String BLUE = "\u001B[34m";
     static String CYAN = "\u001B[36m";
     static String black = "\u001b[30m";
     static String magenta = "\u001b[35m";
     static String WHITE = "\u001B[37m";
     static  String bg ="\u001B[102m";
     static  String bold ="\u001B[1m";
     static  String line ="\u001B[4m";
     static final String bgCyan = "\u001b[46m";
     static final String bgGreen = "\u001b[42m";
     static final String bgMagenta = "\u001b[45m";
     static final String bgRed = "\u001b[41m";
     static final String bgWhite = "\u001b[47m";
     static final String bgYellow = "\u001b[43m";
     static final String bgBrightBlack = "\u001b[40;1m";
     static final String bgBrightBlue = "\u001b[44;1m";
     static final String bgBrightCyan = "\u001b[46;1m";
     static final String bgBrightGreen = "\u001b[42;1m";
     static final String bgBrightMagenta = "\u001b[45;1m";
     static final String bgBrightRed = "\u001b[41;1m";
     static final String bgBrightWhite = "\u001b[47;1m";
     static final String bgBrightYellow = "\u001b[43;1m";
    static
    {
        System.out.println(WHITE+"                                                **********************************************************************");
        System.out.println(WHITE+"                                                *"+bold+magenta+"                      "+bgWhite+" WELCOME TO SHOPPING MALL "+App.RESET+"                     "+"*");
        System.out.println(WHITE+"                                                **********************************************************************");
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int shop_select;
        boolean select=false;
        do
        {
            System.out.println(black+bgYellow+" Kindly Choose your Shopping Mart "+RESET+bold+CYAN+"\n1.Azio                 2.Mynthra                    3.Exit");
            shop_select=sc.nextInt();
            switch (shop_select) 
            {
                case 1:select=true;
                        Azio obj=new Azio();
                        if(Azio.shop==true)
                        {
                            new pay().payment_method(obj.total_amount);
                        }
                        
                
                    break;
                case 2:select=true;
                        Mynthra obj1=new Mynthra();
                        if(Mynthra.shop==true)
                        {
                            new pay().payment_method(obj1.total_amount);
                        }
                
                    break;
                default:if(shop_select!=3)
                        {   
                            System.out.println(App.RED+"<---------------------Choose the Correct Option!-------------------------->"+App.RESET);
                        }
            }
        }while(shop_select!=3 && select==false);
    }
}

interface men 
{
    Scanner sc=new Scanner(System.in);
    static String brand1="ntplay",brand2="US POLO", brand3="PeterEngland";
    static String brand11="Baata",brand12="Crocks",brand13="Roadster";
    int Baata=800,Crocks=900,Roadster=700;
    int ntplay=400,US_POLO=600,PeterEngland=450;
    static void men_cloth_shop()
    {
        int choose,brand,quantity;
        do
        {
            System.out.println(App.black+App.bgYellow+"What You want to buy?"+App.RESET+App.BLUE+"\n1.T-Shirts               2.Pants             3.Exit"+App.RESET);
            choose=sc.nextInt();
            switch (choose) {
                case 1:System.out.println(App.black+App.bgYellow+"Choose the brand"+App.RESET+App.BLUE+"\n1."+brand1+"                   2."+brand2+"                    3."+brand3+App.RESET);
                        brand=sc.nextInt();
                        if(brand==1)
                        {
                            System.out.print(App.CYAN+"Enter Quantity : "+App.RESET);
                            quantity=sc.nextInt();
                            User.total_amount+=quantity*ntplay;
                            shop.product_count++;
                        }
                        else if(brand==2)
                        {
                            System.out.print(App.CYAN+"Enter Quantity : "+App.RESET);
                            quantity=sc.nextInt();
                            User.total_amount=quantity*US_POLO;
                            shop.product_count++;
                        }
                        else if(brand==3)
                        {
                            System.out.print(App.CYAN+"Enter Quantity : "+App.RESET);
                            quantity=sc.nextInt();
                            User.total_amount=quantity*PeterEngland;
                            shop.product_count++;
                        }
                    break;
                case 2:System.out.println(App.black+App.bgYellow+"Choose the brand"+App.RESET+App.BLUE+"\n1."+brand1+"                  2."+brand2+"                    3."+brand3+App.RESET);
                        brand=sc.nextInt();
                        if(brand==1)
                        {
                            System.out.print(App.CYAN+"Enter Quantity : "+App.RESET);
                            quantity=sc.nextInt();
                            User.total_amount+=quantity*ntplay;
                            shop.product_count++;
                        }
                        else if(brand==2)
                        {
                            System.out.print(App.CYAN+"Enter Quantity : "+App.RESET);
                            quantity=sc.nextInt();
                            User.total_amount=quantity*US_POLO;
                            shop.product_count++;
                        }
                        else if(brand==3)
                        {
                            System.out.print(App.CYAN+"Enter Quantity : "+App.RESET);
                            quantity=sc.nextInt();
                            User.total_amount=quantity*PeterEngland;
                            shop.product_count++;
                        }
                    
                    break;
            
                default:if(choose!=3)
                        {
                            System.out.println(App.RED+"<----------------------------------Wrong Choice!!------------------------->"+App.RESET);
                        }
                    break;
            }
        }while(choose!=3);
    }

    static void men_foot_shop()
    {
        int choose,brand,quantity;
        do
        {
            System.out.println(App.black+App.bgYellow+"What You want to buy?"+App.RESET+App.BLUE+"\n1.Shoes                          2.Chappal                    3.Exit"+App.RESET);
            choose=sc.nextInt();
            switch (choose) {
                case 1:System.out.println(App.black+App.bgYellow+"Choose the brand"+App.RESET+App.BLUE+"\n1."+brand11+"              2."+brand12+"                  3."+brand13+App.RESET);
                        brand=sc.nextInt();
                        if(brand==1)
                        {
                            System.out.print(App.CYAN+"Enter Quantity : "+App.RESET);
                            quantity=sc.nextInt();
                            User.total_amount+=quantity*Baata;
                            shop.product_count++;
                        }
                        else if(brand==2)
                        {
                            System.out.print(App.CYAN+"Enter Quantity : "+App.RESET);
                            quantity=sc.nextInt();
                            User.total_amount=quantity*Crocks;
                            shop.product_count++;
                        }
                        else if(brand==3)
                        {
                            System.out.print(App.CYAN+"Enter Quantity : "+App.RESET);
                            quantity=sc.nextInt();
                            User.total_amount=quantity*Roadster;
                            shop.product_count++;
                        }
                    break;
                case 2:System.out.println(App.black+App.bgYellow+"Choose the brand"+App.RESET+App.BLUE+"\n1."+brand11+"              2."+brand12+"               3."+brand13+App.BLUE);
                        brand=sc.nextInt();
                        if(brand==1)
                        {
                            System.out.print(App.CYAN+"Enter Quantity : "+App.RESET);
                            quantity=sc.nextInt();
                            User.total_amount+=quantity*Baata;
                            shop.product_count++;
                        }
                        else if(brand==2)
                        {
                            System.out.print(App.CYAN+"Enter Quantity : "+App.RESET);
                            quantity=sc.nextInt();
                            User.total_amount=quantity*Crocks;
                            shop.product_count++;
                        }
                        else if(brand==3)
                        {
                            System.out.print(App.CYAN+"Enter Quantity : "+App.RESET);
                            quantity=sc.nextInt();
                            User.total_amount=quantity*Roadster;
                            shop.product_count++;
                        }
                    
                    break;
            
                default:if(choose!=3)
                        {
                            System.out.println(App.RED+"<----------------------------------Wrong Choice!!------------------------->"+App.RESET);
                        }
                    break;
            }
        }while(choose!=3);
    }
}
interface women 
{
    Scanner s=new Scanner(System.in);
    static String brand1="Transpirit",brand2="DINIM", brand3="ntplay";
    static String brand11="Walkmate",brand12="Adidas",brand13="Paragon";
    int Transpirit=700,DINIM=550,ntplay=600;
    int walkmate=700,Adidas=1000,Paragon=500;
    static void women_foot_shop()
    {
        int choose,brand,quantity;
        do
        {
            System.out.println(App.black+App.bgYellow+"What You want to buy?"+App.RESET+App.BLUE+"\n1.Shoes                2.Chappals                  3.Exit"+App.BLUE);
            choose=s.nextInt();
            switch (choose) {
                case 1:System.out.println(App.black+App.bgYellow+"Choose the brand"+App.RESET+App.BLUE+"\n1."+brand11+"                     2."+brand12+"                3."+brand13+App.RESET);
                        brand=s.nextInt();
                        if(brand==1)
                        {
                            System.out.print(App.CYAN+"Enter Quantity : "+App.RESET);
                            quantity=s.nextInt();
                            User.total_amount+=quantity*walkmate;
                            shop.product_count++;
                        }
                        else if(brand==2)
                        {
                            System.out.print(App.CYAN+"Enter Quantity : "+App.RESET);
                            quantity=s.nextInt();
                            User.total_amount=quantity*Adidas;
                            shop.product_count++;
                        }
                        else if(brand==3)
                        {
                            System.out.print(App.CYAN+"Enter Quantity : "+App.RESET);
                            quantity=s.nextInt();
                            User.total_amount=quantity*Paragon;
                            shop.product_count++;
                        }
                    break;
                case 2:System.out.println(App.black+App.bgYellow+"Choose the brand"+App.RESET+App.BLUE+"\n1."+brand11+"              2."+brand12+"                   3."+brand13+App.RESET);
                        brand=s.nextInt();
                        if(brand==1)
                        {
                            System.out.print(App.CYAN+"Enter Quantity : "+App.RESET);
                            quantity=s.nextInt();
                            User.total_amount+=quantity*walkmate;
                            shop.product_count++;
                        }
                        else if(brand==2)
                        {
                            System.out.print(App.CYAN+"Enter Quantity : "+App.RESET);
                            quantity=s.nextInt();
                            User.total_amount=quantity*Adidas;
                            shop.product_count++;
                        }
                        else if(brand==3)
                        {
                            System.out.print(App.CYAN+"Enter Quantity : "+App.RESET);
                            quantity=s.nextInt();
                            User.total_amount=quantity*Paragon;
                            shop.product_count++;
                        }
                    
                    break;
            
                default:if(choose!=3)
                        {
                           System.out.println(App.RED+"<----------------------------------Wrong Choice!!------------------------->"+App.RESET);
                        }
                    break;
            }
        }while(choose!=3);
    }

    static void women_cloth_shop()
    {
        int choose,brand,quantity;
        do
        {
            System.out.println(App.black+App.bgYellow+"What You want to buy?"+App.RESET+App.BLUE+"\n1.T-Shirts                   2.Chudidhars                 3.Exit"+App.RESET);
            choose=s.nextInt();
            switch (choose) {
                case 1:System.out.println(App.black+App.bgYellow+"Choose the brand"+App.RESET+App.BLUE+"\n1."+brand1+"               2."+brand2+"                            3."+brand3+App.RESET);
                        brand=s.nextInt();
                        if(brand==1)
                        {
                            System.out.print(App.CYAN+"Enter Quantity : "+App.RESET);
                            quantity=s.nextInt();
                            User.total_amount+=quantity*Transpirit;
                            shop.product_count++;
                        }
                        else if(brand==2)
                        {
                            System.out.print(App.CYAN+"Enter Quantity : "+App.RESET);
                            quantity=s.nextInt();
                            User.total_amount=quantity*DINIM;
                            shop.product_count++;
                        }
                        else if(brand==3)
                        {
                            System.out.print(App.CYAN+"Enter Quantity : "+App.RESET);
                            quantity=s.nextInt();
                            User.total_amount=quantity*ntplay;
                            shop.product_count++;
                        }
                    break;
                case 2:System.out.println(App.black+App.bgYellow+"Choose the brand"+App.RESET+App.BLUE+"\n1."+brand1+"               2."+brand2+"                         3."+brand3+App.RESET);
                        brand=s.nextInt();
                        if(brand==1)
                        {
                            System.out.print(App.CYAN+"Enter Quantity : "+App.RESET);
                            quantity=s.nextInt();
                            User.total_amount+=quantity*Transpirit;
                            shop.product_count++;
                        }
                        else if(brand==2)
                        {
                            System.out.print(App.CYAN+"Enter Quantity : "+App.RESET);
                            quantity=s.nextInt();
                            User.total_amount=quantity*DINIM;
                            shop.product_count++;
                        }
                        else if(brand==3)
                        {
                            System.out.print(App.CYAN+"Enter Quantity : "+App.RESET);
                            quantity=s.nextInt();
                            User.total_amount=quantity*ntplay;
                            shop.product_count++;
                        }
                    
                    break;
            
                default:if(choose!=3)
                        {
                            System.out.println(App.RED+"<--------------------------------Wrong Choice------------------------->"+App.RESET);
                        }
                    break;
            }
        }while(choose!=3);
    }
}
interface clothing extends men,women
{
    Scanner in=new Scanner(System.in);
    void buy_products();
    static void shop()
    {
        int gender;
        do
        {
            System.out.println(App.black+App.bgYellow+"Select the gender"+App.RESET+App.RESET+App.BLUE+"\n1.Male                   2.Female                        3.Exit"+App.RESET);
            gender=in.nextInt();
            switch (gender) {
                case 1:men.men_cloth_shop();
                        break;
                case 2:women.women_cloth_shop();
                    break;
                default:if(gender!=3)
                        {
                            System.out.println(App.RED+"<----------------------------------Wrong Choice!!------------------------->"+App.RESET);
                        }
                    break;
            }
        }while(gender!=3);
    }
}
interface footwear extends men,women
{
    void buy_products();
    Scanner in=new Scanner(System.in);
    static void shop()
    {
        int gender;
        do
        {
            System.out.println(App.black+App.bgYellow+"Select the gender"+App.RESET+App.BLUE+"\n1.Male                         2.Female                   3.Exit"+App.RESET);
            gender=in.nextInt();
            switch (gender) {
                case 1:men.men_foot_shop();
                        break;
                case 2:women.women_foot_shop();
                    break;
                default:if(gender!=3)
                        {
                            System.out.println(App.RED+"<----------------------------------Wrong Choice!!------------------------->"+App.RESET);
                        }
                    break;
            }
        }while(gender!=3);
    }
}
class shop implements clothing, footwear
{
    static int product_count=0;
    void welcome(String s)
    {
        System.out.println( App.YELLOW+"                   <-------------------------WELCOME TO "+s.toUpperCase()+" SHOPPING------------------------------------>"+App.RESET);
    }
    public void buy_products()
    {
        int product_select;
        do
        {
            System.out.println(App.black+App.bgYellow+" Enter Your Choice"+App.RESET+App.BLUE+"\n1.Clothing             2.Footwear             3.Logout"+App.RESET);
            product_select=sc.nextInt();
            switch (product_select) {
                case 1:clothing.shop();
                    break;
                case 2:footwear.shop();
                    break;
                default:if(product_select!=3)
                        {
                            System.out.println("Wrong Choice");
                        }
                    break;
            }

        }while(product_select!=3);  
    }
}
class paytm extends User
{
    void paytm_pay(long total_amount)
    {
        int amount_pay, discount;
        if(shop.product_count>0)
        {
            do
            {
            System.out.print("Enter MPIN : ");
            int pin=sc.nextInt();
            if(getMPIN()==pin)
            {
                if(total_amount>=100000)
                {
                    discount=(int)(total_amount-=(total_amount*5/100));
                    System.out.println(App.YELLOW+"Discount : "+App.RESET+App.BLUE+discount+App.RESET);
                    System.out.println(App.YELLOW+"You Paid : "+App.RESET+App.BLUE+(total_amount-discount+App.RESET));
                    System.out.println(App.GREEN+"<---------------------Hurray! You Saved Rs."+discount+"/- -------------------->"+App.RESET);
                    break;
                }
                else if(total_amount>=5000)
                {
                    System.out.println(App.YELLOW+"Discount : "+App.RESET+App.BLUE+"1000"+App.RESET);
                    System.out.println(App.YELLOW+"You Paid : "+App.RESET+App.BLUE+(total_amount-1000)+App.RESET);
                    System.out.println(App.GREEN+"<---------------------Hurray! You Saved Rs.1000/- -------------------->"+App.RESET);
                    break;
                }
                else if(total_amount>=3000)
                {
                    System.out.println(App.YELLOW+"Discount :"+App.RESET+App.GREEN+" 500"+App.RESET);
                    System.out.println(App.YELLOW+"You Paid : "+App.RESET+App.GREEN+(total_amount-500)+App.RESET);
                    System.out.println(App.GREEN+"<---------------------Hurray! You Saved Rs.500/- -------------------->"+App.RESET);
                    break;
                }
                else 
                {
                    System.out.println(App.GREEN+"You Paid : "+total_amount+App.RESET);
                    break;
                }
            }
            else
            {
                System.out.println(App.RED+"<--------------------------------------WRONG PIN! RE-ENTER------------------------------>"+App.RESET);
            }
            }while(true);
        }
        else
        {
            System.out.println(App.RED+"<------------------------------Your Cart is EMPTY!-------------------------"+App.RESET);
        }
    }
}
class phone_pay extends User
{
    void phone_pay(long total_amount)
    {
        int amount_pay, discount;
        if(shop.product_count>0)
        {
            do
            {
            System.out.print(App.BLUE+"Enter MPIN : "+App.RESET);
            int pin=sc.nextInt();
            if(getMPIN()==pin)
            {
                if(total_amount>=100000)
                {
                    discount=(int)(total_amount-=(total_amount*5/100));
                    System.out.println(App.YELLOW+"Discount : "+App.RESET+App.GREEN+discount+App.RESET);
                    System.out.println(App.YELLOW+"You Paid : "+App.RESET+App.GREEN+(total_amount-discount)+App.RESET);
                    System.out.println(App.GREEN+"<---------------------Hurray! You Saved Rs."+discount+"/- -------------------->"+App.RESET);
                    break;
                }
                else if(total_amount>=5000)
                {
                    System.out.println(App.YELLOW+"Discount : 1000");
                    System.out.println(App.YELLOW+"You Paid : "+App.RESET+App.GREEN+(total_amount-1000)+App.RESET);
                    System.out.println(App.GREEN+"<---------------------Hurray! You Saved Rs.1000/- -------------------->"+App.RESET);
                    break;
                }
                else if(total_amount>=3000)
                {
                    System.out.println(App.YELLOW+"Discount : 500");
                    System.out.println(App.YELLOW+"You Paid : "+App.RESET+App.GREEN+(total_amount-500)+App.RESET);
                    System.out.println(App.GREEN+"<---------------------Hurray! You Saved Rs.500/- -------------------->"+App.RESET);
                    break;
                }
                else 
                {
                    System.out.println(App.YELLOW+"You Paid : "+total_amount+App.RESET);
                    break;
                }
            }
            else
            {
                System.out.println(App.RED+"<--------------------------------------WRONG PIN! RE-ENTER------------------------------>"+App.RESET);
            }
            }while(true);
        }
        else
        {
            System.out.println(App.RED+"<------------------------------Your Cart is EMPTY!-------------------------"+App.RESET);
        }
    }
}
class card extends User
{
    void card_pay(long total_amount)
    {
        int amount_pay, discount;
        if(shop.product_count>0)
        {
            do
        {
            System.out.print(App.CYAN+"Enter last 6-digits of debit card : "+App.RESET);
            int debit_last6_num=sc.nextInt();
            System.out.print(App.CYAN+"Enter CVV : "+App.RESET);
            int cvv=sc.nextInt();   
            int a=(int)(Math.random()+4000+252-6);
            if(debit_last6_num == card_last_digits()&& cvv ==get_cvv() )
            {
                  System.out.println(App.CYAN+"<-----------------------------Enter the OPT send to your Registered Mobile Number-------------------------------->"+App.RESET);
                  display_otp(a);
                  int otp=sc.nextInt();
                if(a==otp)
                {
                    if(total_amount>=100000)
                    {
                        discount=(int)(total_amount-=(total_amount*5/100));
                        System.out.println(App.YELLOW+"Discount : "+App.RESET+App.BLUE+discount+App.RESET);
                        System.out.println(App.YELLOW+"You Paid : "+App.RESET+App.BLUE+(total_amount-discount)+App.RESET);
                        System.out.println(App.GREEN+"<---------------------Hurray! You Saved Rs."+discount+"/- -------------------->"+App.RESET);
                        break;
                    }
                    else if(total_amount>=5000)
                    {
                        System.out.println(App.YELLOW+"Discount : 1000"+App.YELLOW);
                        System.out.println(App.YELLOW+"You Paid : "+App.RESET+App.BLUE+(total_amount-1000)+App.RESET);
                        System.out.println(App.GREEN+"<---------------------Hurray! You Saved Rs.1000/- -------------------->"+App.RESET);
                        break;
                    }
                    else if(total_amount>=3000)
                    {
                        System.out.println(App.YELLOW+"Discount : 500"+App.YELLOW);
                        System.out.println(App.YELLOW+"You Paid : "+App.RESET+App.BLUE+(total_amount-500)+App.BLUE);
                        System.out.println(App.GREEN+"<---------------------Hurray! You Saved Rs.500/- -------------------->"+App.RESET);
                        break;
                    }
                    else 
                    {
                        System.out.println(App.CYAN+"You Paid : "+total_amount+App.RESET);
                        break;
                    }
                }
                else
                {
                    System.out.println(App.RED+"<--------------------------------------Invalid OTP-------------------------------->"+App.RESET);
                }
            }
            else
            {
                System.out.println(App.RED+"<--------------------------------------WRONG PIN! RE-ENTER------------------------------\n>"+App.RESET);
            }
        }while(true);
        }
        else
        {
            System.out.println(App.RED+"<------------------------------Your Cart is EMPTY!-------------------------"+App.RESET);
        }
        
    }
}
class pay //INHERITANCE MULTIPLE
{
    Scanner sc=new Scanner(System.in);
    void payment_method(long total_amount)
    {    
        System.out.println(App.bgYellow+App.black+"Choose Payment Method"+App.RESET+App.BLUE+"\n1.Paytm\n2.Phone Pay\n3.Debit Card"+App.RESET);
        int choose_payment_method=sc.nextInt();
        if(choose_payment_method==1)
        {
            new paytm().paytm_pay( total_amount);
        }
        else if(choose_payment_method==2)
        {
            new phone_pay().phone_pay( total_amount);
        }
        else if(choose_payment_method==3)
        {
            new card().card_pay( total_amount);
        }
        else
        {
            System.out.println("Wrong Choice");
        }
        System.out.println(App.bgBrightWhite+App.BLUE+"                                               /n<----------------------------- VISIT AGAIN!   HAVE A GREAT DAY ----------------------------------->"+App.RESET);
    }
    
}