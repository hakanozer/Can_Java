
import java.lang.Math;

    public class Matrix2 extends Matrix{

        public Integer[] slice(int i, int j, int k, int l){
            if (!(Math.abs(i-k)==Math.abs(j-l) || Math.abs(j-l)==0 || Math.abs(i-k)==0)){
                System.err.println("WARNING: This slice is undefined (null)!");
                return null;
            }
            int rowstep=determineStep(i,k);
            int colstep=determineStep(j,l);
            Integer[] res = new Integer[Math.max(Math.abs(i-k),Math.abs(j-l))+1];
            int el = 0;
            while (i!=k || j!=l){
                res[el] = m[i][j];
                i += rowstep;
                j += colstep;
                el++;
            }
            res[el] = m[i][j];
            return res;
        }

        private int determineStep(int i, int j){
            int step;
            if (i==j){
                step = 0;
            }else if (i<j){
                step = 1;
            }else{
                step = -1;
            }
            return step;
        }
    }


