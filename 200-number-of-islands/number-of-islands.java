class Solution {
    public int numIslands(char[][] grid) {
        int c=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    c++;
                    func(grid,i,j);
                }
            }
        }
        return c;
    }
    static void func(char [][] arr,int i,int j){
        if(i<0 || j<0 ||i>arr.length-1 ||j>arr[0].length-1){
            return;
        }
        if(arr[i][j]=='0'){
            return;
        }
        arr[i][j]='0';
        func(arr,i+1,j);
        func(arr,i-1,j);
        func(arr,i,j+1);
        func(arr,i,j-1);
    }
}