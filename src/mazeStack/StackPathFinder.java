package mazeStack;

import java.util.Stack;


/**
 * Class StackPathFinder implements an algorithm for finding a path using a Stack
 * @author Raquel M. Crespo-Garcia <rcrespo@it.uc3m.es>
 *
 */
public class StackPathFinder implements PathFinder {

    /*
     * ** IMPORTANT: 
     * The exploration order determines the path found
     * even forcing to traverse every cell in the maze. 
     * The algorithm takes profit of knowing the start position to be top-left
     * and the goal towards bottom-right.
     * Notice that using a Stack means retrieving elements in reverse order.
     * Thus, most promising directions are inserted last in the Stack 
     * in order to get them explored first.
     */
    private static final Movement[] DIRS_TO_EXPLORE = new Movement[] {
        	Movement.LEFT, 
        	Movement.UP, 
        	Movement.DOWN,
        	Movement.RIGHT
    };

	public Path findPath(Maze maze) {

		final MazePosition startPos = new MazePosition(0, 0, null);
		Stack <MazePosition> posToCheck = new Stack <MazePosition> ();
		posToCheck.push(startPos);
		MazePosition currentPos = startPos; 
		MazePosition next = startPos;
		
		while(!posToCheck.isEmpty()){
			currentPos = posToCheck.pop(); 
			
			if(maze.getPosStatus(currentPos) == MazeStatus.OPEN){
		//	switch( maze.getPosStatus(currentPos)){
			//case OPEN: 		
			maze.setPosStatus(currentPos, MazeStatus.VISITED); // if open change to visited
				for(Movement mov : DIRS_TO_EXPLORE){ //check all of the neighbours
					next = maze.getNeighbour(currentPos, mov);
					if(next != null && (maze.getPosStatus(next) == MazeStatus.OPEN || maze.getPosStatus(next) == MazeStatus.GOAL)){
						posToCheck.push(next); // if any of the neighbours is OPEN or GOAL add to the list
					}
				}
				//break;
				
			}else if(maze.getPosStatus(currentPos) == MazeStatus.GOAL){ //if goal build the path
			//case GOAL:
				MazePosition aux = currentPos;
				Path pathFound = new Path ();
				
				while(aux != null){
					pathFound.insertFirst(aux.getCoords()[0], aux.getCoords()[1]);
					aux = aux.getFrom();
				}
				
				return pathFound;
				
			}else if(maze.getPosStatus(currentPos) == MazeStatus.OBSTACLE){ 
				// OBSTACLE has never been added so if it is on the list then something is wrong
			//case OBSTACLE:
				return null;
			}else if(maze.getPosStatus(currentPos) == MazeStatus.VISITED){ 
				// NO comprende..
			//case VISITED:
			//	break;
			
			//}
		
			}
		}
		return null;
	}
}

