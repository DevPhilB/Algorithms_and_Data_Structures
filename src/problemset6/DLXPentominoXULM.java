package problemset6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Program takes a natural number (n) from user input and calculates all possibilities for placing
 * Pentominos (X, U, L) and Monominos (M) inside a 6 X n field. 
 * Condition: Pentominos can be rotated or reflected
 * 
 * @author Philipp Backes, 191710
 * @author Homa Alavi, 191720
 * @author Jannis Scholz, 191481
 *
 */
public class DLXPentominoXULM {
  // Static member
  static String userInput = "";

  // Private members
  private int lengthOfIndex;
  private int currentLineOfMatrix;
  private int cellAmount;
  private int n;

  /**
   * Constructor
   */
  public DLXPentominoXULM(int newN) {
    this.lengthOfIndex = 0;
    this.currentLineOfMatrix = 0;
    this.cellAmount = 0;
    this.n = newN;
  }

  /**
   * Getter for lengthOfIndex
   * 
   * @return the lengthOfIndex
   */
  public int getLengthOfIndex() {
    return lengthOfIndex;
  }

  /**
   * Getter for currentLineOfMatrix
   * 
   * @return the currentLineOfMatrix
   */
  public int getCurrentLineOfMatrix() {
    return currentLineOfMatrix;
  }

  /**
   * Getter for cellAmount
   * 
   * @return the cellAmount
   */
  public int getCellAmount() {
    return cellAmount;
  }

  /**
   * Getter for n (natural number)
   * 
   * @return the n
   */
  public int getN() {
    return n;
  }

  /**
   * Create header nodes for header array Iterate over all cells (n)
   * 
   * @param cells Amount of cells
   */
  public void createHeaderNodes(int cells) {
    lengthOfIndex = cells;
    DLXNode.headerArray = new DLXNode[cells + 1];
    DLXNode.headerArray[0] = DLXNode.headerNode;
    DLXNode tempNode;
    int x = 0;
    for (int i = 0; i < cells; i++) {
      DLXNode node = new DLXNode();
      node.headerPosition = ++x;
      node.downPosition = 0;
      DLXNode.headerArray[x] = node;
      if (DLXNode.headerNode.L == DLXNode.headerNode) {
        DLXNode.headerNode.R = node;
        node.R = DLXNode.headerNode;
        DLXNode.headerNode.L = node;
        node.L = DLXNode.headerNode;
      } else {
        tempNode = DLXNode.headerNode.L;
        node.L = tempNode;
        DLXNode.headerNode.L = node;
        tempNode.R = node;
        node.R = DLXNode.headerNode;
      }
    }
  }

  /**
   * Return Header Index
   * 
   * @param positionOfHeader Header position
   * @return DLXNode Node at header index
   */
  private DLXNode returnHeaderIndex(int positionOfHeader) {
    return DLXNode.headerArray[positionOfHeader];
  }

  // All figures
  // - Monomino
  /**
   * Create the monomino
   */
  public void createMonomino() {
    for (int i = 0; i < cellAmount; i++) {
      DLXNode node = new DLXNode();
      node.headerPosition = i + 1;
      node.downPosition = currentLineOfMatrix;
      node.C = returnHeaderIndex(node.headerPosition);
      node.U = returnHeaderIndex(node.headerPosition).U;
      returnHeaderIndex(node.headerPosition).U.D = node;
      returnHeaderIndex(node.headerPosition).U = node;
      node.D = node.C;
      currentLineOfMatrix++; // Increase current line
    }
  }

  // -Pentominos
  /**
   * Create and calculate X (2-7-8-9-14) 
   * 1 7 13 
   * 2 8 14 
   * 3 9 15 
   * 4 10 . 
   * 5 11 . 
   * 6 12 .
   */
  public void createAndCalculateX() {
    int xWidth = 3;
    int xHeight = 3;
    int x0 = 2;
    int x1 = 7;
    int x2 = 8;
    int x3 = 9;
    int x4 = 14;
    ArrayList<Integer> figurePositions = new ArrayList<>();
    figurePositions.add(x0);
    figurePositions.add(x1);
    figurePositions.add(x2);
    figurePositions.add(x3);
    figurePositions.add(x4);
    findFiguresPossiblePositions(xHeight, xWidth, figurePositions);
  }

  /**
   * Create and calculate all possible U pentominos 
   * 1 7 13 
   * 2 8 14 
   * 3 9 15 
   * . .  .
   */
  public void createAndCalculateU() {
    int uWidth = 4;
    int uHeight = 3;
    // U Normal (1-2-8-13-14)
    ArrayList<Integer> figurePositions = new ArrayList<>();
    figurePositions.add(1);
    figurePositions.add(2);
    figurePositions.add(8);
    figurePositions.add(13);
    figurePositions.add(14);
    findFiguresPossiblePositions(uWidth, uHeight, figurePositions);
    // U Flipped (1-2-7-13-14)
    figurePositions.clear();
    figurePositions.add(1);
    figurePositions.add(2);
    figurePositions.add(7);
    figurePositions.add(13);
    figurePositions.add(14);
    findFiguresPossiblePositions(uWidth, uHeight, figurePositions);
    // U Left Handed (1-3-7-9-8)
    uWidth = 3;
    uHeight = 2;
    figurePositions.clear();
    figurePositions.add(1);
    figurePositions.add(3);
    figurePositions.add(7);
    figurePositions.add(9);
    figurePositions.add(8);
    findFiguresPossiblePositions(uWidth, uHeight, figurePositions);
    // U Right Handed (1-2-3-9-7)
    figurePositions.clear();
    figurePositions.add(1);
    figurePositions.add(2);
    figurePositions.add(3);
    figurePositions.add(9);
    figurePositions.add(7);
    findFiguresPossiblePositions(uWidth, uHeight, figurePositions);
  }

  /**
   * Create and calculate all possible L pentominos 
   * 1 7  13 19 
   * 2 8  14 20 
   * 3 9  15 21 
   * 4 10 16 22 
   * 5 11 17 23 
   * 6 12 18 24
   */
  public void createAndCalculateL() {
    int lWidth = 2;
    int lHeight = 2;
    // L Normal (1-2-3-4-10)
    ArrayList<Integer> figurePositions = new ArrayList<>();
    figurePositions.add(1);
    figurePositions.add(2);
    figurePositions.add(3);
    figurePositions.add(4);
    figurePositions.add(10);
    findFiguresPossiblePositions(lWidth, lHeight, figurePositions);
    // L Rotated x 2 (1-7-8-9-10)
    figurePositions.clear();
    figurePositions.add(1);
    figurePositions.add(7);
    figurePositions.add(8);
    figurePositions.add(9);
    figurePositions.add(10);
    findFiguresPossiblePositions(lWidth, lHeight, figurePositions);
    // L Flipped (7-8-9-10-4)
    figurePositions.clear();
    figurePositions.add(7);
    figurePositions.add(8);
    figurePositions.add(9);
    figurePositions.add(10);
    figurePositions.add(4);
    findFiguresPossiblePositions(lWidth, lHeight, figurePositions);
    // L Flipped & Rotated x 3 (1-2-3-4-7)
    figurePositions.clear();
    figurePositions.add(1);
    figurePositions.add(2);
    figurePositions.add(3);
    figurePositions.add(4);
    figurePositions.add(7);
    findFiguresPossiblePositions(lWidth, lHeight, figurePositions);

    lWidth = 4;
    lHeight = 4;
    // L Rotated x 1 (2-8-14-20-19)
    figurePositions.clear();
    figurePositions.add(2);
    figurePositions.add(8);
    figurePositions.add(14);
    figurePositions.add(20);
    figurePositions.add(19);
    findFiguresPossiblePositions(lWidth, lHeight, figurePositions);
    // L Rotated x 2 (1-2-13-7-19)
    figurePositions.clear();
    figurePositions.add(1);
    figurePositions.add(2);
    figurePositions.add(13);
    figurePositions.add(7);
    figurePositions.add(19);
    findFiguresPossiblePositions(lWidth, lHeight, figurePositions);
    // L Flipped & Rotated x 1 (1-7-13-19-20)
    figurePositions.clear();
    figurePositions.add(1);
    figurePositions.add(7);
    figurePositions.add(13);
    figurePositions.add(19);
    figurePositions.add(20);
    findFiguresPossiblePositions(lWidth, lHeight, figurePositions);
    // L Flipped & Rotated x 2 (1-2-8-14-20)
    figurePositions.clear();
    figurePositions.add(1);
    figurePositions.add(2);
    figurePositions.add(8);
    figurePositions.add(14);
    figurePositions.add(20);
    findFiguresPossiblePositions(lWidth, lHeight, figurePositions);

  }

  /**
   * Method for calculating pentominos & monomino position inside the field
   * 
   * @param height Height of figure
   * @param width Width of figure
   * @param figurePositions ArrayList of figure positions
   */
  private void findFiguresPossiblePositions(int height, int width,
      ArrayList<Integer> figurePositions) {
    int maxMovesRight = n - width;
    // Check if moves to the right are possible, if not return
    if (maxMovesRight > n || maxMovesRight < 0) {
      return;
    }
    // Insert Figures into nodes
    insertFiguresIntoNewNodes(figurePositions);
    // Move to the right border
    for (int i = 0; i < height; i++) {
      ArrayList<Integer> copyOfFiguresPosition = new ArrayList<>(figurePositions);
      movesToRightBorder(maxMovesRight, copyOfFiguresPosition);
      moveToBottomBorder(figurePositions);
    }
    movesToRightBorder(maxMovesRight, figurePositions);
  }

  /**
   * Method to move to the right border as long as it is possible
   * 
   * @param maxMoves
   * @param figuresPosition
   */
  private void movesToRightBorder(int maxMoves, ArrayList<Integer> figuresPosition) {
    for (int r = 0; r < maxMoves; r++) {
      move(figuresPosition);
    }
  }

  /**
   * Creates and return a new Node with specific header and down position
   * 
   * @param headerPosition
   * @param downPosition
   * @return node New Node
   */
  private DLXNode returnNewNode(int headerPosition, int downPosition) {
    DLXNode newNode = new DLXNode();
    newNode.headerPosition = headerPosition;
    newNode.downPosition = downPosition;
    return newNode;
  }

  /**
   * Move method
   * 
   * @param figuresPosition
   */
  private void move(ArrayList<Integer> figuresPosition) {
    DLXNode[] nodes = new DLXNode[5];
    int indexM = 0;
    //
    for (int m = 0; m < figuresPosition.size(); m++) {
      Integer element = figuresPosition.get(m);
      element += 6;
      figuresPosition.set(m, element);
      nodes[indexM] = returnNewNode(element, currentLineOfMatrix);
      indexM++;
    }
    connectNodes(nodes);
    currentLineOfMatrix++;
  }

  /**
   * Method to get to the bottom border
   * 
   * @param figuresPosition
   */
  private void moveToBottomBorder(ArrayList<Integer> figuresPosition) {
    DLXNode[] nodes = new DLXNode[5];
    int indexMB = 0;
    //
    for (int mb = 0; mb < figuresPosition.size(); mb++) {
      Integer nextElement = figuresPosition.get(mb) + 1;
      figuresPosition.set(mb, nextElement);
      nodes[indexMB] = returnNewNode(nextElement, currentLineOfMatrix);
      indexMB++;
    }
    connectNodes(nodes);
    currentLineOfMatrix++;
  }

  /**
   * Insert a figure into nodes
   * 
   * @param figuresPosition
   */
  private void insertFiguresIntoNewNodes(ArrayList<Integer> figuresPosition) {
    DLXNode[] nodes = new DLXNode[5];
    int indexFIN = 0;
    for (Integer position : figuresPosition) {
      nodes[indexFIN] = returnNewNode(position, currentLineOfMatrix);
      indexFIN++;
    }
    connectNodes(nodes);
    currentLineOfMatrix++;
  }


  /**
   * Method to connect nodes
   * 
   * @param nodes Nodes to connect
   */
  private void connectNodes(DLXNode[] nodes) {
    for (int d = 0; d < nodes.length; d++) {
      // From up to down
      nodes[d].C = returnHeaderIndex(nodes[d].headerPosition);
      nodes[d].U = returnHeaderIndex(nodes[d].headerPosition).U;
      returnHeaderIndex(nodes[d].headerPosition).U.D = nodes[d];
      nodes[d].D = returnHeaderIndex(nodes[d].headerPosition);
      returnHeaderIndex(nodes[d].headerPosition).U = nodes[d];
      // For the first element from left to the right
      if (d == 0) {
        nodes[d].L = nodes[nodes.length - 1];
        nodes[d].R = nodes[d + 1];
      } else if (d == nodes.length - 1) {
        // For the last element from left to the right
        nodes[d].L = nodes[d - 1];
        nodes[d].R = nodes[0];
      } else {
        // For all other elements from left to the right
        nodes[d].L = nodes[d - 1];
        nodes[d].R = nodes[d + 1];
      }
    }
  }

  /**
   * Main method
   * Read user input and find all possibilities
   * 
   * @param args
   */
  public static void main(String[] args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("n = ");
    try {
      userInput = br.readLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
    DLXPentominoXULM program = new DLXPentominoXULM(Integer.parseInt(userInput));
    DLXNode.counter = 0; // Set counter for start to zero
    DLXNode.headerNode = new DLXNode(); // create header node
    DLXNode.headerNode.headerPosition = 0; // Set header position to zero
    DLXNode.headerNode.downPosition = 0; // Set vertical position to zero
    program.currentLineOfMatrix = 1; // Set current Line of matrix to 1
    program.cellAmount = program.getN() * 6; // Calculate all cells n * 6
    program.createHeaderNodes(program.cellAmount); // Create all header nodes

    // Calculate all figure positions
    program.createMonomino(); // Monominos
    program.createAndCalculateX(); // X-Pentomino
    program.createAndCalculateU(); // U-Pentomino
    program.createAndCalculateL(); // L-Pentomino

    // Start DLX search
    DLXNode.search(42); // No effect for changing k...
    System.out.println("Auf " + DLXNode.counter + " verschiedene Art(en) laesst sich ein 6 x "
        + program.n + " Feld kacheln!");
  }
}
