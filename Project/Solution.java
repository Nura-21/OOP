import java.util.*;
class Map{
    private int size;
    private int init_x;
    private int init_y;
    private char[][] map;

    public Map(Scanner cin) throws InvalidMapException{
        size = cin.nextInt();
        map = new char[size][size];
        if(size != 0){
            for(int i = 0; i < size; ++i){
                cin.nextLine();
                for(int j = 0; j < size; ++j){
                    map[i][j] = cin.next().charAt(0);
                    if(map[i][j] != '0' && 
                    map[i][j] != 'P' && 
                    map[i][j] != '1'){
                        throw new InvalidMapException("Not enough map elements");
                    }else{
                        if (map[i][j] == 'P'){
                            init_x = i;
                            init_y = j;
                        }
                    }
                }
            }
        } else {
            throw new InvalidMapException("Map size can not be zero");
        }
    }

    public void print(){
        for(int i = 0; i < size; ++i){
            for(int j = 0; j < size; ++j){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public char getValueAt(int i, int j){
        return map[i][j];
    }

    public int get_init_x(){
        return init_x;
    }

    public int get_init_y(){
        return init_y;
    }

    public char[][] get_map(){
        return map;
    }

    public int getSize(){
        return size;
    }
}

class Position{
    private int pos_x;
    private int pos_y;

    Position(int init_x, int init_y){
        pos_x = init_x;
        pos_y = init_y;
    }

    public int getX(){
        return pos_x;
    }

    public int getY(){
        return pos_y;
    }

    public void setX(int new_x){
        pos_x = new_x;
    }

    public void setY(int new_y){
        pos_y = new_y;
    }

    public boolean equals(Position pos){
        return (pos_x == pos.getX() && pos_y == pos.getY());
    }

    public String toString(){
        return ("(" + pos_x + "," + pos_y + ")");
    }
}

interface Player {
    public void setMap(Map map);
    public void moveRight();
    public void moveLeft();
    public void moveUp();
    public void moveDown();
    public Position getPosition();
}

class MyPlayer implements Player{
    private Map new_map;
    private int size;
    private Position pos;

    @Override
    public void setMap(Map map){
        new_map = map;
        size = map.getSize();
        pos = new Position(map.get_init_y(), map.get_init_x());
    }

    @Override
    public void moveRight(){
        int x = pos.getX();
        int y = pos.getY();
        if(x < (size-1) && new_map.get_map()[y][x+1] != '1'){
            pos.setX(x+1);
        }
    }

    @Override
    public void moveLeft(){
        int x = pos.getX();
        int y = pos.getY();
        if(x > 0 && new_map.get_map()[y][x-1] != '1'){
            pos.setX(x-1);
        }
    }

    @Override
    public void moveUp(){
        int x = pos.getX();
        int y = pos.getY();
        if(y > 0 && new_map.get_map()[y-1][x] != '1'){
            pos.setY(y-1);
        }
    }

    @Override
    public void moveDown(){
        int x = pos.getX();
        int y = pos.getY();
        if(y < (size-1) && new_map.get_map()[y+1][x] != '1'){
            pos.setY(y+1);
        }
        
    }

    @Override
    public Position getPosition(){
        return pos;
    }
}

class Game{
    private Map new_map;
    public Game(Map map_array){
        new_map = map_array;
    }
    public Map getMap(){
        return new_map;
    }

    public void setMap(Map map_array) {
        new_map = map_array;
    }

    public void addPlayer(Player new_player)  {
        new_player.setMap(new_map);
    }
}

class InvalidMapException extends Exception{
    InvalidMapException(String s){
        super(s);
    }
}

public class Solution{

	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String className = input.nextLine();
        
        // Checking the implementation of the Position class
        if(className.equals("Position")){
            Position p1 = new Position(input.nextInt(), input.nextInt());
            System.out.println(p1);
            p1.setX(5);
            System.out.println(p1.getX());
            
            Position p2 = new Position(5, 10);
            System.out.println(p1.equals(p2));            
        }
        
        // Checking the implementation of the Map class
        else if(className.equals("Map")){
            try{
                Map map = new Map(input);
                map.print();
                int size = map.getSize();
                System.out.println(size);		
                System.out.println(map.getValueAt(size/2, size/2)); 
            }
            catch(Exception e){}
        }
        
        // Checking the Player interface and the MyPlayer class
        else if(className.equals("Player")){
            Player player = new MyPlayer();
            System.out.println(Player.class.isInterface());  
            System.out.println(player instanceof Player);
            System.out.println(player instanceof MyPlayer);
        }
        
        // Checking the InvalidMapException class
        else if(className.equals("Exception")){
            try{
                throw new InvalidMapException("Some message");
            }
            catch(InvalidMapException e){
                System.out.println(e.getMessage());
            }
        }
        
        // Checking the Game class and all of its components
        else if(className.equals("Game")){
            
            // Initialize player, map, and the game
            Player player = new MyPlayer();
            Game game = null;

            try{
                game = new Game(new Map(input));
            }
            catch(InvalidMapException e){ // custom exception
                System.out.println(e.getMessage());
                System.exit(0);
            }

            game.addPlayer(player);

            // Make the player move based on the commands given in the input
            String moves = input.next();
            char move;
            for(int i=0; i<moves.length(); i++){
                move = moves.charAt(i);
                switch(move){
                    case 'R':
                        player.moveRight();
                        break;
                    case 'L':
                        player.moveLeft();
                        break;
                    case 'U':
                        player.moveUp();
                        break;
                    case 'D':
                        player.moveDown();
                        break;
                }
            }

            // Determine the final position of the player after completing all the moves above
            Position playerPosition = player.getPosition();
            System.out.println("Player final position");
            System.out.println("Row: " + playerPosition.getY());
            System.out.println("Col: " + playerPosition.getX());
        }
	}
}