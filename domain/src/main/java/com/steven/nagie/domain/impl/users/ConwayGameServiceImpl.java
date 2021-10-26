package com.steven.nagie.domain.impl.users;

import com.steven.nagie.domain.api.users.UserService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * The cells exist in a 2 dimensional grid. For our purposes, it will be finite. Each cell has 8 neighbors (except possibly at the edges).
 *     At time-step T+1, the following transitions occur
 *     Any live cell at time T with < 2 live neighbors dies (by underpopulation)
 *     Any live cell at time T  with exactly 2 or 3 live neighbors survives
 *     Any live cell at time T with > 3 live neighbors dies (by overpopulation)
 *     Any dead cell with exactly 3 live neighbors becomes alive (by reproduction)
 *
 *     The interface to implement is
 *
 * # Transition exactly one timestep
 *     #    Grid is a 2D array
 *     def transition(old_state: Grid) -> Grid: ...
 *
 *     # Sample input/output
 *     input = [ can be any size grid
 *     [true, false, true, false],
 *     [false, false, false, true],
 *     [true, true, true, false]
 *     ]
 *     expected = [ same size grid as input
 *     [false, false, false, false],
 *     [true, false, false, true],
 *     [false, true, true, false]
 *     ]
 */
@Component
public class ConwayGameServiceImpl {
  
  public boolean[][] go(fileInput) {
    boolean[] row1  = getNewRow(fileInput.getFile());
    boolean[] row2  = getNewRow(fileInput.getFile());
    boolean[] row3  = getNewRow(fileInput.getFile());
    if (row1 == veryFirstRow) {
      boolean[][] toAdd = gameStart(new boolean[3][row1.length]{row1, row1, row3});
      toReturn.add(toAdd[0])
    }
    while (more rows exist) {
      boolean[][] toAdd = gameStart(new boolean[3][row1.length]{row1, row1, row3});
      toReturn.add(toAdd[1]);
      row1 = row2;
      row2 = row3;
      row3 = getNewRow(fileInput);
      
    }
    return fileOutput
  }
  
  public boolean[][] gameStart(boolean[][] input) {
  }
  public boolean[][] gameStart(boolean[][] input) {
    boolean[][] toReturn = new boolean[input.length][input[0].length];
    for (int i = 0; i < input.length; i++) {
      boolean[] currentRowToBuild = new boolean[input[0].length];
      boolean[] currentRow = input[i];
      for (int j = 0; j < currentRow.length; j++) {
        boolean alive = false;
        int liveNeighbors = getLiveNeighbors(input, i, j);
        boolean currentState = currentRow[j];
        if (
            liveNeighbors == 3 && !currentState
        ) {
          alive = true;
        } else if (currentState && (liveNeighbors == 2 || liveNeighbors == 3)) {
          alive = true;
        }
        currentRowToBuild[j] = alive;
      }
      toReturn[i] = currentRowToBuild;
    }
    return toReturn;
  }
  
  private int getLiveNeighbors(boolean[][] input, int i, int j) {
    boolean[] currentRow = input[i];
    boolean[] previousRow = null;
    boolean[] nextRow = null;
    if (i > 0) {
      previousRow = input[i - 1];
    }
    if (i < input.length - 1) {
      nextRow = input[i + 1];
    }
    
    Integer previousIndex = null;
    Integer nextIndex = null;
    if (j > 0) {
      previousIndex = j - 1;
    }
    if (j < currentRow.length - 1) {
      nextIndex = j + 1;
    }
    int aliveNeighbors = 0;
    if (previousRow != null) {
      aliveNeighbors += previousRow[j] ? 1 : 0;
      aliveNeighbors += previousIndex != null && previousRow[previousIndex] ? 1 : 0;
      aliveNeighbors += nextIndex != null && previousRow[nextIndex] ? 1 : 0;
    }
    if (nextRow != null) {
      aliveNeighbors += nextRow[j] ? 1 : 0;
      aliveNeighbors += previousIndex != null && nextRow[previousIndex] ? 1 : 0;
      aliveNeighbors += nextIndex != null && nextRow[nextIndex] ? 1 : 0;
    }
    aliveNeighbors += previousIndex != null && currentRow[previousIndex] ? 1 : 0;
    aliveNeighbors += nextIndex != null && currentRow[nextIndex] ? 1 : 0;
    return aliveNeighbors;
  }
}
