import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Museum {
    public static void main(String[] args) throws ParseException{
        int result = 0;
        int maxCostoms = 0;
        ArrayList<String> date = new ArrayList<String>();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Scanner input = new Scanner(System.in);
        System.out.print("Number of costomers(today):");
        int numberCostomer = input.nextInt();
        for(int i = 1; i <= numberCostomer; i++){
            System.out.print(i + ")Start time:");
            String startTime = input.next();
            date.add(startTime);
            System.out.print(i + ")End time:");
            String endTime = input.next();
            date.add(endTime);
            System.out.println("********************"); 
        }
            for(int i = 0; i < date.size(); i=i+2){
            Date date1Start = format.parse(date.get(i));
            Date date1End = format.parse(date.get(i+1));
            for(int j = 0; j <= date.size(); j=j+2){
                if(j == date.size()){
                    break;
                }
                Date date2Start = format.parse(date.get(j));
                Date date2End = format.parse(date.get(j+1));
                if(date1Start.compareTo(date2Start) < 0 && date1End.compareTo(date2Start) > 0 || date1Start.compareTo(date2End) < 0 && date1End.compareTo(date2End) > 0 || date1Start.compareTo(date2Start) == 0 && date2End.compareTo(date1End) == 0){
                    maxCostoms++;
                }
            }
            if(maxCostoms > result){
                result = maxCostoms;
                maxCostoms = 0;
                
            }else if(maxCostoms < result){
                maxCostoms = 0;
            }
        }
        System.out.println(result);   
    }
}
