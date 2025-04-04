package ipv4

fun main(){

    testIpv4(
        name = "when given a string contain segment on start and dots at the end should return false",
        result = isValidIpAddressVersion4("0000...."),
        correctResult = false
    )
    testIpv4(
        name = "when given a string contain segment out of range should return false",
        result = isValidIpAddressVersion4("1.300.55.444"),
        correctResult = false
    )
    testIpv4(
        name = "when given a string contain number leading with zero should return false",
        result = isValidIpAddressVersion4("01.300.05.444"),
        correctResult = false
    )
    testIpv4(
        name = "when given a string have more than 4 segments should return false",
        result = isValidIpAddressVersion4("1.4.56.45."),
        correctResult = false
    )
    testIpv4(
        name = "when given a string have more than 3 dots should return false",
        result = isValidIpAddressVersion4("..1...4...56...45..."),
        correctResult = false
    )
    testIpv4(
        name = "when given a string contain special characters should return false",
        result = isValidIpAddressVersion4("@1.4.5#.64$^"),
        correctResult = false
    )
    testIpv4(
        name = "when given a string segments is zero is should return true",
        result = isValidIpAddressVersion4("0.0.0.0"),
        correctResult = true
    )

}


fun testIpv4(
    name: String,
    result: Boolean,
    correctResult: Boolean
) {
    if (correctResult == result)
        println("Success $name")
    else
        println("Failed $name")
}