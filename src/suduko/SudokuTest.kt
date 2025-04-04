package suduko

fun main() {

    val invalidRowMatrix = listOf(
        listOf("3", "2", "3", "5"),
        listOf("7", "4", "6", "9"),
        listOf("5", "1", "2", "3"),
        listOf("4", "6", "0", "1")
    )
    testSudoku(
        name = "when given a matrix containing the same number in a row, should return false",
        result = isValidSudoku(invalidRowMatrix),
        correctResult = false
    )

    val invalidColumnMatrix = listOf(
        listOf("3", "2", "-", "5"),
        listOf("7", "4", "6", "9"),
        listOf("5", "1", "6", "3"),
        listOf("4", "6", "0", "1")
    )
    testSudoku(
        name = "when given a matrix containing the same number in a column, should return false",
        result = isValidSudoku(invalidColumnMatrix),
        correctResult = false
    )

    val invalidSubgridMatrix = listOf(
        listOf("1", "2", "3", "4"),
        listOf("3", "4", "1", "2"),
        listOf("2", "1", "3", "3"),
        listOf("4", "3", "2", "1")
    )
    testSudoku(
        name = "when given a matrix containing the same number in a subgrid, should return false",
        result = isValidSudoku(invalidSubgridMatrix),
        correctResult = false
    )

    val emptyMatrix = listOf(
        listOf("", "", "", ""),
        listOf("", "", "", ""),
        listOf("", "", "", ""),
        listOf("", "", "", "")
    )
    testSudoku(
        name = "when given an empty matrix, should return true",
        result = isValidSudoku(emptyMatrix),
        correctResult = false
    )
    val negativeMatrix = listOf(
        listOf("-1", "-2", "-3", "-4"),
        listOf("-5", "-6", "-7", "-8"),
        listOf("-9", "-10", "-11", "-12"),
        listOf("-13", "-14", "-15", "-16")
    )
    testSudoku(
        name = "when given a matrix with negative numbers, should return false",
        result = isValidSudoku(negativeMatrix),
        correctResult = false
    )
    val valid9x9Matrix = listOf(
        listOf("5", "3", "4", "6", "7", "8", "9", "1", "2"),
        listOf("6", "7", "2", "1", "9", "5", "3", "4", "8"),
        listOf("1", "9", "8", "3", "4", "2", "5", "6", "7"),
        listOf("8", "5", "9", "7", "6", "1", "4", "2", "3"),
        listOf("4", "2", "6", "8", "5", "3", "7", "9", "1"),
        listOf("7", "1", "3", "9", "2", "4", "8", "5", "6"),
        listOf("9", "6", "1", "5", "3", "7", "2", "8", "4"),
        listOf("2", "8", "7", "4", "1", "9", "6", "3", "5"),
        listOf("3", "4", "5", "2", "8", "6", "1", "7", "9")
    )
    testSudoku(
        name = "when given a valid 9x9 matrix, should return true",
        result = isValidSudoku(valid9x9Matrix),
        correctResult = true
    )

    val valid16x16Matrix = listOf(
        listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16"),
        listOf("5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "1", "2", "3", "4"),
        listOf("9", "10", "11", "12", "13", "14", "15", "16", "1", "2", "3", "4", "5", "6", "7", "8"),
        listOf("13", "14", "15", "16", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"),

        listOf("2", "1", "4", "3", "6", "5", "8", "7", "10", "9", "12", "11", "14", "13", "16", "15"),
        listOf("6", "5", "8", "7", "10", "9", "12", "11", "14", "13", "16", "15", "2", "1", "4", "3"),
        listOf("10", "9", "12", "11", "14", "13", "16", "15", "2", "1", "4", "3", "6", "5", "8", "7"),
        listOf("14", "13", "16", "15", "2", "1", "4", "3", "6", "5", "8", "7", "10", "9", "12", "11"),

        listOf("3", "4", "1", "2", "7", "8", "5", "6", "11", "12", "9", "10", "15", "16", "13", "14"),
        listOf("7", "8", "5", "6", "11", "12", "9", "10", "15", "16", "13", "14", "3", "4", "1", "2"),
        listOf("11", "12", "9", "10", "15", "16", "13", "14", "3", "4", "1", "2", "7", "8", "5", "6"),
        listOf("15", "16", "13", "14", "3", "4", "1", "2", "7", "8", "5", "6", "11", "12", "9", "10"),

        listOf("4", "3", "2", "1", "8", "7", "6", "5", "12", "11", "10", "9", "16", "15", "14", "13"),
        listOf("8", "7", "6", "5", "12", "11", "10", "9", "16", "15", "14", "13", "4", "3", "2", "1"),
        listOf("12", "11", "10", "9", "16", "15", "14", "13", "4", "3", "2", "1", "8", "7", "6", "5"),
        listOf("16", "15", "14", "13", "4", "3", "2", "1", "8", "7", "6", "5", "12", "11", "10", "9")
    )
    testSudoku(
        name = "when given a valid 16x16 matrix, should return true",
        result = isValidSudoku(valid16x16Matrix),
        correctResult = true
    )

    val valid4x4Matrix = listOf(
        listOf("1", "2", "3", "4"),
        listOf("3", "4", "1", "2"),
        listOf("2", "1", "4", "3"),
        listOf("4", "3", "2", "1")
    )
    testSudoku(
        name = "when given a valid 4x4 matrix, should return true",
        result = isValidSudoku(valid4x4Matrix),
        correctResult = true
    )

    val digitOnlyMatrix = listOf(
        listOf("1", "2", "3", "4"),
        listOf("4", "3", "2", "1"),
        listOf("2", "1", "4", "3"),
        listOf("3", "4", "1", "2")
    )
    testSudoku(
        name = "when given a matrix containing only digits, should return true",
        result = isValidSudoku(digitOnlyMatrix),
        correctResult = true
    )

    val charMatrix = listOf(
        listOf("A", "B", "c", "d"),
        listOf("B", "C", "D", "A"),
        listOf("C", "D", "A", "B"),
        listOf("D", "A", "B", "C")
    )
    testSudoku(
        name = "when given a matrix containing characters, should return false",
        result = isValidSudoku(charMatrix),
        correctResult = false
    )

    val specialCharMatrix = listOf(
        listOf("@", "#", "$", "%"),
        listOf("&", "*", "!", "?"),
        listOf("+", "=", "<", ">"),
        listOf("(", ")", "[", "]")
    )
    testSudoku(
        name = "when given a matrix containing special characters, should return false",
        result = isValidSudoku(specialCharMatrix),
        correctResult = false
    )
}

fun testSudoku(
    name: String,
    result: Boolean,
    correctResult: Boolean
) {
    if (correctResult == result)
        println("Success $name")
    else
        println("Failed $name")
}
