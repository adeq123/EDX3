package mazeStack;

/**
 * Main class of the Java program.
 */
public class Main {
    
    
	public static void main(String[] args) {
		
		// Test StackPathFinder
		StackPathFinder pf = new StackPathFinder();
		// Test StackPathFinder
		//QueuePathFinder pf = new QueuePathFinder();
		System.out.println("Test StackPathFinder");
		Maze maze;
		Path path;

		maze = new Maze(MazeSamples.sMaze2);
		path = pf.findPath(maze);
		maze = new Maze(MazeSamples.sMaze2);
		System.out.println(path.toString());
		maze.followPath(path);
		System.out.println(maze.toString());
		

		maze = new Maze(MazeSamples.sMaze2);
		path = pf.findPath(maze);
		maze = new Maze(MazeSamples.sMaze2);
		System.out.println(path.toString());
		maze.followPath(path);
		System.out.println(maze.toString());

		maze = new Maze(MazeSamples.sMaze2);
		path = pf.findPath(maze);
		maze = new Maze(MazeSamples.sMaze2);
		System.out.println(path.toString());
		maze.followPath(path);
		System.out.println(maze.toString());
		
	}

}
