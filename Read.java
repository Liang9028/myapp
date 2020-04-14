package text;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;


public class Read {
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
    // 校对答案与答卷 传入两个文档的文件名
   public   static  void proofread (String x,String y){
        try {  File file1=new File(x);
            FileReader fileReader1 =new FileReader(file1);
            BufferedReader reader1 =new BufferedReader(fileReader1);
            File file2=new File(y);
            FileReader fileReader2 =new FileReader(file2);
            BufferedReader reader2 =new BufferedReader(fileReader2);   //用缓冲区来获得更高的效率
            String line1=null;
            String line2=null;
            String str="Grade.txt";
            int rightN=0;int wrongN=0;
            ArrayList<String>rightList=new ArrayList<String>();
            ArrayList<String>wrongList=new ArrayList<String>();//用ArrayList接收正确与错误序号

            while (((line1=reader1.readLine())!=null)&&(line2=reader2.readLine())!=null) {
                String[] result1 = line1.split("\\.");                     //将序号与答案分开
                String[] result2 = line2.split("\\.");                     //将序号与答卷分开
                if (result1[1].equals(result2[1])) {
                    rightN++;
                    rightList.add(result1[0]);
                } else {
                    wrongN++;
                    wrongList.add(result1[0]);
                }

               }
                String str1 = "Correct:" + rightN + "(";
                String str2 = "Wrong:" + wrongN + "(";
                for (int i = 0; i <= rightList.size() - 1; i++) {

                    if (i == rightList.size() - 1)
                        str1 = str1 + rightList.get(i) + ")";
                    else
                        str1 = str1 + rightList.get(i) + ",";
                }
                for (int i = 0; i <= wrongList.size() - 1; i++) {

                    if (i == wrongList.size() - 1)
                        str2 = str2 + wrongList.get(i) + ")";
                    else
                        str2 = str2 + wrongList.get(i) + ",";
                }

                writefile(str1 + "\n" + str2, str);

            reader1.close();
            reader2.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }


    }


    public static void main(String[] args) {
        String a="Answers.txt";
        String b="Answers2.txt";
        proofread(a,b);


    }
}