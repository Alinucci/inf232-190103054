import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Scanner;



public class time {
public static void main(String args[]) throws ParseException {
    String s = "12:00";
    String j = "9:44";
    SimpleDateFormat  format = new SimpleDateFormat("hh:mm");
    Date s1 = format.parse(s);
    Date j1 = format.parse(j);
    if(s1.compareTo(j1)>0){
        System.out.println("less");
    }else{
        System.out.println("bigger");
    }

 }
}