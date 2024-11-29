

package assessment1;

class CollectingDetails {
    private String stno;
    private String sName;
    private double temperature;
    private double ph;
    private double chloride;
    private double fluoride;

    public CollectingDetails(String stno, String sName, double temperature, double ph, double chloride, double fluoride) {
        this.stno = stno;
        this.sName = sName;
        this.temperature = temperature;
        this.ph = ph;
        this.chloride = chloride;
        this.fluoride = fluoride;
    }

    public String getStno() {
        return stno;
    }

    public String getSName() {
        return sName;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getPh() {
        return ph;
    }

    public double getChloride() {
        return chloride;
    }

    public double getFluoride() {
        return fluoride;
    }

    @Override
    public String toString() {
        return "CollectingDetails [stno=" + stno + ", sName=" + sName + ", temperature=" + temperature + 
               ", ph=" + ph + ", chloride=" + chloride + ", fluoride=" + fluoride + "]";
    }
}

class ChemicalManager {
	
    private CollectingDetails[] clist = new CollectingDetails[10];
    private int index = 0;

    public void addDetails(String stno, String sName, double temperature, double ph, double chloride, double fluoride) {
        if (index < clist.length) {
            clist[index++] = new CollectingDetails(stno, sName, temperature, ph, chloride, fluoride);
        } else {
            System.out.println("Reached maximum capacity");
        }
    }
    
    public void displayDetail() {
        System.out.printf("%-10s %-15s %-12s %-8s %-10s %-10s%n", 
                          "St No", "Station Name", "Temperature", "pH", "Chloride", "Fluoride");
        System.out.println("--------------------------------------------------------------------------");

        for (int i = 0; i < index; i++) {
            System.out.printf("%-10s %-15s %-12.2f %-8.2f %-10.2f %-10.2f%n",
                              clist[i].getStno(),
                              clist[i].getSName(),
                              clist[i].getTemperature(),
                              clist[i].getPh(),
                              clist[i].getChloride(),
                              clist[i].getFluoride());
        }
    }


    public void sortByChloride() {
        for (int i = 0; i < index - 1; i++) {
            for (int j = 0; j < index - i - 1; j++) {
                if (clist[j].getChloride() > clist[j + 1].getChloride()) {
                    CollectingDetails temp = clist[j];
                    clist[j] = clist[j + 1];
                    clist[j + 1] = temp;
                }
            }
        }
    }

    
}

public class Chemical {
    public static void main(String[] args) {
        ChemicalManager c1 = new ChemicalManager();

        c1.addDetails("s1", "RAMPALLI", 27.05, 7.20, 289.11, 1.22);
        c1.addDetails("s2", "ETHUR", 27.62, 7.70, 286.31, 1.23);
        c1.addDetails("s3", "EDAGAPLLI", 28.97, 7.89, 348.62, 0.81);
        c1.addDetails("s4", "SUGALMITTA", 28.91, 8.02, 45.91, 0.82);
        c1.addDetails("s5", "DANDUPALYAM", 28.75, 8.10, 40.64, 0.55);
        c1.addDetails("s6", "MELAPATULA", 29.50, 7.40, 75.20, 1.71);
        c1.addDetails("s7", "ARADIGUNTA", 29.82, 7.57, 80.50, 2.00);
        c1.addDetails("s8", "BHEMIGANPALLI", 29.67, 8.40, 88.12, 1.96);
        c1.addDetails("s9", "BANDLAPALLE", 28.70, 7.07, 156.01, 3.01);
        c1.addDetails("s10", "MANGALAM", 28.96, 7.88, 124.98, 1.97);

        c1.sortByChloride();
        
        c1.displayDetail();
       
    }
}



//This is output of code by using ClasstypeArrray
/*St No      Station Name    Temperature pH       Chloride   Fluoride  
--------------------------------------------------------------------------
s5         DANDUPALYAM     28.75       8.10     40.64      0.55      
s4         SUGALMITTA      28.91       8.02     45.91      0.82      
s6         MELAPATULA      29.50       7.40     75.20      1.71      
s7         ARADIGUNTA      29.82       7.57     80.50      2.00      
s8         BHEMIGANPALLI   29.67       8.40     88.12      1.96      
s10        MANGALAM        28.96       7.88     124.98     1.97      
s9         BANDLAPALLE     28.70       7.07     156.01     3.01      
s2         ETHUR           27.62       7.70     286.31     1.23      
s1         RAMPALLI        27.05       7.20     289.11     1.22      
s3         EDAGAPLLI       28.97       7.89     348.62     0.81      
*/

