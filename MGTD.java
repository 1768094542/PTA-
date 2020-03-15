package migongtongdao;
import java.util.*;
public class MGTD {
        static int[][] maze;//迷宫矩阵（maze
    // n.迷宫 vt.迷失，使困惑）
        static int n;//矩阵大小
        static int min;//最短步长
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入迷宫的大小");
            n = sc.nextInt();
            min = n*n;
            maze = new int[n][n];
            for(int i=0;i<n;i++){
                System.out.println("请输入第"+(i+1)+"行的元素");
                for(int j=0;j<n;j++){
                    maze[i][j] = sc.nextInt();
                }
                System.out.println("第"+(i+1)+"行输入完毕");
            }

           recursion(1, 1, 0 );//起始点为（1，1），初始步长为0
            if(min==n*n) {
                System.out.println("没有出路");
            }else{
                System.out.println("走出迷宫最少的步数为"+min);
            }
        }
    public static void recursion(int x, int y, int count ) {
        if(x==n-2 && y==n-2) {//跳出条件，走到[n-2][n-2]位置即为终点*
            min = Math.min(count, min);
        }else {
            maze[x][y]=1;//走过的位置不能重复走，故而走过就设为1（障碍物）
            if(y<n-1 && maze[x][y+1]==0) {
                recursion(x, y+1, count+1);			//右
            }
            if(x<n-1 && maze[x+1][y]==0) {
                recursion(x+1, y, count+1);			//下
            }
            if(x>1 && maze[x-1][y]==0) {
                recursion(x-1, y, count+1);			//上
            }
            if(y>1 && maze[x][y-1]==0) {
                recursion(x, y-1, count+1);			//左
            }

            maze[x][y]=0;//若是还没有走到出口就不能动了，表示是死巷子要原路返回，所以置0；
        }
    }
}





