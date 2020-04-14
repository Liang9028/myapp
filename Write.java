package text;

import java.io.*;
public class Write {
    public   static void   writefile (String a,String b ){
        
        try{
            String content = a;
            File file =new File(b);
            if(!file.exists()){
                file.createNewFile();
            }         //使用true，即进行append file
             FileWriter fileWritter = new FileWriter(file.getName(),true);
             fileWritter.write(content+"\r\n");
             fileWritter.close();

        }catch(IOException e){
            e.printStackTrace();     }

    }

    public static void main(String[] args) {
            
            
    }
}
