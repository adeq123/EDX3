package maze;

import java.util.Vector;

/**
 * Class Maze represents a bidimensional maze 
 * to traverse and find a path through
 * @author Raquel M. Crespo-Garcia <rcrespo@it.uc3m.es>
 */
public class Maze {

	private MazeStatus[][] maze;
	
	/**
     * Creates an square Maze of given size
     */
	public Maze(int size) {
		this(size, size);
	}
	
    /**
     * Creates a bidimensional Maze of given height and size,
     * with all positions initially open
     */
	public Maze(int width, int height) {
		maze = new MazeStatus[height] [width];
		for(int i = 0;i < height; i++)
			for(int j = 0;j < width; j++){
				maze[i][j] = MazeStatus.OPEN;
			}
	}

    /**
     * Initializes a Maze from the given textual representation
     */
	public Maze(String sMaze) {
		this.maze = stringToMaze(sMaze);
	}

	
    /**
     * Returns the MazeStatus value corresponding to the given cell, 
     * specified by its row and column
     */
	public MazeStatus getPosStatus(int row, int col) {
		
		return maze[row] [col];
	}
	
    /**
     * Sets the cell corresponding to the specified row and column to 
     * the given status value
     */
	public void setPosStatus(int row, int col, MazeStatus newStatus) {
		maze [row] [col] = newStatus;
	}
	
    /**
     * Creates and returns an String with 
     * the text-based representation of the given Maze
     */
	public String toString() {
		String s = null;

		for(int row = 0; row < maze.length; row++){
			for(int column = 0; column < maze[0].length; column++){
				s = s+maze[row][column].toString();
			}
			s = s + System.lineSeparator();
		}
		return s;
	}

    /**
     * Transforms a text-based Maze into a bidimensional array 
     * of positions with the corresponding status.
     * It creates the array maze and assign to each of its cells
     * the corresponding status value based on the given text representation.
     */
	private MazeStatus[][] stringToMaze(String sMaze) {
		
		MazeStatus[][] auxMaze = null;
		String [] lines = sMaze.split(" ");
		for(int i = 0; i < lines.length; i++){
			char [] singleLine = lines[i].toCharArray();
			for(int j = 0; j < singleLine.length; j++){
				if(singleLine[j] == MazeStatus.GOAL.text()){
					maze[i][j] = MazeStatus.GOAL;
				}else if(singleLine[j] == MazeStatus.OBSTACLE.text()){
					maze[i][j] = MazeStatus.OBSTACLE;
				}else if(singleLine[j] == MazeStatus.OPEN.text()){
					maze[i][j] = MazeStatus.OPEN;
				}else if(singleLine[j] == MazeStatus.VISITED.text()){
					maze[i][j] = MazeStatus.VISITED;
				}
			}
			
		}
		return auxMaze;
		
	}
	

    /**
     * Calculates the destination position in the Maze
     * given an starting position (row, col) and  a Movement (mov)
     * 
     * @returns the coordinates of the next position, if its is a valid position. 
     * Returns null if the destination position is outside the limits of the array.
     */
	public int[] getNeighbourCoords(int row, int col, Movement mov) {
		int newRow = row + mov.hShift(); 
		int newCol = col + mov.vShift(); 
		int [] coords = null;
		
		if(newRow < maze.length && newRow > 0 && newCol < maze[0].length && newCol > 0){
			coords[0] = newRow;
			coords[1] = newCol;
			
		
		}

		return coords;
	}
	

    /**
     * Changes the state of the maze positions following the given path.
     * If the initial status of the position to visit is OPEN or VISITED 
     * (can step into the position), change it to VISITED.
     * If the initial status of the position to visit is GOAL, does not 
     * change it so that the goal keeps displaying in the maze. 
     * If the initial status of the position to visit is OBSTACLE or 
     * the position is outside the limits of the Maze, it is an invalid move,
     * stop and finish. 
     * Empties the received path as it traverses it.
     * 
     */
    public void followPath(Path path) {
        
		// TO DO (Part 4)
		// Learning concepts to work on:
		// extracting elements from list, accessing and modifying array positions

    }

}

