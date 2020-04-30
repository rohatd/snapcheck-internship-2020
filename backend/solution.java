import java.lang.Math; 
import java.util.Scanner;

public class solution 
{

    //prints array in encrypted manner
    public static void print_array(char[][] info,int size_of_word,int floor_num, int ceil_num){
        for(int col = 0;col < ceil_num;col++){
            if(col != 0){
                System.out.print(" ");
            }
            for(int row = 0;row < floor_num;row++){
                System.out.print(info[row][col]);    
            }
        }
    }

    //fills array with word
    public static void create_array(char[][] info,int size_of_word,int floor_num, int ceil_num,String word){
        for(int i = 0; i < size_of_word;i++){
            int row = i / ceil_num; 
            int column = i % ceil_num; 
            info[row][column] = word.charAt(i);
        }
    }

    //gets word from user input
    public static String get_user_input(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter word: ");
        String s = in.nextLine();
        in.close();
        return s;

    }

    public static void main(String[] args) {
    
        String word = get_user_input();

        //find length of word
        int size_of_word = word.length();

        //calc row and column count
        int floor_num = (int)Math.floor(Math.sqrt(size_of_word));
        int ceil_num = (int)Math.ceil(Math.sqrt(size_of_word));

        //make sure array is large enough
        if(floor_num * ceil_num < size_of_word){
            floor_num++;
        }
        
        //create 2d array to be filled
        char[][] two_D_word = new char[floor_num][ceil_num];
        
        //fill 2d array
        create_array(two_D_word, size_of_word, floor_num, ceil_num, word);
        //print 2d array
        print_array(two_D_word, size_of_word, floor_num, ceil_num);
    }
}