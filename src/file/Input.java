package file;

import edu.princeton.cs.algs4.ST;

import java.io.*;
import java.util.Date;
import java.util.Scanner;


public class Input
{
    FileReader fileReader=null;
    BufferedReader bufferedReader=null;
    FileInputStream fileInputStream=null;
    FileOutputStream fileOutputStream=null;
    public static String getInputMessage() throws IOException{
        Scanner scanner=new Scanner(System.in);
        String input=scanner.next();
        return input;
    }
    public void createDir(String path){
        File dir=new File(path);
        if(!dir.exists())
            dir.mkdir();
    }
    public void delFile(String path,String filename){
        File file=new File(path+"/"+filename);
        if(file.exists()&&file.isFile())
            file.delete();
    }

    public void createFile(String path,String filename) throws IOException{
        File file=new File(path+"/"+filename);
        if(!file.exists())
            file.createNewFile();
    }
    public void delDir(String path){
        File dir=new File(path);
        if(dir.exists()){
            File[] tmp=dir.listFiles();
            for(int i=0;i<tmp.length;i++){
                if(tmp[i].isDirectory()){
                    delDir(path+"/"+tmp[i].getName());
                }
                else{
                    tmp[i].delete();
                }
            }
            dir.delete();
        }
    }
    public void writeFile(String filename) throws IOException {
        FileWriter fileWriter=new FileWriter(filename);//输入要写的文件的路径
        fileWriter.write("abcde");
        fileWriter.flush();
        fileWriter.close();
    }
    public void readFile(String filename) throws IOException {
        fileReader=new FileReader(filename);
        bufferedReader=new BufferedReader(fileReader);
        String line="";
        StringBuilder stringBuilder=new StringBuilder("");
        while ((line=bufferedReader.readLine())!=null){
            stringBuilder.append(line);
        }
        System.out.println(stringBuilder.toString());
        fileReader.close();
        bufferedReader.close();
    }
    public void copyFile(String oldFileName, String newFileName) throws IOException {
        fileInputStream=new FileInputStream(oldFileName);
        fileOutputStream=new FileOutputStream(newFileName);
        byte buf[]=new byte[16];
        int num=0;
        while ((num=fileInputStream.read(buf,0,16))!=-1){
            fileOutputStream.write(buf,0,16);
            fileOutputStream.flush();
        }
        fileOutputStream.close();
        fileInputStream.close();
    }
    public void changeDirectory(String filename,String oldpath,String newpath,boolean cover){
        if(!oldpath.equals(newpath)){
            File oldfile=new File(oldpath+"/"+filename);
            File newfile=new File(newpath+"/"+filename);
            if(newfile.exists()){//若在待转移目录下，已经存在待转移文件
                if(cover)//覆盖
                    oldfile.renameTo(newfile);
                else
                    System.out.println("在新目录下已经存在："+filename);
            }
            else{
                oldfile.renameTo(newfile);
            }
        }
    }
    public void listFile(String filename) throws IOException {
        File file=new File(filename+File.separator);
        if(file.isDirectory()) {
            File res[]=file.listFiles();
            for(int x=0;x<res.length;x++) {
                System.out.println((res[x].isDirectory()?"文件夹名称：":"文件名称")+res[x].getName()+"\t\t修改日期："+new Date(res[x].lastModified())+"\t"+"文件大小为："+(res[x].length())+"B");
            }
        }
    }


    public static void main(String[] args) throws Exception{
        Input input=new Input();
        System.out.println("创建文件夹：creatDir，"+"创建文件：creatFile,"+"写入文件：write,"+"读取文件:read,"+"复制文件:copy,"+"列出文件夹下文件：list。"+"输入exit结束");
        String s=getInputMessage();
        String path,name;

        while (!s.equals("exit")){
            switch (s){
                case "creatDir":
                    System.out.println("输入要创建的文件夹地址：");
                    path=getInputMessage();
                    input.createDir(path);
                    break;
                case "creatFile":
                    System.out.println("输入要创建的文件的地址：");
                    path=getInputMessage();
                    System.out.println("输入要创建的文件的名称：");
                    name=getInputMessage();
                    input.createFile(path,name);
                    break;
                case "write":
                    System.out.println("输入要写入的文件的地址：");
                    name=getInputMessage();
                    input.writeFile(name);
                    break;
                case "read":
                    System.out.println("输入要读取的文件的地址：");
                    name=getInputMessage();
                    input.readFile(name);
                    break;
                case "copy":
                    System.out.println("输入要复制的文件的旧地址：");
                    name=getInputMessage();
                    System.out.println("输入要复制的文件的目的地址：");
                    String name1=getInputMessage();
                    input.copyFile(name,name1);
                    break;
                case "list":
                    System.out.println("输入要展示内容的文件夹的地址：");
                    name=getInputMessage();
                    input.listFile(name);
                    break;
                default:
                    System.out.println("exit");
            }
            s=getInputMessage();//输入的命令行，表示要进行的操作
        }

    }

}
