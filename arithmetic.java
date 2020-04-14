package text;


import text.Fraction;
import text.Write;
import text.Read;

public class arithmetic {
	
	int yunsuanfu=0;
	static int count1=0;
	static int count2=0;
	public static int getnumber(int x, int y)
	{
		return(x*10+y);
	}

	public static Object get(int f) {
	 Fraction x=new Fraction();
	 int a=(int)(Math.random()*1.99);
	 int d=(int)(Math.random()*f)+1; 
	 if(a==1)      return d;  
	 else return x.produce();
	}
	
	public static void main(String[] args) {
       int number=0;  int f=0,i;
       Object a,b,c; 
        String d,A=null,E=null;
        for(i=0;i<args.length;i++) {
       	 switch (args[i]){
            case "-n":
                if (args[i+1].matches("\\d+")){
                    f = Integer.parseInt(args[i+1]);
                    
                }
                break;
            case "-r":
                if (args[i+1].matches("\\d+")){
                    number = Integer.parseInt(args[i+1]);
                    
                }
                break;
            case "-e":
                E= args[i+1];
                break;
            case "-a":
                A = args[i+1];
               
                break;
       }
        }
        for(int j=1;j<=f;j++)
        {    Fraction F=new Fraction();
        	count1=(int) (Math.random()*3.99)+1;//确保count1大于1，同时产生4的概率近似与1,2,3相等
            count2=(int) (Math.random()*4.99);//
			switch(getnumber(count1,count2)) 
            {
            case 10: a=get(number);
                     b=get(number);
                     d= j+"."+ a +" + "+ b +" = "; 
            	     System.out.println(d);//
            	     Write.writefile(d,E);
            	     Write.writefile(j+"."+ F.add(a,b),A);
                     break;
            case 20: a=get(number);
                     b=get(number);
                     d= j+"."+ a +" - "+ b +" = "; 
                     System.out.println(d);
                     Write.writefile(d,E);
                     Write.writefile(j+"."+ F.minus(a,b),A);
                     break;
            case 30: a=get(number);
                     b=get(number); 
                     d= j+"."+ a +" % "+ b +" = "; 
                     System.out.println(d);//为区别分数与除法用%代替除号
                     Write.writefile(d,E);
                     Write.writefile(j+"."+ F.divide(a,b),A);
                      break;         
            case 40: a=get(number);
                     b=get(number);
            	     d= j+"."+ a +" *" + b +" = ";
                     System.out.println(d);
                     Write.writefile(d,E);
                     Write.writefile(j+"."+ F.multiply(a,b),A);
                      break;                
            case 11: a=get(number);
                     b=get(number);
                     c=get(number);
                     d= j+"."+a +" + "+ b +" + "+ c +" = ";
            	     System.out.println(d);
            	     Write.writefile(d,E);
            	     Write.writefile(j+"."+ F.add(c,F.add(a,b)),A);
                      break;   
            case 12: a=get(number);
                     b=get(number);
                     c=get(number);
                     d= j+"."+ a +" + "+ b +" - "+ c +" = ";
                     System.out.println(d);
                     Write.writefile(d,E);
                     Write.writefile(j+"."+ F.minus(F.add(a,b),c),A);
                      break; 
            case 13: a=get(number);
                     b=get(number);
                     c=get(number);
                     d= j+"."+ a +" + "+ b +" % "+ c +" = ";
                     System.out.println(d);
                     Write.writefile(d,E);
                     Write.writefile(j+"."+ F.add(a, F.divide(b, c)),A);
                       break;  
            case 14: a=get(number);
                     b=get(number);
                     c=get(number);
                     d= j+"."+ a +" + "+ b +" * "+ c +" = ";
                     System.out.println(d);
                     Write.writefile(d,E);
                     Write.writefile(j+"."+ F.add(a, F.multiply(b, c)),A);
                       break;  
            case 21: a=get(number);
                     b=get(number);
                     c=get(number);
                     d= j+"."+ a +" - "+ b +" + "+ c +" = ";
                     System.out.println(d);
                     Write.writefile(d,E);
                     Write.writefile(j+"."+ F.add(c,F.minus(a, b)),A);
                       break;  
            case 22: a=get(number);
                     b=get(number);
                     c=get(number);
                     d= j+"."+ a +" - "+ b +" - "+ c +" = ";
                     System.out.println(d);
                     Write.writefile(d,E);
                     Write.writefile(j+"."+ F.minus(F.minus(a, b),c),A);
                       break; 
            case 23: a=get(number);
                     b=get(number);
                     c=get(number);
                     d= j+"."+ a +" - "+ b +" % "+ c +" = ";
                     System.out.println(d);
                     Write.writefile(d,E);
                     Write.writefile(j+"."+ F.minus(a,F.divide(b, c)),A);
                       break; 
            case 24: a=get(number);
                     b=get(number);
                     c=get(number);
                     d= j+"."+ a +" - "+ b +" * "+ c +" = ";
                     System.out.println(d);
                     Write.writefile(d,E);
                     Write.writefile(j+"."+ F.minus(a,F.multiply(b, c)),A);
                       break;  
            case 31: a=get(number);
                     b=get(number);
                     c=get(number);
                     d= j+"."+ a +" % "+ b +" + "+ c +" = ";
                     System.out.println(d);
                     Write.writefile(d,E);
                     Write.writefile(j+"."+ F.add(c,F.divide(a, b)),A);
                       break;
            case 32: a=get(number);
                     b=get(number);
                     c=get(number);
                     d= j+"."+ a +" % "+ b +" - "+ c +" = ";
                     System.out.println(d);
                     Write.writefile(d,E);
                     Write.writefile(j+"."+ F.minus(F.divide(a, b),c),A);
                       break; 
            case 33: a=get(number);
                     b=get(number);
                     c=get(number);
                     d= j+"."+ a +" % "+ b +" % "+ c +" = ";
                     System.out.println(d);
                     Write.writefile(d,E);
                     Write.writefile(j+"."+ F.divide(F.divide(a, b),c),A);
                       break; 
            case 34: a=get(number);
                     b=get(number);
                     c=get(number);
                     d= j+"."+ a +" % "+ b +" * "+ c +" = ";
                     System.out.println(d);
                     Write.writefile(d,E);
                     Write.writefile(j+"."+ F.multiply(F.divide(a, b), c),A);
                       break;  
            case 41: a=get(number);
                     b=get(number);
                     c=get(number);
                     d= j+"."+ a +" * "+ b +" + "+ c +" = ";
            	     System.out.println(d);
            	     Write.writefile(d,E);
            	     Write.writefile(j+"."+ F.add(F.multiply(a, b), c),A);
            	       break; 
            case 42: a=get(number);
                     b=get(number);
                     c=get(number);
                     d= j+"."+ a +" * "+ b +" - "+ c +" = ";
 	       	         System.out.println(d);
 	       	         Write.writefile(d,E);
 	       	         Write.writefile(j+"."+ F.minus(F.multiply(a, b), c),A); 
 	       			 break; 
            case 43: a=get(number);
                     b=get(number);
                     c=get(number);
                     d= j+"."+ a +" * "+ b +" % "+ c +" = ";
 	       	   	     System.out.println(d);
 	       	   	     Write.writefile(d,E);
 	       	   	     Write.writefile(j+"."+ F.divide(F.multiply(a, b), c),A); 
 	       			 break;  
            case 44: a=get(number);
                     b=get(number);
                     c=get(number);
                     d= j+"."+ a +" * "+ b +" * "+ c+ " = ";
 	       			 System.out.println(d);
 	       			 Write.writefile(d,E);
 	       	         Write.writefile(j+"."+ F.multiply(F.multiply(a, b),c),E); 
 	       			   break;  		   
            }  //暴力枚举
 
       }
         
}
	
}
