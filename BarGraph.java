package project2;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;





public class BarGraph extends Application
{
    HBox mainPane = new HBox();
    Scene scene = new Scene(mainPane);

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException
    {
        setup();
        
        primaryStage.setTitle("Bars");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void setup() throws FileNotFoundException 
    {
        String[][] allData = readData();
        
        //TODO Complete this method as required in the Project instructions
        String n = "";

        for(int i = 0; i < allData.length; i = i + 3)
        {
         double [] val;
         String [] lbl;

            n = "";
            val = new double[allData[i+1].length];
            lbl = new String[allData[i+1].length];
            n = allData[i][0] + " " + allData[i][1];
            for(int j = 0; j < allData[i + 1].length; j++)
            { 
                        double value = Double.parseDouble(allData[i + 1][j]);
                        val[j] = value;                             
                        lbl[j] = allData[i + 2][j];                                  
            }
           CustomPane student = new CustomPane(true, n, val, lbl);
           VBox vb = student.getSubPane();
           mainPane.getChildren().addAll(vb);
          
        }

        
        
        
    }

    public String[][] readData() throws FileNotFoundException 
    {
        File txt = new File("src/project2/data.txt");
        int c=0;
        String s = "";
         
        try
        {
            Scanner sc = new Scanner(txt);
            while(sc.hasNextLine())
            {
                c++;
                sc.nextLine();
            }
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }  
        
        String [][] temp = new String[c][];
        Scanner kbd = new Scanner(txt);
        
        for( int i = 0; i < temp.length; i++)
        {
            s = kbd.nextLine();
            temp[i] = s.split(" ");
        }
        return temp;
    
    }
    
    public static void main(String[] args)
    {
        Application.launch(args);
    }
    
}
