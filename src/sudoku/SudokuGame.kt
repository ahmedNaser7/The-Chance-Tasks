package sudoku

/**
 * Sudoku checker function that determines whether a given Sudoku puzzle is valid or not.
 * accept sudoku matrix size 4x4 , 9x9 , 16x16
 * @param matrix : is the sudoku grid that contains rows and columns of game
 * @return True once is valid
 * @sample isValidSudokuSample
 */

fun isValidSudoku(matrix: List<List<String>>): Boolean {
    if (matrix.isEmpty()) return false
    val subGridSize = calculateSizeOfSubGrid(matrix.size)
    if (subGridSize == -1) return false
    if (!checkRangeOfNumbers(matrix, subGridSize)) return false
    if (!checkRowValidation(matrix)) return false
    if (!checkColumnValidation(matrix)) return false
    return checkSubGridValidation(matrix, subGridSize)
}

fun calculateSizeOfSubGrid(matrixSize: Int): Int {
    return when {
        matrixSize % 16 == 0 -> 4
        matrixSize % 2 == 0 -> 2
        matrixSize % 3 == 0 -> 3
        else -> -1
    }
}

fun checkRangeOfNumbers(matrix: List<List<String>>, subGridSize: Int): Boolean {
    val checkRangeOfNumbers = mutableListOf<List<String>>()
    val rangeNumbers = when (subGridSize) {
        2 -> setOf("1", "2", "3", "4")
        3 -> setOf("1", "2", "3", "4", "5", "6", "7", "8", "9")
        4 -> setOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16")
        else -> setOf()
    }
    matrix.forEach { row ->
        checkRangeOfNumbers.add(row.filter { it in rangeNumbers || it == "-" })
    }
    for (row in checkRangeOfNumbers) {
        matrix.forEach { if (it.size != row.size) return false }
    }
    return true
}

fun checkRowValidation(matrix: List<List<String>>): Boolean {
    matrix.forEach { row ->
        val newRow = row.filter { it != "-" }.distinct()
        if (row.size > newRow.size) return false
    }
    return true
}

fun checkColumnValidation(matrix: List<List<String>>): Boolean {
    val columnListForCheckDuplication = mutableListOf<String>()
    var counterOfEmpty = 0
    for (row in matrix.indices) {
        for (column in matrix.indices) {
            if (matrix[column][row] != "-") {
                columnListForCheckDuplication+=matrix[column][row]
            } else {
                counterOfEmpty++
            }
        }
        if (columnListForCheckDuplication.toSet().size < columnListForCheckDuplication.size - counterOfEmpty)
            return false
        else {
            columnListForCheckDuplication.clear()
            counterOfEmpty = 0
        }
    }
    return true
}

fun checkSubGridValidation(grid: List<List<String>>, subGridSize: Int): Boolean {
    val subGridListForDuplication = mutableListOf<String>()
    var firstIndex = 0
    var lastIndex = subGridSize
    var sizeOfGridForLoop = subGridSize
    var counterOfEmpty = 0

    GridLoop@ while (sizeOfGridForLoop > 0) {
        
        var counterTheNumberOfSubGrids = 0
        
        subGridLoop@ for (row in grid.indices) {

            if (grid[row].contains("-"))
                counterOfEmpty++
            else
            subGridListForDuplication+=grid[row].subList(fromIndex = firstIndex, toIndex = lastIndex)

            counterTheNumberOfSubGrids++

            if (counterTheNumberOfSubGrids == subGridSize) {

                val checkDuplication = subGridListForDuplication.toSet()

                if (checkDuplication.size < subGridListForDuplication.size-counterOfEmpty )
                    return false

                subGridListForDuplication.clear()
                counterTheNumberOfSubGrids = 0
                counterOfEmpty = 0
            }
        }

        firstIndex += subGridSize
        lastIndex += subGridSize
        sizeOfGridForLoop--
    }
    return true
}

fun isValidSudokuSample(){
    val matrix4x4 = listOf(
        listOf("3", "2", "3", "5"),
        listOf("7", "4", "6", "9"),
        listOf("5", "1", "2", "3"),
        listOf("4", "6", "0", "1")
    )
    isValidSudoku(matrix4x4)
}