    package project2;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.transform.Rotate;


public class CustomPane extends HBox
{
    private VBox subPane;
    private final Colors []colors = Colors.values();
    
    public CustomPane(String name, double[] values, String[] labels)
    {
        subPane = new VBox(10);
        this.preparePane(name, values, labels);
    }
    
    public CustomPane(boolean ordered, String name, double[] values, String[] labels)
    {
        subPane = new VBox(10);
        this.preparePane(true, name, values, labels);
    }
    
    public void preparePane(String name, double[] values, String[] labels)
    {
        
        //TODO Complete this method as required in the Project instructions
        HBox hb = new HBox(10);
        Insets in = new Insets(15, 2, 5, 5);
        Insets ins = new Insets(3);
        hb.setSpacing(1);
        
        Text names = new Text(name);
        names.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        names.setTextAlignment(TextAlignment.CENTER);
        
        for(int i=0; i < values.length; i++)
        {
            StackPane sp = new StackPane();
            VBox vb = new VBox(10);
            vb.setPadding(new Insets (40,0,0,0));
            
            Rectangle r = new Rectangle();
            r.setArcHeight(10.0);
            r.setArcWidth(10.0);
            r.setHeight(values[i]);
            r.setWidth(25);
            
            
            r.setFill(Color.valueOf(colors[i]+""));
            r.setStroke(Color.valueOf(colors[i]+""));
            
            Text sub = new Text(labels[i]);
            sub.setFont(Font.font("Arial", FontWeight.THIN, 12));
            sub.setFill(Color.BLACK);
            sub.setRotate(-90);
            
            Text per = new Text(""+values[i]+"%");
            per.setRotate(-75);
            per.setTranslateX(3);
            per.setTranslateY(-14);
            
            
            sp.getChildren().add(r);
            sp.getChildren().add(sub);
            vb.getChildren().addAll(per, sp);
            vb.setAlignment(Pos.BOTTOM_CENTER);
            hb.getChildren().addAll(vb);
            
            
        }
        hb.setPadding(new Insets(15));
        subPane.getChildren().addAll(hb, names);
        subPane.setStyle("-fx-background-color:grey;");
        subPane.setAlignment(Pos.CENTER);
        
    }
     
    public void preparePane(boolean ordered, String name, double[] values, String[] labels)
    {
        
        ArrayList<Integer> val = new ArrayList<>();
        ArrayList<Double> val2 = new ArrayList<>();
        
        for (double x : values){
            val2.add(x);
        }
        Collections.sort(val2);
        
        for (double x : val2){
            for(int i=0; i < values.length; i++)
            {
                if(x == values[i])
                {
                    val.add(i);
                }
            }
            
        }
        
        Collections.reverse(val);
        System.out.println(val);
        //----
        HBox hb = new HBox(10);
        Insets in = new Insets(15, 2, 5, 5);
        Insets ins = new Insets(3);
        hb.setSpacing(1);
        
        Text names = new Text(name);
        names.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        names.setTextAlignment(TextAlignment.CENTER);
        
        for(int i : val)
        {
            StackPane sp = new StackPane();
            VBox vb = new VBox(10);
            vb.setPadding(new Insets (40,0,0,0));
            
            Rectangle r = new Rectangle();
            r.setArcHeight(10.0);
            r.setArcWidth(10.0);
            r.setHeight(values[i]);
            r.setWidth(25);
            
            
            r.setFill(Color.valueOf(colors[i]+""));
            r.setStroke(Color.valueOf(colors[i]+""));
            
            Text sub = new Text(labels[i]);
            sub.setFont(Font.font("Arial", FontWeight.THIN, 12));
            sub.setFill(Color.BLACK);
            sub.setRotate(-90);
            
            Text per = new Text(""+values[i]+"%");
            per.setRotate(-75);
            per.setTranslateX(3);
            per.setTranslateY(-14);
            
            
            sp.getChildren().add(r);
            sp.getChildren().add(sub);
            vb.getChildren().addAll(per, sp);
            vb.setAlignment(Pos.BOTTOM_CENTER);
            hb.getChildren().addAll(vb);
            
            
        }
        hb.setPadding(new Insets(15));
        subPane.getChildren().addAll(hb, names);
        subPane.setStyle("-fx-background-color:grey;");
        subPane.setAlignment(Pos.CENTER);
        
    }

    public VBox getSubPane()
    {
        return subPane;
    }
}
