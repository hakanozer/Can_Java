import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;
public class Matrix {


        protected Integer[][] m;
        protected boolean debug = false;

        /*
         * read in a matrix from 'filematrix'
         */
        public void readMatrix(String filematrix) throws FileNotFoundException, IOException {
            BufferedReader r=null;
            r = new BufferedReader(new FileReader(filematrix));

            Vector<Integer[]> v = new Vector<Integer[]>();
            String l;
            while ((l=r.readLine())!=null){
                String[] svals = l.split(" ");
                Integer[] dvals = new Integer[svals.length];
                int k=0;
                for (String s:svals){
                    dvals[k] = Integer.valueOf(s);
                    k += 1;
                }
                v.add(dvals);
            }
            this.m = v.toArray(new Integer[0][]);
        }

        /*
         * get the matrix as Integer[][]
         */
        public Integer[][] getMatrix(){
            return this.m;
        }

        /*
         * get row and column number of the matrix
         */
        public int getRowCount(){ return this.m.length; }
        public int getColCount(){ return this.m[0].length; }
    }


