package text;


public class Fraction {
	
	public boolean isNumber(String a) {//判断一个String是否是纯数字
		if(a==null) return false;		
		return a.matches("(-|\\+)?\\d+");
		}
   public   String	 produce(){//产生一个分数
	   int i=(int)(Math.random()*100)+1;
	   int j=(int)(Math.random()*100)+1;
	   if(i%j==0)    return String.valueOf(i/j); 
	   int n=i/j;
	   String fenshu=n+"'"+(i-n*j)+"/"+j;
	   return  simplify(fenshu);
   }
   
  public String simplify(String a) {//化简
	   if(isNumber(a)) return a;
	   int i,j,n;
	   n=Integer.parseInt(a.split("\\'")[0]);//取整数
	   String b[]=a.split("\\'")[1].split("\\/"); //先将n'x/y以'分隔为两部分后部分再以“/”为分隔，将"x/y"分隔为 a[0]="x"  a[1]="y"
	   i=Integer.parseInt(b[0]); //将一个可以转化为整形的字符串装换成整形
	   j=Integer.parseInt(b[1]);  	  	     
	   if(i==0||j==0) return String.valueOf(n);
	   if(i<0&&j<0)  i=Math.abs(i); j=Math.abs(j); 
	   if(i<0||j<0)  
	   {   i=-Math.abs(i); j=Math.abs(j);
		   for(  ;i<0;n--) {
			  i=i+j; 
		   }
	      
	   }
	   if(i==0||j==0) return String.valueOf(n);
	   int d=divisor(i,j);
	   n=n+i/j;
	   return n+"'"+(i/d-i/j*j/d)+"/"+(j/d);
	}
   
   public int divisor(int x,int y) {//求两个数的最大公约数
	   
	   int i,j;
	   if(x<=y)  i=x;
	   else      i=y;
	   for(j=0;j==0;i--) {
		  if(x%i==0&&y%i==0)    j=1;
		 
	   }
        return i+1;
   }
   public String add(Object c,Object d) {//Object加法
	   int s1=0,s2=0;
	   if(c instanceof Integer) s1=1;
	   if(d instanceof Integer) s2=1;
	   switch(s1+s2*10) {
	      case 10: return add(c.toString(),(int)d);        
	      case 1:  return add(d.toString(),(int)c);
          case 11: return add((int)c,(int)d); 
	      case 0:  return add(c.toString(),d.toString());
	               
	   }
	return null;
	 
   }
   public String add(String c,String d) {//分数加法
	   if(isNumber(c)||isNumber(simplify(c)))  return add(d,Integer.parseInt(simplify(c)));
	   if(isNumber(d)||isNumber(simplify(d)))  return add(c,Integer.parseInt(simplify(d)));
	   int s1,s2,s3,s4,n1,n2;
	   n1=Integer.parseInt(c.split("\\'")[0]);
 	   n2=Integer.parseInt(d.split("\\'")[0]);
	   String a[]=c.split("\\'")[1].split("\\/");
	   String b[]=d.split("\\'")[1].split("\\/");
	   s1=Integer.parseInt(a[0]); 
	   s2=Integer.parseInt(a[1]);
	   s3=Integer.parseInt(b[0]);
	   s4=Integer.parseInt(b[1]); 
	   return simplify(0+"'"+((n1*s2+s1)*s4+(n2*s4+s3)*s2)+"/"+(s2*s4));
   }
   public String add(String c,int d) {//混合加法
	   if(isNumber(c)||isNumber(simplify(c)))  return add(Integer.parseInt(simplify(c)),d);
	   int s1,s2,n;
	   n=Integer.parseInt(c.split("\\'")[0]);
	   String a[]=c.split("\\'")[1].split("\\/");
	   s1=Integer.parseInt(a[0]); 
	   s2=Integer.parseInt(a[1]); 
	   return simplify(0+"'"+((n*s2+s1)+d*s2)+"/"+s2);
   }
   public String add(int c,int d) {//整数加法
	   return String.valueOf(c+d);
   }
   public String minus(Object c,Object d) {//
	   int s1=0,s2=0;
	   if(c instanceof Integer) s1=1;
	   if(d instanceof Integer) s2=1;
	   switch(s1+s2*10) {
	      case 10: return minus(c.toString(),(int)d);        
	      case 1:  return minus((int)c,d.toString() );
          case 11: return minus((int)c,(int)d); 
	      case 0:  return minus(c.toString(),d.toString());
	   }
	   return null;
   }
   public String minus(String c,int d) {//分数减法
	   if(isNumber(c)||isNumber(simplify(c)))  return minus(Integer.parseInt(simplify(c)),d);
	   int s1,s2,n;
	   n=Integer.parseInt(c.split("\\'")[0]);
	   String a[]=c.split("\\'")[1].split("\\/");
	   s1=Integer.parseInt(a[0]); 
	   s2=Integer.parseInt(a[1]);
	   return simplify(0+"'"+((n*s2+s1)-d*s2)+"/"+s2);
   }
   public String minus(int c,String d) {//分数减法
	   if(isNumber(d)||isNumber(simplify(d))) return minus(c,Integer.parseInt(simplify(d)));
	   int s1,s2,n;
	   n=Integer.parseInt(d.split("\\'")[0]);
	   String a[]=d.split("\\'")[1].split("\\/");
	   s1=Integer.parseInt(a[0]); 
	   s2=Integer.parseInt(a[1]); 
	   return simplify(0+"'"+(c*s2-(n*s2+s1))+"/"+s2);
   }
   public String minus(String c,String d) {//分数减法
	   if(isNumber(c)||isNumber(simplify(c))) return minus(Integer.parseInt(simplify(c)),d);
	   if(isNumber(d)||isNumber(simplify(d))) return minus(c,Integer.parseInt(simplify(d)));
	   int s1,s2,s3,s4,n1,n2;
	   n1=Integer.parseInt(c.split("\\'")[0]);
 	   n2=Integer.parseInt(d.split("\\'")[0]);
	   String a[]=c.split("\\'")[1].split("\\/");
	   String b[]=d.split("\\'")[1].split("\\/");
	   s1=Integer.parseInt(a[0]); 
	   s2=Integer.parseInt(a[1]);
	   s3=Integer.parseInt(b[0]);
	   s4=Integer.parseInt(b[1]); 
	   return simplify(0+"'"+((n1*s2+s1)*s4-(n2*s4+s3)*s2)+"/"+(s2*s4));
   }
   public String minus(int c,int d) {//分数减法
	   return  String.valueOf(c-d);
   } 
   public String multiply(Object c,Object d) {//分数乘法
	   int s1=0,s2=0;
	   if(c instanceof Integer) s1=1;
	   if(d instanceof Integer) s2=1;
	   switch(s1+s2*10) {
	      case 10: return multiply(c.toString(),(int)d);        
	      case 1:  return multiply(d.toString(),(int)c);
          case 11: return multiply((int)c,(int)d); 
	      case 0:  return multiply(c.toString(),d.toString());
	   }
	   return null;
 	   } 
   public String multiply(String c,String d) {//分数乘法
	   if(isNumber(c)||isNumber(simplify(c))) return multiply(d,Integer.parseInt(simplify(c)));
	   if(isNumber(d)||isNumber(simplify(d))) return multiply(c,Integer.parseInt(simplify(d)));
	   int s1,s2,s3,s4,n1,n2;
 	   n1=Integer.parseInt(c.split("\\'")[0]);
 	   n2=Integer.parseInt(d.split("\\'")[0]);
 	   String a[]=c.split("\\'")[1].split("\\/");
 	   String b[]=d.split("\\'")[1].split("\\/");
 	   s1=Integer.parseInt(a[0]);
 	   s2=Integer.parseInt(a[1]);
 	   s3=Integer.parseInt(b[0]);
 	   s4=Integer.parseInt(b[1]); 
 	   return simplify(0+"'"+((n1*s2+s1)*(n2*s4+s3))+"/"+(s2*s4));   
 	   } 
   public String multiply(String c,int d) {//混合乘法
	   if(isNumber(c)||isNumber(simplify(c))) return multiply(Integer.parseInt(simplify(c)),d);
	   int s1,s2,n1; 	   
 	   n1=Integer.parseInt(c.split("\\'")[0]);
 	   String a[]=c.split("\\'")[1].split("\\/");	 
 	   s1=Integer.parseInt(a[0]);
 	   s2=Integer.parseInt(a[1]);
 	   return simplify(0+"'"+((n1*s2+s1)*d*s2)+"/"+(s2*s2));   
 	   } 
   public String multiply(int c,int d) {//整数乘法
 	   return String.valueOf(c*d);
 	   } 
   public String divide(Object c,Object d) {//除法
	   int s1=0,s2=0;
	   if(c instanceof Integer) s1=1;
	   if(d instanceof Integer) s2=1;
	   switch(s1+s2*10) {
	      case 10: return divide(c.toString(),(int)d);        
	      case 1:  return divide((int)c,d.toString());
          case 11: return divide((int)c,(int)d); 
	      case 0:  return divide(c.toString(),d.toString());	   
   }
	   return null;
   }  
   
   public String divide(String c,String d) {//分数除法
	   if(isNumber(c)||isNumber(simplify(c))) return divide(Integer.parseInt(simplify(c)),d);
	   if(isNumber(d)||isNumber(simplify(d))) return divide(c,Integer.parseInt(simplify(d)));
	   int s1,s2,n2;
 	   n2=Integer.parseInt(d.split("\\'")[0]);
 	   String b[]=d.split("\\'")[1].split("\\/");
 	   s1=Integer.parseInt(b[0]); 
 	   s2=Integer.parseInt(b[1]);
 	   if(n2<0) return  multiply(c,0+"'"+s2+"/"+(n2*s2-s1)); 	 
 	   return  multiply(c,0+"'"+s2+"/"+(s1+n2*s2)); 	   
   }
   public String divide(String c,int d) {//分数除法
	   if(isNumber(c)||isNumber(simplify(c))) return divide(Integer.parseInt(simplify(c)),d);
	   return  multiply(c,0+"'"+1+"/"+d);	   
   }
   public String divide(int c,String d) {//分数除法
	   if(isNumber(d)||isNumber(simplify(d))) return divide(c,Integer.parseInt(simplify(d)));
	   int s1,s2,n2;
	   n2=Integer.parseInt(d.split("\\'")[0]);
 	   String b[]=d.split("\\'")[1].split("\\/");
 	   s1=Integer.parseInt(b[0]); 
 	   s2=Integer.parseInt(b[1]);
 	  if(n2<0) return  multiply(0+"'"+s2+"/"+(n2*s2-s1),c);
 	   return multiply(0+"'"+s2+"/"+(n2*s2+s1),c);
   }
   public String divide(int c,int d) {//分数除法	  
 	   if(c%d==0)  return String.valueOf(c/d);
	   return simplify(0+"'"+c+"/"+d);
 	   
   }
   public static void main(String[] args) {
	   
   }
}
