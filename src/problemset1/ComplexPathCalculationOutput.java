package problemset1;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Complex path calculation with printing all paths
 * @author Philipp Backes
 *
 */
public class ComplexPathCalculationOutput {

  //public static int[][] grid;
  public static Point currentPoint;
  public static Point targetPoint;

  /**
   * @param args
   */
  public static void main(String[] args) {

    String userInput = "";
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("n = ");
    try {
      userInput = br.readLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
    //int pointCounter = 0;
    int n = Integer.parseInt(userInput);
    /*
    grid = new int[n + 1][n * n];
    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < n * n; j++) {
        grid[i][j] = pointCounter;
        pointCounter++;
      }
    }
    */
    currentPoint = new Point(0, 0);
    targetPoint = new Point(n, n);

    Node pathTreeRootNode = new Node(null);
    pathTreeRootNode.setId("0/0");
    System.out.println("Start: " + "(" + currentPoint.x + "/" + currentPoint.y + ")" + "\nTarget: "
        + "(" + targetPoint.x + "/" + targetPoint.y + ")");
    Node currentNode = pathTreeRootNode;
    pathCalc(currentNode);
    printTree(pathTreeRootNode);
  }

  /**
   * Function which creates the path tree
   * 
   * @param currentNode
   */
  public static void pathCalc(Node currentNode) {
    //
    // Possible Moves
    //    X   Y
    // ↗ X+1 Y+1
    // ↖ X-1 Y+1
    // ↘ X+1 Y-1
    // → X+1 Y
    // ↑  X  Y+1
    //
    // Node Order
    // 0 - ARROW RIGHT UP
    // 1 - ARROW LEFT UP
    // 2 - ARROW RIGHT DOWN
    // 3 - ARROW LEFT
    // 4 - ARROW UP
    //
    Node newChildNode;
    for (int i = 0; i < 1; i++) {
      switch (i) {
        case 0:
          if (checkNewPoint(0)) {
            currentPoint.x += 1;
            currentPoint.y += 1;
            newChildNode = addChild(currentNode, "↗");
            if (!currentPoint.equals(targetPoint)) {
              pathCalc(newChildNode);
            }
          }
          break;
        case 1:
          if (checkNewPoint(1)) {
            currentPoint.x -= 1;
            currentPoint.y += 1;
            newChildNode = addChild(currentNode, "↖");
            if (!currentPoint.equals(targetPoint)) {
              pathCalc(newChildNode);
            }
          }
          break;
        case 2:
          if (checkNewPoint(2)) {
            currentPoint.x += 1;
            currentPoint.y -= 1;
            newChildNode = addChild(currentNode, "↘");
            if (!currentPoint.equals(targetPoint)) {
              pathCalc(newChildNode);
            }
          }
          break;
        case 3:
          if (checkNewPoint(3)) {
            currentPoint.x += 1;
            newChildNode = addChild(currentNode, "→");
            if (!currentPoint.equals(targetPoint)) {
              pathCalc(newChildNode);
            }
          }
          break;
        case 4:
          if (checkNewPoint(4)) {
            currentPoint.y += 1;
            newChildNode = addChild(currentNode, "↑");
            if (!currentPoint.equals(targetPoint)) {
              pathCalc(newChildNode);
            }
          }
          break;
      }
    }
  }

  /**
   * Function to proof if the new point is inside the grid and the direction is allowed
   * 
   * @param directionNumber
   * @return
   */
  private static boolean checkNewPoint(int directionNumber) {
    switch (directionNumber) {
      case 0:
        return true;
      case 1:
        return false;
      case 2:
        return false;
      case 3:
        return false;
      case 4:
        return false;
      default:
        return false;
    }
  }

  private static Node addChild(Node parent, String id) {
    Node node = new Node(parent);
    node.setId(id);
    parent.getChildren().add(node);
    return node;
  }

  private static void printTree(Node node) {
    System.out.println();
    System.out.print(node.getId());
    for (Node child : node.getChildren()) {
      printTree(child);
    }
    System.out.println();
  }


}
