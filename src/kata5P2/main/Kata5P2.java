package kata5P2.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import kata5P2.model.Histogram;
import kata5P2.view.HistogramDisplay;
import kata5P2.view.MailHistogramBuilder;
import kata5P2.view.MailListBuilder;
import kata5P2.view.MailListReaderDDBB;

public class Kata5P2 {

    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        Kata5P2 kata4 = new Kata5P2();
        kata4.execute();
    }
    
    private List<String> mailList;
    private HistogramDisplay histoDisplay;
    private Histogram<String> histogram;
    
    public void execute () throws FileNotFoundException, IOException, ClassNotFoundException, SQLException{
      input();
      process();
      output();
    }
     
     private void input() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException{
        mailList = MailListReaderDDBB.readDDBB();
    }
     
    private void output(){
        histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();
    }
    
    private void process(){
        histogram = MailHistogramBuilder.build(mailList); 
    }
}
